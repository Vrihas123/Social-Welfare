package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_list_items.view;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_list_items.model.ItemData;

import java.util.List;

/**
 * Created by samveg on 24/8/17.
 */

public interface ItemView {

    void setData(List<ItemData> itemDataList);
    void showProgressBar(boolean show);
    void showMessage(String message);

}
