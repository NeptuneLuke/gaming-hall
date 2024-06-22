package com.github.neptuneluke.gaminghall;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        NavHostFragment nav_host_fragment = (NavHostFragment) getSupportFragmentManager().
                findFragmentById(R.id.nav_host_fragment);

        NavController nav_controller = nav_host_fragment.getNavController();
        BottomNavigationView bottom_nav = findViewById(R.id.bottom_navigation);

        new AppBarConfiguration.Builder(
                R.id.fragment_home, R.id.fragment_search, R.id.fragment_favorite,
                R.id.fragment_review, R.id.fragment_profile)
                .build();

        NavigationUI.setupWithNavController(bottom_nav, nav_controller);
    }

}
