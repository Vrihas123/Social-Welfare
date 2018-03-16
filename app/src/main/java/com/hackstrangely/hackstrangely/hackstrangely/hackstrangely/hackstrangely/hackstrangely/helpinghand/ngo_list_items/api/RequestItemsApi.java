package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_list_items.api;


import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.helper.Urls;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_list_items.model.ItemList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by samveg on 25/8/17.
 */

public interface RequestItemsApi {

    @GET(Urls.REQUEST_ITEM_LIST)
    Call<ItemList> getItemData(@Query("access_token") String access_token);
}
