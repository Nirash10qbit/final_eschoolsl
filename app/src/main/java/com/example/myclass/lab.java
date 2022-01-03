package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class lab extends AppCompatActivity {

    String st, st0, st1, st2, st3, stn, stl, stg,said,sbid;
    TextView uname1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab);

        uname1 = findViewById(R.id.uname1);
        stn = getIntent().getExtras().getString("uname");
        said = getIntent().getExtras().getString("aid");
        uname1.setText(st3);
        stl = getIntent().getExtras().getString("language");
        stg = getIntent().getExtras().getString("grade");

        st = getIntent().getExtras().getString("value");
        st1 = getIntent().getExtras().getString("gid");
        st2 = getIntent().getExtras().getString("SIDNAME");
        st3 = getIntent().getExtras().getString("SID");
        st0 = getIntent().getExtras().getString("SIDPDF");
        sbid = getIntent().getExtras().getString("bid");
    }


    public void zsub(View view) {
        Intent intent = new Intent(this, plesson.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        intent.putExtra("value", st);
        intent.putExtra("gid", st1);
        intent.putExtra("SIDNAME", st2);
        intent.putExtra("SID", st3);
        intent.putExtra("SIDPDF", st0);
        intent.putExtra("aid",said);
        intent.putExtra("bid",sbid);
        startActivity(intent);
        finish();
    }
    public void zlabsub(View view){
        Intent intent = new Intent(this,labsub.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        intent.putExtra("SIDNAME",st2);
        intent.putExtra("SID",st3);
        intent.putExtra("SIDPDF",st0);
        intent.putExtra("aid",said);
        intent.putExtra("bid",sbid);
        startActivity(intent);
        finish();
    }

    public void zback(View view) {
        Intent intent = new Intent(getApplicationContext(),subject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        intent.putExtra("aid",said);
        intent.putExtra("bid",sbid);
        startActivity(intent);
    }
}