package com.example.spotifyclone_coders_cave.model;

public class Home_Music_Tiles_Model {
    private String music_type, artist_name, music_name, music_description, music_year_of_production;
    private int music_poster, music_title_image_iv;

    public Home_Music_Tiles_Model(String music_type, String artist_name, String music_name, String music_description, String music_year_of_production, int music_poster, int music_title_image_iv) {
        this.music_type = music_type;
        this.artist_name = artist_name;
        this.music_name = music_name;
        this.music_description = music_description;
        this.music_year_of_production = music_year_of_production;
        this.music_poster = music_poster;
        this.music_title_image_iv = music_title_image_iv;
    }

    public Home_Music_Tiles_Model() {
    }

    public int getMusic_title_image_iv() {
        return music_title_image_iv;
    }

    public void setMusic_title_image_iv(int music_title_image_iv) {
        this.music_title_image_iv = music_title_image_iv;
    }

    public String getMusic_type() {
        return music_type;
    }

    public void setMusic_type(String music_type) {
        this.music_type = music_type;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public String getMusic_name() {
        return music_name;
    }

    public void setMusic_name(String music_name) {
        this.music_name = music_name;
    }

    public String getMusic_description() {
        return music_description;
    }

    public void setMusic_description(String music_description) {
        this.music_description = music_description;
    }

    public String getMusic_year_of_production() {
        return music_year_of_production;
    }

    public void setMusic_year_of_production(String music_year_of_production) {
        this.music_year_of_production = music_year_of_production;
    }

    public int getMusic_poster() {
        return music_poster;
    }

    public void setMusic_poster(int music_poster) {
        this.music_poster = music_poster;
    }
}
