package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.agrawalsuneet.dotsloader.loaders.TashieLoader;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class zlabnewload extends AppCompatActivity {

    String st,st0,st1,st2,st3,st4,st5,st6,st30,stn,stanu,stbnu,stcnu,stdnu,stenu,ttanu,stmarks,st22,
            stl,stg,sta,stb,stz,stqa,stqb,stqc,stqd,stqe,staa,stab,stac,stad,stae,stm   ;
    TextView tv1,tv2,tvanu,tvbnu,tvcnu,tvdnu,tvenu,tva1,tva2,tva3,tva4,tva5,tva6,tva7,tva8,tva9,tva10,tva11;
    Button dbtn,dbtn1;

    TashieLoader tashieLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zlabnewload);

        tashieLoader = findViewById(R.id.progress);

        TashieLoader tashie = new TashieLoader(
                this, 5,
                20, 5,
                ContextCompat.getColor(this, R.color.blue));

        tashie.setAnimDuration(100);
        tashie.setAnimDelay(50);
        tashie.setInterpolator(new LinearInterpolator());

        tashieLoader.addView(tashie);


        stn = getIntent().getExtras().getString("uname");
        stl = getIntent().getExtras().getString("language");
        stg = getIntent().getExtras().getString("grade");

        stm = getIntent().getExtras().getString("numm");


        st = getIntent().getExtras().getString("value");
        st1= getIntent().getExtras().getString("gid");
        st2 = getIntent().getExtras().getString("SIDNAME");
        st3 = getIntent().getExtras().getString("SID");
        st4 = getIntent().getExtras().getString("CIDNAME");
        st5 = getIntent().getExtras().getString("CID");
        st6 = getIntent().getExtras().getString("CPDF");
        st0 = getIntent().getExtras().getString("SIDPDF");
        sta = getIntent().getExtras().getString("aid");
        stb = getIntent().getExtras().getString("bid");
        stz = getIntent().getExtras().getString("zid");

        stqa = getIntent().getExtras().getString("zqa");
        stqb = getIntent().getExtras().getString("zqb");
        stqc = getIntent().getExtras().getString("zqc");
        stqd = getIntent().getExtras().getString("zqd");
        stqe = getIntent().getExtras().getString("zqe");


        staa = getIntent().getExtras().getString("zaa");
        stab = getIntent().getExtras().getString("zab");
        stac = getIntent().getExtras().getString("zac");
        stad = getIntent().getExtras().getString("zad");
        stae = getIntent().getExtras().getString("zae");

        tvanu =findViewById(R.id.tvanum);
        tvbnu =findViewById(R.id.tvbnum);
        tvcnu =findViewById(R.id.tvcnum);
        tvdnu =findViewById(R.id.tvdnum);
        tvenu =findViewById(R.id.tvenum);

        dbtn = findViewById(R.id.etadds);
        dbtn1 = findViewById(R.id.etaddss);

        dbtn.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {


                stanu = tvanu.getText().toString();
                stbnu = tvbnu.getText().toString();
                stcnu = tvcnu.getText().toString();
                stdnu = tvdnu.getText().toString();
                stenu = tvenu.getText().toString();


         int tnanum = Integer.valueOf(stanu);
        int tnbnum = Integer.valueOf(stbnu);
        int tncnum = Integer.valueOf(stcnu);
        int tndnum = Integer.valueOf(stdnu);
        int tnenum = Integer.valueOf(stenu);
                int tnmarks = tnanum + tnbnum +tncnum +tndnum +tnenum;

                tva11 =findViewById(R.id.newmarks);
                st22 = String.valueOf(tnmarks);
                tva11.setText(st22);


            }


        });

          Handler handler = new Handler ();
                handler.postDelayed (new Runnable ( ) {
                    @Override
                    public void run() {
                        stn = getIntent().getExtras().getString("uname");
                        st5 = getIntent().getExtras().getString("CID");

                        stanu = tvanu.getText().toString();
                        stbnu = tvbnu.getText().toString();
                        stcnu = tvcnu.getText().toString();
                        stdnu = tvdnu.getText().toString();
                        stenu = tvenu.getText().toString();


                        int tnanum = Integer.valueOf(stanu);
                        int tnbnum = Integer.valueOf(stbnu);
                        int tncnum = Integer.valueOf(stcnu);
                        int tndnum = Integer.valueOf(stdnu);
                        int tnenum = Integer.valueOf(stenu);
                        int tnmarks = tnanum + tnbnum +tncnum +tndnum +tnenum;

                        tva11 =findViewById(R.id.newmarks);
                        st22 = String.valueOf(tnmarks);
                        tva11.setText(st22);

                        addclasses(stn,st5,st22);
                    }
                },5000);

        dbtn1.setOnClickListener (new View.OnClickListener ( ) {

            @Override
            public void onClick(View v) {
                stn = getIntent().getExtras().getString("uname");
                st5 = getIntent().getExtras().getString("CID");

                stanu = tvanu.getText().toString();
                stbnu = tvbnu.getText().toString();
                stcnu = tvcnu.getText().toString();
                stdnu = tvdnu.getText().toString();
                stenu = tvenu.getText().toString();


                int tnanum = Integer.valueOf(stanu);
                int tnbnum = Integer.valueOf(stbnu);
                int tncnum = Integer.valueOf(stcnu);
                int tndnum = Integer.valueOf(stdnu);
                int tnenum = Integer.valueOf(stenu);
                int tnmarks = tnanum + tnbnum +tncnum +tndnum +tnenum;

                tva11 =findViewById(R.id.newmarks);
                st22 = String.valueOf(tnmarks);
                tva11.setText(st22);

                addclasses(stn,st5,st22);
            }

        });


   }


    protected void onResume(){
        super.onResume();
        loadSession1();
    }
    public void loadSession1(){

        JsonObjectRequest jsonObjectRequest4 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/simmarks.php?uname="+stn+"&&cid="+st5+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tvanu.setText(response.getString("anum"));
                            tvbnu.setText(response.getString("bnum"));
                            tvcnu.setText(response.getString("cnum"));
                            tvdnu.setText(response.getString("dnum"));
                            tvenu.setText(response.getString("enum"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                error.printStackTrace();
            }
        });
        VolleySingleton.getInstance(zlabnewload.this).addToRequestQueue(jsonObjectRequest4);
    }

    private void addclasses( final String stn, final String st5, final String st22) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endspoint.addmarks_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("success")) {



                    Intent intent = new Intent(zlabnewload.this, zlabgameg.class);
                    intent.putExtra("uname", stn);
                    intent.putExtra("language", stl);
                    intent.putExtra("grade", stg);
                    intent.putExtra("value", st);
                    intent.putExtra("gid", st1);
                    intent.putExtra("SIDNAME", st2);
                    intent.putExtra("SID", st3);
                    intent.putExtra("SIDPDF", st0);
                    intent.putExtra("CID",st5);
                    intent.putExtra("CIDNAME",st4);
                    intent.putExtra("CPDF", st6);
                    intent.putExtra("aid", sta);
                    intent.putExtra("bid", stb);
                    intent.putExtra("zid", stz);
                    intent.putExtra("zqa", stqa);
                    intent.putExtra("zqb", stqb);
                    intent.putExtra("zqc", stqc);
                    intent.putExtra("zqd", stqd);
                    intent.putExtra("zqe", stqe);
                    intent.putExtra("zaa", staa);
                    intent.putExtra("zab", stab);
                    intent.putExtra("zac", stac);
                    intent.putExtra("zad", stad);
                    intent.putExtra("zae", stae);

                    startActivity(intent);

                } else {



                    Intent intent = new Intent(zlabnewload.this, zlabgameg.class);
                    intent.putExtra("uname", stn);
                    intent.putExtra("language", stl);
                    intent.putExtra("grade", stg);
                    intent.putExtra("value", st);
                    intent.putExtra("gid", st1);
                    intent.putExtra("SIDNAME", st2);
                    intent.putExtra("SID", st3);
                    intent.putExtra("SIDPDF", st0);
                    intent.putExtra("CID",st5);
                    intent.putExtra("CIDNAME",st4);
                    intent.putExtra("CPDF", st6);
                    intent.putExtra("aid", sta);
                    intent.putExtra("bid", stb);
                    intent.putExtra("zid", stz);
                    intent.putExtra("zqa", stqa);
                    intent.putExtra("zqb", stqb);
                    intent.putExtra("zqc", stqc);
                    intent.putExtra("zqd", stqd);
                    intent.putExtra("zqe", stqe);
                    intent.putExtra("zaa", staa);
                    intent.putExtra("zab", stab);
                    intent.putExtra("zac", stac);
                    intent.putExtra("zad", stad);
                    intent.putExtra("zae", stae);
                    intent.putExtra("numm", stm);

                    startActivity(intent);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(zlabnewload.this, "Please check your Internet Connection", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(zlabnewload.this, zlabnewload.class);
                intent.putExtra("uname", stn);
                intent.putExtra("language", stl);
                intent.putExtra("grade", stg);
                intent.putExtra("value", st);
                intent.putExtra("gid", st1);
                intent.putExtra("SIDNAME", st2);
                intent.putExtra("SID", st3);
                intent.putExtra("SIDPDF", st0);
                intent.putExtra("CID",st5);
                intent.putExtra("CIDNAME",st4);
                intent.putExtra("CPDF", st6);
                intent.putExtra("aid", sta);
                intent.putExtra("bid", stb);
                intent.putExtra("zid", stz);
                intent.putExtra("zqa", stqa);
                intent.putExtra("zqb", stqb);
                intent.putExtra("zqc", stqc);
                intent.putExtra("zqd", stqd);
                intent.putExtra("zqe", stqe);
                intent.putExtra("zaa", staa);
                intent.putExtra("zab", stab);
                intent.putExtra("zac", stac);
                intent.putExtra("zad", stad);
                intent.putExtra("zae", stae);
                intent.putExtra("numm", stm);
                startActivity(intent);

            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("uname", stn);
                params.put("cid", st5);
                params.put("marks", st22);


                return params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

}