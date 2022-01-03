package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

public class zgamemarks extends AppCompatActivity {

    String st,st0,st1,st2,st3,st4,st5,st6,st7,st8,st9,st10,st16,st17,st18,stn,stl,stg,ca,cb,cc,ra,rb,rc,totalc,uname,gid,sid,cid,marks,cname;
    TextView tv,tv0,tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10,tva11,tva12,tva13,tv16,tv17,tv18,tv21,tv22,tv23,tv24,tv25,tv26,tv27;
    ListView lv;
    Button ethome,etanswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zgamemarks);

        etanswer = findViewById(R.id.etanswer);
        ethome = findViewById(R.id.ethome);

        stn = getIntent().getExtras().getString("uname");
        stl = getIntent().getExtras().getString("language");
        stg = getIntent().getExtras().getString("grade");

        tv = findViewById(R.id.ltext5);
        st = getIntent().getExtras().getString("value");
        tv.setText(st);
        tv1 = findViewById(R.id.ltext6);
        st1= getIntent().getExtras().getString("gid");
        tv1.setText(st1);
        tv2 = findViewById(R.id.ltext7);
        st2 = getIntent().getExtras().getString("SIDNAME");
        tv2.setText(st2);
        tv3 = findViewById(R.id.ltext8);
        st3 = getIntent().getExtras().getString("SID");
        tv3.setText(st3);
        tv4 = findViewById(R.id.ltext9);
        st4 = getIntent().getExtras().getString("CIDNAME");
        tv4.setText(st4);
        tv5 = findViewById(R.id.ltext10);
        st5 = getIntent().getExtras().getString("CID");
        tv5.setText(st5);
        tv6 = findViewById(R.id.ltext11);
        st6 = getIntent().getExtras().getString("CPDF");
        tv6.setText(st6);
        tv0 = findViewById(R.id.ltext12);
        st0 = getIntent().getExtras().getString("SIDPDF");
        tv0.setText(st0);
        tv16 = findViewById(R.id.ltext16);
        st16 = getIntent().getExtras().getString("qa");
        tv16.setText(st16);

        tv17 = findViewById(R.id.ltext17);
        st17 = getIntent().getExtras().getString("qb");
        tv17.setText(st17);

        tv18 = findViewById(R.id.ltext18);
        st18 = getIntent().getExtras().getString("qc");
        tv18.setText(st18);


        tv21 = findViewById(R.id.ca);
        ca = getIntent().getExtras().getString("ca");
        tv21.setText(ca);

        tv22 = findViewById(R.id.cb);
        cb = getIntent().getExtras().getString("cb");
        tv22.setText(cb);

        tv23 = findViewById(R.id.cc);
        cc = getIntent().getExtras().getString("cc");
        tv23.setText(cc);

        tv24 = findViewById(R.id.ra);
        ra = getIntent().getExtras().getString("ra");
        tv24.setText(ra);

        tv25 = findViewById(R.id.rb);
        rb = getIntent().getExtras().getString("rb");
        tv25.setText(rb);

        tv26 = findViewById(R.id.rc);
        rc = getIntent().getExtras().getString("rc");
        tv26.setText(rc);

        tv27 = findViewById(R.id.totalc);
        totalc = getIntent().getExtras().getString("totalc");
        tv27.setText(totalc);

        tva11 =findViewById(R.id.tv11);
        tva12 =findViewById(R.id.tv12);
        tva13 =findViewById(R.id.tv13);

        etanswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uname = getIntent().getExtras().getString("uname");
                gid= getIntent().getExtras().getString("gid");
                sid = getIntent().getExtras().getString("SID");
                cid = getIntent().getExtras().getString("CID");
                cname = getIntent().getExtras().getString("CIDNAME");
                marks = getIntent().getExtras().getString("totalc");

                addclasses(uname,gid,sid,cid,cname,marks);


                Intent intent = new Intent(zgamemarks.this,zanswers.class);
                intent.putExtra("uname", stn);
                intent.putExtra ("value", st);
                intent.putExtra("language", stl);
                intent.putExtra("grade", stg);
                intent.putExtra ("gid", st1);
                intent.putExtra ("SID", st3);
                intent.putExtra ("SIDNAME", st2);
                intent.putExtra ("SIDPDF", st0);
                intent.putExtra ("CIDNAME", st4);
                intent.putExtra ("CID", st5);
                intent.putExtra ("CPDF", st6);
                intent.putExtra("qa",st16);
                intent.putExtra("qb",st17);
                intent.putExtra("qc",st18);
                intent.putExtra("ca",ca);
                intent.putExtra("cb",cb);
                intent.putExtra("cc",cc);
                intent.putExtra("totalc", totalc);
                intent.putExtra("ra",ra);
                intent.putExtra("rb",rb);
                intent.putExtra("rc",rc);
                startActivity (intent);

            }});

        ethome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                uname = getIntent().getExtras().getString("uname");
//                gid= getIntent().getExtras().getString("gid");
//                sid = getIntent().getExtras().getString("SID");
//                cid = getIntent().getExtras().getString("CID");
//                cname = getIntent().getExtras().getString("CIDNAME");
//                marks = getIntent().getExtras().getString("totalc");
//
//                addclasses(uname,gid,sid,cid,cname,marks);

                Intent intent = new Intent(zgamemarks.this,zlesson.class);
                intent.putExtra("uname", stn);
                intent.putExtra ("value", st);
                intent.putExtra("language", stl);
                intent.putExtra("grade", stg);
                intent.putExtra ("gid", st1);
                intent.putExtra ("SID", st3);
                intent.putExtra ("SIDNAME", st2);
                intent.putExtra ("SIDPDF", st0);
                intent.putExtra ("CIDNAME", st4);
                intent.putExtra ("CID", st5);
                intent.putExtra ("CPDF", st6);
                intent.putExtra("qa",st16);
                intent.putExtra("qb",st17);
                intent.putExtra("qc",st18);
                intent.putExtra("ca",ca);
                intent.putExtra("cb",cb);
                intent.putExtra("cc",cc);
                intent.putExtra("totalc", totalc);
                intent.putExtra("ra",ra);
                intent.putExtra("rb",rb);
                intent.putExtra("rc",rc);
                startActivity (intent);

            }});

    }

    protected void onResume(){
        super.onResume();
        loadSession1();
    }
    public void loadSession1(){

        JsonObjectRequest jsonObjectRequest6 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/getusub.php?sid="+st3+"&&uname="+stn+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tva11.setText(response.getString("ststn"));
                            tva12.setText(response.getString("stmarks"));
                            tva13.setText(response.getString("sttotal"));
                        } catch (JSONException e){
                            e.printStackTrace();;
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });


        VolleySingleton.getInstance(zgamemarks.this).addToRequestQueue(jsonObjectRequest6);

    }

    private void addclasses(final String uname, final String gid, final String sid, final String cid, final String cname,final String marks) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endspoint.addamarks_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("success")) {

                    Toast.makeText(zgamemarks.this, " Successfully Access data", Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(zgamemarks.this, "Error", Toast.LENGTH_SHORT).show();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(zgamemarks.this, "Please check your Internet Connection", Toast.LENGTH_SHORT).show();

            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("uname", uname);
                params.put("marks", marks);
                params.put("gid", gid);
                params.put("sid", sid);
                params.put("cid", cid);
                params.put("cname", cname);

                return params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

}