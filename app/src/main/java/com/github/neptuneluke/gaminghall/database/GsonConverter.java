package com.github.neptuneluke.gaminghall.database;

import androidx.room.TypeConverter;

import com.github.neptuneluke.gaminghall.model.GameGenre;
import com.github.neptuneluke.gaminghall.model.GamePlatform;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class GsonConverter {

    @TypeConverter
    public static List<GamePlatform> fromStringPlatform(String value) {
        Type list = new TypeToken<List<GamePlatform>>() {}.getType();
        return new Gson().fromJson(value, list);
    }

    @TypeConverter
    public static String fromListPlatform(List<GamePlatform> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }


    @TypeConverter
    public static List<GameGenre> fromStringGenre(String value) {
        Type list = new TypeToken<List<GameGenre>>() {}.getType();
        return new Gson().fromJson(value, list);
    }

    @TypeConverter
    public static String fromListGenre(List<GameGenre> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }
}