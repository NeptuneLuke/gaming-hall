package com.github.neptuneluke.gaminghall.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Objects;

public class GameGenre implements Parcelable {

    private String name;

    protected GameGenre(Parcel in) {
        name = in.readString();
    }

    public static final Creator<GameGenre> CREATOR = new Creator<GameGenre>() {
        @Override
        public GameGenre createFromParcel(Parcel in) {
            return new GameGenre(in);
        }

        @Override
        public GameGenre[] newArray(int size) {
            return new GameGenre[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameGenre that = (GameGenre) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
    }
}