package Project3;

import Project1.java.exceptions.UserNotFoundException;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ListIterator;

public class SpotifySwingApp {
    private JFrame frame;
    private JComboBox<Playlist> playlistDropdown;
    private JTextArea songDisplay;
    private JButton nextButton, prevButton, addSongButton, removeSongButton;
    private int selectedPlaylistIndex = 0;

    private final User user;
    private final SpotifyManager manager;

    public SpotifySwingApp(User user, SpotifyManager manager) {
        this.user = user;
        this.manager = manager;
        initUI();
    }

    private void initUI() {
        frame = new JFrame("Mini Spotify - " + user.getUsername());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(520, 420);
        frame.setLocationRelativeTo(null);

        // Top: playlist chooser
        JPanel topPanel = new JPanel(new BorderLayout(8, 0));
        topPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        playlistDropdown = new JComboBox<>();
        refreshPlaylistDropdown();

        playlistDropdown.addActionListener(e -> {
            selectedPlaylistIndex = playlistDropdown.getSelectedIndex();
            updateSongDisplay();
            updateButtonsEnabledState();
        });

        topPanel.add(new JLabel("Playlists:"), BorderLayout.WEST);
        topPanel.add(playlistDropdown, BorderLayout.CENTER);

        // Center: song display
        songDisplay = new JTextArea();
        songDisplay.setEditable(false);
        songDisplay.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(songDisplay);

        // Bottom: controls
        JPanel controlPanel = new JPanel();
        prevButton = new JButton("Previous");
        nextButton = new JButton("Next");
        addSongButton = new JButton("Add Song");
        removeSongButton = new JButton("Remove Song");

        controlPanel.add(prevButton);
        controlPanel.add(nextButton);
        controlPanel.add(addSongButton);
        controlPanel.add(removeSongButton);

        frame.setLayout(new BorderLayout());
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);

        setupListeners();
        updateSongDisplay();
        updateButtonsEnabledState();

        frame.setVisible(true);
    }

    private void refreshPlaylistDropdown() {
        DefaultComboBoxModel<Playlist> model = new DefaultComboBoxModel<>();
        int count = user.getPlaylistCount();
        for (int i = 0; i < count; i++) {
            model.addElement(user.getPlaylists().get(i));
        }
        playlistDropdown.setModel(model);

        if (count > 0) {
            if (selectedPlaylistIndex < 0 || selectedPlaylistIndex >= count) {
                selectedPlaylistIndex = 0;
            }
            playlistDropdown.setSelectedIndex(selectedPlaylistIndex);
        } else {
            selectedPlaylistIndex = -1;
            playlistDropdown.setSelectedIndex(-1);
        }

        playlistDropdown.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value,
                                                          int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Playlist p) {
                    int shownIndex = (index >= 0 ? index + 1 : playlistDropdown.getSelectedIndex() + 1);
                    setText((shownIndex > 0 ? shownIndex + ". " : "") + p.getName());
                } else if (value == null) {
                    setText("No playlists");
                }
                return this;
            }
        });
    }

    private void setupListeners() {
        nextButton.addActionListener(e -> {
            Playlist p = getCurrentPlaylist();
            if (p != null && !p.isEmpty()) {
                p.nextSong();
                updateSongDisplay();
            }
            updateButtonsEnabledState();
        });

        prevButton.addActionListener(e -> {
            Playlist p = getCurrentPlaylist();
            if (p != null && !p.isEmpty()) {
                p.previousSong();
                updateSongDisplay();
            }
            updateButtonsEnabledState();
        });

        addSongButton.addActionListener(e -> {
            Playlist p = getCurrentPlaylist();
            if (p == null) {
                JOptionPane.showMessageDialog(frame, "No playlist selected.");
                return;
            }
            JTextField titleField = new JTextField();
            JTextField artistField = new JTextField();
            JPanel panel = new JPanel(new GridLayout(0, 1, 4, 4));
            panel.add(new JLabel("Song title:"));
            panel.add(titleField);
            panel.add(new JLabel("Artist:"));
            panel.add(artistField);

            int ok = JOptionPane.showConfirmDialog(frame, panel, "Add Song", JOptionPane.OK_CANCEL_OPTION);
            if (ok == JOptionPane.OK_OPTION) {
                String title = titleField.getText();
                String artist = artistField.getText();
                if (title != null && artist != null && !title.isBlank() && !artist.isBlank()) {
                    p.addSong(new Song(title.trim(), artist.trim()));
                    updateSongDisplay();
                    updateButtonsEnabledState();
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter both title and artist.");
                }
            }
        });

        removeSongButton.addActionListener(e -> {
            Playlist p = getCurrentPlaylist();
            if (p == null) {
                JOptionPane.showMessageDialog(frame, "No playlist selected.");
                return;
            }
            Song current = p.getCurrentSong();
            if (current == null) {
                JOptionPane.showMessageDialog(frame, "No song is currently selected.");
                return;
            }
            boolean removed = p.removeSong(current);
            updateSongDisplay();
            updateButtonsEnabledState();
            JOptionPane.showMessageDialog(frame, removed ? "Removed: " + current.getTitle()
                    : "Could not remove the song.");
        });
    }

    private Playlist getCurrentPlaylist() {
        int selectedIndex = playlistDropdown.getSelectedIndex();
        if (selectedIndex < 0) return null;
        // an toàn nếu user.getPlaylists() là List-like:
        if (selectedIndex >= user.getPlaylistCount()) return null;
        return user.getPlaylists().get(selectedIndex);
    }

    private void updateSongDisplay() {
        Playlist p = getCurrentPlaylist();
        if (p == null) {
            songDisplay.setText("No playlist selected.");
            return;
        }
        if (p.isEmpty()) {
            songDisplay.setText("This playlist is empty.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        ListIterator<Song> it = p.getSongs().iterator();
        Song current = p.getCurrentSong();

        while (it.hasNext()) {
            Song s = it.next();
            sb.append((current != null && current.equals(s)) ? "> " : "  ");
            sb.append(s).append("\n");
        }
        songDisplay.setText(sb.toString());
        songDisplay.setCaretPosition(0);
    }


    private void updateButtonsEnabledState() {
        Playlist p = getCurrentPlaylist();
        boolean hasPlaylist = (p != null);
        boolean hasSong = hasPlaylist && !p.isEmpty();

        prevButton.setEnabled(hasSong);
        nextButton.setEnabled(hasSong);
        removeSongButton.setEnabled(hasSong);
        addSongButton.setEnabled(hasPlaylist);
    }

    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select User Data File");
        int result = fileChooser.showOpenDialog(null);

        if (result != JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(null, "No file selected. Exiting app.");
            return;
        }

        File selectedUserFile = fileChooser.getSelectedFile();
        SpotifyManager manager = new SpotifyManager();
        try {
            manager.loadUsersFromFile(selectedUserFile.getAbsolutePath());
        } catch (InvalidUserFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "File Format Error", JOptionPane.ERROR_MESSAGE);
            return;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage(), "I/O Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String chosenUsername = JOptionPane.showInputDialog(null, "Enter username:");
        if (chosenUsername == null || chosenUsername.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No username entered. Exiting app.");
            return;
        }
        String password = JOptionPane.showInputDialog(null, "Enter password:");
        if (password == null) {
            JOptionPane.showMessageDialog(null, "No password entered. Exiting app.");
            return;
        }

        try {
            User userFromFile = manager.findUser(chosenUsername.trim(), password.trim());
            SwingUtilities.invokeLater(() -> new SpotifySwingApp(userFromFile, manager));
        } catch (UserNotFoundException | InvalidPasswordException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
