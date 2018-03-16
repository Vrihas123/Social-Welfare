package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.login.presenter;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.login.LoginCallback;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.login.model.LoginDataResponse;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.login.provider.LoginBaseClassHelper;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.login.view.LoginView;

/**
 * Created by samveg on 28/9/17.
 */

public class LoginPresenterImpl implements LoginPresenter{

    private LoginBaseClassHelper loginBaseClassHelper;
    private LoginView login;
    public LoginPresenterImpl(LoginView login, LoginBaseClassHelper loginBaseClassHelper) {
        this.login = login;
        this.loginBaseClassHelper = loginBaseClassHelper;
    }

    @Override
    public void getLoginData(String mobile, String password) {

        login.showProgressBar(true);
        loginBaseClassHelper.loginData(mobile,password,new LoginCallback() {
            @Override
            public void onLoginSuccess(LoginDataResponse loginResponse) {
                if(loginResponse.isSuccess()) {
                    login.showProgressBar(false);
                    login.showLoginStatus(loginResponse);
                }
                else{
                    login.showProgressBar(false);
                    login.showError(loginResponse.getMessage());
                }
            }
            @Override
            public void onLoginFailure(String error) {
                login.showError("Sorry!!Something went wrong.Please try again.");
                login.showProgressBar(false);
            }
        });

    }
}
