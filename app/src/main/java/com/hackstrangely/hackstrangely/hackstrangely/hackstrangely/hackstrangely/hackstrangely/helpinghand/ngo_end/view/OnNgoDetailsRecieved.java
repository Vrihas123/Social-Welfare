package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_end.view;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_end.model.NgoEndList;

/**
 * Created by vrihas on 17/3/18.
 */

public interface OnNgoDetailsRecieved {
    void onSuccess(NgoEndList ngoEndList);
    void onFailure(String message);
}
