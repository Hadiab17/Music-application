package com.hadiabbasi.musicplayer.Model;

public class Album {

    private String image_url;
    private String name;
    private String fav_count;
    private String song_count;
    private String singer_name;

    public Album(String image_url, String name, String fav_count, String song_count, String singer_name) {
        this.image_url = image_url;
        this.name = name;
        this.fav_count = fav_count;
        this.song_count = song_count;
        this.singer_name = singer_name;
    }

    public Album() {
    }

    public Album(String image_url, String name, String fav_count, String song_count) {
        this.image_url = image_url;
        this.name = name;
        this.fav_count = fav_count;
        this.song_count = song_count;
    }

    public String getSinger_name() {
        return singer_name;
    }

    public void setSinger_name(String singer_name) {
        this.singer_name = singer_name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFav_count() {
        return fav_count;
    }

    public void setFav_count(String fav_count) {
        this.fav_count = fav_count;
    }

    public String getSong_count() {
        return song_count;
    }

    public void setSong_count(String song_count) {
        this.song_count = song_count;
    }
}
