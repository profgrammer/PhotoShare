package com.example.photoshare;

public class Uploads {

    private String name, imageUrl, uploaderId;
    private int likes;

    public Uploads() {
        // empty
    }

    public Uploads(String name, String imageUrl, String uploaderId) {
        if(name.trim() == "") {
            this.name = "No title";
        } else {
            this.name = name;
        }
        this.imageUrl = imageUrl;
        this.uploaderId = uploaderId;
        this.likes = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUploaderId() {
        return uploaderId;
    }

    public void setUploaderId(String uploaderId) {
        this.uploaderId = uploaderId;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
