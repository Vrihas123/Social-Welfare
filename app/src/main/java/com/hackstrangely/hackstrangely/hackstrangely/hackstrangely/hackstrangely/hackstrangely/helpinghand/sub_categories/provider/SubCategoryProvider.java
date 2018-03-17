package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.sub_categories.provider;


import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.sub_categories.view.OnSubCategoryRecieved;

import java.util.List;

/**
 * Created by samveg on 26/8/17.
 */

public interface SubCategoryProvider {

    void requestSubCategoryData(String id,String access_token, OnSubCategoryRecieved onSubCategoryRecieved);

}
