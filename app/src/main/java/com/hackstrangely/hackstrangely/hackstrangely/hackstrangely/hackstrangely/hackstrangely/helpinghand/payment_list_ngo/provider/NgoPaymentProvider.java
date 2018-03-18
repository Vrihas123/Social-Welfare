package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment_list_ngo.provider;


import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment_list_ngo.view.OnNgoPaymentRecieved;

/**
 * Created by samveg on 26/8/17.
 */

public interface NgoPaymentProvider {

    void requestNgoPaymentData(String access_token, OnNgoPaymentRecieved onNgoPaymentRecieved);

}
