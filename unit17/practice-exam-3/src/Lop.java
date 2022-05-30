import java.util.Date;

public class Lop {
    private String nameClass;
    private String dateBegin;
    private int course;
    private int numberOfStudents;

    public Lop() {
    }

    public Lop(String nameClass, String dateBegin, int course, int numberOfStudents) {
        this.nameClass = nameClass;
        this.dateBegin = dateBegin;
        this.course = course;
        this.numberOfStudents = numberOfStudents;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public String getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(String dateBegin) {
        this.dateBegin = dateBegin;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    @Override
    public String toString() {
        return "nameClass='" + nameClass + '\'' +
                ", dateBegin=" + dateBegin +
                ", course=" + course +
                ", numberOfStudents=" + numberOfStudents;
    }
}