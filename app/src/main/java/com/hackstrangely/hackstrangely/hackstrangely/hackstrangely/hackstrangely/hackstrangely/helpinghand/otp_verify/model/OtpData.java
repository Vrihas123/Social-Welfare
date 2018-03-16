package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.otp_verify.model;

/**
 * Created by samveg on 28/9/17.
 */

public class OtpData {

    private String message;
    private boolean success;
    public OtpData(String message, boolean success)
    {
        this.message=message;
        this.success=success;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

}
