package com.example.demo;

import javax.persistence.*;

@Entity
public class Jacket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String color;
    private String material;
    private String size;
    private String season;
    private String imgUrl;
    private String type;
    private String category;

    @ManyToOne(fetch = FetchType.EAGER)
    private Closet closet;

    public Jacket() {
    }

    public Jacket(String color, String material, String size, String season, String imgUrl, String type, String category) {
        this.color = color;
        this.material = material;
        this.size = size;
        this.season = season;
        this.imgUrl = imgUrl;
        this.type = type;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Closet getCloset() {
        return closet;
    }

    public void setCloset(Closet closet) {
        this.closet = closet;
    }
}
