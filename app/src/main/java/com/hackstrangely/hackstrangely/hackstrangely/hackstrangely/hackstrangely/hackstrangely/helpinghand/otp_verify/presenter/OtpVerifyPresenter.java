package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.otp_verify.presenter;

/**
 * Created by samveg on 28/9/17.
 */

public interface OtpVerifyPresenter {

    void otpData(String otp, String mobile, String access_token);
    void onDestroy();

}
