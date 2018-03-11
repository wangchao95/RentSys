package com.rent.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "house")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_house")
    @SequenceGenerator(name = "seq_house",sequenceName = "house_seql_id",allocationSize = 10,initialValue = 1)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private int price;

    @Column(name = "pubdate")
    private Date pubdate;

    @Column(name = "floorage")
    private int floorage;

    @Column(name = "contact")
    private String contact;

    @Transient
    private Users user;

    @Transient
   private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Street.class)
    @JoinColumn(name = "street_id")
    private Street street;

    private int minPrice;
    private int maxPrice;
    private int minFloorage;
    private int maxFloorage;

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getMinFloorage() {
        return minFloorage;
    }

    public void setMinFloorage(int minFloorage) {
        this.minFloorage = minFloorage;
    }

    public int getMaxFloorage() {
        return maxFloorage;
    }

    public void setMaxFloorage(int maxFloorage) {
        this.maxFloorage = maxFloorage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getPubdate() {
        return  new Date(pubdate.getTime());
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public int getFloorage() {
        return floorage;
    }

    public void setFloorage(int floorage) {
        this.floorage = floorage;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }



    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", pubdate=" + pubdate +
                ", floorage=" + floorage +
                ", contact='" + contact + '\'' +
                ", user=" + user +
                ", street=" + street +
                '}';
    }
}
