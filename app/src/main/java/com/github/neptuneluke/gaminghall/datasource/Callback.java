package com.github.neptuneluke.gaminghall.datasource;

import com.github.neptuneluke.gaminghall.model.Games;

import java.util.List;

public interface Callback {

    void onSuccess(List<Games> data);

    void onResultSuccess(List<Games> data);

    void onSuccessFromLocal(List<Games> gamesList);

    void onGamesFavoriteStatusChanged(List<Games> games);

    void onGamesFavoriteStatusChanged(Games games, List<Games> favoriteGames);

    void onDeleteFavoriteGames(List<Games> favoriteGames);

    void onSuccessDeletion();
}
