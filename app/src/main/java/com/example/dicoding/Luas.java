package com.example.dicoding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Luas extends AppCompatActivity implements View.OnClickListener {
    private EditText edtpanjang, edtlebar, edttinggi;
    private Button btnHitung;
    private TextView tvresult;

    private static final String STATE_HASIL = "state_hasil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luas);
        edttinggi = (EditText)findViewById(R.id.edt_tinggi);
        edtlebar = (EditText)findViewById(R.id.edt_lebar);
        edtpanjang = (EditText)findViewById(R.id.edt_panjang);
        btnHitung = (Button)findViewById(R.id.btn_hitung);
        tvresult = (TextView)findViewById(R.id.result);
        btnHitung.setOnClickListener(this);

        if (savedInstanceState != null){
            String hasil = savedInstanceState.getString(STATE_HASIL);
            tvresult.setText(hasil);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_hitung){
            String panjang = edtpanjang.getText().toString().trim();
            String lebar = edtlebar.getText().toString().trim();
            String tinggi = edttinggi.getText().toString().trim();
            boolean isEmptyFielsd = false;
            if (TextUtils.isEmpty(panjang)){
                isEmptyFielsd = true;
                edtpanjang.setError("Kudu di isi riyen kang mas");
            }
            if (TextUtils.isEmpty(lebar)){
                isEmptyFielsd = true;
                edtlebar.setError("Kudu di isi riyen kang mas");
            }
            if (TextUtils.isEmpty(tinggi)){
                isEmptyFielsd = true;
                edttinggi.setError("Kudu di isi riyen kang mas");
            }
            if (!isEmptyFielsd){
                double t = Double.parseDouble(tinggi);
                double l = Double.parseDouble(lebar);
                double p = Double.parseDouble(panjang);
                double volume = t*l*p;
                tvresult.setText(String.valueOf(volume));

            }
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        outState.putString(STATE_HASIL, tvresult.getText().toString());
        super.onSaveInstanceState(outState);
    }

}


