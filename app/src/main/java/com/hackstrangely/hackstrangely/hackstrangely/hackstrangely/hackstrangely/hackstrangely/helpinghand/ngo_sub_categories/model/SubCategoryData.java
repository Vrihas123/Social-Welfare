package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_sub_categories.model;

/**
 * Created by samveg on 26/8/17.
 */

public class SubCategoryData {

    int id;
    String name,location,contact;

    public SubCategoryData(int id, String name, String location, String contact) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.contact = contact;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
