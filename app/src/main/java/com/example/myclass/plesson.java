package com.example.myclass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
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
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class plesson extends AppCompatActivity {

    private static final int RERMISSION_STORAGE_CODE = 1000 ;
    String st,st0,st1,st2,st3,st4,st5,st6,st16,st20,stn,said,sbid,szid;
    TextView tv,tv0,tv1,tv2,tv3,tv4,tv5,tv6,tv16,tv17,tv20;

    ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plesson);
        stn = getIntent().getExtras().getString("uname");
        said = getIntent().getExtras().getString("aid");
        tv0 = findViewById(R.id.ltext4);
        sbid = getIntent().getExtras().getString("bid");
        tv0.setText(sbid);


        tv = findViewById(R.id.ltext);
        st = getIntent().getExtras().getString("value");
        tv.setText(st);
        tv1 = findViewById(R.id.ltext1);
        st1 = getIntent().getExtras().getString("gid");
        tv1.setText(st1);
        tv2 = findViewById(R.id.ltext2);
        st2 = getIntent().getExtras().getString("SIDNAME");
        tv2.setText(st2);
        tv3 = findViewById(R.id.ltext3);
        st3 = getIntent().getExtras().getString("SID");
        tv3.setText(st3);

        st0 = getIntent().getExtras().getString("SIDPDF");



        lv1 = findViewById(R.id.lv1);


        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                tv4 = view.findViewById(R.id.tvcid);
                st5 = tv4.getText().toString();

                tv17 = view.findViewById(R.id.tvzid);
                szid = tv17.getText().toString();

                tv5 = view.findViewById(R.id.tvcidname);
                st4 = tv5.getText().toString();

                tv6 = view.findViewById(R.id.tvcidpdf);
                st6 = tv6.getText().toString();

                tv16 = view.findViewById(R.id.tvcidact);
                st16 = tv16.getText().toString();

                tv20 = view.findViewById(R.id.tvcvideo);
                st20 = tv20.getText().toString();


                getIntent().getExtras().getString("value");
                getIntent().getExtras().getString("gid");

                Intent intent = new Intent(getApplicationContext(), ppage.class);
                intent.putExtra("uname", stn);
                intent.putExtra("value", st);
                intent.putExtra("gid", st1);
                intent.putExtra("SIDNAME", st2);
                intent.putExtra("SID", st3);
                intent.putExtra("SIDPDF", st0);
                intent.putExtra("CID", st5);
                intent.putExtra("CIDNAME", st4);
                intent.putExtra("CPDF", st6);
                intent.putExtra("cact", st16);
                intent.putExtra("cvideo", st20);
                intent.putExtra("aid",said);
                intent.putExtra("bid",sbid);
                intent.putExtra("zid",szid);
                startActivity(intent);
            }
        });


    }
    public void backa(View view){
        getIntent().getExtras().getString("value");
        getIntent().getExtras().getString("gid");
        Intent intent = new Intent(getApplicationContext(),subject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        intent.putExtra("aid",said);
        startActivity(intent);
    }

    public void addplessonn(View view){
        getIntent().getExtras().getString("value");
        getIntent().getExtras().getString("gid");
        getIntent().getExtras().getString("sid");
        getIntent().getExtras().getString("sidname");
        Intent intent = new Intent(getApplicationContext(),addplesson.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        intent.putExtra("sidname",st2);
        intent.putExtra("sid",st3);
        intent.putExtra("aid",said);
        intent.putExtra("bid",sbid);
        startActivity(intent);
    }
    public void editsub(View view){
        getIntent().getExtras().getString("value");
        getIntent().getExtras().getString("gid");
        getIntent().getExtras().getString("sid");
        getIntent().getExtras().getString("sidname");
        Intent intent = new Intent(getApplicationContext(),editsub.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        intent.putExtra("SIDNAME",st2);
        intent.putExtra("SID",st3);
        intent.putExtra("aid",said);
        intent.putExtra("bid",sbid);
        startActivity(intent);
    }


    public void dcsub(View view){
        AlertDialog.Builder builder =  new AlertDialog.Builder(plesson.this);

        builder.setMessage("Are you sure? Do you want to delete this subject, ");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                st3 = getIntent().getExtras().getString("SID");

                RequestQueue queue = Volley.newRequestQueue(plesson.this);
                String url = "https://eschoolslgit1.000webhostapp.com/deletesub.php?sid="+st3+"";

                JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,

                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                Toast.makeText(plesson.this, "Delete Subject", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(plesson.this,subject.class);
                                intent.putExtra("uname", stn);
                                intent.putExtra("value",st);
                                intent.putExtra("gid",st1);
                                intent.putExtra("aid",said);
                                startActivity(intent);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                error.printStackTrace();
                                Toast.makeText(plesson.this, "Delete Subject", Toast.LENGTH_SHORT).show();
                                Log.d("VOLLEY", error.getMessage());

                                Intent intent = new Intent(plesson.this,subject.class);
                                intent.putExtra("uname", stn);
                                intent.putExtra("value",st);
                                intent.putExtra("gid",st1);
                                intent.putExtra("aid",said);
                                startActivity(intent);

                            }
                        });

                queue.add(request);
            }
        });
        builder.setNegativeButton("No", null);

        AlertDialog alert = builder.create();
        alert.show();
    }

    protected void onResume(){
        super.onResume();
        loadSession1();
    }

    public void loadSession1(){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url1 = "https://eschoolslgit1.000webhostapp.com/less.php?gid="+st1+"&&sid="+st3+"";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url1, null,

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

                map.put("gid",obj.getString("gid"));
                map.put("sid",obj.getString("sid"));
                map.put("cid",obj.getString("cid"));
                map.put("zid",obj.getString("zid"));
                map.put("cidname",obj.getString("cidname"));
                map.put("cact",obj.getString("cact"));
                map.put("cpdf",obj.getString("cpdf"));
                map.put("cvideo",obj.getString("cvideo"));

                list.add(map);
            }
            //1.layout file
            int layout= R.layout.pless;
            //2.views
            int[] views = {R.id.tvgid1,R.id.tvsid1, R.id.tvcid,R.id.tvzid,R.id.tvcidname,R.id.tvcidact, R.id.tvcidpdf, R.id.tvcvideo};
            //3.Columms
            String[]  columns = {"gid","sid","cid","zid","cidname","cact","cpdf","cvideo"};

            SimpleAdapter adapter = new SimpleAdapter(this, list, layout, columns, views);
            lv1.setAdapter(adapter);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}

