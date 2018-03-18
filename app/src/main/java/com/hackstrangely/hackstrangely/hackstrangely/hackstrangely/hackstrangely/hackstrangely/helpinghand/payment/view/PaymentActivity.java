package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment.view;

import android.support.design.widget.TextInputLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.R;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.helper.SharedPrefs;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PaymentActivity extends AppCompatActivity {



    @BindView(R.id.user_name_login)
    EditText firstname_etxt;
    @BindView(R.id.mobile_login)
    EditText mobile_etxt;
    @BindView(R.id.email_login)
    EditText email_etxt;
    @BindView(R.id.amount_login)
    EditText amount_etxt;
    @BindView(R.id.sign_up)
    TextView signUp;
    @BindView(R.id.sign_up_underline)
    View signUpUnderLine;
    @BindView(R.id.sign_in)
    TextView signIn;
    @BindView(R.id.sign_in_underline)
    View signInUnderLine;
    @BindView(R.id.sign_in_button)
    Button signInButton;
    @BindView(R.id.progressBar_sign_in)
    ProgressBar progressBar;
    @BindView(R.id.input_layout_mobile_login)
    TextInputLayout inputLayoutMobile;
    @BindView(R.id.input_layout_email_login)
    TextInputLayout inputLayoutEmail;
    @BindView(R.id.input_layout_amount_login)
    TextInputLayout inputLayoutAmount;
    @BindView(R.id.input_layout_username_login)
    TextInputLayout inputLayoutUsername;
    @BindView(R.id.btn_info_submit)
    Button btn_submit;

    private SharedPrefs sharedPrefs;
    String fname,email,mobile,amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        ButterKnife.bind(this);
        sharedPrefs = new SharedPrefs(this);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // submit();
            }
        });

    }





    public boolean validateUsername(){

        if(firstname_etxt.getText().toString().trim().isEmpty())
        {
            inputLayoutUsername.setError(getString(R.string.err_msg_empty));
            requestFocus(firstname_etxt);
            return false;
        }
        else{
            inputLayoutUsername.setErrorEnabled(false);
            return true;
        }

    }
    public boolean validateMobile(){

        if(mobile_etxt.getText().toString().trim().isEmpty())
        {
            inputLayoutMobile.setError(getString(R.string.err_msg_empty));
            requestFocus(inputLayoutMobile);
            return false;
        }
        else{
            inputLayoutMobile.setErrorEnabled(false);
            return true;
        }

    }
    public boolean validateEmail(){

        if(email_etxt.getText().toString().trim().isEmpty())
        {
            inputLayoutEmail.setError(getString(R.string.err_msg_empty));
            requestFocus(inputLayoutMobile);
            return false;
        }
        else{
            inputLayoutEmail.setErrorEnabled(false);
            return true;
        }

    }

    public boolean validateAmount(){

        if(amount_etxt.getText().toString().trim().isEmpty())
        {
            inputLayoutAmount.setError(getString(R.string.err_msg_empty));
            requestFocus(inputLayoutMobile);
            return false;
        }
        else{
            inputLayoutEmail.setErrorEnabled(false);
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
                case R.id.user_name_login:
                    validateUsername();
                    break;
                case R.id.mobile_login:
                    validateMobile();
                    break;
                case R.id.email_login:
                    validateEmail();
                    break;
                case R.id.amount_login:
                    validateAmount();
                    break;
            }
        }
    }

//    public void addFragment(android.support.v4.app.Fragment fragment, String title) {
//        if (fragment != null) {
//            FragmentManager fragmentManager = getSupportFragmentManager();
//            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//            fragmentTransaction.replace(R.id., fragment);
//            fragmentTransaction.addToBackStack(null);
//            fragmentTransaction.commit();
//            getSupportActionBar().setTitle(title);
//        }
//
//    }
}
