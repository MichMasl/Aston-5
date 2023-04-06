package ru.mihmas.aston_5.data;

import java.util.ArrayList;
import java.util.List;

import ru.mihmas.aston_5.domain.model.Contact;
import ru.mihmas.aston_5.domain.repository.ContactListRepository;

public class ContactListRepositoryImpl implements ContactListRepository {

    private final List<Contact> contactList = new ArrayList<>();
    private int autoId = 0;

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

    @Override
    public void addContact(Contact contact) {
        if (contact.getId() == Contact.UNDEFINED_ID) {
            contact.setId(autoId++);
        }
        contactList.add(contact);
    }

    @Override
    public void editContact(
            String newFirstName,
            String newMiddleName,
            String newSecondName,
            String newPhoneNumber,
            int id
    ) {
        for (Contact contact : contactList) {
            if (contact.getId() == id) {
                contact.setFirstName(newFirstName);
                contact.setMiddleName(newMiddleName);
                contact.setSecondName(newSecondName);
                contact.setPhoneNumber(newPhoneNumber);
            }
        }
        getContactList();
    }

    @Override
    public void deleteContact(Contact contact) {
        contactList.remove(contact.getId());
        autoId--;
    }

    private void listInit() {
        contactList.add(new Contact(
                "Василий",
                "Евграфович",
                "Петров",
                "223322223322"
        ));
        contactList.add(new Contact(
                "Анатолий",
                "Германович",
                "Комар",
                "39486739046"
        ));
        contactList.add(new Contact(
                "Иван",
                "Полиграфович",
                "Сидоров",
                "88005553535"
        ));
        contactList.add(new Contact(
                "Дарья",
                "Лукинична",
                "Иванова",
                "123456789"
        ));
        contactList.add(new Contact(
                "Ольга",
                "Кондратьевна",
                "Урожай",
                "987654321"
        ));
        contactList.add(new Contact(
                "Виктор",
                "Робертович",
                "Цой",
                "768493012"
        ));
        for (Contact contact : contactList) {
            contact.setId(autoId++);
        }
    }
}
