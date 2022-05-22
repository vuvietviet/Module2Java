import java.util.Date;

public class Employee {
    private String gender;
    private String birthday;

    public Employee() {
    }

    public Employee(String gender, String birthday) {
        this.gender = gender;
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
