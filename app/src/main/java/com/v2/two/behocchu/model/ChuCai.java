package com.v2.two.behocchu.model;

public class ChuCai {
    private String chu;
    private String image;

    public ChuCai(String chu) {
        this.chu = chu;
    }

    public ChuCai() {
    }

    public ChuCai(String chu, String image) {
        this.chu = chu;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getChu() {
        return chu;
    }

    public void setChu(String chu) {
        this.chu = chu;
    }
}
