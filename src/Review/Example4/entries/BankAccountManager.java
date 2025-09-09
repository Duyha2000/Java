package Review.Example4.entries;

import Review.Example4.exceptions.DublicateAccountException;
import Review.Example4.exceptions.InvalidAccountException;
import Review.Example4.exceptions.InvalidBalanceException;

import java.util.ArrayList;
import java.util.List;

public class BankAccountManager {
    private List<BankAccount> accounts;

    public BankAccountManager() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(String accountNumber, double initialBalance) throws InvalidAccountException, InvalidBalanceException, DublicateAccountException {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new InvalidAccountException("Number cannot be null or empty");
        }
        if (initialBalance < 0) {
            throw new InvalidBalanceException("You have no money in account");
        }
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                throw new DublicateAccountException("Please re-type your Account Number");
            }
            accounts.add(new BankAccount(accountNumber, initialBalance));
        }


    }

}
