package com.example.spotifyclone_coders_cave.model;

import android.graphics.Color;
import android.graphics.drawable.Drawable;

public class Search_Browse_Tiles {
    private int image;
    private String title;
    private int bgColor;


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBgColor() {
        return bgColor;
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }

    public Search_Browse_Tiles() {
    }

    public Search_Browse_Tiles(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public Search_Browse_Tiles(int image, String title, int bgColor) {
        this.image = image;
        this.title = title;
        this.bgColor = bgColor;
    }
}
