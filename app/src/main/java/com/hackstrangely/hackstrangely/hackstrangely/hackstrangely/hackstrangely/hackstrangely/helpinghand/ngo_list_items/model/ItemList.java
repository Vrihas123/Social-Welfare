package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_list_items.model;

import java.util.List;

/**
 * Created by samveg on 24/8/17.
 */

public class ItemList {

    private List<ItemData> data;
    private boolean success;
    private String message;

    public List<ItemData> getData() {
        return data;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public ItemList(List<ItemData> data, boolean success, String message) {

        this.data = data;
        this.success = success;
        this.message = message;
    }
}
