package com.github.neptuneluke.gaminghall;

import android.app.Application;

import com.github.neptuneluke.gaminghall.database.Games_RoomDatabase;
import com.github.neptuneluke.gaminghall.datasource.BaseLocalDataSource;
import com.github.neptuneluke.gaminghall.datasource.BaseRemoteDataSource;
import com.github.neptuneluke.gaminghall.datasource.BaseUserAuthenticationRemoteDataSource;
import com.github.neptuneluke.gaminghall.datasource.BaseUserDataRemoteDataSource;
import com.github.neptuneluke.gaminghall.datasource.LocalDataSource;
import com.github.neptuneluke.gaminghall.datasource.RemoteDataSource;
import com.github.neptuneluke.gaminghall.datasource.UserAuthenticationRemoteDataSource;
import com.github.neptuneluke.gaminghall.datasource.UserDataRemoteDataSource;
import com.github.neptuneluke.gaminghall.repository.GamesRepository;
import com.github.neptuneluke.gaminghall.repository.IGamesRepository;
import com.github.neptuneluke.gaminghall.repository.IUserRepository;
import com.github.neptuneluke.gaminghall.repository.UserRepository;
import com.github.neptuneluke.gaminghall.request.GamesApiSearch;
import com.github.neptuneluke.gaminghall.request.GamesApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceLocator {
    private static volatile ServiceLocator INSTANCE = null;

    private ServiceLocator() {}

    public static ServiceLocator getInstance() {
        if (INSTANCE == null) {
            synchronized(ServiceLocator.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ServiceLocator();
                }
            }
        }
        return INSTANCE;
    }

    public GamesApiService getGamesApiService() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.igdb.com/v4/").
                addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(GamesApiService.class);
    }

    public GamesApiSearch getSearchGamesApiService() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.igdb.com/v4/").
                addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(GamesApiSearch.class);
    }

    public Games_RoomDatabase getGamesDao(Application application) {
        return Games_RoomDatabase.getDatabase(application);
    }

    public IGamesRepository getGamesRepository(Application application, boolean debugMode) {
        BaseRemoteDataSource baseRemoteDataSource;
        BaseLocalDataSource baseLocalDataSource;
        baseRemoteDataSource =
                new RemoteDataSource("AIzaSyDjxOWg-U0iXBiF3JgtEzqD2w9GJ-x1wEo");
        baseLocalDataSource = new LocalDataSource(getGamesDao(application)) {
        };

        return new GamesRepository(baseRemoteDataSource, baseLocalDataSource);
    }


    public IUserRepository getUserRepository(Application application) {

        BaseUserAuthenticationRemoteDataSource userRemoteAuthenticationDataSource =
                new UserAuthenticationRemoteDataSource();

        BaseLocalDataSource baseLocalDataSource =
                new LocalDataSource(getGamesDao(application));

        BaseUserDataRemoteDataSource userDataRemoteDataSource =
                new UserDataRemoteDataSource();

        return new UserRepository(userRemoteAuthenticationDataSource, userDataRemoteDataSource, baseLocalDataSource);
    }

}
