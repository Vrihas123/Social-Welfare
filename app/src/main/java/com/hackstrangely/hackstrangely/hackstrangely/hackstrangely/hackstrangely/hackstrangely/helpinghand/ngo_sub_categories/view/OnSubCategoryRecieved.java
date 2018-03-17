package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_sub_categories.view;


import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_sub_categories.model.SubCategoryList;

/**
 * Created by samveg on 26/8/17.
 */

public interface OnSubCategoryRecieved {

    void onSuccess(SubCategoryList subCategoryList);
    void onFailure();

}
