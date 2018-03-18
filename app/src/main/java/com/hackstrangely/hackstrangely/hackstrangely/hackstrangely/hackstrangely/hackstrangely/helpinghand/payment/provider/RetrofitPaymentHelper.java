package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment.provider;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.helper.Urls;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment.PaymentCallback;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment.api.RequestPayment;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment.model.PaymentDataResponse;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.register.RegisterCallback;

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

public class RetrofitPaymentHelper implements PaymentBaseClassHelper {
    @Override
    public void registerData(String firstname, String mobile, String email, String amount,String access_token, final PaymentCallback paymentCallback) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).addInterceptor(interceptor).build();

        Retrofit retrofit= new Retrofit.Builder().baseUrl(Urls.BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).build();
        RequestPayment requestPayment = retrofit.create(RequestPayment.class);
        Call<PaymentDataResponse> call= requestPayment.getJSON(firstname,mobile,email,amount,access_token);
        call.enqueue(new Callback<PaymentDataResponse>() {
            @Override
            public void onResponse(Call<PaymentDataResponse> call, Response<PaymentDataResponse> response) {
                paymentCallback.onPaymentSuccess(response.body());
            }

            @Override
            public void onFailure(Call<PaymentDataResponse> call, Throwable t) {
                paymentCallback.onPaymentFailure(t.getMessage());
            }
        });

    }
}
