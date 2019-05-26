import contexts.BankServer;
import models.Account;
import models.User;
import utils.Bank;

public class Main {

    public static void main(String[] args) {
        BankServer.addUser("login_1", "qwerty123");
        BankServer.addUser("login_2", "qwerty1234");
        BankServer.addUser("login_3", "qwerty12345");
        User user1 = BankServer.addUser("login_4", "qwerty12345");
        User user2 = BankServer.addUser("login_5", "qwerty12345");

        Account account1 = BankServer.addAccount(user1.getUserId(), "Checking");
        Account account2 = BankServer.addAccount(user1.getUserId(), "Saving");
        Account account3 = BankServer.addAccount(user2.getUserId(), "Checking");

        user1.updateBalance(account1.getAccountId(), -100); // Getting 100 y from account

        // Normal transaction
        user1.sendMoney(account1.getAccountId(), account2.getAccountId(), 100); // sending from first account to another

        // Not enough money for sending
        try {
            user1.sendMoney(account1.getAccountId(), account2.getAccountId(), 1000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Sending money from one user to another
        user2.sendMoney(account3.getAccountId(), account1.getAccountId(), 500);

        System.out.println("Account 1 balance: " + Bank.getBalance(user1, account1.getAccountId()));
        System.out.println("Account 2 balance: " + Bank.getBalance(user1, account2.getAccountId()));
    }
}
