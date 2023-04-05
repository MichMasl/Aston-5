package ru.mihmas.aston_5.presentation.recycler_view;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import ru.mihmas.aston_5.domain.Contact;

public class ContactDiffCallback extends DiffUtil.ItemCallback<Contact> {
    @Override
    public boolean areItemsTheSame(@NonNull Contact oldItem, @NonNull Contact newItem) {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull Contact oldItem, @NonNull Contact newItem) {
        return oldItem.equals(newItem);
    }
}
