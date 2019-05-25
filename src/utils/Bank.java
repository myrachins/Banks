package utils;

import models.User;

/**
 * Агрегирует связь с сервером и проверку пароля от пользователя на корректность.
 * Когда пользователь посылает запрос в банк, последний посылает запрос в Checker, и, если права верные,
 * посылает запрос от пользователя на сервер. Содержит логику проверки наличия средств и прав для совершения операции.
 */
public class Bank {

    public static int getRemainder(User user, int accountId) {
        // TODO implement here
        return 0;
    }

    public static void updateBalance(User user, int accountId, int addition) {
        // TODO implement here
    }
}