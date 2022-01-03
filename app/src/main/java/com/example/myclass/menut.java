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

public class menut extends AppCompatActivity {

    String st,st1,stn,aid;
    DrawerLayout drawerLayouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menut);

        drawerLayouts = findViewById(R.id.drawer_layer_admin);

        stn = getIntent().getExtras().getString("uname");
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


    public void tf(View view){

        st = "தரம் 06";
        st1="5";
        aid="6";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        intent.putExtra("aid",aid);
        startActivity(intent);
        finish();
    }
    public void tg(View view){

        st = "தரம் 07";
        st1="6";
        aid="7";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        intent.putExtra("aid",aid);
        startActivity(intent);
        finish();
    }
    public void th(View view){

        st = "தரம் 08";
        st1="18";
        aid="8";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        intent.putExtra("aid",aid);
        startActivity(intent);
        finish();
    }
    public void ti(View view) {

        st = "தரம் 09";
        st1 = "19";
        aid="9";
        Intent intent = new Intent(this, subject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value", st);
        intent.putExtra("gid", st1);
        intent.putExtra("aid",aid);
        startActivity(intent);
        finish();
    }

    public void tj(View view){

        st = "தரம் 10";
        st1="20";
        aid="10";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        intent.putExtra("aid",aid);
        startActivity(intent);
        finish();
    }
    public void tk(View view){

        st = "தரம் 11";
        st1="21";
        aid="11";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        intent.putExtra("aid",aid);
        startActivity(intent);
        finish();
    }
    public void tl(View view){

        st = "பொருள்";
        st1="22";
        aid="12";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        intent.putExtra("aid",aid);
        startActivity(intent);
        finish();
    }

    public void tsbtn(View view){
        Intent intent = new Intent (this,menus.class);
        intent.putExtra("uname", stn);
        startActivity (intent);
    }

    public void ttbtn(View view){
        Intent intent = new Intent (this,menut.class);
        intent.putExtra("uname", stn);
        startActivity (intent);
    }

    public void tebtn(View view){
        Intent intent = new Intent (this,menue.class);
        intent.putExtra("uname", stn);
        startActivity (intent);
    }

}