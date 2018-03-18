package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment.model;

/**
 * Created by samveg on 28/9/17.
 */

public class PaymentDataResponse {

    private boolean success;
    private String message;
    public PaymentDataResponse(boolean success, String message)
    {
        this.message=message;
        this.success=success;
    }


    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }


}
