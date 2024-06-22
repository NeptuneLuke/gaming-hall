package com.github.neptuneluke.gaminghall.access;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.github.neptuneluke.gaminghall.R;

public class AccessMainActivity extends AppCompatActivity {

    private static final String TAG = AccessMainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_access_main);

        NavHostFragment nav_host_fragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);

        NavController nav_controller = nav_host_fragment.getNavController();
    }

}
