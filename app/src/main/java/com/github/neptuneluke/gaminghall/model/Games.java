package com.github.neptuneluke.gaminghall.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.github.neptuneluke.gaminghall.database.GsonConverter;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

@Entity
public class Games implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @Embedded(prefix = "cover")
    private GameCover cover;

    private long first_release_date;

    @SerializedName("summary")
    private String summary;

    @SerializedName("name")
    private String name;

    @SerializedName("platforms")
    @TypeConverters(GsonConverter.class)
    private List<GamePlatform> platforms;

    @SerializedName("genres")
    @TypeConverters(GsonConverter.class)
    private List<GameGenre> genres;

    private double rating;

    @ColumnInfo(name = "is_favorite")
    private boolean isFavorite;


    public Games(long id, GameCover cover, long first_release_date,
                 String summary, String name,
                 List<GamePlatform> platforms, List<GameGenre> genres,
                 double rating, boolean isFavorite) {

        this.id = id;
        this.cover = cover;
        this.first_release_date = first_release_date;
        this.summary = summary;
        this.name = name;
        this.platforms = platforms;
        this.genres = genres;
        this.rating = rating;
        this.isFavorite = isFavorite;
    }

    protected Games(Parcel in) {
        id = in.readLong();
        cover = in.readParcelable(GameCover.class.getClassLoader());
        first_release_date = in.readLong();
        summary = in.readString();
        name = in.readString();
        platforms = in.createTypedArrayList(GamePlatform.CREATOR);
        genres = in.createTypedArrayList(GameGenre.CREATOR);
        rating = in.readDouble();
        isFavorite = in.readByte() != 0;
    }

    public static final Creator<Games> CREATOR = new Creator<Games>() {
        @Override
        public Games createFromParcel(Parcel in) {
            return new Games(in);
        }

        @Override
        public Games[] newArray(int size) {
            return new Games[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public GameCover getCover() {
        return cover;
    }

    public void setCover(GameCover cover) {
        this.cover = cover;
    }

    public long getFirst_release_date() {
        return first_release_date;
    }

    public void setFirst_release_date(long first_release_date) {
        this.first_release_date = first_release_date;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GamePlatform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<GamePlatform> platforms) {
        this.platforms = platforms;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<GameGenre> getGenres() {
        return genres;
    }

    public void setGenres(List<GameGenre> genres) {
        this.genres = genres;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Games game = (Games) o;
        return id == game.id
                && first_release_date == game.first_release_date
                && Double.compare(rating, game.rating) == 0
                && Objects.equals(cover, game.cover)
                && Objects.equals(summary, game.summary)
                && Objects.equals(name, game.name)
                && Objects.equals(platforms, game.platforms)
                && Objects.equals(genres, game.genres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cover, first_release_date, summary, name, platforms, genres, rating);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeParcelable(cover, flags);
        dest.writeLong(first_release_date);
        dest.writeString(summary);
        dest.writeString(name);
        dest.writeTypedList(platforms);
        dest.writeTypedList(genres);
        dest.writeDouble(rating);
        dest.writeByte((byte) (isFavorite ? 1 : 0));
    }

    @Override
    public String toString() {
        return "Games{" +
                "id=" + id +
                ", cover=" + cover +
                ", first_release_date=" + first_release_date +
                ", summary='" + summary + '\'' +
                ", name='" + name + '\'' +
                ", platforms=" + platforms +
                ", genres=" + genres +
                ", rating=" + rating +
                ", isFavorite=" + isFavorite +
                '}';
    }
}