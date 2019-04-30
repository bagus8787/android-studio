package com.example.dicoding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;

public class MySharedPreference extends AppCompatActivity implements View.OnClickListener {

    TextView tvNama, tvAge, tvPhone, tvEmail, tvIsLoveMU;
    Button btnSave;
    private UserPreference mUserPreference;

    private boolean isPreferenceEmpty = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_shared_preference);

        tvNama = (TextView)findViewById(R.id.tv_name);
        tvAge = (TextView)findViewById(R.id.tv_age);
        tvPhone = (TextView)findViewById(R.id.tv_phone);
        tvEmail = (TextView)findViewById(R.id.tv_email);
        tvIsLoveMU = (TextView)findViewById(R.id.tv_love_mu);
        btnSave = (Button)findViewById(R.id.btn_save);
        btnSave.setOnClickListener(this);

        mUserPreference = new UserPreference(this);

        getSupportActionBar().setTitle("Data");

        showExistingPreference();
    }

    private void showExistingPreference(){
        if (!TextUtils.isEmpty(mUserPreference.getNama())){
            tvNama.setText(mUserPreference.getNama());
            tvAge.setText(String.valueOf(mUserPreference.getAge()));
            tvIsLoveMU.setText(mUserPreference.isLOVEMU() ? "Ya" : "Tidak");
            tvEmail.setText(mUserPreference.getEmail());
            tvPhone.setText(mUserPreference.getPhoneNumber());

            btnSave.setText("Ubah");
        }else {
            final String TEXT_EMPTY = "Tidak Ada";

            tvNama.setText(TEXT_EMPTY);
            tvAge.setText(TEXT_EMPTY);
            tvIsLoveMU.setText(TEXT_EMPTY);
            tvEmail.setText(TEXT_EMPTY);
            tvPhone.setText(TEXT_EMPTY);

            btnSave.setText("Simpan");

            isPreferenceEmpty = true;
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_save){
            Intent intent = new Intent(MySharedPreference.this, FormUserPreferenceActivity.class);
            if (isPreferenceEmpty){
                intent.putExtra(FormUserPreferenceActivity.EXTRA_TYPE_FORM, FormUserPreferenceActivity.TYPE_ADD);
            }else {
                intent.putExtra(FormUserPreferenceActivity.EXTRA_TYPE_FORM, FormUserPreferenceActivity.TYPE_EDIT);
            }
            startActivityForResult(intent, FormUserPreferenceActivity.REQUEST_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FormUserPreferenceActivity.REQUEST_CODE){
            showExistingPreference();
        }
    }
}
