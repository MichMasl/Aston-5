package ru.mihmas.aston_5.domain;

import java.util.List;

public class GetContactListUseCase {
    private final ContactListRepository repository;

    public GetContactListUseCase(ContactListRepository repositoryImpl) {
        repository = repositoryImpl;
    }

    public List<Contact> execute() {
        return repository.getContactList();
    }
}
