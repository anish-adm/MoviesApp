package com.anish.movies.data.local.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.google.gson.annotations.SerializedName;
import com.anish.movies.data.remote.ApiConstants;
import com.squareup.picasso.Picasso;

@Entity(tableName = "movies")
public class MovieEntity {

    @PrimaryKey
    @SerializedName("id")
    private long id;

    @SerializedName("title")
    private String title;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("poster_path")
    private String posterPath;


    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    @SerializedName("overview")
    private String overview;

    @SerializedName("vote_average")
    private float voteAverage;

    @SerializedName("vote_count")
    private long voteCount;


    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public long getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(long voteCount) {
        this.voteCount = voteCount;
    }

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @BindingAdapter({"bind:posterPath"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.get().load(ApiConstants.RESOURCE_BASE_URL+imageUrl).into(view);
    }

}
