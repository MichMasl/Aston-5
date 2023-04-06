package ru.mihmas.aston_5.domain.usecase;

import ru.mihmas.aston_5.domain.model.Contact;
import ru.mihmas.aston_5.domain.repository.ContactListRepository;

public class DeleteContactUseCase {
    private final ContactListRepository repository;

    public DeleteContactUseCase(ContactListRepository repository) {
        this.repository = repository;
    }
    public void execute(Contact contact) {
        repository.deleteContact(contact);
    }
}
