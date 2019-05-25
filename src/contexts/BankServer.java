package contexts;

import models.Account;
import models.User;

import java.util.*;

/**
 * Хранит информацию об аккаунтах. Обрабатывает запрос и списывает/зачисляет соответствующие суммы на аккаунты.
 */
public class BankServer {

    private BankServer() { }

    private static final ArrayList<User> users = new ArrayList<>();

    private static final ArrayList<Account> accounts = new ArrayList<>();

    public static User getUser(int userId) {
        synchronized (users) {
            return users.stream()
                    .filter((user) -> user.getUserId() == userId)
                    .findAny()
                    .orElse(null);
        }
    }

    public static Account GetAccount(int accountId) {
        synchronized (accounts) {
            return accounts.stream()
                    .filter((account) -> account.getAccountId() == accountId)
                    .findAny()
                    .orElse(null);
        }
    }

    /**
     * Adds user to the database
     * @param login: login of user
     * @param password: password of user
     * @return Created user
     */
    public static User addUser(String login, String password) {
        User user;
        synchronized (users) {
            user = new User(users.size() + 1, login, password);
            users.add(user);
        }
        return user;
    }

    /**
     * Adds account to the database
     * @param userId: id of user
     */
    public static Account addAccount(int userId, String type) {
        Account account;
        synchronized (accounts) {
            account = new Account(accounts.size() + 1, userId, type);
            accounts.add(account);
        }
        return account;
    }

    /**
     * @param accountId: id of account
     * @param addition: addition to account
     */
    public static void updateAccount(int accountId, int addition) {
        synchronized (accounts) {
            Account account = accounts.stream()
                    .filter((acc) -> acc.getAccountId() == accountId)
                    .findAny()
                    .orElse(null);

            if (account == null) {
                throw new IllegalArgumentException("No account with such id: " + accountId);
            }
            account.updateBalance(addition);
        }
    }

}