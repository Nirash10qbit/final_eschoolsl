package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class zlabgamef extends AppCompatActivity {

    String st,st0,st1,st2,st3,st4,st5,st6,ca,cb,cc,cd,ce,stn,stl,stg,sta,stb,stz,stqa,stqb,stqc,stqd,stqe,staa,stab,stac,stad,stae,totale,totalf,ra,rb,rc,rd,re,sttstn,sttmarks,stnt,totalt,markst,sttotal,
            tote,stbstn,stbmarks,stbtotal,stzstn,stzmarks,stztotal,stnb,totalb,marksb,stnz,marksz,totalz,marks;
    TextView tv2,tv3,tv4,tv5,tva1,tva2,tva3,tva4,tva5,tva6,tva7,tva8,tva9,tva10,tvmarks;
    ListView lv1;
    Button etadd,ethome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zlabgamef);

        etadd = findViewById(R.id.etadd);
        ethome = findViewById(R.id.ethome);

        stn = getIntent().getExtras().getString("uname");
        stl = getIntent().getExtras().getString("language");
        stg = getIntent().getExtras().getString("grade");

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


        ra = getIntent().getExtras().getString("ra");
        rb = getIntent().getExtras().getString("rb");
        rc = getIntent().getExtras().getString("rc");
        rd = getIntent().getExtras().getString("rd");
        re = getIntent().getExtras().getString("re");

        ca = getIntent().getExtras().getString("ca");
        cb = getIntent().getExtras().getString("cb");
        cc = getIntent().getExtras().getString("cc");
        cd = getIntent().getExtras().getString("cd");
        ce = getIntent().getExtras().getString("ce");

        tva1 =findViewById(R.id.aastn);
        tva2 =findViewById(R.id.aamarks);
        tva3 =findViewById(R.id.aatotal);
        tva4 =findViewById(R.id.abstn);
        tva5 =findViewById(R.id.abmarks);
        tva6 =findViewById(R.id.abtotal);
        tva7 =findViewById(R.id.azstn);
        tva8 =findViewById(R.id.azmarks);
        tva9 =findViewById(R.id.aztotal);
        tva10 =findViewById(R.id.marks);


        tvmarks = findViewById(R.id.gidnew6);
