package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.login.api;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.helper.Urls;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.login.model.LoginDataResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by samveg on 28/9/17.
 */

public interface RequestLogin {

    @FormUrlEncoded
    @POST(Urls.REQUEST_LOGIN)
    Call<LoginDataResponse> getJSON(@Field("username") String mobile, @Field("password") String password);

}
