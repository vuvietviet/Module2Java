import java.util.LinkedList;
import java.util.Queue;

public class FileEmployees extends Employee {
    Employee[] employees = new Employee[0];

    public void add(String gender, String birthday) {
        Employee e = new Employee(gender, birthday);
        Employee[] newEmployees = new Employee[employees.length + 1];
        for (int i = 0; i < employees.length; i++) {
            newEmployees[i] = employees[i];
        }
        newEmployees[newEmployees.length - 1] = e;
        employees = newEmployees;
    }

    public void show() {
        for (Employee ele: employees) {
            System.out.println(ele.getGender() + "\t" + ele.getBirthday());
        }
    }
    public void sortGender(){

        Queue<Employee> queueNu = new LinkedList();
        Queue<Employee> queueNam = new LinkedList();
        for (int i = 0; i < employees.length; i++) {
            if ((employees[i].getGender()).equals("nu")) {
                queueNu.add(employees[i]);
            } else if ((employees[i].getGender()).equals("nam")) {
                queueNam.add(employees[i]);
            }
        }

        Employee[] sortEmployees = new Employee[employees.length];
        for (int i = 0; i < sortEmployees.length; i++) {
            if (!(queueNu.isEmpty())) {
                sortEmployees[i] = queueNu.remove();
            } else if (!(queueNam.isEmpty())){
                sortEmployees[i] = queueNam.remove();
            }
        }
        employees = sortEmployees;
    }

}
