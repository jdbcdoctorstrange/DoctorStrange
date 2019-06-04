package com.example.demo;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Collections;
@Entity
public class Closet {

    ArrayList<Jacket> jackets = new ArrayList<>();
    ArrayList<Top> tops = new ArrayList<>();
    ArrayList<Bottom> pants = new ArrayList<>();
    ArrayList<Footwear> footwears = new ArrayList<>();

    public Closet(){

    }

    public Jacket getJacket(int i) {
        return jackets.get(i);
    }

    public void setJackets(Jacket jacket) {
        jackets.add(jacket);
    }

    public Top getShirts(int i) {
        return tops.get(i);
    }

    public void setTops(Top top) {
        tops.add(top);
    }

    public Bottom getPants(int i) {
        return pants.get(i);
    }

    public void setPants(Bottom pant) {
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
        Collections.shuffle(tops);
        Collections.shuffle(pants);
        Collections.shuffle(footwears);

        return "Jacket:\n"+jackets.get(0).toString()+"\nTop:\n"+ tops.get(0).toString()+"\nPair of Bottom:\n"
                +pants.get(0).toString()+"\nShoes:\n"+footwears.get(0).toString()+"\n";
    }
}
