package com.github.neptuneluke.gaminghall;

import static com.github.neptuneluke.gaminghall.Constants.APPLICATION_ID;
import static com.github.neptuneluke.gaminghall.Constants.SHARED_PREFERENCES_FILE_NAME;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

public class SharedPreferencesClass {

    private final Context context;
    private final String FILE_NAME = APPLICATION_ID + "." + SHARED_PREFERENCES_FILE_NAME;

    public SharedPreferencesClass(Application application) {
        this.context = application.getApplicationContext();
    }


    public void saveString(String key, String value) {

        SharedPreferences shared_pref = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shared_pref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getString(String key) {

        SharedPreferences shared_pref = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return shared_pref.getString(key, null);
    }


    public void saveSetString(String key, Set<String> value) {

        SharedPreferences shared_pref = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shared_pref.edit();
        editor.putStringSet(key, value);
        editor.apply();
    }

    public Set<String> getSetString(String key) {

        SharedPreferences shared_pref = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return shared_pref.getStringSet(key, null);
    }


    public void saveBoolean(String key, boolean value) {

        SharedPreferences shared_pref = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shared_pref.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean getBoolean(String key) {

        SharedPreferences shared_pref = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return shared_pref.getBoolean(key, false);
    }

}