import controllers.ManagerStudents;

public class Main {
    public static void main(String[] args) {
        ManagerStudents managerStudents = new ManagerStudents();
        while (true) {
            managerStudents.menu();
        }
    }
}
