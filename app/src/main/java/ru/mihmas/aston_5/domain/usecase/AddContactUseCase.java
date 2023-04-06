package ru.mihmas.aston_5.domain.usecase;

import ru.mihmas.aston_5.domain.model.Contact;
import ru.mihmas.aston_5.domain.repository.ContactListRepository;

public class AddContactUseCase {
    private final ContactListRepository repository;

    public AddContactUseCase(ContactListRepository repository) {
        this.repository = repository;
    }

    public void execute(Contact contact) {
        repository.addContact(contact);
    }
}
