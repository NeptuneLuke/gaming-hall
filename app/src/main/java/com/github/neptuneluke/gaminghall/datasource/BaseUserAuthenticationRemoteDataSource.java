package com.github.neptuneluke.gaminghall.datasource;

import com.github.neptuneluke.gaminghall.model.User;
import com.github.neptuneluke.gaminghall.repository.UserResponseCallback;

/**
 * Base class to manage the user authentication.
 */
public abstract class BaseUserAuthenticationRemoteDataSource {

    protected UserResponseCallback user_response_callback;

    public void setUserResponseCallback(UserResponseCallback userResponseCallback) {
        this.user_response_callback = userResponseCallback;
    }


    public abstract User getLoggedUser();

    public abstract void logout();

    public abstract void signUp(String email, String password);

    public abstract void signIn(String email, String password);

    public abstract void signInWithGoogle(String googleToken);
}