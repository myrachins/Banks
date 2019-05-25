package contexts;

import models.Account;
import models.User;

import java.util.*;

/**
 * Хранит информацию об аккаунтах. Обрабатывает запрос и списывает/зачисляет соответствующие суммы на аккаунты.
 */
public class BankServer {

    private static ArrayList<User> users;

    private static ArrayList<Account> accounts;


    /**
     * Adds user to the database
     * @param login: login of user
     * @param password: password of user
     * @return Created user
     */
    public static User addUser(String login, String password) {
        // TODO implement here
        return null;
    }

    /**
     * Adds account to the database
     * @param userId: id of user
     */
    public static void addAccount(int userId) {
        // TODO implement here
    }

    /**
     * @param accountId: id of account
     * @param addition: addition to account
     */
    public static void updateAccount(int accountId, int addition) {
        // TODO implement here
    }

}