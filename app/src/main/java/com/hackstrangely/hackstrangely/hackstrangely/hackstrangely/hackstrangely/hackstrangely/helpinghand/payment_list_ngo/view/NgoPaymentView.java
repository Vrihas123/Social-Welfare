package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment_list_ngo.view;


import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment_list_ngo.model.NgoPaymentData;

import java.util.List;

/**
 * Created by samveg on 26/8/17.
 */

public interface NgoPaymentView {

    void showProgressBar(boolean show);
    void setSubCategoryData(List<NgoPaymentData> subCategoryList);

}
