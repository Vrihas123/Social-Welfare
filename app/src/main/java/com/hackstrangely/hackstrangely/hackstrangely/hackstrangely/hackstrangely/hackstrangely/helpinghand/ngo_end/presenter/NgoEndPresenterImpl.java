package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_end.presenter;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_end.model.NgoEndList;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_end.provider.NgoEndProvider;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_end.view.NgoView;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_end.view.OnNgoDetailsRecieved;

/**
 * Created by vrihas on 17/3/18.
 */

public class NgoEndPresenterImpl implements NgoEndPresenter{
    NgoView ngoView;
    NgoEndProvider ngoEndProvider;

    public NgoEndPresenterImpl(NgoView ngoView, NgoEndProvider ngoEndProvider) {
        this.ngoView = ngoView;
        this.ngoEndProvider = ngoEndProvider;
    }

    @Override
    public void requestNgoDetails(String token, int itemId, int ngoId, String quantity, String details) {
        ngoView.showProgressBar(true);
        ngoEndProvider.requestNgoEnd(token, itemId, ngoId, quantity, details, new OnNgoDetailsRecieved() {
            @Override
            public void onSuccess(NgoEndList ngoEndList) {
                ngoView.showProgressBar(false);
                if(ngoEndList.isSuccess()){
                    ngoView.setData(ngoEndList);
                }
                else{
                    ngoView.showMessage(ngoEndList.getMessage());
                }

            }

            @Override
            public void onFailure(String message) {
                ngoView.showProgressBar(false);
            }
        });
    }
}
