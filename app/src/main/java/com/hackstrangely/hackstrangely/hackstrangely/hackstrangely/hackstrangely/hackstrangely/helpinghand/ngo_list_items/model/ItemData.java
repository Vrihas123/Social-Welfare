package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_list_items.model;

/**
 * Created by samveg on 24/8/17.
 */

public class ItemData {
    String item,image;
    int id;

    public ItemData(String item, String image, int id) {
        this.item = item;
        this.image = image;
        this.id = id;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {

        return item;
    }

    public String getImage() {
        return image;
    }

    public int getId() {
        return id;
    }
}
