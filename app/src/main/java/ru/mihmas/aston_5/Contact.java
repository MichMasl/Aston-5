package ru.mihmas.aston_5;

public class Contact {
    private String firstName;
    private String secondName;
    private String phoneNumber;

    public Contact(String firstName, String secondName, String phoneNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
