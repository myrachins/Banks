package utils;

import java.util.*;

/**
 * Связующее звено между банком и аккаунтом, проверяет имеет ли доступ пользователь к аккаунту. Отвечает за безопасность аккаунтов. Проверяет есть ли у запрашивающего пользователя права на управление аккаунтом.
 */
public class Checker {

    /**
     * Default constructor
     */
    public Checker() {
    }




    /**
     * Checks is password valid
     * @param userId 
     * @param password 
     * @return
     */
    public boolean isPasswordValid(int userId, String password) {
        // TODO implement here
        return false;
    }

    /**
     * Checks the rights of user to modify and see account
     * @param userId 
     * @param accountId 
     * @return
     */
    public boolean hasRights(int userId, int accountId) {
        // TODO implement here
        return false;
    }

}