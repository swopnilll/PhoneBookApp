package main.java.app;

public class PhoneBookEntry implements InterfacePhoneBookEntry {
    private String name;
    private String phoneNumber;
    private String birthday;
    private String address;
    private String email;

    public PhoneBookEntry() {

    }

    public PhoneBookEntry(String name, String phoneNumber, String birthday) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
    }

    public PhoneBookEntry(String name, String phoneNumber, String birthday, String address, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.email = email;
        this.address = address;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getBirthday() {
        return birthday;
    }

    @Override
    public void setBirthday(String birthday) {
        this.birthday = birthday;
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
    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthday='" + birthday + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'';
    }
}
