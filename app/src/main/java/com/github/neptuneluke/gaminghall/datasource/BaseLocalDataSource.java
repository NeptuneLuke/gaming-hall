package com.github.neptuneluke.gaminghall.datasource;

import com.github.neptuneluke.gaminghall.model.Games;

import java.util.List;

public abstract class BaseLocalDataSource {

    protected Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public abstract void getFavoriteGames();

    public abstract void updateGame(Games games);

    public abstract void deleteFavoriteGames();

    public abstract void insertGames(List<Games> gamesList);

    public abstract void getAllGames();

    public abstract void deleteAll();
}
