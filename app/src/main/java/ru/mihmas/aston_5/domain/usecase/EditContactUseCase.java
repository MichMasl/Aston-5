package ru.mihmas.aston_5.domain.usecase;

import ru.mihmas.aston_5.domain.repository.ContactListRepository;

public class EditContactUseCase {
    private final ContactListRepository repository;

    public EditContactUseCase(ContactListRepository repository) {
        this.repository = repository;
    }

    public void execute(
            String newFirstName,
            String newMiddleName,
            String newSecondName,
            String newPhoneNumber,
            int id
    ) {
        repository.editContact(
                newFirstName,
                newMiddleName,
                newSecondName,
                newPhoneNumber,
                id
        );
    }
}
