package com.github.neptuneluke.gaminghall.database;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.github.neptuneluke.gaminghall.model.Games;

import java.util.List;

@Dao
public interface Games_Dao {

    @Query("SELECT * FROM games")
    List<Games> getAll();

    @Query("SELECT * FROM games WHERE id = :id")
    Games getGamesById(long id);

    @Query("SELECT * FROM games WHERE is_favorite = 1")
    List<Games> getFavoriteGames();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insertGames(List<Games> gamesList);

    @Update
    int updateFavoriteGames(Games game);

    @Update
    int updateFavoriteGames(List<Games> gamesList);

    @Query("DELETE FROM games")
    int deleteAll();

}