package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment.view;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment.model.PaymentDataResponse;

/**
 * Created by samveg on 27/9/17.
 */

public interface PaymentView {

    void showProgressBar(boolean show);
    void showError(String message);
    void showRegisterStatus(PaymentDataResponse paymentDataResponse);

}
