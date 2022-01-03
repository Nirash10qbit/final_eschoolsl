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

public class zsubject extends AppCompatActivity {

    String st,st0,st1,st2,st3,st8,st9,st10,st11,st12,st13,stn,stl,stg;
    TextView uname1,tv,tv0,tv1,tv2,tv3;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zsubject);

        st8 = "6";
        st9 = "001";
        st10 = "10";

        tv = findViewById(R.id.subjectv);
        tv1 = findViewById(R.id.ltext2);
        st = getIntent().getExtras().getString("value");
        st1 = getIntent().getExtras().getString("gid");
        stl = getIntent().getExtras().getString("language");
        stg = getIntent().getExtras().getString("grade");
        tv.setText(st);
        tv1.setText(st1);

        uname1 = findViewById(R.id.uname1);
        stn = getIntent().getExtras().getString("uname");
        uname1.setText(stn);
        lv = findViewById(R.id.llist);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {


                tv3 = view.findViewById(R.id.tvsid);
                st3 = tv3.getText().toString();

                tv2 = view.findViewById(R.id.tvsidname);
                st2 = tv2.getText().toString();

                tv0 = view.findViewById(R.id.tvsidpdf);
                st0 = tv0.getText().toString();

                getIntent().getExtras().getString("value");
                getIntent().getExtras().getString("gid");

                int leone = st8.length ();
                int lezero = st9.length ();
                int letwo = st1.length ();

                if(leone == letwo){

                    Intent intent = new Intent(getApplicationContext(),zlesson.class);   //   Grade 6 / 7
                    intent.putExtra("uname", stn);
                    intent.putExtra("language", stl);
                    intent.putExtra("grade", stg);
                    intent.putExtra("value",st);
                    intent.putExtra("gid",st1);
                    intent.putExtra("SIDNAME",st2);
                    intent.putExtra("SID",st3);
                    intent.putExtra("SIDPDF",st0);

                    startActivity(intent);

                }
                else if(lezero == letwo){

                    Intent intent = new Intent(getApplicationContext(),zvlesson.class);   //   Grade 1 / 2 / 3 / 4 / 5
                    intent.putExtra("uname", stn);
                    intent.putExtra("language", stl);
                    intent.putExtra("grade", stg);
                    intent.putExtra("value",st);
                    intent.putExtra("gid",st1);
                    intent.putExtra("SIDNAME",st2);
                    intent.putExtra("SID",st3);
                    intent.putExtra("SIDPDF",st0);

                    startActivity(intent);
                }
                else {
                    int act = st10.length ();
                    int pdf = st0.length ();
                    if(act == pdf){
                        Intent intent = new Intent(getApplicationContext(),zlab.class);   //   Grade  08 / 09 / 10 / 11 /12
                        intent.putExtra("uname", stn);
                        intent.putExtra("language", stl);
                        intent.putExtra("grade", stg);
                        intent.putExtra("value",st);
                        intent.putExtra("gid",st1);
                        intent.putExtra("SIDNAME",st2);
                        intent.putExtra("SID",st3);
                        intent.putExtra("SIDPDF",st0);

                        startActivity(intent);
                    }
                    else{
                        Intent intent = new Intent(getApplicationContext(),zplesson.class);   //   Grade  08 / 09 / 10 / 11 /12
                        intent.putExtra("uname", stn);
                        intent.putExtra("language", stl);
                        intent.putExtra("grade", stg);
                        intent.putExtra("value",st);
                        intent.putExtra("gid",st1);
                        intent.putExtra("SIDNAME",st2);
                        intent.putExtra("SID",st3);
                        intent.putExtra("SIDPDF",st0);

                        startActivity(intent);
                    }


                }
            }
        });


    }

    public void back(View view){
        st11 = "sin";
        st12 = "en";
        int leone = st11.length();
        int lezero = st12.length();
        int letwo = stl.length();

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

    protected void onResume(){
        super.onResume();
        loadSession();
    }

    public void loadSession(){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://eschoolslgit1.000webhostapp.com/subject.php?gid="+st1+"";

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
                        Toast.makeText(zsubject.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
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
                map.put("sidname",obj.getString("sidname"));
                map.put("sidpdf",obj.getString("sidpdf"));

                list.add(map);
            }
            //1.layout file
            int layout= R.layout.zsub;
            //2.views
            int[] views = {R.id.tvgid, R.id.tvsid,R.id.tvsidpdf, R.id.tvsidname};
            //3.Columms
            String[]  columns = {"gid","sid","sidpdf","sidname"};

            SimpleAdapter adapter = new SimpleAdapter(this, list, layout, columns, views);
            lv.setAdapter(adapter);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}