package ru.mihmas.aston_5.domain.usecase;

import java.util.List;

import ru.mihmas.aston_5.domain.model.Contact;
import ru.mihmas.aston_5.domain.repository.ContactListRepository;

public class GetContactListUseCase {
    private final ContactListRepository repository;

    public GetContactListUseCase(ContactListRepository repository) {
        this.repository = repository;
    }

    public List<Contact> execute() {
        return repository.getContactList();
    }
}
