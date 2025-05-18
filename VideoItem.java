package com.example.videobrowserapp;

public class VideoItem {
    private String title;
    private String description;
    private String videoUrl;
    private String thumbnailUrl;

    // Constructor to initialize the video item
    public VideoItem(String title, String description, String videoUrl, String thumbnailUrl) {
        this.title = title;
        this.description = description;
        this.videoUrl = videoUrl;
        this.thumbnailUrl = thumbnailUrl;
    }

    // Getter methods to retrieve video properties
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
}
