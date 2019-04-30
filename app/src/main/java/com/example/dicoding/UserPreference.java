package com.example.dicoding;

import android.content.Context;
import android.content.SharedPreferences;

public class UserPreference {
    private String KEY_NAMA = "nama";
    private String KEY_EMAIL = "email";
    private String KEY_LOVE_MU = "love_mu";
    private String KEY_PHONE_NUMBER = "phone_number";
    private String KEY_AGE = "age";

    private SharedPreferences preferences;

    UserPreference(Context context){
        String PREFS_NAMA = "UserPref";
        preferences = context.getSharedPreferences(PREFS_NAMA, Context.MODE_PRIVATE);
    }

    public void setNama(String nama){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_NAMA, nama);
        editor.apply();
    }

    public String getNama(){
        return preferences.getString(KEY_NAMA, null);
    }

    void setEmail(String email){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_EMAIL, email);
        editor.apply();
    }

    String getEmail(){
        return preferences.getString(KEY_EMAIL, null);
    }

    void setLOVEMU(boolean status){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(KEY_LOVE_MU, status);
        editor.apply();
    }

    boolean isLOVEMU() {
        return preferences.getBoolean(KEY_LOVE_MU, false);
    }

    void setPhoneNumber(String phoneNumber){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_PHONE_NUMBER, phoneNumber);
        editor.apply();
    }

    String getPhoneNumber(){
        return preferences.getString(KEY_PHONE_NUMBER, null);
    }

    void setAge(int age){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(KEY_AGE, age);
        editor.apply();
    }

    int getAge(){
        return preferences.getInt(KEY_AGE, 0);
    }
}
