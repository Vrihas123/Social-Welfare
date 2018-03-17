package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.sub_categories.provider;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.helper.Urls;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.sub_categories.api.RequestSubCategoryApi;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.sub_categories.model.SubCategoryList;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.sub_categories.view.OnSubCategoryRecieved;

import java.util.List;

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

public class RetrofitSubCategoryProvider implements SubCategoryProvider{

    private Retrofit retrofit;
    private RequestSubCategoryApi requestSubCategoryApi;
    Call<SubCategoryList> call;

    @Override
    public void requestSubCategoryData(String id,String access_token, final OnSubCategoryRecieved onSubCategoryRecieved) {

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

        requestSubCategoryApi = retrofit.create(RequestSubCategoryApi.class);

        call = requestSubCategoryApi.getsubCategoryData(id,access_token);

        call.enqueue(new Callback<SubCategoryList>() {
            @Override
            public void onResponse(Call<SubCategoryList> call, Response<SubCategoryList> response) {
                onSubCategoryRecieved.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<SubCategoryList> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
