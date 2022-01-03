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

public class zmenue extends AppCompatActivity {

    String st,st1,stn,stl,stg,nstg;
    TextView uname1;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zmenue);

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
        uname1.setText(stn);
    }

    public void ClickAnalyse(View view) {
        stg = getIntent().getExtras().getString("grade");

        int tot = Integer.valueOf(stg);

        if(tot <= 7){
            int tnstn = Integer.valueOf(stg);
            int nstn = tnstn - 3;
            nstg = String.valueOf(nstn);
        }
        else{
            int tnstn = Integer.valueOf(stg);
            int nstn = tnstn + 5;
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
        Intent intent = new Intent (this,zmenue.class);
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

    public void esbtn(View view){
        Intent intent = new Intent (this,zmenus.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        startActivity (intent);
    }

    public void etbtn(View view){
        Intent intent = new Intent (this,zmenut.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        startActivity (intent);
    }

    public void eebtn(View view){
        Intent intent = new Intent (this,zmenue.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        startActivity (intent);
    }


    public void ef(View view){

        st = "Grade 06";
        st1="3";
        Intent intent = new Intent(this,zsubject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void eg(View view){

        st = "Grade 07";
        st1="4";
        Intent intent = new Intent(this,zsubject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void eh(View view){

        st = "Grade 08";
        st1="13";
        Intent intent = new Intent(this,zsubject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void ei(View view){

        st = "Grade 09";
        st1="14";
        Intent intent = new Intent(this,zsubject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void ej(View view){

        st = "Grade 10";
        st1="15";
        Intent intent = new Intent(this,zsubject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void ek(View view){

        st = "Grade 11";
        st1="16";
        Intent intent = new Intent(this,zsubject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void el(View view){

        st = "Subject";
        st1="17";
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
