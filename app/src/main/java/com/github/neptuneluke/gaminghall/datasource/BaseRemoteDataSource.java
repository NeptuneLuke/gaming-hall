package com.github.neptuneluke.gaminghall.datasource;

public abstract class BaseRemoteDataSource {
    
    protected Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public abstract void getGamesApi(String query);

    public abstract void getResultGamesApi(String query);

    public abstract void getCategoryGames(String query);
}