package ru.mihmas.aston_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ru.mihmas.aston_5.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
    }
}