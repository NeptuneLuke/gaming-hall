package com.github.neptuneluke.gaminghall;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.github.neptuneluke.gaminghall.model.Result;
import com.github.neptuneluke.gaminghall.model.User;
import com.github.neptuneluke.gaminghall.repository.IUserRepository;

public class UserViewModel extends ViewModel {

    private static final String TAG = UserViewModel.class.getSimpleName();

    private final IUserRepository user_repository;
    private MutableLiveData<Result> user_mutablelivedata;
    private boolean authentication_error;

    public UserViewModel(IUserRepository userRepository) {
        this.user_repository = userRepository;
        authentication_error = false;
    }

    public MutableLiveData<Result> getUserMutableLiveData(String email, String password, boolean isUserRegistered) {
        if (user_mutablelivedata == null) {
            getUserData(email, password, isUserRegistered);
        }
        return user_mutablelivedata;
    }

    public MutableLiveData<Result> getGoogleUserMutableLiveData(String googleToken) {
        if (user_mutablelivedata == null) {
            getUserData(googleToken);
        }
        return user_mutablelivedata;
    }

    public User getLoggedUser() {
        return user_repository.getLoggedUser();
    }

    public MutableLiveData<Result> logout() {
        if (user_mutablelivedata == null) {
            user_mutablelivedata = user_repository.logout();
        }
        else {
            user_repository.logout();
        }

        return user_mutablelivedata;
    }

    public void getUser(String email, String password, boolean isUserRegistered) {
        user_repository.getUser(email, password, isUserRegistered);
    }

    public boolean isAuthenticationError() {
        return authentication_error;
    }

    public void setAuthenticationError(boolean authenticationError) {
        this.authentication_error = authenticationError;
    }

    private void getUserData(String email, String password, boolean isUserRegistered) {
        user_mutablelivedata = user_repository.getUser(email, password, isUserRegistered);
    }

    private void getUserData(String googleToken) {
        user_mutablelivedata = user_repository.getGoogleUser(googleToken);
    }
}