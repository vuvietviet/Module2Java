package models;

public class Students {
    private String codeStudent;
    private String nameStudent;
    private int age;
    private String gender;
    private String address;
    private double scoreMedium;

    public Students() {
    }

    public Students(String codeStudent, String nameStudent, int age,
                    String gender, String address, double scoreMedium) {
        this.codeStudent = codeStudent;
        this.nameStudent = nameStudent;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.scoreMedium = scoreMedium;
    }

    public String getCodeStudent() {
        return codeStudent;
    }

    public void setCodeStudent(String codeStudent) {
        this.codeStudent = codeStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getScoreMedium() {
        return scoreMedium;
    }

    public void setScoreMedium(double scoreMedium) {
        this.scoreMedium = scoreMedium;
    }

    @Override
    public String toString() {
        return "Students{" +
                "codeStudent='" + codeStudent + '\'' +
                ", nameStudent='" + nameStudent + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", scoreMedium=" + scoreMedium +
                '}';
    }

    public String write() {
        return codeStudent + "," +nameStudent + "," + age + "," +
                gender + "," + address + "," + scoreMedium;
    }
}
