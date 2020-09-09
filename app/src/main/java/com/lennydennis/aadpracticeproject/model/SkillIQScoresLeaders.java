package com.lennydennis.aadpracticeproject.model;

import android.content.Context;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SkillIQScoresLeaders {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("score")
    @Expose
    private int score;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("badgeUrl")
    @Expose
    private String badgeUrl;

    public SkillIQScoresLeaders(String name, int score, String country, String badgeUrl) {
        this.name = name;
        this.score = score;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }

    @BindingAdapter("android:skillIQBadge")
    public static void loadSkillIQBadge(ImageView skillIQBadge, String badgeUrl){
        Glide.with(skillIQBadge.getContext())
                .asBitmap()
                .load(badgeUrl)
                .into(skillIQBadge);
    }

}
