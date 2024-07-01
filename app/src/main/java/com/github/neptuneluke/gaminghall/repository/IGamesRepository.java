package com.github.neptuneluke.gaminghall.repository;

import androidx.lifecycle.MutableLiveData;

import com.github.neptuneluke.gaminghall.model.Games;
import com.github.neptuneluke.gaminghall.model.GamesApiResponse;

import java.util.List;

public interface IGamesRepository {

    MutableLiveData<GamesApiResponse> getGames(String query);

    MutableLiveData<GamesApiResponse> getResultGames(String query);

    MutableLiveData<GamesApiResponse> getFavoriteGames();

    MutableLiveData<GamesApiResponse> getCategoryGamesLiveData(String query);

    void deleteFavoriteGames();

    void updateStatusGames(Games games);
}
