package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.github.barteksc.pdfviewer.PDFView;

import org.json.JSONException;
import org.json.JSONObject;

public class zlabview extends AppCompatActivity {

    String st,st0,st1,st2,st3,st4,st5,st6,st30,stn,stl,stg,sta,stb,stz,stqa,stqb,stqc,stqd,stqe,staa,stab,stac,stad,stae,num,numm  ;
    TextView tv1,tv2,tva1;
    private WebView webView;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zlabview);

        stn = getIntent().getExtras().getString("uname");
        stl = getIntent().getExtras().getString("language");
        stg = getIntent().getExtras().getString("grade");

        tva1 =findViewById(R.id.tva1);


        st = getIntent().getExtras().getString("value");
        tv1 = findViewById(R.id.uname2);
        st1= getIntent().getExtras().getString("gid");
        tv1.setText(st1);
        st2 = getIntent().getExtras().getString("SIDNAME");
        st3 = getIntent().getExtras().getString("SID");
        st4 = getIntent().getExtras().getString("CIDNAME");
        tv2 = findViewById(R.id.gidnew2);
        st5 = getIntent().getExtras().getString("CID");
        tv2.setText(st5);
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



        webView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl(st6);
    }
    public void zbacklabview(View view){
        Intent intent = new Intent(this,zlabsub.class);
        intent.putExtra("uname", stn);
        intent.putExtra("language", stl);
        intent.putExtra("grade", stg);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        intent.putExtra("SIDNAME",st2);
        intent.putExtra("SID",st3);
        intent.putExtra("SIDPDF",st0);
        intent.putExtra("CID",st5);
        intent.putExtra("CIDNAME",st4);
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
        finish();
    }
    public void zgameview(View view){
        numm = tva1.getText().toString();
        int num1 = 1;
        num = tva1.getText().toString();
        int num2 = num.length();
        if(num1 == num2){
            Intent intent = new Intent(this, zlabviewsim.class);
            intent.putExtra("uname", stn);
            intent.putExtra("language", stl);
            intent.putExtra("grade", stg);
            intent.putExtra("value", st);
            intent.putExtra("gid", st1);
            intent.putExtra("SIDNAME", st2);
            intent.putExtra("SID", st3);
            intent.putExtra("SIDPDF", st0);
            intent.putExtra("CID", st5);
            intent.putExtra("CIDNAME", st4);
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
            intent.putExtra("numm", numm);

            startActivity(intent);
            finish();
        }
        else{
            Intent intent = new Intent(this, zlabmarks.class);
            intent.putExtra("uname", stn);
            intent.putExtra("language", stl);
            intent.putExtra("grade", stg);
            intent.putExtra("value", st);
            intent.putExtra("gid", st1);
            intent.putExtra("SIDNAME", st2);
            intent.putExtra("SID", st3);
            intent.putExtra("SIDPDF", st0);
            intent.putExtra("CID", st5);
            intent.putExtra("CIDNAME", st4);
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
            finish();
        }
    }

    protected void onResume(){
        super.onResume();
        loadSession();
    }
    public void loadSession() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/user.php?gid="+st1+"&&uname="+stn+"&&cid="+st5+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tva1.setText(response.getString("marks"));
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
        VolleySingleton.getInstance(zlabview.this).addToRequestQueue(jsonObjectRequest);
    }


}