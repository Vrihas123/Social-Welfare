package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_list_items.presenter;


import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_list_items.model.ItemList;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_list_items.provider.ItemProvider;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_list_items.view.ItemView;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_list_items.view.OnItemRecieved;

/**
 * Created by samveg on 25/8/17.
 */

public class ItemPresenterImpl implements ItemPresenter {

    ItemView itemView;
    ItemProvider itemProvider;

    public ItemPresenterImpl(ItemView itemView, ItemProvider itemProvider) {
        this.itemView = itemView;
        this.itemProvider = itemProvider;
    }

    @Override
    public void requesItem(String access_token) {

        itemView.showProgressBar(true);
        itemProvider.requestItem(access_token,new OnItemRecieved() {
            @Override
            public void onSuccess(ItemList itemList) {
                itemView.showProgressBar(false);
                if(itemList.isSuccess()){
                    itemView.setData(itemList.getData());
                }
                else{
                    itemView.showMessage(itemList.getMessage());
                }

            }

            @Override
            public void onFailure() {
                itemView.showProgressBar(false);
                itemView.showMessage("We cant connect to our server.Please check your internet connection.");
            }
        });

    }
}
