package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

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

public class zlabmarks extends AppCompatActivity {

    String numm,st, st0, st1, st2, st3, st4, st5, st6, stn, stl, stg, sta, stb, stz, stqa, stqb, stqc, stqd, stqe, staa, stab, stac, stad, stae;
    TextView tva1, tva2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zlabmarks);

        tva1 =findViewById(R.id.tva1);


        stn = getIntent().getExtras().getString("uname");
        stl = getIntent().getExtras().getString("language");
        stg = getIntent().getExtras().getString("grade");

        tva2 = findViewById(R.id.tva2);
        st4 = getIntent().getExtras().getString("CIDNAME");
        tva2.setText(st4);


        st = getIntent().getExtras().getString("value");
        st1 = getIntent().getExtras().getString("gid");
        st2 = getIntent().getExtras().getString("SIDNAME");
        st3 = getIntent().getExtras().getString("SID");
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


    }


    public void zlabgame(View view) {
        numm = tva1.getText().toString();

        Intent intent = new Intent(this, zlabviewsim.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        intent.putExtra("value", st);
        intent.putExtra("gid", st1);
        intent.putExtra("SIDNAME", st2);
        intent.putExtra("SID", st3);
        intent.putExtra("SIDPDF", st0);
        intent.putExtra("CID", st5);
        intent.putExtra("CIDNAME", st4);
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
        intent.putExtra("numm", numm);

        startActivity(intent);
        finish();
    }

    protected void onResume(){
        super.onResume();
        loadSession();
    }
    public void loadSession() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/user.php?gid="+st1+"&&uname="+stn+"&&cid="+st5+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tva1.setText(response.getString("marks"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(zlabmarks.this, "wrong", Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        });
        VolleySingleton.getInstance(zlabmarks.this).addToRequestQueue(jsonObjectRequest);
    }

}