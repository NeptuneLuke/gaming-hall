package com.github.neptuneluke.gaminghall.database;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.github.neptuneluke.gaminghall.model.Game;

import java.util.List;

@Dao
public interface Games_Dao {

    @Query("SELECT * FROM games")
    List<Game> getAll();

    @Query("SELECT * FROM games WHERE id = :id")
    Game getGamesById(long id);

    @Query("SELECT * FROM games WHERE is_favorite = 1")
    List<Game> getFavoriteGames();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insertGames(List<Game> gamesList);

    @Update
    int updateFavoriteGames(Game game);

    @Update
    int updateFavoriteGames(List<Game> gamesList);

    @Query("DELETE FROM games")
    int deleteAll();

}