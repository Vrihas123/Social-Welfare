package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.otp_verify.provider;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.otp_verify.OtpVerificationCallback;

/**
 * Created by samveg on 28/9/17.
 */

public interface OtpVerifyHelperClass {

    void getOtpResponse(String otp, String mobile, String access_token, OtpVerificationCallback otpVerificationCallback);
    void onDestroy();

}
