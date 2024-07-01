package com.github.neptuneluke.gaminghall.repository;

import androidx.lifecycle.MutableLiveData;

import com.github.neptuneluke.gaminghall.model.Result;
import com.github.neptuneluke.gaminghall.model.User;

public interface IUserRepository {

    MutableLiveData<Result> getUser(String email, String password, boolean isUserRegistered);

    MutableLiveData<Result> getGoogleUser(String googleToken);

    MutableLiveData<Result> logout();

    User getLoggedUser();

    void signUp(String email, String password);

    void signIn(String email, String password);

    void signInWithGoogle(String googleToken);
}
