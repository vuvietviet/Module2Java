package models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HocVien implements Serializable {
    private String name;
    private int age;
    private Date birthDay;
    private String numberPhone;
    private String address;
    private Lop lop;

    public HocVien() {
    }

    public HocVien(String name, int age, Date birthDay, String numberPhone, String address, Lop lop) {
        this.name = name;
        this.age = age;
        this.birthDay = birthDay;
        this.numberPhone = numberPhone;
        this.address = address;
        this.lop = lop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String  getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", age=" + age +
                ", birthDay=" + birthDay +
                ", numberPhone=" + numberPhone +
                ", address='" + address + '\'' +
                lop.toString();
    }

    public String write() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return name + "," + age + "," + formatter.format(birthDay) + "," + numberPhone + "," +
                address + "," + lop.getNameClass();
    }
}
