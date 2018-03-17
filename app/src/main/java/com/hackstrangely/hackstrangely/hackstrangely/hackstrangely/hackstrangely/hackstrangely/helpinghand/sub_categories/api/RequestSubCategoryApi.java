package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.sub_categories.api;



import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.helper.Urls;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.sub_categories.model.SubCategoryList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by samveg on 26/8/17.
 */

public interface RequestSubCategoryApi {

    @GET(Urls.REQUEST_SUB_CATEGORY)
    Call<SubCategoryList> getsubCategoryData(@Query("id") String id, @Query("access_token") String access_token);

}
