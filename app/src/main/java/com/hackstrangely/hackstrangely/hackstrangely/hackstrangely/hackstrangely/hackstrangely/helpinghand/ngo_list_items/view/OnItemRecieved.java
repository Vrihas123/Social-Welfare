package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_list_items.view;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_list_items.model.ItemList;

/**
 * Created by samveg on 24/8/17.
 */

public interface OnItemRecieved {

    void onSuccess(ItemList itemList);
    void onFailure();

}
