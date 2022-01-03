package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class zlabgamezb extends AppCompatActivity {

    private String st,st0,st1,st2,st3,st4,st5,st6,st8,st9,st10,ca,cb,cc,cd,ce,stn,stl,stg,sta,stb,stz,stqa,stqb,stqc,stqd,stqe,staa,stab,stac,stad,stae,total,ra,rb,rc,rd,re,sac,saw;
    TextView tv1,tv2;
    ImageView imageView1;
    ListView lv,lv2,lv3;
    Button help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zlabgamezb);

        help=(Button) findViewById(R.id.help);

        st10="0";

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


        lv = findViewById(R.id.zgamelist);
        lv2 = findViewById(R.id.you);
        lv3 = findViewById(R.id.corr);

    }

    protected void onResume(){
        super.onResume();

        stqb = getIntent().getExtras().getString("zqb");
        imageView1 = findViewById(R.id.image1);
        String url1 = stqb;
        Picasso.with(this).load(url1).into(imageView1);

        loadSession();
        int leone = rb.length ();
        int letwo = st10.length ();

        tv2 = findViewById(R.id.heading);
        sac = "your answer is correct";
        saw = "your answer is wrong";

        if(leone == letwo) {
            help.setVisibility(View.VISIBLE);
            loadSession1();
            loadSession2();
            tv2.setText(saw);
        }
        else{
            loadSession3();
            tv2.setText(sac);
        }
    }

    public void loadSession(){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://eschoolslgit1.000webhostapp.com/simgame.php?gid="+st1+"&&cid="+st5+"";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        setSessions(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(zlabgamezb.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
                        Log.d("VOLLEY", error.getMessage());
                    }
                });

        queue.add(request);
    }
    public void setSessions(JSONArray response){
        List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try{
            for(int i=0;i <response.length()  ;i++){
                JSONObject obj = response.getJSONObject(i);
                HashMap<String, String> map = new HashMap<>();

                map.put("nna",obj.getString("nna"));
                map.put("nb",obj.getString("nb"));
                map.put("anb",obj.getString("anb"));

                list.add(map);
            }
            //1.layout file
            int layout= R.layout.gam;
            //2.views
            int[] views = {R.id.tvnn,R.id.tvn,R.id.tvan};
            //3.Columms
            String[]  columns = {"nna","nb","anb"};

            SimpleAdapter adapter = new SimpleAdapter(this, list, layout, columns, views);
            lv.setAdapter(adapter);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void loadSession1(){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://eschoolslgit1.000webhostapp.com/cb.php?gid="+st1+"&&sid="+st3+"&&cid="+st5+"&&cb="+cb+"";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        setSessions1(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(zlabgamezb.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
                        Log.d("VOLLEY", error.getMessage());
                    }
                });

        queue.add(request);
    }
    public void setSessions1(JSONArray response){
        List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try{
            for(int i=0;i <response.length()  ;i++){
                JSONObject obj = response.getJSONObject(i);
                HashMap<String, String> map = new HashMap<>();

                map.put("anb",obj.getString("anb"));

                list.add(map);
            }
            //1.layout file
            int layout= R.layout.your;
            //2.views
            int[] views = {R.id.tvyou};
            //3.Columms
            String[]  columns = {"anb"};

            SimpleAdapter adapter = new SimpleAdapter(this, list, layout, columns, views);
            lv2.setAdapter(adapter);
        }catch(Exception e){
            e.printStackTrace();
        }

    }


    public void loadSession2(){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://eschoolslgit1.000webhostapp.com/nb.php?gid="+st1+"&&sid="+st3+"&&cid="+st5+"";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        setSessions2(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(zlabgamezb.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
                        Log.d("VOLLEY", error.getMessage());
                    }
                });

        queue.add(request);
    }
    public void setSessions2(JSONArray response){
        List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try{
            for(int i=0;i <response.length()  ;i++){
                JSONObject obj = response.getJSONObject(i);
                HashMap<String, String> map = new HashMap<>();

                map.put("anb",obj.getString("anb"));

                list.add(map);
            }
            //1.layout file
            int layout= R.layout.correct;
            //2.views
            int[] views = {R.id.tvcorr};
            //3.Columms
            String[]  columns = {"anb"};

            SimpleAdapter adapter = new SimpleAdapter(this, list, layout, columns, views);
            lv3.setAdapter(adapter);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void loadSession3(){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://eschoolslgit1.000webhostapp.com/cb.php?gid="+st1+"&&sid="+st3+"&&cid="+st5+"&&cb="+cb+"";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        setSessions3(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(zlabgamezb.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
                        Log.d("VOLLEY", error.getMessage());
                    }
                });

        queue.add(request);
    }
    public void setSessions3(JSONArray response){
        List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try{
            for(int i=0;i <response.length()  ;i++){
                JSONObject obj = response.getJSONObject(i);
                HashMap<String, String> map = new HashMap<>();

                map.put("anb",obj.getString("anb"));

                list.add(map);
            }
            //1.layout file
            int layout= R.layout.yourcorr;
            //2.views
            int[] views = {R.id.tvyourcorr};
            //3.Columms
            String[]  columns = {"anb"};

            SimpleAdapter adapter = new SimpleAdapter(this, list, layout, columns, views);
            lv2.setAdapter(adapter);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public void zaa(View view){
        Intent intent = new Intent(this,zlabgameab.class);
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
        finish();
    }

    public void zgb(View view){
        Intent intent = new Intent(this,zlabgamezc.class);
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
        finish();
    }

}
