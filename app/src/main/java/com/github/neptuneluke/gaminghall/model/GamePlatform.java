package com.github.neptuneluke.gaminghall.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Objects;

public class GamePlatform implements Parcelable {

    private String name;

    protected GamePlatform(Parcel in) {
        name = in.readString();
    }

    public static final Creator<GamePlatform> CREATOR = new Creator<GamePlatform>() {
        @Override
        public GamePlatform createFromParcel(Parcel in) {
            return new GamePlatform(in);
        }

        @Override
        public GamePlatform[] newArray(int size) {
            return new GamePlatform[size];
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
        GamePlatform that = (GamePlatform) o;
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