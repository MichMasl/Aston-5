package ru.mihmas.aston_5.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ru.mihmas.aston_5.data.ContactListRepositoryImpl;
import ru.mihmas.aston_5.domain.Contact;
import ru.mihmas.aston_5.domain.ContactListRepository;
import ru.mihmas.aston_5.domain.GetContactListUseCase;
import ru.mihmas.aston_5.domain.GetContactUseCase;

public class MainViewModel extends ViewModel {
    private final ContactListRepository repository = new ContactListRepositoryImpl();
    private final GetContactListUseCase getContactListUseCase = new GetContactListUseCase(repository);
    private final GetContactUseCase getContactUseCase = new GetContactUseCase(repository);

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
}
