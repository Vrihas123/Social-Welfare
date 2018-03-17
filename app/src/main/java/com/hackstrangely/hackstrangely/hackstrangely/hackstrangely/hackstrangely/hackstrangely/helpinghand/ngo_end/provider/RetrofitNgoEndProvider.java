package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_end.provider;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.helper.Urls;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_end.api.RequestNgoEndApi;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_end.model.NgoEndList;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_end.view.OnNgoDetailsRecieved;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vrihas on 17/3/18.
 */

public class RetrofitNgoEndProvider implements NgoEndProvider {

    @Override
    public void requestNgoEnd(String token, int itemId, int ngoId, int quantity, String details, final OnNgoDetailsRecieved onNgoDetailsRecieved) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).addInterceptor(interceptor).build();

        Retrofit retrofit= new Retrofit.Builder().baseUrl(Urls.BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).build();
        RequestNgoEndApi requestNgoEndApi = retrofit.create(RequestNgoEndApi.class);
        Call<NgoEndList> call = requestNgoEndApi.getItemData(token, itemId, ngoId, quantity, details);
        call.enqueue(new Callback<NgoEndList>() {
            @Override
            public void onResponse(Call<NgoEndList> call, Response<NgoEndList> response) {
                onNgoDetailsRecieved.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<NgoEndList> call, Throwable t) {
                onNgoDetailsRecieved.onFailure(t.getMessage());
            }
        });
    }
}
