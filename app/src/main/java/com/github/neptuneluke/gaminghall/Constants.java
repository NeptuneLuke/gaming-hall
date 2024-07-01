package com.github.neptuneluke.gaminghall;

public class Constants {

    // Application
    public static final String APPLICATION_ID = "com.github.neptuneluke.gaminghall";

    // Strings
    public static final int USERNAME_MIN_LENGTH = 1;
    public static final int USERNAME_MAX_LENGTH = 30;
    public static final int PASSWORD_MIN_LENGTH = 6;
    public static final int PASSWORD_MAX_LENGTH = 30;

    // Firebase Realtime Database
    public static final String FIREBASE_REALTIME_DATABASE = "https://gaminghall-e3416-default-rtdb.firebaseio.com";
    public static final String FIREBASE_USERS_COLLECTION = "users";

    // Shared Preferences
    public static final String SHARED_PREFERENCES_FILE = "shared_pref";

    // Errors
    public static final String RETROFIT_ERROR = "retrofit_error";
    public static final String API_KEY_ERROR = "api_key_error";
    public static final String UNEXPECTED_ERROR = "unexpected_error";
    public static final String INVALID_USER_ERROR = "invalidUserError";
    public static final String INVALID_CREDENTIALS_ERROR = "invalidCredentials";
    public static final String USER_COLLISION_ERROR = "userCollisionError";
    public static final String WEAK_PASSWORD_ERROR = "passwordIsWeak";
}
