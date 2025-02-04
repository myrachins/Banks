package models;

import utils.Bank;

/**
 * Посылает запросы в банк. Проверить/изменить баланс, сделать перевод.
 */
public class User {

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

    public User(int userId, String login, String password) {
        this.userId = userId;
        this.login = login;
        this.password = password;
    }

    /**
     * Gets the remainder of current user on specified account
     * @param accountId: id of account
     * @return remainder of current
     */
    public int getBalance(int accountId) {
        return Bank.getBalance(this, accountId);
    }

    /**
     * Updates balance of account on addition amount
     * @param accountId: id of account
     * @param addition: value to be added to remainder
     */
    public void updateBalance(int accountId, int addition) {
        Bank.updateBalance(this, accountId, addition);
    }

    public void sendMoney(int fromAccountId, int toAccountId, int addition) {
        Bank.sendMoney(this, fromAccountId, toAccountId, addition);
    }

    public int getUserId() {
        return this.userId;
    }

    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }

}