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
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.github.barteksc.pdfviewer.PDFView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ppage extends AppCompatActivity {

    private static final int RERMISSION_STORAGE_CODE = 1000 ;
    String st,st0,st1,st2,st3,st4,st5,st6,st16,st20,st31,stn,said,sbid,szid,stva1,stva2;
    TextView tv,tv0,tv1,tv2,tv3,tv4,tv5,tv6,tv16,tv20,tva1,tva2;
    PDFView pdfView;
    Button dbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ppage);
        stn = getIntent().getExtras().getString("uname");
        tv = findViewById(R.id.ltext5);
        said = getIntent().getExtras().getString("aid");
        tv.setText(said);
        tv2 = findViewById(R.id.ltext7);
        sbid = getIntent().getExtras().getString("bid");
        tv2.setText(sbid);

        tv20 = findViewById(R.id.ltext20);
        szid = getIntent().getExtras().getString("zid");
        tv20.setText(szid);

        final ProgressBar progressBar = findViewById(R.id.progressBar1);
        progressBar.setVisibility(View.VISIBLE);

        pdfView = findViewById(R.id.pdfview);
        dbtn = findViewById (R.id.downloadpdf);


        st = getIntent().getExtras().getString("value");

        tv1 = findViewById(R.id.ltext6);
        st1= getIntent().getExtras().getString("gid");
        tv1.setText(st1);

        st2 = getIntent().getExtras().getString("SIDNAME");

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
        st16 = getIntent().getExtras().getString("cact");
        tv16.setText(st16);
        st20 = getIntent().getExtras().getString("cvideo");



        tva1 =findViewById(R.id.asub);
        tva2 =findViewById(R.id.aact);

        new ppage.Retrivepddf ().execute(st6);

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



    public void editpless(View view){
        Intent intent = new Intent(getApplicationContext(),editplesson.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        intent.putExtra("SIDNAME",st2);
        intent.putExtra("SID",st3);
        intent.putExtra("CIDNAME",st4);
        intent.putExtra("CID",st5);
        intent.putExtra("CPDF",st6);
        intent.putExtra("SIDPDF",st0);
        intent.putExtra("cact",st16);
        intent.putExtra("aid",said);
        intent.putExtra("bid",sbid);
        startActivity(intent);
    }

    public void dcpless(View view){
        AlertDialog.Builder builder =  new AlertDialog.Builder(ppage.this);

        builder.setMessage("Are you sure? Do you want to delete this Lesson, ");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                st5 = getIntent().getExtras().getString("CID");

                RequestQueue queue = Volley.newRequestQueue(ppage.this);
                String url1 = "https://eschoolslgit1.000webhostapp.com/deletepless.php?cid="+st5+"";

                JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url1, null,

                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                Toast.makeText(ppage.this, "Delete Lesson", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(ppage.this,plesson.class);
                                intent.putExtra("uname", stn);
                                intent.putExtra("value",st);
                                intent.putExtra("gid",st1);
                                intent.putExtra("SIDNAME",st2);
                                intent.putExtra("SID",st3);
                                intent.putExtra("SIDPDF",st0);
                                intent.putExtra("aid",said);
                                intent.putExtra("bid",sbid);
                                startActivity(intent);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                error.printStackTrace();
                                Toast.makeText(ppage.this, "Delete Lesson", Toast.LENGTH_SHORT).show();
                                Log.d("VOLLEY", error.getMessage());

                                Intent intent = new Intent(ppage.this,plesson.class);
                                intent.putExtra("uname", stn);
                                intent.putExtra("value",st);
                                intent.putExtra("gid",st1);
                                intent.putExtra("SIDNAME",st2);
                                intent.putExtra("SID",st3);
                                intent.putExtra("SIDPDF",st0);
                                intent.putExtra("aid",said);
                                intent.putExtra("bid",sbid);
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

    private void startDownloadig() {

        // String url = tv6.getText ().toString ().trim ();
        String url = st6;
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


    class Retrivepddf extends AsyncTask<String,Void, InputStream> {


        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream = null;

            try{
                URL url = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
                if(urlConnection.getResponseCode()==200){
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }
            }
            catch (IOException e){
                return null;

            }
            return inputStream;

        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            pdfView.fromStream(inputStream).load();
        }
    }

    protected void onResume(){
        super.onResume();
        loadSession1();
    }

    public void loadSession1(){


        JsonObjectRequest jsonObjectRequest2 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/getlabsub.php?aid="+said+"&&bid="+sbid+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tva1.setText(response.getString("btotal"));
                        } catch (JSONException e){
                            e.printStackTrace();;
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tva1.setText("2000");
                error.printStackTrace();
            }
        });


        VolleySingleton.getInstance(ppage.this).addToRequestQueue(jsonObjectRequest2)   ;

        JsonObjectRequest jsonObjectRequest3 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/getlabact.php?aid="+said+"&&bid="+sbid+"&&zid="+szid+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tva2.setText(response.getString("ztotal"));
                        } catch (JSONException e){
                            e.printStackTrace();;
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tva2.setText("2000");
                error.printStackTrace();
            }
        });


        VolleySingleton.getInstance(ppage.this).addToRequestQueue(jsonObjectRequest3);

    }

    public void ppaper(View view){
        Intent intent = new Intent (this,paper.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        intent.putExtra("SID",st3);
        intent.putExtra("SIDNAME",st2);
        intent.putExtra("SIDPDF",st0);
        intent.putExtra("CIDNAME",st4);
        intent.putExtra("CID",st5);
        intent.putExtra("CPDF",st6);
        intent.putExtra("cact",st16);
        intent.putExtra("cvideo",st20);
        intent.putExtra("aid",said);
        intent.putExtra("bid",sbid);
        intent.putExtra("zid",szid);
        startActivity (intent);

    }

    public void addsim(View view){
        stva1 = tva1.getText().toString();
        stva2 = tva2.getText().toString();
        Intent intent = new Intent (this, addnewsim.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        intent.putExtra("SID",st3);
        intent.putExtra("SIDNAME",st2);
        intent.putExtra("SIDPDF",st0);
        intent.putExtra("CIDNAME",st4);
        intent.putExtra("CID",st5);
        intent.putExtra("CPDF",st6);
        intent.putExtra("cact",st16);
        intent.putExtra("cvideo",st20);
        intent.putExtra("aid",said);
        intent.putExtra("bid",sbid);
        intent.putExtra("zid",szid);
        intent.putExtra("asub", stva1);
        intent.putExtra("aact", stva2);
        startActivity (intent);

    }


    public void backplesson(View view){
        Intent intent = new Intent (this, plesson.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        intent.putExtra("SID",st3);
        intent.putExtra("SIDNAME",st2);
        intent.putExtra("SIDPDF",st0);
        intent.putExtra("aid",said);
        intent.putExtra("bid",sbid);
        startActivity (intent);

    }


}