package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_list_items.provider;


import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_list_items.view.OnItemRecieved;

/**
 * Created by samveg on 24/8/17.
 */

public interface ItemProvider {

    void requestItem(String access_token, OnItemRecieved onItemRecieved);

}
