package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment_list_ngo.api;



import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.helper.Urls;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment_list_ngo.model.NgoPaymentList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by samveg on 26/8/17.
 */

public interface RequestNgoPaymentApi {

    @GET(Urls.REQUEST_SUB_CATEGORY)
    Call<NgoPaymentList> getNgoPaymentData(@Query("token") String access_token);

}
