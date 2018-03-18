package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment_list_ngo.provider;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.helper.Urls;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment_list_ngo.api.RequestNgoPaymentApi;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment_list_ngo.model.NgoPaymentList;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment_list_ngo.view.OnNgoPaymentRecieved;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by samveg on 26/8/17.
 */

public class RetrofitNgoPaymentProvider implements NgoPaymentProvider {

    private Retrofit retrofit;
    private RequestNgoPaymentApi requestNgoPaymentApi;
    Call<NgoPaymentList> call;

    @Override
    public void requestNgoPaymentData(String access_token, final OnNgoPaymentRecieved onNgoPaymentRecieved) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        requestNgoPaymentApi = retrofit.create(RequestNgoPaymentApi.class);

        call = requestNgoPaymentApi.getNgoPaymentData(access_token);

        call.enqueue(new Callback<NgoPaymentList>() {
            @Override
            public void onResponse(Call<NgoPaymentList> call, Response<NgoPaymentList> response) {
                onNgoPaymentRecieved.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<NgoPaymentList> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
