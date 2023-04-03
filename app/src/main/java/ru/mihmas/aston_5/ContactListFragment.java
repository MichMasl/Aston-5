package ru.mihmas.aston_5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class ContactListFragment extends Fragment {

    LinearLayout linearLayout;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        return inflater.inflate(R.layout.fragment_contact_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        listInit(view);
    }

    public static ContactListFragment newInstance() {
        return new ContactListFragment();
    }

    private void initViews(View view) {
        linearLayout = view.findViewById(R.id.linear_layout);
    }

    private void listInit(View view) {
        for (Contact contact : contactList()) {
            linearLayout.addView(LayoutInflater.from(getContext()).inflate(
                            R.layout.contact_item,
                            linearLayout,
                            false
                    )
            );
            TextView firstName = view.findViewById(R.id.first_name);
            firstName.setText(contact.getFirstName());
//            secondName.setText(contact.getSecondName());
//            phoneNumber.setText(contact.getPhoneNumber());
        }
    }


    private List<Contact> contactList() {
        List<Contact> contactList = new ArrayList<>(5);
        contactList.add(new Contact(
                "Василий",
                "Петров",
                "223322223322"
        ));
        contactList.add(new Contact(
                "Иван",
                "Сидоров",
                "88005553535"
        ));
        contactList.add(new Contact(
                "Дарья",
                "Иванова",
                "123456789"
        ));
        contactList.add(new Contact(
                "Ольга",
                "Урожай",
                "987654321"
        ));
        contactList.add(new Contact(
                "Виктор",
                "Цой",
                "768493012"
        ));
        return contactList;
    }
}