package com.github.neptuneluke.gaminghall.repository;

import androidx.lifecycle.MutableLiveData;

import com.github.neptuneluke.gaminghall.datasource.Callback;
import com.github.neptuneluke.gaminghall.Util;
import com.github.neptuneluke.gaminghall.datasource.BaseLocalDataSource;
import com.github.neptuneluke.gaminghall.datasource.BaseUserAuthenticationRemoteDataSource;
import com.github.neptuneluke.gaminghall.datasource.BaseUserDataRemoteDataSource;
import com.github.neptuneluke.gaminghall.model.Games;
import com.github.neptuneluke.gaminghall.model.Result;
import com.github.neptuneluke.gaminghall.model.User;

import java.util.List;


/**
 * Repository class to get the user information.
 */
public class UserRepository implements IUserRepository, UserResponseCallback, Callback {

    private static final String TAG = UserRepository.class.getSimpleName();

    private final BaseUserAuthenticationRemoteDataSource userauth_remote_datasource;
    private final BaseUserDataRemoteDataSource userdata_remote_datasource;
    private final BaseLocalDataSource local_datasource;
    private final MutableLiveData<Result> user_mutablelivedata;


    public UserRepository(BaseUserAuthenticationRemoteDataSource userRemoteDataSource,
                          BaseUserDataRemoteDataSource userDataRemoteDataSource,
                          BaseLocalDataSource localDataSource) {

        this.userauth_remote_datasource = userRemoteDataSource;
        this.userdata_remote_datasource = userDataRemoteDataSource;
        this.local_datasource = localDataSource;
        this.user_mutablelivedata = new MutableLiveData<>();

        this.userauth_remote_datasource.setUserResponseCallback(this);
        this.userdata_remote_datasource.setUserResponseCallback(this);
        this.local_datasource.setCallback(this);
    }

    @Override
    public MutableLiveData<Result> getUser(String email, String password, boolean isUserRegistered) {

        Util.LOG_MESSAGE_D(TAG, "GET USER MUTABLE-LIVE-DATA");
        if (isUserRegistered) {
            Util.LOG_MESSAGE_D(TAG, "SIGN IN");
            signIn(email, password);
        } else {
            Util.LOG_MESSAGE_D(TAG, "SIGN UP");
            signUp(email, password);
        }
        return user_mutablelivedata;
    }

    @Override
    public MutableLiveData<Result> getGoogleUser(String idToken) {
        Util.LOG_MESSAGE_D(TAG, "GET GOOGLE USER MUTABLE-LIVE-DATA");
        signInWithGoogle(idToken);
        return user_mutablelivedata;
    }


    @Override
    public User getLoggedUser() {
        return userauth_remote_datasource.getLoggedUser();
    }

    @Override
    public MutableLiveData<Result> logout() {
        userauth_remote_datasource.logout();
        return user_mutablelivedata;
    }

    @Override
    public void signUp(String email, String password) {
        userauth_remote_datasource.signUp(email, password);
    }

    @Override
    public void signIn(String email, String password) {
        userauth_remote_datasource.signIn(email, password);
    }

    @Override
    public void signInWithGoogle(String token) {
        userauth_remote_datasource.signInWithGoogle(token);
    }


    @Override
    public void onSuccessFromAuthentication(User user) {
        if (user != null) {
            userdata_remote_datasource.saveUserData(user);
        }
    }

    @Override
    public void onFailureFromAuthentication(String message) {
        Result.Error result = new Result.Error(message);
        user_mutablelivedata.postValue(result);
    }

    @Override
    public void onSuccessFromRemoteDatabase(User user) {
        Result.UserResponseSuccess result = new Result.UserResponseSuccess(user);
        user_mutablelivedata.postValue(result);
    }



    @Override
    public void onFailureFromRemoteDatabase(String message) {
        Result.Error result = new Result.Error(message);
        user_mutablelivedata.postValue(result);
    }

    @Override
    public void onSuccessLogout() {
        local_datasource.deleteAll();
    }


    @Override
    public void onSuccess(List<Games> data) {

    }

    @Override
    public void onResultSuccess(List<Games> data) {

    }


    @Override
    public void onSuccessFromLocal(List<Games> gamesList) {

    }

    @Override
    public void onGamesFavoriteStatusChanged(List<Games> games) {

    }

    @Override
    public void onDeleteFavoriteGames(List<Games> favoriteGames) {

    }

    @Override
    public void onGamesFavoriteStatusChanged(Games games, List<Games> favoriteGames) {

    }

    @Override
    public void onSuccessDeletion() {
        Result.UserResponseSuccess result = new Result.UserResponseSuccess(null);
        user_mutablelivedata.postValue(result);
    }


}