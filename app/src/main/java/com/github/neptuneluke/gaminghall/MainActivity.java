package com.github.neptuneluke.gaminghall;

import android.content.pm.ActivityInfo;
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

        // Set the application orientation to vertical (portrait) mode
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Hide the action bar (in this application only the title bar)
        if(getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        setContentView(R.layout.activity_main);

        NavHostFragment nav_host_fragment = (NavHostFragment) getSupportFragmentManager().
                findFragmentById(R.id.nav_host_fragment);

        BottomNavigationView bottom_nav = findViewById(R.id.bottom_navigation);
        if(nav_host_fragment != null) {
            NavController nav_controller = nav_host_fragment.getNavController();
            NavigationUI.setupWithNavController(bottom_nav, nav_controller);
        }

        AppBarConfiguration bar_config = new AppBarConfiguration.Builder(
                R.id.home_fragment, R.id.search_fragment, R.id.favorite_fragment,
                R.id.review_fragment, R.id.profile_fragment)
                .build();

    }

}
