package com.example.spotifyclone_coders_cave.model;

public class Music_List_Model {
    private int posterImg;
    private String songName, songDuration;

    public int getPosterImg() {
        return posterImg;
    }

    public void setPosterImg(int posterImg) {
        this.posterImg = posterImg;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongDuration() {
        return songDuration;
    }

    public void setSongDuration(String songDuration) {
        this.songDuration = songDuration;
    }

    public Music_List_Model() {
    }

    public Music_List_Model(int posterImg, String songName, String songDuration) {
        this.posterImg = posterImg;
        this.songName = songName;
        this.songDuration = songDuration;
    }
}
