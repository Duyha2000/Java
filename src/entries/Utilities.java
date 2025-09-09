package entries;

import exceptions.DuplicateUserException;

public final class Utilities {

    // Prevent instantiation
    private Utilities() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static String encryptPassword(String password) {
        try {
            // Get a SHA-256 MessageDigest instance
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");
            // Apply the digest to the password's bytes
            byte[] hash = md.digest(password.getBytes(java.nio.charset.StandardCharsets.UTF_8));

            // Convert the resulting byte array into a hex string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0'); // pad with leading zero if needed
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            // SHA-256 should always be available in modern JVMs; rethrow as runtime error if not
            throw new RuntimeException("SHA-256 algorithm not found", e);
        }
    }

    public static void readAccountFile(String filename, UserAccessManager manager) {
        try (java.util.Scanner fileScanner = new java.util.Scanner(new java.io.File(filename))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();

                // Skip blank lines
                if (line.isEmpty()) {
                    continue;
                }

                // Split line into username and encrypted password
                String[] parts = line.split("\\s+");
                if (parts.length >= 2) {
                    String username = parts[0];
                    String encryptedPassword = parts[1];

                    try {
                        manager.addUser(username, encryptedPassword);
                    } catch (DuplicateUserException e) {
                        // Print warning if duplicate user is encountered, but continue processing
                        System.out.println("Warning: User '" + username + "' already exists. Skipping.");
                    } catch (Exception e) {
                        System.out.println("Invalid Command: " + e.getMessage());
                    }
                }
            }
        } catch (java.io.FileNotFoundException e) {
            // Inform user if file cannot be found
            System.out.println("Unable to load file: " + filename);
        }
    }
}


