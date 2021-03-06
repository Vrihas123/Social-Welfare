package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.otp_verify.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.HomeActivity;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.R;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.helper.SharedPrefs;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.otp_verify.model.OtpData;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.otp_verify.presenter.OtpVerifyPresenter;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.otp_verify.presenter.OtpVerifyPresenterImpl;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.otp_verify.provider.RetrofitOtpVerifyHelper;
import com.valdesekamdem.library.mdtoast.MDToast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OtpActivity extends AppCompatActivity implements OtpView{

    private String message,otpNumber;

    private OtpVerifyPresenter otpVerifyPresenter;

    private SharedPrefs sharedPrefs;

    @BindView(R.id.verify)
    Button verifyOtp;
    @BindView(R.id.otp)
    EditText otp;
//    @BindView(R.id.resend_otp)
//    Button resendOtp;
    @BindView(R.id.progressBar_otp)
    ProgressBar progressBar;
    @BindView(R.id.input_layout_otp)
    TextInputLayout inputLayoutOtp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        ButterKnife.bind(this);
        sharedPrefs = new SharedPrefs(this);


        otp.addTextChangedListener(new MyTextWatcher(otp));
        setupUI(findViewById(R.id.parent_view_otp));
        verifyOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proceed_verify();

            }
        });
    }


    public void proceed_verify() {
        otpNumber = otp.getText().toString();
        verifyOtp.setClickable(false);
        if (!validateOtp()){
            verifyOtp.setClickable(true);
        }
        else {
            otpVerifyPresenter = new OtpVerifyPresenterImpl(OtpActivity.this,new RetrofitOtpVerifyHelper());
            otpVerifyPresenter.otpData(otpNumber, sharedPrefs.getMobile(),sharedPrefs.getAccessToken());
        }

    }
//    public void resend(View v) {
//        PaymentPresenter registerPresenter = new PaymentPresenterImpl(new RetrofitPaymentHelper(),new RegisterView() {
//            @Override
//            public void showProgressBar(boolean show) {
//                if (show) {
//                    progressBar.setVisibility(View.VISIBLE);
//                } else {
//                    progressBar.setVisibility(View.INVISIBLE);
//                }
//            }
//
//
//            @Override
//            public void showError(String message) {
//
//            }
//
//            @Override
//            public void showRegisterStatus(PaymentDataResponse registerDataResponse) {
//
//            }
//        });
//        registerPresenter.getRegisterData(sharedPrefs.getName(),sharedPrefs.getMobile(),sharedPrefs.getPassword(),sharedPrefs.getBloodGroup(),sharedPrefs.getUserName(),sharedPrefs.getEmail());
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                verifyOtp.setVisibility(View.VISIBLE);
//            }
//        },30000);
//
//
//    }

    @Override
    public void showProgressBar(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void showMessage(String message) {
            Log.d("Error","OTP Verification error.");
    }

    @Override
    public void OtpStatus(OtpData otpData) {

        Intent i = new Intent(this, HomeActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        sharedPrefs.setLogin(true);
        finish();

    }

    public boolean validateOtp(){
        if(otp.getText().toString().trim().isEmpty())
        {
            inputLayoutOtp.setError(getString(R.string.err_msg_empty));
            requestFocus(otp);
            MDToast mdToast = MDToast.makeText(this, getString(R.string.err_msg_empty), MDToast.LENGTH_LONG, MDToast.TYPE_ERROR);
            mdToast.show();
            return false;
        }
        else{
            inputLayoutOtp.setErrorEnabled(false);
            return true;
        }
    }
    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.otp:
                    validateOtp();
                    break;
            }
        }
    }
    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }
    //The below function helps to hide keyboard if clicked anywhere except edit text
    public void setupUI(View view) {

        // Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard(OtpActivity.this);
                    return false;
                }
            });
        }

        //If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupUI(innerView);
            }
        }
    }
}
