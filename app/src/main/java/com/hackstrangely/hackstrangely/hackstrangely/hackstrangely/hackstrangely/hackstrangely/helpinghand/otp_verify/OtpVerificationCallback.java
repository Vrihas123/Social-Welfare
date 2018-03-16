package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.otp_verify;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.otp_verify.model.OtpData;

/**
 * Created by samveg on 28/9/17.
 */

public interface OtpVerificationCallback {

    void onOtpVerified(OtpData otpData);
    void onFailure(String error);

}
