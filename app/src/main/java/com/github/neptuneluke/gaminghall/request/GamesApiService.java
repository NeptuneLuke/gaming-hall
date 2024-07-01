package com.github.neptuneluke.gaminghall.request;

import com.github.neptuneluke.gaminghall.model.Games;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface GamesApiService {

    @Headers({
            "Client-ID: " + "q4ls0i7lpmqoc9j3k5jthmsire5t7v",
            "Authorization: Bearer " + "1vjwc0gn5pyzacym2bkz25cdcobgju"
    })
    @POST("games")
    Call<List<Games>> getApiGames(
            @Body RequestBody query);
}
