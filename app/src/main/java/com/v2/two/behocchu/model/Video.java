package com.v2.two.behocchu.model;

public class Video {
    private String name;
    private String image;
    private String idVideo;
    private String idPlayList;

    public Video() {
    }

    public Video(String name, String image, String idVideo, String idPlayList) {
        this.name = name;
        this.image = image;
        this.idVideo = idVideo;
        this.idPlayList = idPlayList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(String idVideo) {
        this.idVideo = idVideo;
    }

    public String getIdPlayList() {
        return idPlayList;
    }

    public void setIdPlayList(String idPlayList) {
        this.idPlayList = idPlayList;
    }
}
