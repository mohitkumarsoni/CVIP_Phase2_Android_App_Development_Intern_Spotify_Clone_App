package com.example.spotifyclone_coders_cave.model;

public class Album_Cover_info {
    private String  text;
    private int image;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Album_Cover_info() {
    }

    public Album_Cover_info(int image, String text) {
        this.image = image;
        this.text = text;
    }
}
