import contexts.BankServer;
import models.Account;
import models.User;
import utils.Bank;

public class Main {

    public static void main(String[] args) {
        BankServer.addUser("login_1", "qwerty12345");
        BankServer.addUser("login_1", "qwerty12345");
        BankServer.addUser("login_1", "qwerty12345");
        User user = BankServer.addUser("login_1", "qwerty12345");

        Account account = BankServer.addAccount(user.getUserId(), "SOME_TYPE");

        System.out.println(Bank.getBalance(user, account.getAccountId()));
    }
}
