package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment.presenter;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment.PaymentCallback;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment.model.PaymentDataResponse;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment.provider.PaymentBaseClassHelper;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment.view.PaymentView;

/**
 * Created by samveg on 28/9/17.
 */

public class PaymentPresenterImpl implements PaymentPresenter {

    private PaymentBaseClassHelper paymentBaseClassHelper;
    private PaymentView paymentView;

    public PaymentPresenterImpl(PaymentBaseClassHelper paymentBaseClassHelper, PaymentView paymentView) {
        this.paymentBaseClassHelper = paymentBaseClassHelper;
        this.paymentView = paymentView;
    }

    @Override
    public void getPaymentData(String firstname, String mobile, String email, String amount, String access_token) {

        paymentView.showProgressBar(true);
        paymentBaseClassHelper.registerData(firstname, mobile, email, amount,access_token,new PaymentCallback() {
            @Override
            public void onPaymentSuccess(PaymentDataResponse paymentDataResponse) {
                if(paymentDataResponse.isSuccess()){
                    paymentView.showProgressBar(false);
                    paymentView.showRegisterStatus(paymentDataResponse);
                }
                else{
                    paymentView.showProgressBar(false);
                    paymentView.showError(paymentDataResponse.getMessage());
                }

            }

            @Override
            public void onPaymentFailure(String error) {

            }
        });

    }
}
