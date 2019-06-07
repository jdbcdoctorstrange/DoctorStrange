package com.example.demo;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class Closet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "closet_name")
    private String closetName;

    @Column(name = "uid")
    private long uid;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @OneToMany(mappedBy = "closet", orphanRemoval = true)
    private Collection<Jacket> jackets;

    @OneToMany(mappedBy = "closet", orphanRemoval = true)
    Collection<Top> tops;

    @OneToMany(mappedBy = "closet", orphanRemoval = true)
    Collection<Bottom> bottoms;

    @OneToMany(mappedBy = "closet", orphanRemoval = true)
    Collection<Footwear> footwears;

    @OneToMany(mappedBy = "closet", orphanRemoval = true)
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

    public Collection<Bottom> getBottoms() {
        return bottoms;
    }

    public void setBottoms(Collection<Bottom> bottoms) {
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

    public String getClosetName() {
        return closetName;
    }

    public void setClosetName(String closetName) {
        this.closetName = closetName;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
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
