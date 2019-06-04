package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Top extends Clothes{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Top() {
    }

    public Top(String color, String material, String size, String season, String imgUrl) {
        super(color, material, size, season, imgUrl);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
