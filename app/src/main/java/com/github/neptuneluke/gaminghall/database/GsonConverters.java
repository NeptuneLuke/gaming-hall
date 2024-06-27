package com.github.neptuneluke.gaminghall.database;

import androidx.room.TypeConverter;

import com.github.neptuneluke.gaminghall.model.GamesGenre;
import com.github.neptuneluke.gaminghall.model.GamesPlatform;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class GsonConverters {

    @TypeConverter
    public static List<GamesPlatform> fromStringPlatform(String value) {
        Type list = new TypeToken<List<GamesPlatform>>() {}.getType();
        return new Gson().fromJson(value, list);
    }

    @TypeConverter
    public static String fromListPlatform(List<GamesPlatform> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }


    @TypeConverter
    public static List<GamesGenre> fromStringGenre(String value) {
        Type list = new TypeToken<List<GamesGenre>>() {}.getType();
        return new Gson().fromJson(value, list);
    }

    @TypeConverter
    public static String fromListGenre(List<GamesGenre> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }
}