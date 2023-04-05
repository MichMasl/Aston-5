package ru.mihmas.aston_5.presentation.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ru.mihmas.aston_5.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(
                        R.id.fragment_container_view,
                        ContactListFragment.newInstance()
                ).commit();
    }


}