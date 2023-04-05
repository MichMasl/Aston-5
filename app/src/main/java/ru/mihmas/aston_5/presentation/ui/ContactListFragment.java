package ru.mihmas.aston_5.presentation.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ru.mihmas.aston_5.R;
import ru.mihmas.aston_5.presentation.recycler_view.MyAdapter;
import ru.mihmas.aston_5.presentation.viewmodel.MainViewModel;

public class ContactListFragment extends Fragment {

    private MainViewModel viewModel;
    private MyAdapter adapter;

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
        setupRecyclerView(view);
        setupViewModel();
    }

    private void setupViewModel() {
        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        viewModel.getContactList().observe(getViewLifecycleOwner(), list -> adapter.submitList(list));
    }

    private void setupRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);
    }

    public static ContactListFragment newInstance() {
        return new ContactListFragment();
    }
}