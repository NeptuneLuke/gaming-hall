package com.github.neptuneluke.gaminghall.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Objects;

public class GamesCover implements Parcelable {

    private String url;

    public GamesCover(String url) {
        this.url = url;
    }

    protected GamesCover(Parcel in) {
        url = in.readString();
    }

    public static final Creator<GamesCover> CREATOR = new Creator<GamesCover>() {
        @Override
        public GamesCover createFromParcel(Parcel in) {
            return new GamesCover(in);
        }

        @Override
        public GamesCover[] newArray(int size) {
            return new GamesCover[size];
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
        GamesCover that = (GamesCover) o;
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