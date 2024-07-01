package com.github.neptuneluke.gaminghall;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.github.neptuneluke.gaminghall.repository.IUserRepository;


/**
 * Custom ViewModelProvider to be able to have a custom constructor
 * for the UserViewModel class.
 */
public class UserViewModelFactory implements ViewModelProvider.Factory {

    private final IUserRepository user_repository;

    public UserViewModelFactory(IUserRepository userRepository) {
        this.user_repository = userRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new UserViewModel(user_repository);
    }
}