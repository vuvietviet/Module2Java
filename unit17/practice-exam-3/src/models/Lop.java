package models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Lop implements Serializable {
    private String nameClass;
    private Date dateBegin;
    private int course;
    private int numberOfStudents;

    public Lop() {
    }

    public Lop(String nameClass, Date dateBegin, int course, int numberOfStudents) {
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

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
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

    public String write() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return nameClass + "," +formatter.format(dateBegin) + "," + course + "," + numberOfStudents;
    }
}