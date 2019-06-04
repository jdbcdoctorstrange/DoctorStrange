package com.example.demo;

import javax.persistence.*;

@Entity
public class Footwear extends Clothes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Closet closet;

    public Footwear() {
    }

    public Footwear(String color, String material, String size, String season, String imgUrl) {
        super(color, material, size, season, imgUrl);
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
