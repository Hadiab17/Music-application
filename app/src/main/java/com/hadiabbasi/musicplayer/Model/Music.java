package com.hadiabbasi.musicplayer.Model;

public class Music {

    private String singer_name, music_name, music_time, music_image_link, count;

    public Music(String music_name, String music_image_link){
        this.music_name = music_name;
        this.music_image_link = music_image_link;
    }

    public Music(String singer_name, String music_name, String music_time, String music_image_link) {
        this.singer_name = singer_name;
        this.music_name = music_name;
        this.music_time = music_time;
        this.music_image_link = music_image_link;
    }

    public Music(String music_image_link) {
        this.music_image_link = music_image_link;
    }

    public Music() {
    }

    public String getSinger_name() {
        return singer_name;
    }

    public void setSinger_name(String singer_name) {
        this.singer_name = singer_name;
    }

    public String getMusic_name() {
        return music_name;
    }

    public void setMusic_name(String music_name) {
        this.music_name = music_name;
    }

    public String getMusic_time() {
        return music_time;
    }

    public void setMusic_time(String music_time) {
        this.music_time = music_time;
    }

    public String getMusic_image_link() {
        return music_image_link;
    }

    public void setMusic_image_link(String music_image_link) {
        this.music_image_link = music_image_link;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
