package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.otp_verify.view;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.otp_verify.model.OtpData;

/**
 * Created by samveg on 28/9/17.
 */

public interface OtpView {

    void showProgressBar(boolean show);
    void showMessage(String message);
    void OtpStatus(OtpData otpData);

}
