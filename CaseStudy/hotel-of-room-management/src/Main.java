import controllers.AccountManagement;

public class Main {
    public static void main(String[] args) {
        AccountManagement accountManagement = new AccountManagement();
        while (true) {
            accountManagement.menuAccount();
        }
    }
}
