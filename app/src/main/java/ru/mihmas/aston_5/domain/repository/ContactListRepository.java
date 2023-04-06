package ru.mihmas.aston_5.domain.repository;

import java.util.List;

import ru.mihmas.aston_5.domain.model.Contact;

public interface ContactListRepository {
    Contact getContact(int contactId);
    List<Contact> getContactList();
    void addContact(Contact contact);
    void editContact(String newFirstName,
                     String newMiddleName,
                     String newSecondName,
                     String newPhoneNumber,
                     int id
    );
    void deleteContact(Contact contact);
}
