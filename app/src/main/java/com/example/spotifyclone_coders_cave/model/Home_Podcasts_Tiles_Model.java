package com.example.spotifyclone_coders_cave.model;

public class Home_Podcasts_Tiles_Model {
    private int podcast_img;
    private String pod_title, pod_episode_name, pod_description, pod_time_duration;

    public int getPodcast_img() {
        return podcast_img;
    }

    public void setPodcast_img(int podcast_img) {
        this.podcast_img = podcast_img;
    }

    public String getPod_title() {
        return pod_title;
    }

    public void setPod_title(String pod_title) {
        this.pod_title = pod_title;
    }

    public String getPod_episode_name() {
        return pod_episode_name;
    }

    public void setPod_episode_name(String pod_episode_name) {
        this.pod_episode_name = pod_episode_name;
    }

    public String getPod_description() {
        return pod_description;
    }

    public void setPod_description(String pod_description) {
        this.pod_description = pod_description;
    }

    public String getPod_time_duration() {
        return pod_time_duration;
    }

    public void setPod_time_duration(String pod_time_duration) {
        this.pod_time_duration = pod_time_duration;
    }

    public Home_Podcasts_Tiles_Model() {
    }

    public Home_Podcasts_Tiles_Model(int podcast_img, String pod_title, String pod_episode_name, String pod_description, String pod_time_duration) {
        this.podcast_img = podcast_img;
        this.pod_title = pod_title;
        this.pod_episode_name = pod_episode_name;
        this.pod_description = pod_description;
        this.pod_time_duration = pod_time_duration;
    }
}
