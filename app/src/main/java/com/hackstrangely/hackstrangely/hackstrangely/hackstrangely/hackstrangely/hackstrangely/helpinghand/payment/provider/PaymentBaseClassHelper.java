package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment.provider;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment.PaymentCallback;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.register.RegisterCallback;

/**
 * Created by samveg on 28/9/17.
 */

public interface PaymentBaseClassHelper {

    void registerData(String firstname, String mobile, String email, String amount, String access_token, PaymentCallback paymentCallback);

}
