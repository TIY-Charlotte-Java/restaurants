package com.theironyard.charlotte;

/**
 * Created by Ben on 1/9/17.
 */
public class Restaurant {
    int id;
    String name;
    String address;
    String type;
    String price;
    int rating;

    public Restaurant() {
    }

    public Restaurant(int id, String name, String address, String type, String price, int rating) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.type = type;
        this.price = price;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
