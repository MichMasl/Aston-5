package ru.mihmas.aston_5.domain;

import java.util.Objects;

public class Contact {
    private final String firstName;
    private final String middleName;
    private final String secondName;
    private final String phoneNumber;
    private final int id;

    public Contact(String firstName, String middleName, String secondName, String phoneNumber, int id) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return id == contact.id && Objects.equals(firstName, contact.firstName) && Objects.equals(secondName, contact.secondName) && Objects.equals(phoneNumber, contact.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName, phoneNumber);
    }
}
