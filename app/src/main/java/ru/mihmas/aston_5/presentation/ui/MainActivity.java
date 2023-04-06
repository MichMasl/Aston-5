package ru.mihmas.aston_5.presentation.ui;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ru.mihmas.aston_5.R;

public class MainActivity extends AppCompatActivity implements ContactDetailFragment.OnEditFinished {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRightFragment();
    }

    private void setRightFragment() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(
                            R.id.fragment_container_view,
                            ContactListFragment.newInstance()
                    ).commit();
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(
                            R.id.contact_list_fragment_container_view,
                            ContactListFragment.newInstance()
                    ).commit();
        }
    }

    @Override
    public void onEditFinished() {
        setRightFragment();
    }
}