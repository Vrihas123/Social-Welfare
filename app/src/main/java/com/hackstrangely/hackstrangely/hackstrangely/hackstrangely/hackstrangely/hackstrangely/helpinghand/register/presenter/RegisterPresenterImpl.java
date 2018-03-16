package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.register.presenter;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.register.RegisterCallback;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.register.model.RegisterDataResponse;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.register.provider.RegisterBaseClassHelper;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.register.view.RegisterView;

/**
 * Created by samveg on 28/9/17.
 */

public class RegisterPresenterImpl implements RegisterPresenter{

    private RegisterBaseClassHelper registerBaseClassHelper;
    private RegisterView registerView;

    public RegisterPresenterImpl(RegisterBaseClassHelper registerBaseClassHelper, RegisterView registerView) {
        this.registerBaseClassHelper = registerBaseClassHelper;
        this.registerView = registerView;
    }

    @Override
    public void getRegisterData(String name, String mobile, String password, String userName,String aadhar) {

        registerView.showProgressBar(true);
        registerBaseClassHelper.registerData(name, mobile, password, userName,aadhar, new RegisterCallback() {
            @Override
            public void onRegisterSuccess(RegisterDataResponse registerResponse) {
                if(registerResponse.isSuccess()){
                    registerView.showProgressBar(false);
                    registerView.showRegisterStatus(registerResponse);
                }
                else{
                    registerView.showProgressBar(false);
                    registerView.showError(registerResponse.getMessage());
                }

            }

            @Override
            public void onRegisterFailure(String error) {

            }
        });

    }
}
