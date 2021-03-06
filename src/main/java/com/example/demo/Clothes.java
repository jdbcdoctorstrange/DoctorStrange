package com.example.demo;

public class Clothes {
    private String color;
    private String material;
    private String size;
    private String season;
    private String imgUrl;
    private String type;//shirt, tank top, sweater...
    private String category;

    public Clothes(String color, String material, String size, String season, String imgUrl, String type, String category) {
        this.color = color;
        this.material = material;
        this.size = size;
        this.season = season;
        this.imgUrl = imgUrl;
        this.type = type;
        this.category = category;
    }

    public Clothes() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString(){
        return "Color : "+getColor()+"\nMaterial: "+getMaterial()+"\nSize: "+getSize()+"\n";
    }
}
