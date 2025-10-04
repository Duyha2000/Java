//package Project3;
//
//import Project1.java.exceptions.FileNotFoundException;
//import Project1.java.exceptions.UserNotFoundException;
//
//import java.util.Scanner;
//
//public class SpotifyManager {
//    private GenericLinkedList<User> users;
//
//    public SpotifyManager() {
//        users = new GenericLinkedList<>();
//    }
//
//    public void loadFromFile(String filename) throws FileNotFoundException, InvalidUserFormatException, InvalidPasswordException {
//        try (Scanner scanner = new Scanner(new File(filename))) {
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine().trim();
//                if (line.isEmpty()) continue;
//
//                String[] parts = line.split(",");
//                if (parts.length < 2) {
//                    throw new InvalidUserFormatException("Invalid user format in file: " + line);
//                }
//
//                String username = parts[0].trim();
//                String password = parts[1].trim();
//
//                if (username.isEmpty()) {
//                    throw new InvalidUserFormatException("Username cannot be empty");
//                }
//                if (password.isEmpty()) {
//                    throw new InvalidPasswordException("Password cannot be empty");
//                }
//
//                User user = new User(username, password);
//                for (int i = 2; i < parts.length; i++) {
//                    String[] playlistData = parts[i].trim().split(":");
//                    if (playlistData.length < 1) continue;
//
//                    PlayList playlist = new PlayList(playlistData[0].trim());
//                    if (playlistData.length > 1) {
//                        String[] songs = playlistData[1].split(";");
//                        for (String songData : songs) {
//                            String[] songParts = songData.split("-");
//                            if (songParts.length == 2) {
//                                playlist.addSong(new Song(songParts[0].trim(), songParts[1].trim()));
//                            }
//                        }
//                    }
//                    user.addPlayList(playlist);
//                }
//                users.add(user);
//            }
//        } catch (FileNotFoundException e) {
//            throw new FileNotFoundException("File not found: " + filename);
//        }
//    }
//
//    public User findUser(String username, String password) throws UserNotFoundException, InvalidPasswordException {
//        for (User user : users) {
//            if (user.getUsername().equals(username)) {
//                if (user.getPassword().equals(password)) {
//                    return user;
//                } else {
//                    throw new InvalidPasswordException("Incorrect password for user: " + username);
//                }
//            }
//        }
//        throw new UserNotFoundException("User not found: " + username);
//    }
//}
