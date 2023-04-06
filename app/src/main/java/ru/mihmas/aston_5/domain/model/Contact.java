package ru.mihmas.aston_5.domain.model;

import java.util.Objects;

public class Contact {
    public final static int UNDEFINED_ID = -1;
    private String firstName;
    private String middleName;
    private String secondName;
    private String phoneNumber;
    private int id = UNDEFINED_ID;

    public Contact(String firstName, String middleName, String secondName, String phoneNumber) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int newId) {
        id = newId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String newFirstName) {
        firstName = newFirstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String newMiddleName) {
        middleName = newMiddleName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String newSecondName) {
        secondName = newSecondName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String newPhoneNumber) {
        phoneNumber = newPhoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(firstName, contact.firstName) && Objects.equals(middleName, contact.middleName) && Objects.equals(secondName, contact.secondName) && Objects.equals(phoneNumber, contact.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, secondName, phoneNumber, id);
    }
}

