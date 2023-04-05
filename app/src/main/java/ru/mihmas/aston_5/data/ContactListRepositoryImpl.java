package ru.mihmas.aston_5.data;

import java.util.ArrayList;
import java.util.List;

import ru.mihmas.aston_5.domain.Contact;
import ru.mihmas.aston_5.domain.ContactListRepository;

public class ContactListRepositoryImpl implements ContactListRepository {

    private final List<Contact> contactList = new ArrayList<>();

    public ContactListRepositoryImpl() {
        listInit();
    }

    @Override
    public Contact getContact(int contactId) {
        return contactList.get(contactId);
    }

    @Override
    public List<Contact> getContactList() {
        return contactList;
    }

    private void listInit() {
        contactList.add(new Contact(
                "Василий",
                "Петров",
                "223322223322",
                0
        ));
        contactList.add(new Contact(
                "Анатолий",
                "Комар",
                "39486739046",
                1
        ));
        contactList.add(new Contact(
                "Иван",
                "Сидоров",
                "88005553535",
                2
        ));
        contactList.add(new Contact(
                "Дарья",
                "Иванова",
                "123456789",
                3
        ));
        contactList.add(new Contact(
                "Ольга",
                "Урожай",
                "987654321",
                4
        ));
        contactList.add(new Contact(
                "Виктор",
                "Цой",
                "768493012",
                5
        ));
    }
}
