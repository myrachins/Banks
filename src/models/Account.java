package models;

import java.util.*;

/**
 * Одному пользователю может соответствовать несколько счетов. У счета есть тип - Checking, Saving. В рамках предлагаемой задачи принципиально ничем не отличаются, только полем type. Пользователь может посылать запросы как на первый, так и на второй счет.
 */
public class Account {

    /**
     * Default constructor
     */
    public Account() {
    }

    /**
     * 
     */
    private int accountId;

    /**
     * 
     */
    private int userId;

    /**
     * 
     */
    private String type;

    /**
     * 
     */
    private int remainder;






    /**
     * @param userId 
     * @param type
     */
    public void Account(int userId, String type) {
        // TODO implement here
    }

    /**
     * @return
     */
    public int getAccountId() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public int getUserId() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public String getType() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public int getRemainder() {
        // TODO implement here
        return 0;
    }

}