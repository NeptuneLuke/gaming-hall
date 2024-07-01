package com.github.neptuneluke.gaminghall.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.List;

public class GamesApiResponse implements Parcelable {

    private List<Games> results;


    public GamesApiResponse() {
        super();
    }

    public GamesApiResponse(List<Games> results) {
        this.results = results;
    }

    protected GamesApiResponse(Parcel in) {
        results = in.createTypedArrayList(Games.CREATOR);
    }

    public static final Creator<GamesApiResponse> CREATOR = new Creator<GamesApiResponse>() {
        @Override
        public GamesApiResponse createFromParcel(Parcel in) {
            return new GamesApiResponse(in);
        }

        @Override
        public GamesApiResponse[] newArray(int size) {
            return new GamesApiResponse[size];
        }
    };

    @Override
    public String toString() {
        return "GamesApiResponse{" +
                ", results=" + results +
                '}';
    }

    public List<Games> getResults() {
        return results;
    }

    public void setResults(List<Games> results) {
        this.results = results;
    }

    public void reset(){
        results.clear();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeTypedList(results);
    }
}
