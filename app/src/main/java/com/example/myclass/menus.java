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

public class menus extends AppCompatActivity {

    String st,st1,stn,aid;
    TextView tv1;
    DrawerLayout drawerLayouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);

        drawerLayouts = findViewById(R.id.drawer_layer_admin);

        tv1 = findViewById(R.id.uname);
        stn = getIntent().getExtras().getString("uname");
        tv1.setText(stn);
    }
    public void ClickMenuAdmin(View view){
        openDrawer(drawerLayouts);
    }

    private void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void DashboardAdmin(View view) {
        Intent intent = new Intent (this,menus.class);
        intent.putExtra("uname", stn);
        startActivity (intent);
    }
    public void AnalyseAdmin(View view){
        Intent intent = new Intent (this,analyse.class);
        intent.putExtra("uname", stn);
        startActivity (intent);
    }
    public void SettingsAdmin(View view) {
        Intent intent = new Intent (this,adminsettings.class);
        intent.putExtra("uname", stn);
        startActivity (intent);
    }
    public void LogoutAdmin(View view){
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
        Intent intent = new Intent (this,menus.class);
        intent.putExtra("uname", stn);
        startActivity (intent);
    }

    public void stbtn(View view){
        Intent intent = new Intent (this,menut.class);
        intent.putExtra("uname", stn);
        startActivity (intent);
    }

    public void sebtn(View view){
        Intent intent = new Intent (this,menue.class);
        intent.putExtra("uname", stn);
        startActivity (intent);
    }


    public void sf(View view){

        st = "06 වසර";
        st1="1";
        aid="6";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        intent.putExtra("aid",aid);
        startActivity(intent);
        finish();
    }
    public void sg(View view){

        st = "07 වසර";
        st1="2";
        aid="7";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        intent.putExtra("aid",aid);
        startActivity(intent);
        finish();
    }
    public void sh(View view){

        st = "08 වසර";
        st1="08";
        aid="8";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        intent.putExtra("aid",aid);
        startActivity(intent);
        finish();
    }
    public void si(View view){

        st = "09 වසර";
        st1="09";
        aid="9";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        intent.putExtra("aid",aid);
        startActivity(intent);
        finish();
    }
    public void sj(View view){

        st = "10 වසර";
        st1="10";
        aid="10";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        intent.putExtra("aid",aid);
        startActivity(intent);
        finish();
    }
    public void sk(View view){

        st = "11 වසර";
        st1="11";
        aid="11";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        intent.putExtra("aid",aid);
        startActivity(intent);
        finish();
    }
    public void sl(View view){

        st = "විෂය";
        st1="12";
        aid="12";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        intent.putExtra("aid",aid);
        startActivity(intent);
        finish();
    }
}
