package com.github.neptuneluke.gaminghall.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.github.neptuneluke.gaminghall.database.GsonConverters;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

@Entity
public class Games implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @Embedded(prefix = "cover")
    private GamesCover cover;

    private long first_release_date;

    @SerializedName("summary")
    private String summary;

    @SerializedName("name")
    private String name;

    @SerializedName("platforms")
    @TypeConverters(GsonConverters.class)
    private List<GamesPlatform> platforms;

    @SerializedName("genres")
    @TypeConverters(GsonConverters.class)
    private List<GamesGenre> genres;

    private double rating;

    @ColumnInfo(name = "is_favorite")
    private boolean isFavorite;


    public Games(long id, GamesCover cover, long first_release_date,
                 String summary, String name,
                 List<GamesPlatform> platforms, List<GamesGenre> genres,
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
        cover = in.readParcelable(GamesCover.class.getClassLoader());
        first_release_date = in.readLong();
        summary = in.readString();
        name = in.readString();
        platforms = in.createTypedArrayList(GamesPlatform.CREATOR);
        genres = in.createTypedArrayList(GamesGenre.CREATOR);
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

    public GamesCover getCover() {
        return cover;
    }

    public void setCover(GamesCover cover) {
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

    public List<GamesPlatform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<GamesPlatform> platforms) {
        this.platforms = platforms;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<GamesGenre> getGenres() {
        return genres;
    }

    public void setGenres(List<GamesGenre> genres) {
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
        Games games = (Games) o;
        return id == games.id
                && first_release_date == games.first_release_date
                && Double.compare(rating, games.rating) == 0
                && Objects.equals(cover, games.cover)
                && Objects.equals(summary, games.summary)
                && Objects.equals(name, games.name)
                && Objects.equals(platforms, games.platforms)
                && Objects.equals(genres, games.genres);
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