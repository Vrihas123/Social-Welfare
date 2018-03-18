package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment_list_ngo.presenter;


import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment_list_ngo.model.NgoPaymentList;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment_list_ngo.provider.NgoPaymentProvider;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment_list_ngo.view.OnNgoPaymentRecieved;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment_list_ngo.view.NgoPaymentView;

/**
 * Created by samveg on 26/8/17.
 */

public class NgoPaymentPresenterImpl implements NgoPaymentPresenter {

    NgoPaymentView ngoPaymentView;
    NgoPaymentProvider ngoPaymentProvider;

    public NgoPaymentPresenterImpl(NgoPaymentView ngoPaymentView, NgoPaymentProvider ngoPaymentProvider) {
        this.ngoPaymentView = ngoPaymentView;
        this.ngoPaymentProvider = ngoPaymentProvider;
    }
    @Override
    public void requestNgoPayment(String access_token) {

        ngoPaymentView.showProgressBar(true);
        ngoPaymentProvider.requestNgoPaymentData(access_token,new OnNgoPaymentRecieved() {
            @Override
            public void onSuccess(NgoPaymentList ngoPaymentList) {
                ngoPaymentView.showProgressBar(false);
                if(ngoPaymentList.isSuccess()){
                    ngoPaymentView.setSubCategoryData(ngoPaymentList.getGet_property());
                }
            }

            @Override
            public void onFailure() {
                ngoPaymentView.showProgressBar(false);
            }
        });

    }
}
