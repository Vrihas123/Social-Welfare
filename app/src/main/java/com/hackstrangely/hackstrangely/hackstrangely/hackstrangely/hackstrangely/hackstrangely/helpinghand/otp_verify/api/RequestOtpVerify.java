package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.otp_verify.api;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.helper.Urls;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.otp_verify.model.OtpData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by samveg on 28/9/17.
 */

public interface RequestOtpVerify {

    @FormUrlEncoded
    @POST(Urls.REQUEST_VERIFY)
    Call<OtpData> getJson(@Field("otp") String otp, @Field("number") String mobile, @Field("token") String access_token);

}
