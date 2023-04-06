package ru.mihmas.aston_5.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ru.mihmas.aston_5.data.ContactListRepositoryImpl;
import ru.mihmas.aston_5.domain.model.Contact;
import ru.mihmas.aston_5.domain.repository.ContactListRepository;
import ru.mihmas.aston_5.domain.usecase.AddContactUseCase;
import ru.mihmas.aston_5.domain.usecase.DeleteContactUseCase;
import ru.mihmas.aston_5.domain.usecase.EditContactUseCase;
import ru.mihmas.aston_5.domain.usecase.GetContactListUseCase;
import ru.mihmas.aston_5.domain.usecase.GetContactUseCase;

public class MainViewModel extends ViewModel {
    private final ContactListRepository repository = new ContactListRepositoryImpl();
    private final GetContactListUseCase getContactListUseCase = new GetContactListUseCase(repository);
    private final GetContactUseCase getContactUseCase = new GetContactUseCase(repository);
    private final AddContactUseCase addContactUseCase = new AddContactUseCase(repository);
    private final EditContactUseCase editContactUseCase = new EditContactUseCase(repository);
    private final DeleteContactUseCase deleteContactUseCase = new DeleteContactUseCase(repository);

    public int idOfClickedContact;

    private MutableLiveData<List<Contact>> getContactList;
    private MutableLiveData<Contact> getContact;

    public MutableLiveData<List<Contact>> getContactList() {
        if (getContactList == null) {
            getContactList = new MutableLiveData<>();
        }
        getContactList.setValue(getContactListUseCase.execute());
        return getContactList;
    }

    public MutableLiveData<Contact> getContact(int contactId) {
        if (getContact == null) {
            getContact = new MutableLiveData<>();
        }
        getContact.setValue(getContactUseCase.execute(contactId));
        return getContact;
    }

    public void addContact(
            String firstName,
            String middleName,
            String secondName,
            String phoneNumber
    ) {
        Contact contact = new Contact(firstName, middleName, secondName, phoneNumber);
        addContactUseCase.execute(contact);
    }

    public void editContact(
            String firstName,
            String middleName,
            String secondName,
            String phoneNumber
    ) {
        editContactUseCase.execute(firstName, middleName, secondName, phoneNumber, idOfClickedContact);
    }

    public void deleteContact(Contact contact) {
        deleteContactUseCase.execute(contact);
    }
}
