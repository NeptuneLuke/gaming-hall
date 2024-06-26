package com.github.neptuneluke.gaminghall;

import android.util.Log;

import androidx.core.util.PatternsCompat;

public class Util {

    // Login/Registration
    public static boolean isValidUsername(String username) {
        if(username.length() < Constants.USERNAME_MIN_LENGTH
            || username.length() > Constants.USERNAME_MAX_LENGTH
            || username.contains(" ")) {
            return false;
        }
        return true;
    }

    public static boolean isValidEmail(String email) {
        if(!PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()) {
            return false;
        }
        return true;
    }

    public static boolean isValidPassword(String password) {
        if(password.isEmpty()
                || password.contains(" ")
                || password.length() < Constants.PASSWORD_MIN_LENGTH
                || password.length() > Constants.PASSWORD_MAX_LENGTH) {
            return false;
        }
        return true;
    }


    // Logs
    public static void LOG_MESSAGE_D(String TAG, String message) {

        message = message.toUpperCase();
        String separator = "";
        for(int i=0; i < message.length(); ++i) {
            separator += "-";
        }
        Log.d(TAG,separator);
        Log.d(TAG,message);
    }

    public static void LOG_MESSAGE_I(String TAG, String message) {

        message = message.toUpperCase();
        String separator = "";
        for(int i=0; i < message.length(); ++i) {
            separator += "-";
        }
        Log.i(TAG,separator);
        Log.i(TAG,message);
    }
}
