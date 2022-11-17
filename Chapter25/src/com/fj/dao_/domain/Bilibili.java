package com.fj.dao_.domain;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/6/30 22:15    since 1.0.0
 */
public class Bilibili {
    public String title;
    public String url;
    public String UP;
    public String Comment;
    public String PlayVolume;
    public int rank;

    public Bilibili() {
    }

    public Bilibili(String title, String url, String UP, String comment, String playVolume, int rank) {
        this.title = title;
        this.url = url;
        this.UP = UP;
        Comment = comment;
        PlayVolume = playVolume;
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUP() {
        return UP;
    }

    public void setUP(String UP) {
        this.UP = UP;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public String getPlayVolume() {
        return PlayVolume;
    }

    public void setPlayVolume(String playVolume) {
        PlayVolume = playVolume;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "\nBilibili{" +
                "title='" + title.replace("\n","").replace(" ","") + '\'' +
                ", url='" + url.replace("\n","").replace(" ","") + '\'' +
                ", UP='" + UP.replace("\n","").replace(" ","") + '\'' +
                ", Comment='" + Comment.replace("\n","").replace(" ","") + '\'' +
                ", PlayVolume='" + PlayVolume.replace("\n","").replace(" ","") + '\'' +
                ", rank=" + rank +
                '}';
    }
}
