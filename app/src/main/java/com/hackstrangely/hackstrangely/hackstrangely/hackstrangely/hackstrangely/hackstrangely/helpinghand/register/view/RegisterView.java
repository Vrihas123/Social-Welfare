package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.register.view;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.register.model.RegisterDataResponse;

/**
 * Created by samveg on 27/9/17.
 */

public interface RegisterView {

    void showProgressBar(boolean show);
    void showError(String message);
    void showRegisterStatus(RegisterDataResponse registerDataResponse);

}
