package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_list_items.provider;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.helper.Urls;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_list_items.api.RequestItemsApi;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_list_items.model.ItemList;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_list_items.view.OnItemRecieved;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by samveg on 24/8/17.
 */

public class RetrofitItemProvider implements ItemProvider {
    @Override
    public void requestItem(String access_token,final OnItemRecieved onItemRecieved) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        final RequestItemsApi request = retrofit.create(RequestItemsApi.class);
        Call<ItemList> call=request.getItemData(access_token);
        call.enqueue(new Callback<ItemList>(){
            @Override
            public void onResponse(Call<ItemList> call, Response<ItemList> response) {

                onItemRecieved.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ItemList> call, Throwable throwable) {
                onItemRecieved.onFailure();
            }
        });

    }
}
