package ru.mihmas.aston_5.presentation.recycler_view;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import ru.mihmas.aston_5.R;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView firstName = itemView.findViewById(R.id.first_name);
    TextView secondName = itemView.findViewById(R.id.second_name);
    TextView phoneNumber = itemView.findViewById(R.id.phone_number);

    public MyViewHolder(View view) {
        super(view);
    }
}
