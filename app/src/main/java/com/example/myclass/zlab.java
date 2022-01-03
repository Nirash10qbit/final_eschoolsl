package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class zlab extends AppCompatActivity {

    String st,st0,st1,st2,st3,stn,stl,stg;
    TextView uname1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zlab);

        uname1 = findViewById(R.id.uname1);
        stn = getIntent().getExtras().getString("uname");
        uname1.setText(st3);
        stl = getIntent().getExtras().getString("language");
        stg = getIntent().getExtras().getString("grade");

        st = getIntent().getExtras().getString("value");
        st1= getIntent().getExtras().getString("gid");
        st2 = getIntent().getExtras().getString("SIDNAME");
        st3 = getIntent().getExtras().getString("SID");
        st0 = getIntent().getExtras().getString("SIDPDF");
    }
    public void zbackmenu(View view){
        Intent intent = new Intent(this,zsubject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }

    public void zsub(View view){
        Intent intent = new Intent(this,zplesson.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        intent.putExtra("SIDNAME",st2);
        intent.putExtra("SID",st3);
        intent.putExtra("SIDPDF",st0);
        startActivity(intent);
        finish();
    }
    public void zlabsub(View view){
        Intent intent = new Intent(this,zlabsub.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        intent.putExtra("SIDNAME",st2);
        intent.putExtra("SID",st3);
        intent.putExtra("SIDPDF",st0);
        startActivity(intent);
        finish();
    }
}