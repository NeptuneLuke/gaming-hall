package com.github.neptuneluke.gaminghall.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Objects;

public class GamesGenre implements Parcelable {

    private String name;

    protected GamesGenre(Parcel in) {
        name = in.readString();
    }

    public static final Creator<GamesGenre> CREATOR = new Creator<GamesGenre>() {
        @Override
        public GamesGenre createFromParcel(Parcel in) {
            return new GamesGenre(in);
        }

        @Override
        public GamesGenre[] newArray(int size) {
            return new GamesGenre[size];
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
        GamesGenre that = (GamesGenre) o;
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