package entries;

import exceptions.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserAccessManager {
    private List<UserAccount> accounts = new ArrayList<>();

    public void loadAccounts(String filename) throws FileNotFoundException {
        Utilities.readAccountFile(filename, this);
    }

    public void addUser(String username, String encryptedPassword) throws DuplicateUserException, InvalidCommandException {
        if (username == null || username.isEmpty() || encryptedPassword == null || encryptedPassword.isEmpty()) {
            throw new InvalidCommandException("Invalid command");
        }
        UserAccount existing = findUser(username);
        if (existing != null) {
            throw new DuplicateUserException("User '" + username + "' account already exists.");
        }
        accounts.add(new UserAccount(username, encryptedPassword));
        System.out.println("Add successfully!!");
    }

    public void removeUser(String username) throws UserNotFoundException, InvalidCommandException {
        if (username == null || username.isEmpty()) {
            throw new InvalidCommandException("Invalid command");
        }
        UserAccount user = findUser(username);
        if (user == null) {
            throw new UserNotFoundException("User '" + username + "' not found.");
        }
        accounts.remove(user);
    }

    public void verifyAccess(String username, String password) throws UserNotFoundException, AccountLockedException, InvalidCommandException, PasswordIncorrectException {
        if (username == null || username.isEmpty()) {
            throw new InvalidCommandException("Invalid command");
        }
        UserAccount user = findUser(username);
        if (user == null) {
            throw new UserNotFoundException("User '" + username + "' not found.");
        }
        // Gọi checkPassword để xử lý logic xác minh
        user.checkPassword(password); // Sử dụng password plaintext
    }

    private UserAccount findUser(String username) {
        for (UserAccount u : accounts) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        String password = "mypassword123";
//        String encryptedPassword = Utilities.encryptPassword(password);
//        System.out.println("Encrypted password for " + password + ": " + encryptedPassword);

        UserAccessManager manager = new UserAccessManager();
        System.out.println("User access manager ready.");
        Scanner scanner = new Scanner(System.in);
        boolean running = true; // Cờ điều khiển vòng lặp

        while (running) {
            System.out.print("User Access Manager> ");
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;
            Scanner lineScanner = new Scanner(line);
            if (!lineScanner.hasNext()) continue;
            String command = lineScanner.next();

            switch (command) {
                case "exit":
                    running = false; // Dừng vòng lặp khi người dùng nhập "exit"
                    break;
                case "load":
                    if (lineScanner.hasNext()) {
                        String filename = lineScanner.next();
                        try {
                            manager.loadAccounts(filename);
                        } catch (FileNotFoundException e) {
                            System.out.println("Unable to load file: " + filename);
                        }
                    } else {
                        System.out.println("Invalid command");
                    }
                    break;
                case "add":
                    if (lineScanner.hasNext()) {
                        String username = lineScanner.next();
                        System.out.print("Password: ");
                        String pw = scanner.nextLine();
                        String enc = Utilities.encryptPassword(pw);
                        try {
                            manager.addUser(username, enc);
                        } catch (DuplicateUserException | InvalidCommandException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Invalid command");
                    }
                    break;
                case "remove":
                    if (lineScanner.hasNext()) {
                        String username = lineScanner.next();
                        try {
                            manager.removeUser(username);
                        } catch (UserNotFoundException | InvalidCommandException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Invalid command");
                    }
                    break;
                case "verify":
                    if (lineScanner.hasNext()) {
                        String username = lineScanner.next();
                        System.out.print("Password: ");
                        String pw = scanner.nextLine();
                        try {
                            manager.verifyAccess(username, pw); // Sử dụng verifyAccess với password plaintext
                            System.out.println("Access granted.");
                        } catch (UserNotFoundException | AccountLockedException | InvalidCommandException |
                                 PasswordIncorrectException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Invalid command");
                    }
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
    }
}

