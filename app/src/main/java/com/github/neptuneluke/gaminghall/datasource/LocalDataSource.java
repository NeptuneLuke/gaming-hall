package com.github.neptuneluke.gaminghall.datasource;

import com.github.neptuneluke.gaminghall.database.Games_Dao;
import com.github.neptuneluke.gaminghall.database.Games_RoomDatabase;
import com.github.neptuneluke.gaminghall.model.Games;

import java.util.List;

public class LocalDataSource extends BaseLocalDataSource{

    private static final String TAG = LocalDataSource.class.getSimpleName();

    private final Games_Dao games_dao;


    public LocalDataSource(Games_RoomDatabase gamesRoomDatabase) {
        this.games_dao = gamesRoomDatabase.gamesDao();
    }

    public void getFavoriteGames() {

        Games_RoomDatabase.databaseWriteExecutor.execute(() -> {

            List<Games> favorite_games = games_dao.getFavoriteGames();
            callback.onGamesFavoriteStatusChanged(favorite_games);
        });
    }

    public void updateGame(Games game) {

        Games_RoomDatabase.databaseWriteExecutor.execute(() -> {

            int rows_updated = games_dao.updateFavoriteGames(game);
            if (rows_updated == 1) {
                Games id_games_update = games_dao.getGamesById(game.getId());
                callback.onGamesFavoriteStatusChanged(id_games_update, games_dao.getFavoriteGames());
            } else {
                // Error
            }
        });
    }

    public void deleteFavoriteGames() {

        Games_RoomDatabase.databaseWriteExecutor.execute(() -> {

            List<Games> favorite_games = games_dao.getFavoriteGames();
            for(Games games : favorite_games) {
                games.setFavorite(false);
            }
            int rows_updated = games_dao.updateFavoriteGames(favorite_games);

            if (rows_updated == favorite_games.size()) {
                callback.onDeleteFavoriteGames(favorite_games);
            } else {
                //Error
            }
        });
    }

    public void insertGames(List<Games> games) {

        Games_RoomDatabase.databaseWriteExecutor.execute(() -> {

            List<Games> allRoomGames = games_dao.getAll();
            if(games != null) {
                for (Games game : allRoomGames) {
                    if (games.contains(game)) {
                        games.set(games.indexOf(game), game);
                    }
                }
                List<Long> idGames = games_dao.insertGames(games);
                for (int i = 0; i < games.size(); i++) {
                    games.get(i).setId(idGames.get(i));
                }
                callback.onSuccessFromLocal(games);
            }
        });
    }

    public void getAllGames() {

        Games_RoomDatabase.databaseWriteExecutor.execute(() -> {
            callback.onSuccessFromLocal(games_dao.getAll());
        });
    }

    public void deleteAll() {

        Games_RoomDatabase.databaseWriteExecutor.execute(() -> {
            int rows_counter = games_dao.getAll().size();
            int rows_deleted_counter = games_dao.deleteAll();

            // It means that everything has been deleted
            if (rows_counter == rows_deleted_counter) {
                callback.onSuccessDeletion();
            }
        });
    }
}
