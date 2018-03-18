package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment_list_ngo.view;


import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment_list_ngo.model.NgoPaymentList;

/**
 * Created by samveg on 26/8/17.
 */

public interface OnNgoPaymentRecieved {

    void onSuccess(NgoPaymentList ngoPaymentList);
    void onFailure();

}
