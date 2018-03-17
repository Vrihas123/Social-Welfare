package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_sub_categories.provider;


import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_sub_categories.view.OnSubCategoryRecieved;

/**
 * Created by samveg on 26/8/17.
 */

public interface SubCategoryProvider {

    void requestSubCategoryData(int id,String access_token, OnSubCategoryRecieved onSubCategoryRecieved);

}
