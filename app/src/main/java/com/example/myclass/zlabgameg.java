
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

public class zlabgameg extends AppCompatActivity {

    String st,st0,st1,st2,st3,st4,st5,st6,st8,st9,st10,ca,cb,cc,cd,ce,stn,stl,stg,sta,stb,stz,stqa,stqb,stqc,stqd,stqe,staa,stab,stac,stad,stae,totale,totalf,ra,rb,rc,rd,re,sttstn,sttmarks,stnt,totalt,markst,sttotal,
            nstntt,nmarkstt,ntotaltt,anu,bnu,cnu,dnu,enu,one,stbstn,stbmarks,stbtotal,stzstn,stzmarks,stztotal,stnb,totalb,marksb,stnz,marksz,totalz,marks,ststn,stmarks,stttotal,stntt,markstt,totaltt,
            stststn,ststmarks,ststtotal,stnst,marksst,totalst,nstnst,nmarksst,ntotalst,
            ml1,ml2,ml3,ml4,ml5,ms1,ms2,ms3,ms4,ms5,mz1,mz2,mz3,mz4,mz5,sl1,sl2,sl3,sl4,sl5,ss1,ss2,ss3,ss4,ss5,sz1,sz2,sz3,sz4,sz5,al1,al2,al3,al4,al5,as1,as2,as3,as4,as5,az1,az2,az3,az4,az5;
    TextView tv2,tv3,tv4,tv5,tva1,tva2,tva3,tva4,tva5,tva6,tva7,tva8,tva9,tva10,tvmarks,tvboy,tva11,tva12,tva13,tvl1,tvl2,tvl3,tvl4,tvl5,tvs1,tvs2,tvs3,tvs4,tvs5,tvz1,tvz2,tvz3,tvz4,tvz5;
    ListView lv1;
    Button etadd,ethome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zlabgameg);

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

        tva11 =findViewById(R.id.tv11);
        tva12 =findViewById(R.id.tv12);
        tva13 =findViewById(R.id.tv13);

        tvl1 =findViewById(R.id.l1);
        tvl2 =findViewById(R.id.l2);
        tvl3 =findViewById(R.id.l3);
        tvl4 =findViewById(R.id.l4);
        tvl5 =findViewById(R.id.l5);

        tvs1 =findViewById(R.id.s1);
        tvs2 =findViewById(R.id.s2);
        tvs3 =findViewById(R.id.s3);
        tvs4 =findViewById(R.id.s4);
        tvs5 =findViewById(R.id.s5);

        tvz1 =findViewById(R.id.z1);
        tvz2 =findViewById(R.id.z2);
        tvz3 =findViewById(R.id.z3);
        tvz4 =findViewById(R.id.z4);
        tvz5 =findViewById(R.id.z5);



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

                ststn = tva11.getText().toString();
                stmarks = tva12.getText().toString();
                stttotal = tva13.getText().toString();

                sl1 = tvl1.getText().toString();
                sl2 = tvl2.getText().toString();
                sl3 = tvl3.getText().toString();
                sl4 = tvl4.getText().toString();
                sl5 = tvl5.getText().toString();

                ss1 = tvs1.getText().toString();
                ss2 = tvs2.getText().toString();
                ss3 = tvs3.getText().toString();
                ss4 = tvs4.getText().toString();
                ss5 = tvs5.getText().toString();

                sz1 = tvz1.getText().toString();
                sz2 = tvz2.getText().toString();
                sz3 = tvz3.getText().toString();
                sz4 = tvz4.getText().toString();
                sz5 = tvz5.getText().toString();


                totale = tvmarks.getText().toString();

                one = "1";


                int tot = Integer.valueOf(totale);
                int ma = Integer.valueOf(marks);

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

                int tnstnt = Integer.valueOf(ststn);
                int nstnt = tnstnt + 1;
                stntt = String.valueOf(nstnt);

                nstntt = String.valueOf(tnstnt);

                int tnmarkst = Integer.valueOf(stmarks);
                int nmarkst = tnmarkst + tot;
                markstt = String.valueOf(nmarkst);

                int nnmarkst = nmarkst - ma ;

                nmarkstt = String.valueOf(nnmarkst);

                int nstotalt = nmarkst/nstnt;
                totaltt = String.valueOf(nstotalt);

                int nnstotalt = nnmarkst/tnstnt;
                ntotaltt = String.valueOf(nnstotalt);


                int l1 = Integer.valueOf(sl1);
                int ll1 = l1 + 1;
                al1 = String.valueOf(ll1);

                int l2 = Integer.valueOf(sl2);
                int ll2 = l2 + 1;
                al2 = String.valueOf(ll2);

                int l3 = Integer.valueOf(sl3);
                int ll3 = l3 + 1;
                al3 = String.valueOf(ll3);

                int l4= Integer.valueOf(sl4);
                int ll4 = l4 + 1;
                al4 = String.valueOf(ll4);

                int l5 = Integer.valueOf(sl5);
                int ll5 = l5 + 1;
                al5 = String.valueOf(ll5);

                int s1 = Integer.valueOf(ss1);
                int ls1 = s1 + 1;
                as1 = String.valueOf(ls1);

                int s2 = Integer.valueOf(ss2);
                int ls2 = s2 + 1;
                as2 = String.valueOf(ls2);

                int s3 = Integer.valueOf(ss3);
                int ls3 = s3 + 1;
                as3 = String.valueOf(ls3);

                int s4 = Integer.valueOf(ss4);
                int ls4 = s4 + 1;
                as4 = String.valueOf(ls4);

                int s5 = Integer.valueOf(ss5);
                int ls5 = s5 + 1;
                as5 = String.valueOf(ls5);


                int z1 = Integer.valueOf(sz1);
                int lz1 = z1 + 1;
                az1 = String.valueOf(lz1);

                int z2 = Integer.valueOf(sz2);
                int lz2 = z2 + 1;
                az2 = String.valueOf(lz2);

                int z3 = Integer.valueOf(sz3);
                int lz3 = z3 + 1;
                az3 = String.valueOf(lz3);

                int z4 = Integer.valueOf(sz4);
                int lz4 = z4 + 1;
                az4 = String.valueOf(lz4);

                int z5 = Integer.valueOf(sz5);
                int lz5 = z5 + 1;
                az5 = String.valueOf(lz5);



                addclasses(st4,stnt,markst,totalt,stnb,marksb,totalb,stnz,marksz,totalz,stn,stg,st1,st3,st5,sta,stb,stz,marks,totale,al1,al2,al3,al4,al5,as1,as2,as3,as4,as5,az1,az2,az3,az4,az5);

                addclasses3(stmarks,st1,st2,one,ststn,totale,marks,stn,st3,sta,stg,stntt,markstt,totaltt,nstntt,nmarkstt,ntotaltt);

            }
        });

        ethome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sttstn = tva1.getText().toString();
                sttmarks = tva2.getText().toString();
                sttotal = tva3.getText().toString();

                ml1 = tvl1.getText().toString();
                ml2 = tvl2.getText().toString();
                ml3 = tvl3.getText().toString();
                ml4 = tvl4.getText().toString();
                ml5 = tvl5.getText().toString();

                ms1 = tvs1.getText().toString();
                ms1 = tvs1.getText().toString();
                ms1 = tvs1.getText().toString();
                ms1 = tvs1.getText().toString();
                ms1 = tvs1.getText().toString();

                mz1 = tvz1.getText().toString();
                mz2 = tvz2.getText().toString();
                mz3 = tvz3.getText().toString();
                mz4 = tvz4.getText().toString();
                mz5 = tvz5.getText().toString();




                stbstn = tva4.getText().toString();
                stbmarks = tva5.getText().toString();
                stbtotal = tva6.getText().toString();    

                stzstn = tva7.getText().toString();
                stzmarks = tva8.getText().toString();
                stztotal = tva9.getText().toString();

                marks = tva10.getText().toString();

                ststn = tva11.getText().toString();
                stmarks = tva12.getText().toString();
                stttotal = tva13.getText().toString();


                totale = tvmarks.getText().toString();

                one = "1";


                int tot = Integer.valueOf(totale);
                int ma = Integer.valueOf(marks);

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

                int tnstnt = Integer.valueOf(ststn);
                int nstnt = tnstnt + 1;
                stntt = String.valueOf(nstnt);

                nstntt = String.valueOf(tnstnt);

                int tnmarkst = Integer.valueOf(stmarks);
                int nmarkst = tnmarkst + tot;
                markstt = String.valueOf(nmarkst);

                int nnmarkst = nmarkst - ma ;

                nmarkstt = String.valueOf(nnmarkst);

                int nstotalt = nmarkst/nstnt;
                totaltt = String.valueOf(nstotalt);

                int nnstotalt = nnmarkst/tnstnt;
                ntotaltt = String.valueOf(nnstotalt);


                addclasses2(st4,stnt,markst,totalt,stnb,marksb,totalb,stnz,marksz,totalz,stn,stg,st1,st3,st5,sta,stb,stz,marks,totale,al1,al2,al3,al4,al5,as1,as2,as3,as4,as5,az1,az2,az3,az4,az5);

                addclasses3(stmarks,st1,st2,one,ststn,totale,marks,stn,st3,sta,stg,stntt,markstt,totaltt,nstntt,nmarkstt,ntotaltt);

            }
        });
    }


    protected void onResume(){
        super.onResume();
        loadSession1();
    }
    public void loadSession1(){

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zgetlab.php", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tva1.setText(response.getString("tstn"));
                            tva2.setText(response.getString("tmarks"));
                            tva3.setText(response.getString("ttotal"));

                            tvl1.setText(response.getString("la"));
                            tvl2.setText(response.getString("lb"));
                            tvl3.setText(response.getString("lc"));
                            tvl4.setText(response.getString("ld"));
                            tvl5.setText(response.getString("le"));
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

        VolleySingleton.getInstance(zlabgameg.this).addToRequestQueue(jsonObjectRequest)   ;

        JsonObjectRequest jsonObjectRequest2 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zgetlabsub.php?aid="+sta+"&&bid="+stb+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tva4.setText(response.getString("bstn"));
                            tva5.setText(response.getString("bmarks"));
                            tva6.setText(response.getString("btotal"));

                            tvs1.setText(response.getString("sa"));
                            tvs2.setText(response.getString("sb"));
                            tvs3.setText(response.getString("sc"));
                            tvs4.setText(response.getString("sd"));
                            tvs5.setText(response.getString("se"));
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


        VolleySingleton.getInstance(zlabgameg.this).addToRequestQueue(jsonObjectRequest2)   ;

        JsonObjectRequest jsonObjectRequest3 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zgetlabact.php?aid="+sta+"&&bid="+stb+"&&zid="+stz+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tva7.setText(response.getString("zstn"));
                            tva8.setText(response.getString("zmarks"));
                            tva9.setText(response.getString("ztotal"));

                            tvz1.setText(response.getString("aa"));
                            tvz2.setText(response.getString("ab"));
                            tvz3.setText(response.getString("ac"));
                            tvz4.setText(response.getString("ad"));
                            tvz5.setText(response.getString("ae"));
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


        VolleySingleton.getInstance(zlabgameg.this).addToRequestQueue(jsonObjectRequest3);

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


        VolleySingleton.getInstance(zlabgameg.this).addToRequestQueue(jsonObjectRequest4)   ;

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
        VolleySingleton.getInstance(zlabgameg.this).addToRequestQueue(jsonObjectRequest5);

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


        VolleySingleton.getInstance(zlabgameg.this).addToRequestQueue(jsonObjectRequest6);






    }



    private void showMessage(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }



    private void addclasses( final String st4,final String stnt, final String markst, final  String totalt,final String stnb, final String marksb, final  String totalb,final String stnz, final String marksz, final  String totalz,final String stn, final String stg, final  String st1 ,final  String st3 ,final  String st5 ,final  String sta, final String stb,
                             final String stz, final String marks, final String totale,
                             final String al1, final String al2, final String al3, final String al4, final String al5,
                             final String as1, final String as2, final String as3, final String as4, final String as5,
                             final String az1, final String az2, final String az3, final String az4, final String az5) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endspoint.updatedata_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("success")) {
                    Intent intent = new Intent(zlabgameg.this, zlabload.class);
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
                    Intent intent = new Intent(zlabgameg.this, zlabload.class);
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
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(zlabgameg.this, "Please check your Internet Connection", Toast.LENGTH_SHORT).show();
                Log.d("VOLLEY", error.getMessage());
                Intent intent = new Intent(zlabgameg.this, zlabload.class);
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
                params.put("cname", st4);

                params.put("al1", al1);
                params.put("al2", al2);
                params.put("al3", al3);
                params.put("al4", al4);
                params.put("al5", al5);

                params.put("as1", as1);
                params.put("as2", as2);
                params.put("as3", as3);
                params.put("as4", as4);
                params.put("as5", as5);

                params.put("az1", az1);
                params.put("az2", az2);
                params.put("az3", az3);
                params.put("az4", az4);
                params.put("az5", az5);





                return params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

    private void addclasses2( final String st4,final String stnt, final String markst, final  String totalt,final String stnb, final String marksb, final  String totalb,final String stnz, final String marksz, final  String totalz,final String stn, final String stg, final  String st1 ,final  String st3 ,final  String st5 ,final  String sta, final String stb,
                             final String stz, final String marks, final String totale,
                              final String al1, final String al2, final String al3, final String al4, final String al5,
                              final String as1, final String as2, final String as3, final String as4, final String as5,
                              final String az1, final String az2, final String az3, final String az4, final String az5) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endspoint.updatedata_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("success")) {
                    Intent intent = new Intent(zlabgameg.this,zsubject.class);
                    intent.putExtra("uname", stn);
                    intent.putExtra("language", stl);
                    intent.putExtra("grade", stg);
                    intent.putExtra("value",st);
                    intent.putExtra("gid",st1);
                    intent.putExtra("SIDNAME",st2);
                    intent.putExtra("SID",st3);
                    intent.putExtra("SIDPDF",st0);
                    startActivity(intent);
                    finish();

                } else {
                    Intent intent = new Intent(zlabgameg.this,zsubject.class);
                    intent.putExtra("uname", stn);
                    intent.putExtra("language", stl);
                    intent.putExtra("grade", stg);
                    intent.putExtra("value",st);
                    intent.putExtra("gid",st1);
                    intent.putExtra("SIDNAME",st2);
                    intent.putExtra("SID",st3);
                    intent.putExtra("SIDPDF",st0);
                    startActivity(intent);
                    finish();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(zlabgameg.this, "Please check your Internet Connection", Toast.LENGTH_SHORT).show();
                Log.d("VOLLEY", error.getMessage());
                Intent intent = new Intent(zlabgameg.this,zsubject.class);
                intent.putExtra("uname", stn);
                intent.putExtra("language", stl);
                intent.putExtra("grade", stg);
                intent.putExtra("value",st);
                intent.putExtra("gid",st1);
                intent.putExtra("SIDNAME",st2);
                intent.putExtra("SID",st3);
                intent.putExtra("SIDPDF",st0);
                startActivity(intent);
                finish();

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
                params.put("cname", st4);

                params.put("al1", al1);
                params.put("al2", al2);
                params.put("al3", al3);
                params.put("al4", al4);
                params.put("al5", al5);

                params.put("as1", as1);
                params.put("as2", as2);
                params.put("as3", as3);
                params.put("as4", as4);
                params.put("as5", as5);

                params.put("az1", az1);
                params.put("az2", az2);
                params.put("az3", az3);
                params.put("az4", az4);
                params.put("az5", az5);


                return params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }


    private void addclasses3(final String stmarks, final String st1,final String st2, final String one,final String ststn,final String totale,final String marks,final String stn,final String st3,final String stg, final  String sta, final String stntt, final  String markstt,final String totaltt, final String nstntt, final  String nmarkstt,final String ntotaltt) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endspoint.updateusub_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("success")) {

                } else {

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("marks", marks);
                params.put("ststn", stntt);
                params.put("stmarks", markstt);
                params.put("sttotal", totaltt);

                params.put("nststn", nstntt);
                params.put("nstmarks", nmarkstt);
                params.put("nsttotal", ntotaltt);

                params.put("stg", stg);
                params.put("sta", sta);

                params.put("sname", st2);

                params.put("uname", stn);
                params.put("gid", st1);
                params.put("sid", st3);

                params.put("one", one);
                params.put("zero", ststn);
                params.put("total", totale);

                params.put("change", stmarks);



                return params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

}
