package utils;

import contexts.BankServer;
import models.Account;
import models.User;

/**
 * Агрегирует связь с сервером и проверку пароля от пользователя на корректность.
 * Когда пользователь посылает запрос в банк, последний посылает запрос в Checker, и, если права верные,
 * посылает запрос от пользователя на сервер. Содержит логику проверки наличия средств и прав для совершения операции.
 */
public class Bank {

    private Bank() { }

    private static Checker checker = new Checker();

    public static int getBalance(User user, int accountId) {
        if (!checker.hasRights(user.getUserId(), accountId)
                || !checker.isPasswordValid(user.getUserId(), user.getPassword())) {
            throw new IllegalArgumentException("User doesn't have enough rights to see account with such id: " + accountId);
        }
        Account account = BankServer.GetAccount(accountId);
        if (account == null) {
            throw new IllegalArgumentException("No account with such id: " + accountId);
        }
        return account.getBalance();
    }

    public static void updateBalance(User user, int accountId, int addition) {
        if (!checker.hasRights(user.getUserId(), accountId)
                || !checker.isPasswordValid(user.getUserId(), user.getPassword())) {
            throw new IllegalArgumentException("User doesn't have enough rights to see account with such id: " + accountId);
        }
        BankServer.updateAccount(accountId, addition);
    }
}