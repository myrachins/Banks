package models;

import utils.AppSettings;

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
        this.balance = AppSettings.START_BALANCE;
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

    public synchronized int getBalance() {
        return this.balance;
    }

    public synchronized void updateBalance(int addition) {
        // TODO: Check the bounds of the new balance
        this.balance += addition; // TODO: Add Atomic addition
    }
}