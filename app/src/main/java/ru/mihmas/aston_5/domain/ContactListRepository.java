package ru.mihmas.aston_5.domain;

import java.util.List;

public interface ContactListRepository {
    Contact getContact(int contactId);
    List<Contact> getContactList();
}
