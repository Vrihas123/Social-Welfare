package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_end.api;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.helper.Urls;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_end.model.NgoEndList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by vrihas on 17/3/18.
 */
//item id,ngo id, access_token,donation details,donation quantity
    //success,msg,ngo details
public interface RequestNgoEndApi {
    @GET(Urls.REQUEST_NGO_DETAILS)
    Call<NgoEndList> getItemData(@Query("token") String token, @Query("itemId") int itemId, @Query("ngoId") int ngoId, @Query("quantity") int quantity, @Query("details") String details);
}
