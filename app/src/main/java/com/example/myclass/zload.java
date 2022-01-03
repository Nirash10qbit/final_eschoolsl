package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.agrawalsuneet.dotsloader.loaders.TashieLoader;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class zload extends AppCompatActivity {

    String st1,st8,st9,stn,stl,stg,sta;
    TextView tv1,tv2,tv3,tv4,tva1,tva2,tva3;
    TashieLoader tashieLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zload);

//        checkconnection();

        tashieLoader = findViewById(R.id.progress);

        TashieLoader tashie = new TashieLoader(
                this, 5,
                20, 5,
                ContextCompat.getColor(this, R.color.blue));

        tashie.setAnimDuration(100);
        tashie.setAnimDelay(50);
        tashie.setInterpolator(new LinearInterpolator());

        tashieLoader.addView(tashie);

        tv1 = findViewById(R.id.loadname);
        stn = getIntent().getExtras().getString("uname");
        tv1.setText(stn);


        tva1 =findViewById(R.id.tva1);
        tva2 =findViewById(R.id.tva2);
        tva3 =findViewById(R.id.tva3);


        Handler handler = new Handler ();
        handler.postDelayed (new Runnable ( ) {
            @Override
            public void run() {
                tva1 =findViewById(R.id.tva1);
                tva2 =findViewById(R.id.tva2);
                tva3 =findViewById(R.id.tva3);

                stg = tva1.getText().toString();
                stl = tva2.getText().toString();
                sta = tva3.getText().toString();


                getIntent().getExtras().getString("value");
                getIntent().getExtras().getString("gid");


                int b = 10;
                int a = Integer.valueOf(sta);



                st8 = "sin";
                st9 = "en";
                int leone = st8.length();
                int lezero = st9.length();
                int letwo = stl.length();

                if (a == b) {
                    Intent intent = new Intent(getApplicationContext(), menus.class);
                    intent.putExtra("uname", stn);
                    startActivity(intent);

                } else {

                    if (leone == letwo) {

                        Intent intent = new Intent(getApplicationContext(), zmenus.class);
                        intent.putExtra("uname", stn);
                        intent.putExtra("language", stl);
                        intent.putExtra("grade", stg);

                        startActivity(intent);

                    } else if (lezero == letwo) {

                        Intent intent = new Intent(getApplicationContext(), zmenue.class);
                        intent.putExtra("uname", stn);
                        intent.putExtra("language", stl);
                        intent.putExtra("grade", stg);

                        startActivity(intent);

                    } else {
                        Intent intent = new Intent(getApplicationContext(), zmenut.class);
                        intent.putExtra("uname", stn);
                        intent.putExtra("language", stl);
                        intent.putExtra("grade", stg);
                        startActivity(intent);
                    }
                }
            }
        },2000);

    }

    public void checkconnection(){

        ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = manager.getActiveNetworkInfo();

        if(null!=activeNetwork){
            if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI){
                //  Toast.makeText(this,"Connection Enable",Toast.LENGTH_SHORT).show();

            }
            if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE){
                // Toast.makeText(this,"Data Network Enable",Toast.LENGTH_SHORT).show();

            }
        }
        else {

        }
    }

    protected void onResume(){
        super.onResume();
        loadSession();
    }
    public void loadSession() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/language.php?uname="+stn+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tva1.setText(response.getString("grade"));
                            tva2.setText(response.getString("language"));
                            tva3.setText(response.getString("is_admin"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                            ;
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(zload.this, "wrong", Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        });

        VolleySingleton.getInstance(zload.this).addToRequestQueue(jsonObjectRequest);
    }
}