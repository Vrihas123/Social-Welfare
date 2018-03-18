package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment_list_ngo.model;

import java.util.List;

/**
 * Created by samveg on 26/8/17.
 */

public class NgoPaymentList {

    boolean success;
    String message;
    private List<NgoPaymentData> ngo;

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<NgoPaymentData> getGet_property() {
        return ngo;
    }

    public NgoPaymentList(boolean success, String message, List<NgoPaymentData> ngo) {

        this.success = success;
        this.message = message;
        this.ngo = ngo;
    }
}
