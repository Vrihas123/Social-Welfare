package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_sub_categories.model;

import java.util.List;

/**
 * Created by samveg on 26/8/17.
 */

public class SubCategoryList {

    boolean success;
    String message;
    private List<SubCategoryData> ngo;

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<SubCategoryData> getGet_property() {
        return ngo;
    }

    public SubCategoryList(boolean success, String message, List<SubCategoryData> ngo) {

        this.success = success;
        this.message = message;
        this.ngo = ngo;
    }
}
