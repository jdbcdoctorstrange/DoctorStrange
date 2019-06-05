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

    @OneToMany(mappedBy = "closet",orphanRemoval = true)
    private Set<Jacket> jackets;

    @OneToMany(mappedBy = "closet",orphanRemoval = true)
    Set<Top> tops;

    @OneToMany(mappedBy = "closet",orphanRemoval = true)
    Set<Bottom> pants;

    @OneToMany(mappedBy = "closet",orphanRemoval = true)
    Set<Footwear> footwears;

    @OneToMany(mappedBy = "closet", orphanRemoval = true)
    Set<Accessories> accessories;

    public Closet(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Collection<Jacket> getJackets() {
        return jackets;
    }

    public void setJackets(Set<Jacket> jackets) {
        this.jackets = jackets;
    }

    public Set<Top> getTops() {
        return tops;
    }

    public void setTops(Set<Top> tops) {
        this.tops = tops;
    }

    public Set<Bottom> getPants() {
        return pants;
    }

    public void setPants(Set<Bottom> pants) {
        this.pants = pants;
    }

    public Set<Footwear> getFootwears() {
        return footwears;
    }

    public void setFootwears(Set<Footwear> footwears) {
        this.footwears = footwears;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Accessories> getAccessories() {
        return accessories;
    }

    public void setAccessories(Set<Accessories> accessories) {
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