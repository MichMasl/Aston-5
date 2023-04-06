package ru.mihmas.aston_5.domain.usecase;

import ru.mihmas.aston_5.domain.model.Contact;
import ru.mihmas.aston_5.domain.repository.ContactListRepository;

public class GetContactUseCase {
    private final ContactListRepository repository;

    public GetContactUseCase(ContactListRepository repository) {
        this.repository = repository;
    }

    public Contact execute(int contactId) {
        return repository.getContact(contactId);
    }
}
