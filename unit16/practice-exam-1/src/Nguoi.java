import java.util.Date;

public class Nguoi {
    private String fullName;
    private Date birthDay;
    private String address;
    private String classStudent;
    private int course;
    private int semester;

    public Nguoi() {
    }

    public Nguoi(String fullName, Date birthDay, String address,
                 String classStudent, int course, int semester) {
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.address = address;
        this.classStudent = classStudent;
        this.course = course;
        this.semester = semester;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClassStudent() {
        return classStudent;
    }

    public void setClassStudent(String classStudent) {
        this.classStudent = classStudent;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return  "fullName='" + fullName + '\'' +
                ", birthDay=" + birthDay +
                ", address='" + address + '\'' +
                ", classStudent='" + classStudent + '\'' +
                ", course=" + course +
                ", semester=" + semester;
    }
}