//        totale = getIntent().getExtras().getString("totale");
//        tv2.setText(totale);


        etadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sttstn = tva1.getText().toString();
                sttmarks = tva2.getText().toString();
                sttotal = tva3.getText().toString();

                stbstn = tva4.getText().toString();
                stbmarks = tva5.getText().toString();
                stbtotal = tva6.getText().toString();

                stzstn = tva7.getText().toString();
                stzmarks = tva8.getText().toString();
                stztotal = tva9.getText().toString();

                marks = tva10.getText().toString();



                tote = String.valueOf(totale);
                int tot = Integer.valueOf(tote);

                int tnstn = Integer.valueOf(sttstn);
                int nstn = tnstn + 1;
                stnt = String.valueOf(nstn);

                int tnmarks = Integer.valueOf(sttmarks);
                int nmarks = tnmarks + tot;
                markst = String.valueOf(nmarks);

                int nstotal = nmarks/nstn;
                totalt = String.valueOf(nstotal);

                int tmstn = Integer.valueOf(stbstn);
                int mstn = tmstn + 1;
                stnb = String.valueOf(mstn);

                int tmmarks = Integer.valueOf(stbmarks);
                int mmarks = tmmarks + tot;
                marksb = String.valueOf(mmarks);

                int mstotal = mmarks/mstn;
                totalb = String.valueOf(mstotal);


                int tpstn = Integer.valueOf(stzstn);
                int pstn = tpstn + 1;
                stnz = String.valueOf(pstn);

                int tpmarks = Integer.valueOf(stzmarks);
                int pmarks = tpmarks + tot;
                marksz = String.valueOf(pmarks);

                int pstotal = pmarks/pstn;
                totalz = String.valueOf(pstotal);

                addclasses(stnt,markst,totalt,stnb,marksb,totalb,stnz,marksz,totalz,stn,stg,st1,sta,stb,stz,marks,totale);

            }
        });

        ethome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sttstn = tva1.getText().toString();
                sttmarks = tva2.getText().toString();
                sttotal = tva3.getText().toString();

                stbstn = tva4.getText().toString();
                stbmarks = tva5.getText().toString();
                stbtotal = tva6.getText().toString();

                stzstn = tva7.getText().toString();
                stzmarks = tva8.getText().toString();
                stztotal = tva9.getText().toString();

                marks = tva10.getText().toString();



                tote = String.valueOf(totale);
                int tot = Integer.valueOf(tote);

                int tnstn = Integer.valueOf(sttstn);
                int nstn = tnstn + 1;
                stnt = String.valueOf(nstn);

                int tnmarks = Integer.valueOf(sttmarks);
                int nmarks = tnmarks + tot;
                markst = String.valueOf(nmarks);

                int nstotal = nmarks/nstn;
                totalt = String.valueOf(nstotal);

                int tmstn = Integer.valueOf(stbstn);
                int mstn = tmstn + 1;
                stnb = String.valueOf(mstn);

                int tmmarks = Integer.valueOf(stbmarks);
                int mmarks = tmmarks + tot;
                marksb = String.valueOf(mmarks);

                int mstotal = mmarks/mstn;
                totalb = String.valueOf(mstotal);


                int tpstn = Integer.valueOf(stzstn);
                int pstn = tpstn + 1;
                stnz = String.valueOf(pstn);

                int tpmarks = Integer.valueOf(stzmarks);
                int pmarks = tpmarks + tot;
                marksz = String.valueOf(pmarks);

                int pstotal = pmarks/pstn;
                totalz = String.valueOf(pstotal);

                addclasses(stnt,markst,totalt,stnb,marksb,totalb,stnz,marksz,totalz,stn,stg,st1,sta,stb,stz,marks,totale);

            }
        });
    }


    protected void onResume(){
        super.onResume();
        loadSession1();
    }
    public void loadSession1(){

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/getdata.php", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tva1.setText(response.getString("tstn"));
                            tva2.setText(response.getString("tmarks"));
                            tva3.setText(response.getString("ttotal"));
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

        VolleySingleton.getInstance(zlabgamef.this).addToRequestQueue(jsonObjectRequest)   ;

        JsonObjectRequest jsonObjectRequest2 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/getlabsub.php?aid="+sta+"&&bid="+stb+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tva4.setText(response.getString("bstn"));
                            tva5.setText(response.getString("bmarks"));
                            tva6.setText(response.getString("btotal"));
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


        VolleySingleton.getInstance(zlabgamef.this).addToRequestQueue(jsonObjectRequest2)   ;

        JsonObjectRequest jsonObjectRequest3 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/getlabact.php?aid="+sta+"&&bid="+stb+"&&zid="+stz+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tva7.setText(response.getString("zstn"));
                            tva8.setText(response.getString("zmarks"));
                            tva9.setText(response.getString("ztotal"));
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


        VolleySingleton.getInstance(zlabgamef.this).addToRequestQueue(jsonObjectRequest3);

        JsonObjectRequest jsonObjectRequest4 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/getuser.php?uname="+stn+"&&gid="+st1+"&&sid="+st3+"&&cid="+st5+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tva10.setText(response.getString("marks"));
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


        VolleySingleton.getInstance(zlabgamef.this).addToRequestQueue(jsonObjectRequest4)   ;


        JsonObjectRequest jsonObjectRequest5 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/simmarks.php?uname="+stn+"&&cid="+st5+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tvmarks.setText(response.getString("marks"));
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
        VolleySingleton.getInstance(zlabgamef.this).addToRequestQueue(jsonObjectRequest5);

    }



    private void showMessage(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }



    private void addclasses( final String stnt, final String markst, final  String totalt,final String stnb, final String marksb, final  String totalb,final String stnz, final String marksz, final  String totalz,final String stn, final String stg, final  String st1 ,final  String sta, final String stb, final String stz, final String marks, final String totale) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endspoint.updatedata_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("success")) {
                    Intent intent = new Intent(zlabgamef.this, zlabgameza.class);
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
                    intent.putExtra("ra", ra);
                    intent.putExtra("rb", rb);
                    intent.putExtra("rc", rc);
                    intent.putExtra("rd", rd);
                    intent.putExtra("re", re);
                    intent.putExtra("ca", ca);
                    intent.putExtra("cb", cb);
                    intent.putExtra("cc", cc);
                    intent.putExtra("cd", cd);
                    intent.putExtra("ce", ce);
                    startActivity(intent);

                } else {
                    Intent intent = new Intent(zlabgamef.this, zlabgameza.class);
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
                    intent.putExtra("ra", ra);
                    intent.putExtra("rb", rb);
                    intent.putExtra("rc", rc);
                    intent.putExtra("rd", rd);
                    intent.putExtra("re", re);
                    intent.putExtra("ca", ca);
                    intent.putExtra("cb", cb);
                    intent.putExtra("cc", cc);
                    intent.putExtra("cd", cd);
                    intent.putExtra("ce", ce);
                    startActivity(intent);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(zlabgamef.this, "Please check your Internet Connection", Toast.LENGTH_SHORT).show();
                Log.d("VOLLEY", error.getMessage());
                Intent intent = new Intent(zlabgamef.this, zlabgameza.class);
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
                intent.putExtra("ra", ra);
                intent.putExtra("rb", rb);
                intent.putExtra("rc", rc);
                intent.putExtra("rd", rd);
                intent.putExtra("re", re);
                intent.putExtra("ca", ca);
                intent.putExtra("cb", cb);
                intent.putExtra("cc", cc);
                intent.putExtra("cd", cd);
                intent.putExtra("ce", ce);
                startActivity(intent);

            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("tstn", stnt);
                params.put("tmarks", markst);
                params.put("ttotal", totalt);
                params.put("bstn", stnb);
                params.put("bmarks", marksb);
                params.put("btotal", totalb);
                params.put("zstn", stnz);
                params.put("zmarks", marksz);
                params.put("ztotal", totalz);
                params.put("stn", stn);
                params.put("stg", stg);
                params.put("sta", sta);
                params.put("stb", stb);
                params.put("stz", stz);
                params.put("marks", marks);
                params.put("totale", totale);
                params.put("gid", st1);
                params.put("sid", st3);
                params.put("cid", st5);

                return params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }
}
