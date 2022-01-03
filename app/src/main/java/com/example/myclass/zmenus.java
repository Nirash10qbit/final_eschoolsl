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

public class zmenus extends AppCompatActivity {

    String st,st1,stn,stl,stg,nstg;
    TextView uname1,language1;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zmenus);

        drawerLayout = findViewById(R.id.drawer_layer);

        uname1 = findViewById(R.id.uname1);
        stn = getIntent().getExtras().getString("uname");
        uname1.setText(stn);

        language1 = findViewById(R.id.language);
        stl = getIntent().getExtras().getString("language");
        language1.setText(stl);

        stg = getIntent().getExtras().getString("grade");
    }

    public void ClickMenu(View view){
        openDrawer(drawerLayout);
    }

    private void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);

        uname1 = findViewById(R.id.usname);
        stn = getIntent().getExtras().getString("uname");
        uname1.setText(stn);
    }

    public void ClickAnalyse(View view) {
        stg = getIntent().getExtras().getString("grade");

        int tot = Integer.valueOf(stg);

        if(tot <= 7){
            int tnstn = Integer.valueOf(stg);
            int nstn = tnstn - 5;
            nstg = String.valueOf(nstn);
        }
        else{
            int tnstn = Integer.valueOf(stg);
            int nstn = tnstn + 0;
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
        Intent intent = new Intent (this,zmenus.class);
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

    public void ssbtn(View view){
        Intent intent = new Intent (this,zmenus.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        startActivity (intent);
    }

    public void stbtn(View view){
        Intent intent = new Intent (this,zmenut.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        startActivity (intent);
    }

    public void sebtn(View view){
        Intent intent = new Intent (this,zmenue.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        startActivity (intent);
    }


    public void sf(View view){

        st = "06 වසර";
        st1="1";
        Intent intent = new Intent(this,zsubject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void sg(View view){

        st = "07 වසර";
        st1="2";
        Intent intent = new Intent(this,zsubject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void sh(View view){

        st = "08 වසර";
        st1="08";
        Intent intent = new Intent(this,zsubject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void si(View view){

        st = "09 වසර";
        st1="09";
        Intent intent = new Intent(this,zsubject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void sj(View view){

        st = "10 වසර";
        st1="10";
        Intent intent = new Intent(this,zsubject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void sk(View view){

        st = "11 වසර";
        st1="11";
        Intent intent = new Intent(this,zsubject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void sl(View view){

        st = "විෂය";
        st1="12";
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