package com.github.neptuneluke.gaminghall.repository;

import androidx.lifecycle.MutableLiveData;

import com.github.neptuneluke.gaminghall.model.Games;
import com.github.neptuneluke.gaminghall.model.GamesApiResponse;
import com.github.neptuneluke.gaminghall.datasource.BaseLocalDataSource;
import com.github.neptuneluke.gaminghall.datasource.BaseRemoteDataSource;
import com.github.neptuneluke.gaminghall.datasource.Callback;

import java.util.List;

public class GamesRepository implements IGamesRepository, Callback {

    private static final String TAG = GamesRepository.class.getSimpleName();

    private final MutableLiveData<GamesApiResponse> games_livedata;
    private final MutableLiveData<GamesApiResponse> result_games_livedata;
    private final MutableLiveData<GamesApiResponse> favorite_games_livedata;
    private final MutableLiveData<GamesApiResponse> category_games_livedata;

    private final BaseRemoteDataSource base_remote_datasource;
    private final BaseLocalDataSource base_local_datasource;

    public GamesRepository(BaseRemoteDataSource baseDataSource, BaseLocalDataSource baseLocalDataSource) {

        games_livedata = new MutableLiveData<>();
        favorite_games_livedata = new MutableLiveData<>();
        result_games_livedata = new MutableLiveData<>();
        category_games_livedata = new MutableLiveData<>();

        this.base_remote_datasource = baseDataSource;
        this.base_local_datasource = baseLocalDataSource;
        this.base_remote_datasource.setCallback(this);
        this.base_local_datasource.setCallback(this);
    }

    @Override
    public MutableLiveData<GamesApiResponse> getGames(String query) {
        base_remote_datasource.getGamesApi(query);
        return games_livedata;
    }


    @Override
    public MutableLiveData<GamesApiResponse> getResultGames(String query) {
        base_remote_datasource.getResultGamesApi(query);
        return result_games_livedata;
    }

    @Override
    public MutableLiveData<GamesApiResponse> getFavoriteGames() {
        base_local_datasource.getFavoriteGames();
        return favorite_games_livedata;
    }

    @Override
    public MutableLiveData<GamesApiResponse> getCategoryGamesLiveData(String query) {
        base_remote_datasource.getCategoryGames(query);
        return category_games_livedata;
    }

    @Override
    public void onSuccess(List<Games> data) {
        base_local_datasource.insertGames(data);
    }

    @Override
    public void onResultSuccess(List<Games> data) {
        GamesApiResponse result = new GamesApiResponse(data);
        result_games_livedata.postValue(result);
    }

    @Override
    public void onSuccessFromLocal(List<Games> gamesList) {
        GamesApiResponse result = new GamesApiResponse(gamesList);
        games_livedata.postValue(result);
    }


    @Override
    public void onGamesFavoriteStatusChanged(List<Games> games) {
        favorite_games_livedata.postValue(new GamesApiResponse(games));
    }

    @Override
    public void onDeleteFavoriteGames(List<Games> favoriteGames) {
        GamesApiResponse all_games = games_livedata.getValue();

        if (all_games != null) {
            List<Games> oldGames = ((GamesApiResponse) all_games).getResults();
            for (Games games : favoriteGames) {
                if (oldGames.contains(games)) {
                    oldGames.set(oldGames.indexOf(games), games);
                }
            }
            games_livedata.postValue(all_games);
        }

        if (favorite_games_livedata.getValue() != null) {
            favoriteGames.clear();
            GamesApiResponse result = new GamesApiResponse(favoriteGames);
            favorite_games_livedata.postValue(result);
        }
    }

    @Override
    public void onGamesFavoriteStatusChanged(Games games, List<Games> favoriteGames) {
        GamesApiResponse allGames = games_livedata.getValue();

        if (allGames != null) {
            List<Games> oldGames = ((GamesApiResponse) allGames).getResults();
            if (oldGames.contains(games)) {
                oldGames.set(oldGames.indexOf(games), games);
                games_livedata.postValue(allGames);
            }
        }
        favorite_games_livedata.postValue(new GamesApiResponse(favoriteGames));
    }

    @Override
    public void onSuccessDeletion() {

    }

    @Override
    public void updateStatusGames(Games games) {
        base_local_datasource.updateGame(games);
    }

    @Override
    public void deleteFavoriteGames() {
        base_local_datasource.deleteFavoriteGames();
    }
}
