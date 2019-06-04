package com.example.demo.ClosetApp;

public class Clothes {
    private String color;
    private String material;
    private String size;
    private String season;
    private String imgUrl;

    public Clothes() {
    }

    public Clothes(String color, String material, String size, String season, String imgUrl) {
        this.color = color;
        this.material = material;
        this.size = size;
        this.season = season;
        this.imgUrl = imgUrl;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString(){
        return "Color : "+getColor()+"\nMaterial: "+getMaterial()+"\nSize: "+getSize()+"\n";
    }
}
