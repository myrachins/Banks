package utils;

/**
 * Связующее звено между банком и аккаунтом, проверяет имеет ли доступ пользователь к аккаунту.
 * Отвечает за безопасность аккаунтов. Проверяет есть ли у запрашивающего пользователя права на управление аккаунтом.
 */
public class Checker {

    /**
     * Checks is password valid
     * @param userId: id of user
     * @param password: password of user
     * @return is password valid
     */
    public boolean isPasswordValid(int userId, String password) {
        // TODO implement here
        return false;
    }

    /**
     * Checks the rights of user to modify and see account
     * @param userId: id of user
     * @param accountId: id of account
     * @return does user have specified rights
     */
    public boolean hasRights(int userId, int accountId) {
        // TODO implement here
        return false;
    }

}