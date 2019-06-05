package com.example.demo;

import javax.persistence.*;

@Entity
public class Accessories extends Clothes{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Closet closet;

    public Accessories(String color, String material, String size, String season, String imgUrl, String type, String category, Closet closet) {
        super(color, material, size, season, imgUrl, type, category);
        this.closet = closet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Closet getCloset() {
        return closet;
    }

    public void setCloset(Closet closet) {
        this.closet = closet;
    }
}
