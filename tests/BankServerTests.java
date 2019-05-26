import contexts.BankServer;
import models.Account;
import models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class BankServerTests {
    /**
     * Test 1
     */
    @Test
    void testStartBalance() {
        User user = BankServer.addUser("some_login", "some_password");
        Account account = BankServer.addAccount(user.getUserId(), "Saving");

        Assertions.assertEquals(1000, account.getBalance());
    }

    /**
     * Test 2
     */
    @Test
    void testSending() throws InterruptedException {
        User user1 = BankServer.addUser("user_1", "some_password");
        Account account1 = BankServer.addAccount(user1.getUserId(), "Saving");
        Account account2 = BankServer.addAccount(user1.getUserId(), "Saving");
        User user2 = BankServer.addUser("user_2", "some_password");
        Account account3 = BankServer.addAccount(user2.getUserId(), "Saving");

        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 1000; ++i) {
            Thread thread = new Thread(() -> {
                user1.sendMoney(account1.getAccountId(), account3.getAccountId(), 1);
                user1.sendMoney(account2.getAccountId(), account3.getAccountId(), 1);
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        Assertions.assertEquals(account1.getBalance(), 0);
        Assertions.assertEquals(account2.getBalance(), 0);
        Assertions.assertEquals(account3.getBalance(), 3000);
    }

    /**
     * Test 2, 4
     */
    @Test
    void testIfNotEnoughMoney() {
        User user1 = BankServer.addUser("user_1", "some_password");
        Account account1 = BankServer.addAccount(user1.getUserId(), "Saving");
        Account account2 = BankServer.addAccount(user1.getUserId(), "Saving");

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> user1.sendMoney(account1.getAccountId(), account2.getAccountId(), 5000));

        Assertions.assertEquals(account1.getBalance(), 1000);
        Assertions.assertEquals(account2.getBalance(), 1000);
    }

    /**
     * Test 3, 4
     */
    @Test
    void testRequestFromForeign() {
        User user1 = BankServer.addUser("user_1", "some_password");
        Account account1 = BankServer.addAccount(user1.getUserId(), "Saving");
        User user2 = BankServer.addUser("user_2", "some_password");
        Account account2 = BankServer.addAccount(user1.getUserId(), "Saving");

        // User 2 is trying to get money from user 1 account
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> user2.sendMoney(account1.getAccountId(), account2.getAccountId(), 1));

        Assertions.assertEquals(account1.getBalance(), 1000);
        Assertions.assertEquals(account2.getBalance(), 1000);
    }

    /**
     * Test 4
     */
    @Test
    void testInvalidPassword() {
        User user1 = BankServer.addUser("user_1", "some_password");
        Account account1 = BankServer.addAccount(user1.getUserId(), "Saving");

        // Creating hacker with same id and login, but with wrong password
        User hacker = new User(user1.getUserId(), user1.getLogin(), "wrong_password");

        // Trying to get 100 y from another user's account
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                hacker.updateBalance(account1.getAccountId(), -100));
    }

    /**
     * Test 5
     */
    @Test
    void testMain() {
        Main.main(null);
    }
}
