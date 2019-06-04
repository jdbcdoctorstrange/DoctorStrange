package com.example.demo.ClosetApp;

import javax.persistence.*;

@Entity
public class Top extends Clothes{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Closet closet;

    private String sleeves;//either short or long

    public Top() {
    }

    public Top(String color, String material, String size, String season, String imgUrl, Closet closet, String sleeves) {
        super(color, material, size, season, imgUrl);
        this.closet = closet;
        this.sleeves = sleeves;
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

    public String getSleeves() {
        return sleeves;
    }

    public void setSleeves(String sleeves) {
        this.sleeves = sleeves;
    }
}
