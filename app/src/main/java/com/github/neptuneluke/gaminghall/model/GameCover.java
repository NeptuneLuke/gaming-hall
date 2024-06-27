package com.github.neptuneluke.gaminghall.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Objects;

public class GameCover implements Parcelable {

    private String url;

    public GameCover(String url) {
        this.url = url;
    }

    protected GameCover(Parcel in) {
        url = in.readString();
    }

    public static final Creator<GameCover> CREATOR = new Creator<GameCover>() {
        @Override
        public GameCover createFromParcel(Parcel in) {
            return new GameCover(in);
        }

        @Override
        public GameCover[] newArray(int size) {
            return new GameCover[size];
        }
    };

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameCover that = (GameCover) o;
        return Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }

    @Override
    public String toString() {
        return url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(url);
    }
}