package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.register.api;


import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.helper.Urls;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.register.model.RegisterDataResponse;

/**
 * Created by samveg on 28/9/17.
 */

public interface RequestRegister {

    @FormUrlEncoded
    @POST(Urls.REQUEST_REGISTER)
    Call<RegisterDataResponse> getJSON(@Field("name") String name, @Field("mobile_number") String mobile, @Field("password") String password, @Field("blood") String bloodGroup, @Field("username") String userName, @Field("email") String eMail);

}
