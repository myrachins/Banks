package models;

/**
 * Одному пользователю может соответствовать несколько счетов. У счета есть тип - Checking, Saving.
 * В рамках предлагаемой задачи принципиально ничем не отличаются, только полем type.
 * Пользователь может посылать запросы как на первый, так и на второй счет.
 */
public class Account {

    private int accountId;

    private int userId;

    /**
     * Type of the account
     */
    private String type;

    /**
     * Remainder amount on the account
     */
    private int balance;

    public Account(int accountId, int userId, String type) {
        this.accountId = accountId;
        this.userId = userId;
        this.type = type;
    }

    public int getAccountId() {
        return this.accountId;
    }

    public int getUserId() {
        return this.userId;
    }

    public String getType() {
        return this.type;
    }

    public int getBalance() {
        return this.balance;
    }

    public void updateBalance(int addition) {
        this.balance += addition; // TODO: Add Atomic addition
    }
}