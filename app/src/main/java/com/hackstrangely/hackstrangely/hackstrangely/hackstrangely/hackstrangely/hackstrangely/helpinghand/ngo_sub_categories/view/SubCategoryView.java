package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_sub_categories.view;


import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_sub_categories.model.SubCategoryData;

import java.util.List;

/**
 * Created by samveg on 26/8/17.
 */

public interface SubCategoryView {

    void showProgressBar(boolean show);
    void setSubCategoryData(List<SubCategoryData> subCategoryList);

}
