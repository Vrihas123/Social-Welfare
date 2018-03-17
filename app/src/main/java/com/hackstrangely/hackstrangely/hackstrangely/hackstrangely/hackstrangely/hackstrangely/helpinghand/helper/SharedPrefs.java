package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by Meghal on 6/9/2016.
 */
public class SharedPrefs {

    // Shared preferences file name
    private static final String PREF_NAME = "AndroidHiveLogin";
    private static final String KEY_IS_LOGGEDIN = "isLoggedIn";
    private static final String KEY_ITEM_ID = "item_id";
    private static final String KEY_NGO_ID = "ngo_id";
    private static final String KEY_NGO_NAME = "ngo_name";
    private static final String KEY_IS_OTPLOGGEDIN = "isOtpLoggedIn";
    private static final String KEY_NAME = "name";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_MOBILE = "mobile";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_AADHAR = "your aadhar";
    private static final String KEY_PHOTO_URL = "photoUrl";
    private static final String KEY_USER_ID = "userId";
    private static final String KEY_LOGIN_TYPE = "loginType";
    private static final String KEY_FCM = "fcm";
    private static final String KEY_ACCESS_TOKEN = "access_token";
    private static final int KEY_VERSION=1;
    // LogCat tag
    private static String TAG = "Shared Preference";
    // Shared Preferences
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    // Shared pref mode
    int PRIVATE_MODE = 0;

    public static int getKeyVersion() {
        return KEY_VERSION;
    }

    public SharedPrefs(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setLogin(boolean isLoggedIn) {

        editor.putBoolean(KEY_IS_LOGGEDIN, isLoggedIn);
        // commit changes
        editor.commit();
        Log.d(TAG, "User login session modified!");
    }

    public void setItem_id(int item_id) {

        editor.putInt(KEY_ITEM_ID, item_id);
        // commit changes
        editor.commit();
        Log.d(TAG, "Item id set!");
    }

    public int getItemId(){
        return pref.getInt(KEY_ITEM_ID,0);
    }

    public void setNgo_id(int ngo_id) {

        editor.putInt(KEY_ITEM_ID, ngo_id);
        // commit changes
        editor.commit();
        Log.d(TAG, "Ngo id set!");
    }

    public int getNgoId(){
        return pref.getInt(KEY_ITEM_ID,0);
    }

    public void setNgo_name(String ngo_name) {

        editor.putString(KEY_NGO_NAME, ngo_name);
        // commit changes
        editor.commit();
        Log.d(TAG, "Ngo id set!");
    }

    public String getNgoName(){
        return pref.getString(KEY_NGO_NAME,"");
    }

    public void setOtpLogin(boolean isOtpLoggedIn){
        editor.putBoolean(KEY_IS_OTPLOGGEDIN, isOtpLoggedIn);
        editor.commit();
        Log.d(TAG, "User login session modified!");
    }

    public boolean isLoggedIn() {
        return pref.getBoolean(KEY_IS_LOGGEDIN, false);
    }

    public String getUsername() {

        return pref.getString(KEY_USERNAME, "USER NAME");
    }


    public void setFCM(String fcm) {
        editor.putString(KEY_FCM, fcm);
        editor.commit();
    }

    public String getFcm() {
        return pref.getString(KEY_FCM, null);
    }

    public void setAccessToken(String accessToken) {
        editor.putString(KEY_ACCESS_TOKEN, accessToken);
        editor.commit();
    }

    public String getAccessToken() {

        return pref.getString(KEY_ACCESS_TOKEN, null);
    }

    public String getMobile() {

        return pref.getString(KEY_MOBILE, "Your Phone Number");

    }

    public void setMobile(String userName) {

        editor.putString(KEY_MOBILE, userName);
        editor.commit();

    }

    public void setPassword(String password){

        editor.putString(KEY_PASSWORD,password);
        editor.commit();
    }

    public String getPassword(){
        return pref.getString(KEY_PASSWORD,"Your Password");
    }

    public void setName(String name){
        editor.putString(KEY_NAME,name);
        editor.commit();
    }

    public String getName(){
        return pref.getString(KEY_NAME,"Your name");
    }

    public void setUserName(String user){
        editor.putString(KEY_USERNAME,user);
        editor.commit();
    }

    public String getUserName(){
        return pref.getString(KEY_USERNAME,"your username");
    }

    public void setEmail(String email){
        editor.putString(KEY_EMAIL,email);
        editor.commit();
    }
    public String getEmail(){
        return pref.getString(KEY_EMAIL,"your email");
    }

    public void setAadhar(String aadhar){
        editor.putString(KEY_AADHAR,aadhar);
        editor.commit();
    }
    public String getAadhar(){
        return pref.getString(KEY_AADHAR,"your aadhar");
    }
}
