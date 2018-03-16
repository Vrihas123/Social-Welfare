package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.login;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.login.model.LoginDataResponse;

/**
 * Created by samveg on 28/9/17.
 */

public interface LoginCallback {

    void onLoginSuccess(LoginDataResponse loginResponse);
    void onLoginFailure(String error);

}
