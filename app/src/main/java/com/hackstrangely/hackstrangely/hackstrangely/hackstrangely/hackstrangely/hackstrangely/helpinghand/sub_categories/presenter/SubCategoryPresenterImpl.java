package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.sub_categories.presenter;



import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.sub_categories.model.SubCategoryList;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.sub_categories.provider.SubCategoryProvider;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.sub_categories.view.OnSubCategoryRecieved;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.sub_categories.view.SubCategoryView;

import java.util.List;

/**
 * Created by samveg on 26/8/17.
 */

public class SubCategoryPresenterImpl implements SubCategoryPresenter{

    SubCategoryView subCategoryView;
    SubCategoryProvider subCategoryProvider;

    public SubCategoryPresenterImpl(SubCategoryView subCategoryView, SubCategoryProvider subCategoryProvider) {
        this.subCategoryView = subCategoryView;
        this.subCategoryProvider = subCategoryProvider;
    }
    @Override
    public void requestSubCategory(String id, String access_token) {

        subCategoryView.showProgressBar(true);
        subCategoryProvider.requestSubCategoryData(id,access_token,new OnSubCategoryRecieved() {
            @Override
            public void onSuccess(SubCategoryList subCategoryList) {
                subCategoryView.showProgressBar(false);
                if(subCategoryList.isSuccess()){
                    subCategoryView.setSubCategoryData(subCategoryList.getGet_property());
                }
            }

            @Override
            public void onFailure() {
                subCategoryView.showProgressBar(false);
            }
        });

    }
}
