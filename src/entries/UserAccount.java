package entries;

import exceptions.AccountLockedException;
import exceptions.PasswordIncorrectException;

public class UserAccount {
    private String username;
    private String encryptedPassword;
    int failureCount = 0;
    private boolean locked = false;

    public UserAccount(String username, String encryptedPassword) {
        this.username = username;
        this.encryptedPassword = encryptedPassword;
    }

    public String getUsername() {
        return username;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void incrementFailureCount() {
        failureCount++;
    }

    public void resetFailureCount() {
        failureCount = 0;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public void checkPassword(String password) throws AccountLockedException, PasswordIncorrectException {
        if (locked) {
            throw new AccountLockedException("User '" + username + "' account is locked.");
        }

        String enc = Utilities.encryptPassword(password);

        if (!enc.equals(encryptedPassword)) {
            incrementFailureCount();
            if (failureCount >= 3) { // Giới hạn số lần nhập sai mật khẩu, ví dụ 3 lần
                setLocked(true);
            }
            throw new PasswordIncorrectException("Incorrect Password");
        }
        resetFailureCount(); // Đặt lại failureCount khi đăng nhập thành công
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAccount other)) return false;
        return username.equals(other.username);
    }

    @Override
    public String toString() {
        return username;
    }
}
