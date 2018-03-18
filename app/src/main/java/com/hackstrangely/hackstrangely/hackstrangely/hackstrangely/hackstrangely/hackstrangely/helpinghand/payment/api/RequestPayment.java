package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment.api;


import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.helper.Urls;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment.model.PaymentDataResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by samveg on 28/9/17.
 */

public interface RequestPayment {

    @FormUrlEncoded
    @POST(Urls.REQUEST_PAYMENT)
    Call<PaymentDataResponse> getJSON(@Field("firstname") String name, @Field("phone") String mobile, @Field("email") String email, @Field("amount") String amount, @Field("token") String access_token);

}
