package com.github.neptuneluke.gaminghall.datasource;

import com.github.neptuneluke.gaminghall.model.User;
import com.github.neptuneluke.gaminghall.repository.UserResponseCallback;

/**
 * Base class to get the user data from a remote source.
 */
public abstract class BaseUserDataRemoteDataSource {

    protected UserResponseCallback user_response_callback;

    public void setUserResponseCallback(UserResponseCallback userResponseCallback) {
        this.user_response_callback = userResponseCallback;
    }

    public abstract void saveUserData(User user);

}