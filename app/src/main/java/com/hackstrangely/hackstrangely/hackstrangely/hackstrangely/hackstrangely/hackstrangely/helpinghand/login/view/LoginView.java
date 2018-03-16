package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.login.view;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.login.model.LoginDataResponse;

/**
 * Created by samveg on 28/9/17.
 */

public interface LoginView {

    void showProgressBar(boolean show);
    void showError(String message);
    void showLoginStatus(LoginDataResponse loginDataResponse);

}
