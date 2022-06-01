package validate;

import models.Students;

import java.util.List;
import java.util.Scanner;

public class ValidateStudent {
    Scanner scanner = new Scanner(System.in);

    public String validateCodeStudent(List<Students> studentsList) {
        while (true) {
            try {
                System.out.println("Input code student:");
                String codeStudent = scanner.nextLine();
                if (getIndexCodeStudent(codeStudent, studentsList) != -1) {
                    throw new Exception();
                }
                return codeStudent;
            } catch (Exception e) {
                System.err.println("Format code student: Error!");
            }
        }
    }

    public int getIndexCodeStudent(String codeStudent, List<Students> studentsList) {
        for (int i = 0; i < studentsList.size(); i++) {
            if (studentsList.get(i).getCodeStudent().equals(codeStudent)) {
                return i;
            }
        }
        return -1;
    }

    public String validateString(String name) {
        while (true) {
            System.out.println("Input " + name);
            String str = scanner.nextLine();
            if (str.equals("")) {
                System.err.println("Cannot empty");
                continue;
            } else {
                return str;
            }
        }
    }

    public int validateAge() {
        while (true) {
            try {
                System.out.println("Input age:");
                int age = Integer.parseInt(scanner.nextLine());
                return age;
            } catch (Exception e) {
                System.err.println("Format age: Error");
            }
        }
    }

    public double validateScore() {
        while (true) {
            try {
                System.out.println("Input score medium:");
                double scoreMedium = Double.parseDouble(scanner.nextLine());
                return scoreMedium;
            } catch (Exception e) {
                System.err.println("Format score: Error");
            }
        }
    }
}
