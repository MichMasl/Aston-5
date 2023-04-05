package ru.mihmas.aston_5.domain;

public class GetContactUseCase {
    private final ContactListRepository repository;

    public GetContactUseCase(ContactListRepository repositoryImpl) {
        repository = repositoryImpl;
    }

    public Contact execute(int contactId) {
        return repository.getContact(contactId);
    }
}
