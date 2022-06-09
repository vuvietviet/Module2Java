package models;

public class Account {
    private String accountName;
    private String passWord;
    private String numberPhone;
    private String address;
    private String email;
    private int age;
    private String useName;
    private String role;

    public Account() {
    }

    public Account(String accountName, String passWord, String numberPhone,
                   String address, String email, int age, String useName,String role) {
        this.accountName = accountName;
        this.passWord = passWord;
        this.numberPhone = numberPhone;
        this.address = address;
        this.email = email;
        this.age = age;
        this.useName = useName;
        this.role = role;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getNumberPhone() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        this.useName = useName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountName='" + accountName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", useName='" + useName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public String write() {
        return accountName + "," + passWord + "," + numberPhone + "," +
                address + "," + email + "," + age + "," + useName + "," + role;
    }
}
