package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment.model.PaymentDataResponse;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.register.model.RegisterDataResponse;

/**
 * Created by samveg on 28/9/17.
 */

public interface PaymentCallback {

    void onPaymentSuccess(PaymentDataResponse paymentDataResponse);
    void onPaymentFailure(String error);
}
