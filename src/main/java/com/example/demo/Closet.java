package com.example.demo;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class Closet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @OneToMany(mappedBy = "closet", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Jacket> jackets;

    @OneToMany(mappedBy = "closet", cascade = CascadeType.ALL, orphanRemoval = true)
    Collection<Top> tops;

    @OneToMany(mappedBy = "closet", cascade = CascadeType.ALL, orphanRemoval = true)
    Collection<Bottom> bottoms;

    @OneToMany(mappedBy = "closet", cascade = CascadeType.ALL, orphanRemoval = true)
    Collection<Footwear> footwears;

    @OneToMany(mappedBy = "closet", cascade = CascadeType.ALL, orphanRemoval = true)
    Collection<Accessories> accessories;

    public Closet() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Collection<Jacket> getJackets() {
        return jackets;
    }

    public void setJackets(Collection<Jacket> jackets) {
        this.jackets = jackets;
    }

    public Collection<Top> getTops() {
        return tops;
    }

    public void setTops(Collection<Top> tops) {
        this.tops = tops;
    }

    public Collection<Bottom> getPants() {
        return bottoms;
    }

    public void setPants(Collection<Bottom> bottoms) {
        this.bottoms = bottoms;
    }

    public Collection<Footwear> getFootwears() {
        return footwears;
    }

    public void setFootwears(Collection<Footwear> footwears) {
        this.footwears = footwears;
    }

    public Collection<Accessories> getAccessories() {
        return accessories;
    }

    public void setAccessories(Collection<Accessories> accessories) {
        this.accessories = accessories;
    }

    //    public String randomOutfit(){
//        Collections.shuffle(jackets);
//        Collections.shuffle(tops);
//        Collections.shuffle(pants);
//        Collections.shuffle(footwears);
//
//        return "Jacket:\n"+jackets.get(0).toString()+"\nTop:\n"+ tops.get(0).toString()+"\nPair of Bottom:\n"
//                +pants.get(0).toString()+"\nShoes:\n"+footwears.get(0).toString()+"\n";
//    }
}
