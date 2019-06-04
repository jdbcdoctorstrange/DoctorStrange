package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;

public class Closet {
    ArrayList<Jacket> jackets = new ArrayList<>();
    ArrayList<Shirt> shirts = new ArrayList<>();
    ArrayList<Pants> pants = new ArrayList<>();
    ArrayList<Footwear> footwears = new ArrayList<>();

    public Closet(){

    }

    public Jacket getJacket(int i) {
        return jackets.get(i);
    }

    public void setJackets(Jacket jacket) {
        jackets.add(jacket);
    }

    public Shirt getShirts(int i) {
        return shirts.get(i);
    }

    public void setShirts(Shirt shirt) {
        shirts.add(shirt);
    }

    public Pants getPants(int i) {
        return pants.get(i);
    }

    public void setPants(Pants pant) {
        pants.add(pant);
    }

    public Footwear getFootwear(int i) {
        return footwears.get(i);
    }

    public void setFootwear(Footwear footwear) {
        footwears.add(footwear);
    }

    public String randomOutfit(){
        Collections.shuffle(jackets);
        Collections.shuffle(shirts);
        Collections.shuffle(pants);
        Collections.shuffle(footwears);

        return "Jacket:\n"+jackets.get(0).toString()+"\nShirt:\n"+shirts.get(0).toString()+"\nPair of Pants:\n"
                +pants.get(0).toString()+"\nShoes:\n"+footwears.get(0).toString()+"\n";
    }
}
