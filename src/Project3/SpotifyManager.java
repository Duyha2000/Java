package Project3;

import Project1.java.exceptions.UserNotFoundException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SpotifyManager {
    private GenericLinkedList<User> users;

    public SpotifyManager() {
        users = new GenericLinkedList<>();
    }

    public void loadUsersFromFile(String path)
            throws FileNotFoundException, InvalidUserFormatException {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            User currentUser = null;
            Playlist currentPlaylist = null;
            String line;
            int lineNo = 0;

            if (users == null) {
                users = new GenericLinkedList<>();
            }

            while ((line = br.readLine()) != null) {
                lineNo++;
                line = line.trim();
                if (line.isEmpty()) continue;

                if (line.equalsIgnoreCase("# USER")) {
                    if (currentUser != null) {
                        users.addLast(currentUser);
                    }
                    currentUser = null;
                    currentPlaylist = null;
                    continue;
                }

                if (line.startsWith("username:")) {
                    String username = line.substring("username:".length()).trim();
                    if (username.isEmpty())
                        throw new InvalidUserFormatException("Line " + lineNo + ": username is empty");
                    if (currentUser != null)
                        throw new InvalidUserFormatException("Line " + lineNo + ": duplicate username for same user block");
                    currentUser = new User(username, "");
                    continue;
                }

                if (line.startsWith("password:")) {
                    if (currentUser == null)
                        throw new InvalidUserFormatException("Line " + lineNo + ": password appears before username");
                    String password = line.substring("password:".length()).trim();
                    if (password.isEmpty())
                        throw new InvalidUserFormatException("Line " + lineNo + ": password is empty");
                    // set password (nếu User của bạn không có setter, hãy sửa constructor ở trên)
                    // Ở đây giả định có setter hoặc bạn tạo User sau khi có cả username+password
                    currentUser = new User(currentUser.getUsername(), password);
                    currentPlaylist = null;
                    continue;
                }

                if (line.startsWith("playlist:")) {
                    if (currentUser == null)
                        throw new InvalidUserFormatException("Line " + lineNo + ": playlist appears before user");
                    String plName = line.substring("playlist:".length()).trim();
                    if (plName.isEmpty())
                        throw new InvalidUserFormatException("Line " + lineNo + ": playlist name is empty");
                    currentPlaylist = new Playlist(plName);
                    currentUser.addPlaylist(currentPlaylist);
                    continue;
                }

                if (line.startsWith("song:")) {
                    if (currentUser == null)
                        throw new InvalidUserFormatException("Line " + lineNo + ": song appears before user");
                    String[] parts = getStrings(currentPlaylist, lineNo, line);
                    String title = parts[0].trim();
                    String artist = parts[1].trim();
                    if (title.isEmpty() || artist.isEmpty())
                        throw new InvalidUserFormatException("Line " + lineNo + ": empty title/artist");
                    currentPlaylist.addSong(new Song(title, artist));
                    continue;
                }
                throw new InvalidUserFormatException("Line " + lineNo + ": unknown directive -> " + line);
            }

            if (currentUser != null) {
                users.addLast(currentUser);
            }
        } catch (IOException ioe) {
            if (ioe instanceof FileNotFoundException) throw (FileNotFoundException) ioe;
            throw new InvalidUserFormatException("I/O error: " + ioe.getMessage(), ioe);
        }
    }

    private static String[] getStrings(Playlist currentPlaylist, int lineNo, String line) throws InvalidUserFormatException {
        if (currentPlaylist == null)
            throw new InvalidUserFormatException("Line " + lineNo + ": song appears before any playlist");
        String songRaw = line.substring("song:".length()).trim();
        if (songRaw.isEmpty())
            throw new InvalidUserFormatException("Line " + lineNo + ": song line is empty");

        String[] parts = songRaw.split("\\s*-\\s*", 2);
        if (parts.length != 2)
            throw new InvalidUserFormatException("Line " + lineNo + ": song must be 'Title - Artist'");
        return parts;
    }


    public User findUser(String username, String password) throws UserNotFoundException, InvalidPasswordException {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                if (user.getPassword().equals(password)) return user;
                else throw new InvalidPasswordException("Incorrect password for user: " + username);
            }
        }
        throw new UserNotFoundException("User not found: " + username);
    }


}
