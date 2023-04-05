package ru.mihmas.aston_5.presentation.recycler_view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import java.util.List;

import ru.mihmas.aston_5.R;
import ru.mihmas.aston_5.domain.Contact;

public class MyAdapter extends ListAdapter<Contact, MyViewHolder> {

    public MyAdapter() {
        super(new ContactDiffCallback());
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.contact_item,
                parent,
                false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.firstName.setText(getItem(position).getFirstName());
        holder.secondName.setText(getItem(position).getSecondName());
        holder.phoneNumber.setText(getItem(position).getPhoneNumber());
    }
}
