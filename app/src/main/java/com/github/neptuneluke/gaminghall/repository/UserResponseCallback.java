package com.github.neptuneluke.gaminghall.repository;

import com.github.neptuneluke.gaminghall.model.User;

public interface UserResponseCallback {

    void onSuccessFromAuthentication(User user);

    void onFailureFromAuthentication(String message);

    void onSuccessFromRemoteDatabase(User user);

    void onFailureFromRemoteDatabase(String message);

    void onSuccessLogout();
}
