package models;

import java.util.*;

/**
 * Посылает запросы в банк. Проверить/изменить баланс, сделать перевод.
 */
public class User {

    /**
     * Default constructor
     */
    public User() {
    }

    /**
     * Id of user
     */
    private int userId;

    /**
     * Login of user
     */
    private String login;

    /**
     * Password of user
     */
    private String password;






    /**
     * @param login 
     * @param password
     */
    public void User(String login, String password) {
        // TODO implement here
    }

    /**
     * Gets the remainder of current user on specified account
     * @param accountId 
     * @return
     */
    public int getRemainder(int accountId) {
        // TODO implement here
        return 0;
    }

    /**
     * Updates balance of account on addition amount
     * @param accountId 
     * @param addition 
     * @return
     */
    public void updateBalance(int accountId, int addition) {
        // TODO implement here
        return null;
    }

    /**
     * Gets id of user
     * @return
     */
    public int getUserId() {
        // TODO implement here
        return 0;
    }

    /**
     * Gets login of user
     * @return
     */
    public String getLogin() {
        // TODO implement here
        return "";
    }

    /**
     * Gets password of user
     * @return
     */
    public String getPassword() {
        // TODO implement here
        return "";
    }

}