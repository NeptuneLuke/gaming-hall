package com.github.neptuneluke.gaminghall.datasource;

import android.util.Log;

import androidx.annotation.NonNull;

import com.github.neptuneluke.gaminghall.ServiceLocator;
import com.github.neptuneluke.gaminghall.model.Games;
import com.github.neptuneluke.gaminghall.request.GamesApiSearch;
import com.github.neptuneluke.gaminghall.request.GamesApiService;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteDataSource extends BaseRemoteDataSource {

    private static final String TAG = RemoteDataSource.class.getSimpleName();

    private final GamesApiService games_api_service;
    private final GamesApiSearch games_api_search;
    private final String api_key;

    public RemoteDataSource(String apiKey) {
        this.api_key = apiKey;
        this.games_api_service = ServiceLocator.getInstance().getGamesApiService();
        this.games_api_search = ServiceLocator.getInstance().getSearchGamesApiService();
    }


    @Override
    public void getGamesApi(String query) {
        RequestBody body =
                RequestBody.create(MediaType.parse("text/plain"), query);
        Call<List<Games>> responseCall = games_api_service.getApiGames(body);

        responseCall.enqueue(new Callback<List<Games>>() {
            @Override
            public void onResponse(@NonNull Call<List<Games>> call,
                                   @NonNull Response<List<Games>> response) {

                Log.e(TAG, String.valueOf(response.body()));

                if (response.body() != null) {
                    callback.onSuccess(response.body());
                } else {
                    //Error
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Games>> call, @NonNull Throwable t) {
                //Error
            }
        });
    }


    @Override
    public void getResultGamesApi(String query) {
        RequestBody body =
                RequestBody.create(MediaType.parse("text/plain"), query);
        Call<List<Games>> responseCall = games_api_search.getApiSearchGames(body);

        responseCall.enqueue(new Callback<List<Games>>() {
            @Override
            public void onResponse(@NonNull Call<List<Games>> call,
                                   @NonNull Response<List<Games>> response) {

                Log.e(TAG, String.valueOf(response.body()));

                if (response.body() != null) {
                    callback.onResultSuccess(response.body());
                } else {
                    //Error
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Games>> call, @NonNull Throwable t) {
                //Error
            }
        });
    }

    @Override
    public void getCategoryGames(String query) {
        RequestBody body =
                RequestBody.create(MediaType.parse("text/plain"), query);
        Call<List<Games>> responseCall = games_api_search.getApiSearchGames(body);

        responseCall.enqueue(new Callback<List<Games>>() {
            @Override
            public void onResponse(@NonNull Call<List<Games>> call,
                                   @NonNull Response<List<Games>> response) {

                Log.e(TAG, String.valueOf(response.body()));

                if (response.body() != null) {
                    callback.onResultSuccess(response.body());
                } else {
                    //Error
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Games>> call, @NonNull Throwable t) {
                //Error
            }
        });
    }
}
