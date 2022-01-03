package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class zmenut extends AppCompatActivity {

    String st,st1,stn,stl,stg,nstg;
    TextView uname1;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zmenut);

        drawerLayout = findViewById(R.id.drawer_layer);

        uname1 = findViewById(R.id.uname1);
        stn = getIntent().getExtras().getString("uname");
        uname1.setText(stn);

        stl = getIntent().getExtras().getString("language");
        stg = getIntent().getExtras().getString("grade");
    }

    public void ClickMenu(View view){
        openDrawer(drawerLayout);
    }

    private void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);

        uname1 = findViewById(R.id.usname);
        stn = getIntent().getExtras().getString("uname");
        stl = getIntent().getExtras().getString("language");
        stg = getIntent().getExtras().getString("grade");
        uname1.setText(stn);
    }

    public void ClickAnalyse(View view) {
        stg = getIntent().getExtras().getString("grade");

        int tot = Integer.valueOf(stg);

        if(tot <= 7){
            int tnstn = Integer.valueOf(stg);
            int nstn = tnstn - 1;
            nstg = String.valueOf(nstn);
        }
        else{
            int tnstn = Integer.valueOf(stg);
            int nstn = tnstn + 10;
            nstg = String.valueOf(nstn);
        }


        Intent intent = new Intent (this,zanalyse.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        intent.putExtra("analyse", nstg);
        startActivity (intent);
    }

    public void ClickDashboard(View view) {
        Intent intent = new Intent (this,zmenut.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        startActivity (intent);
    }
    public void ClickSettings(View view) {
        Intent intent = new Intent (this,usersettings.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        startActivity (intent);
    }
    public void ClickLogout(View view){
        logout(this);
    }

    private void logout(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Logout");
        builder.setMessage("Are you sure you want to logout ?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }


    public void tsbtn(View view){
        Intent intent = new Intent (this,zmenus.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        startActivity (intent);
    }

    public void ttbtn(View view){
        Intent intent = new Intent (this,zmenut.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        startActivity (intent);
    }

    public void tebtn(View view){
        Intent intent = new Intent (this,zmenue.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        startActivity (intent);
    }


    public void tf(View view){

        st = "தரம் 06";
        st1="5";
        Intent intent = new Intent(this,zsubject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void tg(View view){

        st = "தரம் 07";
        st1="6";
        Intent intent = new Intent(this,zsubject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void th(View view){

        st = "தரம் 08";
        st1="18";
        Intent intent = new Intent(this,zsubject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void ti(View view) {

        st = "தரம் 09";
        st1 = "19";
        Intent intent = new Intent(this,zsubject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        intent.putExtra("value", st);
        intent.putExtra("gid", st1);
        startActivity(intent);
        finish();
    }

    public void tj(View view){

        st = "தரம் 10";
        st1="20";
        Intent intent = new Intent(this,zsubject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void tk(View view){

        st = "தரம் 11";
        st1="21";
        Intent intent = new Intent(this,zsubject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void tl(View view){

        st = "பொருள்";
        st1="22";
        Intent intent = new Intent(this,zsubject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
}