package com.github.neptuneluke.gaminghall.access;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.github.neptuneluke.gaminghall.R;

public class AccessMainActivity extends AppCompatActivity {

    private static final String TAG = AccessMainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the activity orientation to vertical (portrait) mode
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Hide the action bar (in this application only the title bar)
        if(getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // Disable the application night mode (dark theme)
        // Users can still override this setting if they have a system-wide dark theme
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        setContentView(R.layout.activity_access_main);

        NavHostFragment nav_host_fragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);

        NavController nav_controller = nav_host_fragment.getNavController();
    }

}
