package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_list_items.model;

import java.util.List;

/**
 * Created by samveg on 24/8/17.
 */

public class ItemList {

    private List<ItemData> items;
    private boolean success;
    private String message;

    public List<ItemData> getData() {
        return items;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public ItemList(List<ItemData> items, boolean success, String message) {

        this.items = items;
        this.success = success;
        this.message = message;
    }
}
