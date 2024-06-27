package com.github.neptuneluke.gaminghall.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.github.neptuneluke.gaminghall.model.Games;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Games.class}, version = 1)
public abstract class Games_RoomDatabase extends RoomDatabase{

    public abstract Games_Dao gamesDao();

    private static volatile Games_RoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = Runtime.getRuntime().availableProcessors();
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static Games_RoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Games_RoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            Games_RoomDatabase.class,
                            "games_db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
