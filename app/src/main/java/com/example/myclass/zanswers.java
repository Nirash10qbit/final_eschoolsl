package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

public class zanswers extends AppCompatActivity {

    String st,st0,st1,st2,st3,st4,st5,st6,st7,st8,st9,st10,st16,st17,st18,stn,stl,stg,ca,cb,cc,totalc,ra,rb,rc;
    TextView uname1,tv,tv0,tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10,tv11,tv12,tv13,tv14,tv15,tv16,tv17,tv18,tv21;
    ListView lvza,lvzb,lvzc,lvzd,lvze,lvzf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zanswers);

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

        st16 = getIntent().getExtras().getString("qa");
        st17 = getIntent().getExtras().getString("qb");
        st18 = getIntent().getExtras().getString("qc");

        ra = getIntent().getExtras().getString("ra");
        rb = getIntent().getExtras().getString("rb");
        rc = getIntent().getExtras().getString("rc");

        ca = getIntent().getExtras().getString("ca");
        cb = getIntent().getExtras().getString("cb");
        cc = getIntent().getExtras().getString("cc");

        tv16 = findViewById(R.id.q1);
        tv16.setText(st16);

        tv17 = findViewById(R.id.q2);
        tv17.setText(st17);

        tv18 = findViewById(R.id.q3);
        tv18.setText(st18);


        totalc = getIntent().getExtras().getString("totalc");


        lvza = findViewById(R.id.lvza);
        lvzb = findViewById(R.id.lvzb);
        lvzc = findViewById(R.id.lvzc);
        lvzd = findViewById(R.id.lvzd);
        lvze = findViewById(R.id.lvze);
        lvzf = findViewById(R.id.lvzf);

    }

    protected void onResume(){
        super.onResume();

        int leone = ra.length ();
        int lethree = rb.length ();
        int lefour = rc.length ();
        int letwo = st10.length ();

        if(leone >= letwo) {

            if (leone == letwo) {
                loadSession1();
                loadSession2();
            } else {
                loadSession3();
            }
        }

        if(lethree >= letwo) {

            if (lethree == letwo) {
                loadSession4();
                loadSession5();
            } else {
                loadSession6();
            }
        }

        if(lefour >= letwo) {

            if (lefour == letwo) {
                loadSession7();
                loadSession8();
            } else {
                loadSession9();
            }
        }
    }


    public void loadSession1(){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://eschoolslgit1.000webhostapp.com/ga.php?gid="+st1+"&&cid="+st5+"&&ca="+ca+"";


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
                        Toast.makeText(zanswers.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
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

                map.put("ana",obj.getString("ana"));

                list.add(map);
            }
            //1.layout file
            int layout= R.layout.gyou;
            //2.views
            int[] views = {R.id.tvyou};
            //3.Columms
            String[]  columns = {"ana"};

            SimpleAdapter adapter = new SimpleAdapter(this, list, layout, columns, views);
            lvza.setAdapter(adapter);
        }catch(Exception e){
            e.printStackTrace();
        }

    }


    public void loadSession2(){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://eschoolslgit1.000webhostapp.com/aa.php?gid="+st1+"&&cid="+st5+"";

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
                        Toast.makeText(zanswers.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
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

                map.put("ana",obj.getString("ana"));

                list.add(map);
            }
            //1.layout file
            int layout= R.layout.gcorr;
            //2.views
            int[] views = {R.id.tvcorr};
            //3.Columms
            String[]  columns = {"ana"};

            SimpleAdapter adapter = new SimpleAdapter(this, list, layout, columns, views);
            lvzb.setAdapter(adapter);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void loadSession3(){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://eschoolslgit1.000webhostapp.com/ga.php?gid="+st1+"&&cid="+st5+"&&ca="+ca+"";

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
                        Toast.makeText(zanswers.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
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

                map.put("ana",obj.getString("ana"));

                list.add(map);
            }
            //1.layout file
            int layout= R.layout.gycorr;
            //2.views
            int[] views = {R.id.tvyourcorr};
            //3.Columms
            String[]  columns = {"ana"};

            SimpleAdapter adapter = new SimpleAdapter(this, list, layout, columns, views);
            lvza.setAdapter(adapter);
        }catch(Exception e){
            e.printStackTrace();
        }

    }




    public void loadSession4(){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://eschoolslgit1.000webhostapp.com/gb.php?gid="+st1+"&&cid="+st5+"&&cb="+cb+"";


        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        setSessions4(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(zanswers.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
                        Log.d("VOLLEY", error.getMessage());
                    }
                });

        queue.add(request);
    }
    public void setSessions4(JSONArray response){
        List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try{
            for(int i=0;i <response.length()  ;i++){
                JSONObject obj = response.getJSONObject(i);
                HashMap<String, String> map = new HashMap<>();

                map.put("anb",obj.getString("anb"));

                list.add(map);
            }
            //1.layout file
            int layout= R.layout.gyou;
            //2.views
            int[] views = {R.id.tvyou};
            //3.Columms
            String[]  columns = {"anb"};

            SimpleAdapter adapter = new SimpleAdapter(this, list, layout, columns, views);
            lvzc.setAdapter(adapter);
        }catch(Exception e){
            e.printStackTrace();
        }

    }


    public void loadSession5(){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://eschoolslgit1.000webhostapp.com/ab.php?gid="+st1+"&&cid="+st5+"";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        setSessions5(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(zanswers.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
                        Log.d("VOLLEY", error.getMessage());
                    }
                });

        queue.add(request);
    }
    public void setSessions5(JSONArray response){
        List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try{
            for(int i=0;i <response.length()  ;i++){
                JSONObject obj = response.getJSONObject(i);
                HashMap<String, String> map = new HashMap<>();

                map.put("anb",obj.getString("anb"));

                list.add(map);
            }
            //1.layout file
            int layout= R.layout.gcorr;
            //2.views
            int[] views = {R.id.tvcorr};
            //3.Columms
            String[]  columns = {"anb"};

            SimpleAdapter adapter = new SimpleAdapter(this, list, layout, columns, views);
            lvzd.setAdapter(adapter);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void loadSession6(){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://eschoolslgit1.000webhostapp.com/gb.php?gid="+st1+"&&cid="+st5+"&&cb="+cb+"";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        setSessions6(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(zanswers.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
                        Log.d("VOLLEY", error.getMessage());
                    }
                });

        queue.add(request);
    }
    public void setSessions6(JSONArray response){
        List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try{
            for(int i=0;i <response.length()  ;i++){
                JSONObject obj = response.getJSONObject(i);
                HashMap<String, String> map = new HashMap<>();

                map.put("anb",obj.getString("anb"));

                list.add(map);
            }
            //1.layout file
            int layout= R.layout.gycorr;
            //2.views
            int[] views = {R.id.tvyourcorr};
            //3.Columms
            String[]  columns = {"anb"};

            SimpleAdapter adapter = new SimpleAdapter(this, list, layout, columns, views);
            lvzc.setAdapter(adapter);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void loadSession7(){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://eschoolslgit1.000webhostapp.com/gc.php?gid="+st1+"&&cid="+st5+"&&cc="+cc+"";


        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        setSessions7(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(zanswers.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
                        Log.d("VOLLEY", error.getMessage());
                    }
                });

        queue.add(request);
    }
    public void setSessions7(JSONArray response){
        List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try{
            for(int i=0;i <response.length()  ;i++){
                JSONObject obj = response.getJSONObject(i);
                HashMap<String, String> map = new HashMap<>();

                map.put("anc",obj.getString("anc"));

                list.add(map);
            }
            //1.layout file
            int layout= R.layout.gyou;
            //2.views
            int[] views = {R.id.tvyou};
            //3.Columms
            String[]  columns = {"anc"};

            SimpleAdapter adapter = new SimpleAdapter(this, list, layout, columns, views);
            lvze.setAdapter(adapter);
        }catch(Exception e){
            e.printStackTrace();
        }

    }


    public void loadSession8(){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://eschoolslgit1.000webhostapp.com/ab.php?gid="+st1+"&&cid="+st5+"";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        setSessions8(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Log.d("VOLLEY", error.getMessage());
                    }
                });

        queue.add(request);
    }
    public void setSessions8(JSONArray response){
        List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try{
            for(int i=0;i <response.length()  ;i++){
                JSONObject obj = response.getJSONObject(i);
                HashMap<String, String> map = new HashMap<>();

                map.put("anc",obj.getString("anc"));

                list.add(map);
            }
            //1.layout file
            int layout= R.layout.gcorr;
            //2.views
            int[] views = {R.id.tvcorr};
            //3.Columms
            String[]  columns = {"anc"};

            SimpleAdapter adapter = new SimpleAdapter(this, list, layout, columns, views);
            lvzf.setAdapter(adapter);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void loadSession9(){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://eschoolslgit1.000webhostapp.com/gc.php?gid="+st1+"&&cid="+st5+"&&cc="+cc+"";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        setSessions9(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(zanswers.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
                        Log.d("VOLLEY", error.getMessage());
                    }
                });

        queue.add(request);
    }
    public void setSessions9(JSONArray response){
        List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try{
            for(int i=0;i <response.length()  ;i++){
                JSONObject obj = response.getJSONObject(i);
                HashMap<String, String> map = new HashMap<>();

                map.put("anc",obj.getString("anc"));

                list.add(map);
            }
            //1.layout file
            int layout= R.layout.gycorr;
            //2.views
            int[] views = {R.id.tvyourcorr};
            //3.Columms
            String[]  columns = {"anc"};

            SimpleAdapter adapter = new SimpleAdapter(this, list, layout, columns, views);
            lvze.setAdapter(adapter);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void back(View view){
        Intent intent = new Intent(getApplicationContext(),zlesson.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        intent.putExtra("SID",st3);
        intent.putExtra("SIDNAME",st2);
        intent.putExtra("SIDPDF",st0);
        startActivity(intent);

    }

}
