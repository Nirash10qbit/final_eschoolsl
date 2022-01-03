package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class zanlesson extends AppCompatActivity {

    String st,st0,st1,st2,st3,st8,st9,st10,st11,st12,st13,stn,stl,stg,nstg;
    TextView uname1,tv,tv0,tv1,tv2,tv3;
    ListView lv,lv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zanlesson);



        st = getIntent().getExtras().getString("value");
        st1 = getIntent().getExtras().getString("gid");
        stl = getIntent().getExtras().getString("language");
        stg = getIntent().getExtras().getString("grade");
        nstg = getIntent().getExtras().getString("analyse");
        st2 = getIntent().getExtras().getString("SIDNAME");
        st3 = getIntent().getExtras().getString("SID");

        stn = getIntent().getExtras().getString("uname");

        lv = findViewById(R.id.llist);
        lv2 = findViewById(R.id.usub);

//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
//
//
//                tv3 = view.findViewById(R.id.tvsid);
//                st3 = tv3.getText().toString();
//
//                tv2 = view.findViewById(R.id.tvsidname);
//                st2 = tv2.getText().toString();
//
//                tv0 = view.findViewById(R.id.tvsidpdf);
//                st0 = tv0.getText().toString();
//
//                getIntent().getExtras().getString("value");
//                getIntent().getExtras().getString("gid");
//
//
//                Intent intent = new Intent(getApplicationContext(),zanlesson.class);   //   Grade 6 / 7
//                intent.putExtra("uname", stn);
//                intent.putExtra("language", stl);
//                intent.putExtra("analyse", nstg);
//                intent.putExtra("grade", stg);
//                intent.putExtra("value",st);
//                intent.putExtra("gid",st1);
//                intent.putExtra("SIDNAME",st2);
//                intent.putExtra("SID",st3);
//
//                startActivity(intent);
//
//
//            }
//        });

    }

    public void back(View view){
            Intent intent = new Intent(getApplicationContext(), zanalyse.class);
                intent.putExtra("uname", stn);
                intent.putExtra("language", stl);
                intent.putExtra("analyse", nstg);
                intent.putExtra("grade", stg);
                intent.putExtra("value",st);
                intent.putExtra("gid",st1);

            startActivity(intent);

    }

    protected void onResume(){
        super.onResume();
        loadSession();
        loadSession1();
    }

    public void loadSession(){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://eschoolslgit1.000webhostapp.com/zanlesson.php?sid="+ st3 +"&&uname="+stn +"";

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
                        Toast.makeText(zanlesson.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
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

                map.put("gid",obj.getString("gid"));
                map.put("sid",obj.getString("sid"));
                map.put("cname",obj.getString("cname"));
                map.put("marks",obj.getString("marks"));

                list.add(map);
            }
            //1.layout file
            int layout= R.layout.zanless;
            //2.views
            int[] views = {R.id.tvgid, R.id.tvsid,R.id.tvcname, R.id.tvmarks};
            //3.Columms
            String[]  columns = {"gid","sid","cname","marks"};

            SimpleAdapter adapter = new SimpleAdapter(this, list, layout, columns, views);
            lv.setAdapter(adapter);
        }catch(Exception e){
            e.printStackTrace();
        }

    }


    public void loadSession1(){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://eschoolslgit1.000webhostapp.com/zanlessonsub.php?sid="+ st3 +"&&uname="+stn +"";

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
                        Toast.makeText(zanlesson.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
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

                map.put("sidname",obj.getString("sidname"));
                map.put("sttotal",obj.getString("sttotal"));

                list.add(map);
            }
            //1.layout file
            int layout= R.layout.zusub;
            //2.views
            int[] views = {R.id.tvusubs, R.id.tvusubm};
            //3.Columms
            String[]  columns = {"sidname","sttotal"};

            SimpleAdapter adapter = new SimpleAdapter(this, list, layout, columns, views);
            lv2.setAdapter(adapter);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}