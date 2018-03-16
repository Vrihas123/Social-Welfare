package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_sub_categories.provider;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.sub_products.view.OnSubProductsRecieved;

/**
 * Created by samveg on 26/8/17.
 */

public interface SubProductsProvider {

    void requestSubProductData(String product_type, String access_token, OnSubProductsRecieved onSubProductsRecieved);

}
