package com.example.dicoding;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.net.Uri.parse;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnmove;
    private Button btnmovedata;
    private Button btnmoveobject;
    private Button btndial;
    private Button btnpenyimpanan;
    private Button btnsoundpoll;
    private Button btnRecycleView;
    private Button btnsharedpreference;
    private Button btnHitungLuas;
    private Button btnMyNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnmove = (Button)findViewById(R.id.btn_move_activity);
        btnmove.setOnClickListener(this);

        btnmovedata = (Button)findViewById(R.id.btn_move_activity_data);
        btnmovedata.setOnClickListener(this);

        btnmoveobject = (Button)findViewById(R.id.btn_move_object);
        btnmoveobject.setOnClickListener(this);

        btndial = (Button)findViewById(R.id.btn_dial_number);
        btndial.setOnClickListener(this);

        btnpenyimpanan = (Button)findViewById(R.id.penyimpanan_lokal);
        btnpenyimpanan.setOnClickListener(this);

        btnsoundpoll = (Button)findViewById(R.id.sound_pool);
        btnsoundpoll.setOnClickListener(this);

        btnRecycleView = (Button) findViewById(R.id.recycle);
        btnRecycleView.setOnClickListener(this);

        btnsharedpreference = (Button)findViewById(R.id.sharepreference);
        btnsharedpreference.setOnClickListener(this);

        btnHitungLuas = (Button)findViewById(R.id.HitungActivity);
        btnHitungLuas.setOnClickListener(this);

        btnMyNotes = (Button)findViewById(R.id.MyNotesApp);
        btnMyNotes.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_move_activity:
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(moveIntent);
            break;

            case R.id.btn_move_activity_data:
            Intent moveData = new Intent(MainActivity.this, MoveWithData.class);
            moveData.putExtra(MoveWithData.EXTRA_NAME, "Dicoding");
            moveData.putExtra(MoveWithData.EXTRA_AGE, 19);
            startActivity(moveData);
            break;

            case R.id.btn_move_object:
                Person mPerson = new Person();
                mPerson.setName("Dicoding");
                mPerson.setAge(20);
                mPerson.setEmail("baba@gmail.com");
                mPerson.setCity("JKT");

                Intent movewithobject = new Intent(MainActivity.this, MoveActivityObject.class);
                movewithobject.putExtra(MoveActivityObject.EXTRA_PERSON, mPerson);
                startActivity(movewithobject);
                break;

            case R.id.btn_dial_number:
                String phoneNumber = "081210841382";
                Intent dialPhone = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+phoneNumber));
                startActivity(dialPhone);
                break;

            case R.id.penyimpanan_lokal:
                Intent movepenyimpanan = new Intent(MainActivity.this, Peniympanan_lokal.class);
                startActivity(movepenyimpanan);
                break;

            case R.id.sound_pool:
                Intent movesoundpool = new Intent(MainActivity.this, sound_pool.class);
                startActivity(movesoundpool);
                break;

            case R.id.recycle:
                Intent moveRecycle = new Intent(MainActivity.this, MyRecycleView.class );
                startActivity(moveRecycle);
                break;

            case R.id.sharepreference:
                Intent moveShared = new Intent(MainActivity.this, MySharedPreference.class);
                startActivity(moveShared);
                break;

            case R.id.HitungActivity:
                Intent moveHitung = new Intent(MainActivity.this, Luas.class);
                startActivity(moveHitung);
                break;

            case R.id.MyNotesApp:
                Intent moveNotes = new Intent(MainActivity.this, MyNotesApp.class);
                startActivity(moveNotes);
                break;
        }

    }
}
