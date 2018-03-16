package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.register.provider;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.helper.Urls;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.register.RegisterCallback;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.register.api.RequestRegister;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.register.model.RegisterDataResponse;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by samveg on 28/9/17.
 */

public class RetrofitRegisterHelper implements RegisterBaseClassHelper{
    @Override
    public void registerData(String name, String mobile, String password, String userName,String aadhar,final RegisterCallback registerCallback) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).addInterceptor(interceptor).build();

        Retrofit retrofit= new Retrofit.Builder().baseUrl(Urls.BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).build();
        RequestRegister requestRegister = retrofit.create(RequestRegister.class);
        Call<RegisterDataResponse> call= requestRegister.getJSON(name,mobile,password,userName,aadhar);
        call.enqueue(new Callback<RegisterDataResponse>() {
            @Override
            public void onResponse(Call<RegisterDataResponse> call, Response<RegisterDataResponse> response) {
                registerCallback.onRegisterSuccess(response.body());
            }

            @Override
            public void onFailure(Call<RegisterDataResponse> call, Throwable t) {
                registerCallback.onRegisterFailure(t.getMessage());
            }
        });

    }
}
