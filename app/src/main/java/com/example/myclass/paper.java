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

public class paper extends AppCompatActivity {

    private static final int RERMISSION_STORAGE_CODE = 1000 ;
    String st,st0,st1,st2,st3,st4,st5,st6,st16,st20,stn,said,sbid,szid;
    PDFView pdfView;
    Button dbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paper);

        stn = getIntent().getExtras().getString("uname");
        said = getIntent().getExtras().getString("aid");
        sbid = getIntent().getExtras().getString("bid");
        szid = getIntent().getExtras().getString("zid");


        pdfView = findViewById(R.id.ppdfview);
        dbtn = findViewById (R.id.ddbtn);


        st = getIntent().getExtras().getString("value");
        st1= getIntent().getExtras().getString("gid");
        st2 = getIntent().getExtras().getString("SIDNAME");
        st3 = getIntent().getExtras().getString("SID");;
        st4 = getIntent().getExtras().getString("CIDNAME");
        st5 = getIntent().getExtras().getString("CID");
        st6 = getIntent().getExtras().getString("CPDF");
        st0 = getIntent().getExtras().getString("SIDPDF");
        st16 = getIntent().getExtras().getString("cact");
        st20 = getIntent().getExtras().getString("cvideo");


        new paper.Retrivepddf ().execute(st16);

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

        String url = st16;
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


    public void ppage(View view){
        Intent intent = new Intent (this, ppage.class);
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


    public void editsim(View view){
        Intent intent = new Intent (this, editnewsim.class);
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

}