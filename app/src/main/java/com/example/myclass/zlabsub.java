package com.example.myclass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
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

public class zlabsub extends AppCompatActivity {

    private static final int RERMISSION_STORAGE_CODE = 1000 ;
    String st,st0,st1,st2,st3,st4,st5,st6,st16,st17,st18,st20,stn,stl,stg,sta,stb,stz,stqa,stqb,stqc,stqd,stqe,staa,stab,stac,stad,stae;
    TextView uname1,tv,tv0,tv1,tv2,tv3,tv4,tv5,tv6,tv16,tv17,tv18,tv20,tva,tvb,tvz,tvqa,tvqb,tvqc,tvqd,tvqe,tvaa,tvab,tvac,tvad,tvae;

    ListView lv1,lv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zlabsub);


        tv1 = findViewById(R.id.uname1);
        stn = getIntent().getExtras().getString("uname");
        tv1.setText(stn);
        stl = getIntent().getExtras().getString("language");
        stg = getIntent().getExtras().getString("grade");

        Button dbtn = findViewById (R.id.downloadpdf);

        tv = findViewById(R.id.ltext);
        st = getIntent().getExtras().getString("value");
        tv.setText(st);
        st1= getIntent().getExtras().getString("gid");
        tv2 = findViewById(R.id.ltext2);
        st2 = getIntent().getExtras().getString("SIDNAME");
        tv2.setText(st2);
        st3 = getIntent().getExtras().getString("SID");
        tv0 = findViewById(R.id.ltext4);
        st0 = getIntent().getExtras().getString("SIDPDF");
        tv0.setText(st0);


        lv1 = findViewById(R.id.lv1);


        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                tva = view.findViewById(R.id.tvaid1);
                sta = tva.getText().toString();

                tvb = view.findViewById(R.id.tvbid1);
                stb = tvb.getText().toString();

                tvz = view.findViewById(R.id.tvzid1);
                stz = tvz.getText().toString();

                tv4 = view.findViewById(R.id.tvcid1);
                st4 = tv4.getText().toString();

                tv5 = view.findViewById(R.id.tvcidname);
                st5 = tv5.getText().toString();

                tv6 = view.findViewById(R.id.tvcidpdf);
                st6 = tv6.getText().toString();

                tvqa = view.findViewById(R.id.tvzqa1);
                stqa = tvqa.getText().toString();

                tvqb = view.findViewById(R.id.tvzqb1);
                stqb = tvqb.getText().toString();

                tvqc = view.findViewById(R.id.tvzqc1);
                stqc = tvqc.getText().toString();

                tvqd = view.findViewById(R.id.tvzqd1);
                stqd = tvqd.getText().toString();

                tvqe = view.findViewById(R.id.tvzqe1);
                stqe = tvqe.getText().toString();

                tvaa = view.findViewById(R.id.tvzaa1);
                staa = tvaa.getText().toString();

                tvab = view.findViewById(R.id.tvzab1);
                stab = tvab.getText().toString();

                tvac = view.findViewById(R.id.tvzac1);
                stac = tvac.getText().toString();

                tvad = view.findViewById(R.id.tvzad1);
                stad = tvad.getText().toString();

                tvae = view.findViewById(R.id.tvzae1);
                stae = tvae.getText().toString();

                getIntent().getExtras().getString("value");
                getIntent().getExtras().getString("gid");

                Intent intent = new Intent(zlabsub.this,zlabview.class);
                intent.putExtra("uname", stn);
                intent.putExtra("language", stl);
                intent.putExtra("grade", stg);
                intent.putExtra("value",st);
                intent.putExtra("gid",st1);
                intent.putExtra("SIDNAME",st2);
                intent.putExtra("SID",st3);
                intent.putExtra("SIDPDF",st0);
                intent.putExtra("CID",st4);
                intent.putExtra("CIDNAME",st5);
                intent.putExtra("CPDF",st6);
                intent.putExtra("aid",sta);
                intent.putExtra("bid",stb);
                intent.putExtra("zid",stz);
                intent.putExtra("zqa",stqa);
                intent.putExtra("zqb",stqb);
                intent.putExtra("zqc",stqc);
                intent.putExtra("zqd",stqd);
                intent.putExtra("zqe",stqe);
                intent.putExtra("zaa",staa);
                intent.putExtra("zab",stab);
                intent.putExtra("zac",stac);
                intent.putExtra("zad",stad);
                intent.putExtra("zae",stae);

                startActivity(intent);


            }
        });

        dbtn.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if(    checkSelfPermission (Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                            PackageManager.PERMISSION_DENIED){
                        String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        requestPermissions (permissions,  RERMISSION_STORAGE_CODE);

                    }else{
                        startDownloadig();

                    }
                }
                else{

                    startDownloadig();
                }
            }


        });

    }
    private void startDownloadig() {

        String url = tv0.getText ().toString ().trim ();
        DownloadManager.Request request = new DownloadManager.Request (Uri.parse (url));
        request.setAllowedNetworkTypes (DownloadManager.Request.NETWORK_WIFI |
                DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle ("Download");
        request.setDescription ("Downloading file.......");

        request.allowScanningByMediaScanner ();
        request.setNotificationVisibility (DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir (Environment.DIRECTORY_DOWNLOADS, ""+System.currentTimeMillis ());

        DownloadManager manager = (DownloadManager)getSystemService (Context.DOWNLOAD_SERVICE);
        manager.enqueue (request);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case RERMISSION_STORAGE_CODE:{
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    startDownloadig ();
                }
                else {
                    Toast.makeText (this, "Permission denied...",Toast.LENGTH_SHORT).show ();
                }

            }
        }
    }

    public void backalab(View view){
        Intent intent = new Intent(this,zsubject.class);
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

    protected void onResume(){
        super.onResume();
        loadSession1();
    }

    public void loadSession1(){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url1 = "https://eschoolslgit1.000webhostapp.com/simless.php?gid="+st1+"&&sid="+st3+"";

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
                        Toast.makeText(zlabsub.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
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
                map.put("aid",obj.getString("aid"));
                map.put("sid",obj.getString("sid"));
                map.put("bid",obj.getString("bid"));
                map.put("cid",obj.getString("cid"));
                map.put("zid",obj.getString("zid"));
                map.put("cidname",obj.getString("cidname"));
                map.put("cpdf",obj.getString("cpdf"));
                map.put("zqa",obj.getString("zqa"));
                map.put("zqb",obj.getString("zqb"));
                map.put("zqc",obj.getString("zqc"));
                map.put("zqd",obj.getString("zqd"));
                map.put("zqe",obj.getString("zqe"));
                map.put("zaa",obj.getString("zaa"));
                map.put("zab",obj.getString("zab"));
                map.put("zac",obj.getString("zac"));
                map.put("zad",obj.getString("zad"));
                map.put("zae",obj.getString("zae"));

                list.add(map);
            }
            //1.layout file
            int layout= R.layout.zsublab;
            //2.views
            int[] views = {R.id.tvgid1,R.id.tvaid1,R.id.tvsid1,R.id.tvbid1,R.id.tvcid1, R.id.tvzid1,R.id.tvcidname,R.id.tvcidpdf,R.id.tvzqa1,R.id.tvzqb1,R.id.tvzqc1,R.id.tvzqd1,R.id.tvzqe1,R.id.tvzaa1,R.id.tvzab1,R.id.tvzac1,R.id.tvzad1,R.id.tvzae1};
            //3.Columms
            String[]  columns = {"gid","aid","sid","bid","cid","zid","cidname","cpdf","zqa","zqb","zqc","zqd","zqe","zaa","zab","zac","zad","zae"};
            SimpleAdapter adapter = new SimpleAdapter(this, list, layout, columns, views);
            lv1.setAdapter(adapter);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}