package test.java;

import main.java.exceptions.AccountLockedException;
import main.java.exceptions.DuplicateUserException;
import main.java.exceptions.PasswordIncorrectException;
import main.java.exceptions.UserNotFoundException;
import main.java.org.example.UserAccessManager;
import main.java.org.example.Utilities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class UserAccessManagerPublicTest {

    private UserAccessManager uam;

    /**
     * Sets up a fresh UserAccessManager instance before each test.
     */
    @BeforeEach
    public void setUp() {
        uam = new UserAccessManager();
    }

    /**
     * Tests adding a new user and verifying access with the correct password.
     */
    @Test
    public void testAddUser() throws Exception {
        uam.addUser("charlie", Utilities.encryptPassword("abc123"));
        assertTrue(uam.verifyAccess("charlie", Utilities.encryptPassword("abc123")));
    }

    /**
     * Tests removing a user and checking that the user no longer exists.
     */
    @Test
    public void testRemoveUser() throws Exception {
        uam.addUser("dave", Utilities.encryptPassword("davepass"));
        uam.removeUser("dave");
        assertThrows(UserNotFoundException.class, () ->
                uam.verifyAccess("dave", Utilities.encryptPassword("davepass")));
    }

    /**
     * Tests that adding a duplicate user triggers the appropriate exception.
     */
    @Test
    public void testDuplicateUserException() throws Exception {
        uam.addUser("ellen", Utilities.encryptPassword("pw"));
        assertThrows(DuplicateUserException.class, () ->
                uam.addUser("ellen", Utilities.encryptPassword("pw")));
    }

    /**
     * Tests that a user with correct credentials can be verified successfully.
     */
    @Test
    public void testVerifyPasswordSuccess() throws Exception {
        String username = "sarah";
        String password = "correctHorse";
        String encrypted = Utilities.encryptPassword(password);

        uam.addUser(username, encrypted);
        assertTrue(uam.verifyAccess(username, encrypted),
                "Access should be granted with correct credentials.");
    }

    /**
     * Tests that providing the wrong password for a valid user
     * results in a PasswordIncorrectException.
     */
    @Test
    public void testInvalidPasswordFailsAccess() throws Exception {
        String username = "nina";
        String correctPassword = "ninaPass";
        String wrongPassword = "wrongPass";

        uam.addUser(username, Utilities.encryptPassword(correctPassword));

        // Attempt to log in with the wrong password
        assertThrows(PasswordIncorrectException.class,
                () -> uam.verifyAccess(username, Utilities.encryptPassword(wrongPassword)));
    }

    /**
     * Tests that an account becomes locked after repeated invalid attempts.
     * The 6th attempt should always throw AccountLockedException.
     */
    @Test
    public void testAccountEventuallyLocks() throws Exception {
        String username = "lockme";
        String correctPassword = "right";
        String wrongPassword = "wrong";

        uam.addUser(username, Utilities.encryptPassword(correctPassword));

        // Attempt 5 incorrect passwords (ignore exceptions)
        for (int i = 0; i < 5; i++) {
            try {
                uam.verifyAccess(username, Utilities.encryptPassword(wrongPassword));
            } catch (Exception ignored) {
            }
        }

        // 6th attempt must throw AccountLockedException
        assertThrows(AccountLockedException.class,
                () -> uam.verifyAccess(username, Utilities.encryptPassword(correctPassword)));
    }


}
