package ru.mihmas.aston_5.presentation.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import ru.mihmas.aston_5.R;
import ru.mihmas.aston_5.domain.model.Contact;
import ru.mihmas.aston_5.presentation.viewmodel.MainViewModel;

public class ContactDetailFragment extends Fragment {
    private OnEditFinished onEditFinished;
    private static final String CONTACT_INFO = "Contact info";
    private MainViewModel viewModel;
    private EditText firstName;
    private EditText middleName;
    private EditText secondName;
    private EditText phoneNumber;
    private Button saveButton;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        onEditFinished = (OnEditFinished) context;
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        return inflater.inflate(R.layout.fragment_contact_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int contactId = requireArguments().getInt(CONTACT_INFO);
        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        initViews(view);
        setupViews(contactId);
    }

    private void initViews(View view) {
        firstName = view.findViewById(R.id.first_name);
        middleName = view.findViewById(R.id.middle_name);
        secondName = view.findViewById(R.id.second_name);
        phoneNumber = view.findViewById(R.id.phone_number);
        saveButton = view.findViewById(R.id.save_changes_button);
    }

    private void setupViews(int contactId) {
        viewModel.getContact(contactId).observe(getViewLifecycleOwner(), contact -> {
            firstName.setText(contact.getFirstName());
            middleName.setText(contact.getMiddleName());
            secondName.setText(contact.getSecondName());
            phoneNumber.setText(contact.getPhoneNumber());
        });
        saveButton.setOnClickListener(click -> {
            String newFirstName = firstName.getText().toString();
            String newMiddleName = middleName.getText().toString();
            String newSecondName = secondName.getText().toString();
            String newPhoneNumber = phoneNumber.getText().toString();

            viewModel.editContact(
                    newFirstName,
                    newMiddleName,
                    newSecondName,
                    newPhoneNumber
            );
            requireActivity().getSupportFragmentManager().popBackStack();
            onEditFinished.onEditFinished();
        });
    }

    interface OnEditFinished {
        void onEditFinished();
    }

    public static ContactDetailFragment newInstance(int contactId) {
        Bundle args = new Bundle();
        args.putInt(CONTACT_INFO, contactId);
        ContactDetailFragment instanceWithArguments = new ContactDetailFragment();
        instanceWithArguments.setArguments(args);
        return instanceWithArguments;

    }
}