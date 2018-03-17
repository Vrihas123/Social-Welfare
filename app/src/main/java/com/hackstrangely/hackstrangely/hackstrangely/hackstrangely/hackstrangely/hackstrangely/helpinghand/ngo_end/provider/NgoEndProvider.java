package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_end.provider;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_end.view.OnNgoDetailsRecieved;

/**
 * Created by vrihas on 17/3/18.
 */

public interface NgoEndProvider {
    void requestNgoEnd(String token, int itemId, int ngoId, int quantity, String details, OnNgoDetailsRecieved onNgoDetailsRecieved);
}
