package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.health_bot.view;

import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.R;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.helper.SharedPrefs;
import com.valdesekamdem.library.mdtoast.MDToast;
import com.wang.avi.AVLoadingIndicatorView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HealthBotActivity extends AppCompatActivity {

    @BindView(R.id.gender_layout_bot)
    LinearLayout genderLayoutBot;

    @BindView(R.id.gender_layout_button)
    LinearLayout genderButtons;
    @BindView(R.id.female)
    Button femaleButton;
    @BindView(R.id.male)
    Button maleButton;


    @BindView(R.id.gender_layout_user)
    LinearLayout genderLayoutUser;
    @BindView(R.id.user_gender)
    TextView userGender;

    @BindView(R.id.age_layout_bot)
    LinearLayout ageLayoutBot;
    @BindView(R.id.tv_age)
    TextView ageBot;

    @BindView(R.id.age_layout_user)
    LinearLayout ageLayoutUser;
    @BindView(R.id.user_age)
    TextView ageUser;

    @BindView(R.id.symptoms_layout_bot)
    LinearLayout symptomsLayoutBot;
    @BindView(R.id.tv_symptoms)
    TextView symptomsBot;

    @BindView(R.id.symptoms_layout_user)
    LinearLayout symptomsLayoutUser;
    @BindView(R.id.user_symptoms)
    TextView symptomsUser;

    @BindView(R.id.avi_bot)
    AVLoadingIndicatorView question_progressbar;

    @BindView(R.id.user_message)
    EditText userAnswer;
    @BindView(R.id.save_message)
    ImageView storeAnswer;

    SharedPrefs sharedPrefs;
    boolean isAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_bot);
        ButterKnife.bind(this);
        sharedPrefs = new SharedPrefs(this);
        isAge = false;
        hide();
        question_progressbar.show();
        delay();
        question_progressbar.hide();
        genderLayoutBot.setVisibility(View.VISIBLE);
        genderButtons.setVisibility(View.VISIBLE);
        maleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                genderButtons.setVisibility(View.GONE);
                genderLayoutUser.setVisibility(View.VISIBLE);
                userGender.setText("Male");
                sharedPrefs.setGender("Male");
                question_progressbar.show();
                delay();
                question_progressbar.hide();
                ageLayoutBot.setVisibility(View.VISIBLE);
                requestFocus(userAnswer);
            }
        });
        femaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                genderButtons.setVisibility(View.GONE);
                genderLayoutUser.setVisibility(View.VISIBLE);
                userGender.setText("Female");
                sharedPrefs.setGender("Female");
                question_progressbar.show();
                delay();
                question_progressbar.hide();
                ageLayoutBot.setVisibility(View.VISIBLE);
                requestFocus(userAnswer);
            }
        });

        storeAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isAge==false){
                    if(userAnswer.getText().toString().trim().isEmpty()){
                        MDToast mdToast = MDToast.makeText(getApplicationContext(),"Cannot submit an empty message", MDToast.LENGTH_LONG, MDToast.TYPE_ERROR);
                        mdToast.show();
                        requestFocus(userAnswer);
                    }
                    else{
                        try {
                            if(Integer.parseInt(userAnswer.getText().toString().trim())>120){
                                MDToast mdToast = MDToast.makeText(getApplicationContext(),"Please enter a possible age", MDToast.LENGTH_LONG, MDToast.TYPE_ERROR);
                                mdToast.show();
                                requestFocus(userAnswer);
                            }
                            else
                            {
                                sharedPrefs.setAge(userAnswer.getText().toString().trim());
                                ageLayoutUser.setVisibility(View.VISIBLE);
                                ageUser.setText(sharedPrefs.getAge());
                                question_progressbar.show();
                                delay();
                                question_progressbar.hide();
                                symptomsLayoutBot.setVisibility(View.VISIBLE);
                                requestFocus(userAnswer);
                            }
                        }catch (Exception e){
                            MDToast mdToast = MDToast.makeText(getApplicationContext(),"Please enter a valid age", MDToast.LENGTH_LONG, MDToast.TYPE_ERROR);
                            mdToast.show();
                            requestFocus(userAnswer);
                        }

                    }
                }
                else{
                    if(userAnswer.getText().toString().trim().isEmpty()){
                        MDToast mdToast = MDToast.makeText(getApplicationContext(),"Cannot submit an empty message", MDToast.LENGTH_LONG, MDToast.TYPE_ERROR);
                        mdToast.show();
                        requestFocus(userAnswer);
                    }
                    else{
                        sharedPrefs.setSymptoms(userAnswer.getText().toString().trim());
                        symptomsLayoutUser.setVisibility(View.VISIBLE);
                        symptomsUser.setText(sharedPrefs.getSymptoms());
                    }
                }
            }
        });
    }
    public void hide()
    {
        genderLayoutBot.setVisibility(View.GONE);
        genderButtons.setVisibility(View.GONE);
        genderLayoutUser.setVisibility(View.GONE);
        ageLayoutBot.setVisibility(View.GONE);
        ageLayoutUser.setVisibility(View.GONE);
        symptomsLayoutBot.setVisibility(View.GONE);
        symptomsLayoutUser.setVisibility(View.GONE);
        question_progressbar.hide();
    }
    public void delay()
    {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
            }
        }, 1500);

    }
    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
}
