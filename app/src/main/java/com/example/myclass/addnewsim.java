package com.example.myclass;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class addnewsim extends AppCompatActivity {

    TextView tv1,tv2;
    ProgressBar progressBaradd;

    Button etadd;
    EditText etsim,etname,ettest,etless;
    String st,st0,st1,st2,st3,st4,st5,st6,st16,st20,stn,said,sbid,szid,asub,aact;
    private static final String url="https://eschoolslgit1.000webhostapp.com/fileupload.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnewsim);


        stn = getIntent().getExtras().getString("uname");

        progressBaradd = findViewById(R.id.progressBaradd);
        progressBaradd.setVisibility(View.INVISIBLE);

        etadd = findViewById(R.id.simadd);


        said = getIntent().getExtras().getString("aid");
        sbid = getIntent().getExtras().getString("bid");
        szid = getIntent().getExtras().getString("zid");

        asub = getIntent().getExtras().getString("asub");
        aact = getIntent().getExtras().getString("aact");

        st = getIntent().getExtras().getString("value");
        st1= getIntent().getExtras().getString("gid");

        st2 = getIntent().getExtras().getString("SIDNAME");
        st3 = getIntent().getExtras().getString("SID");

        st5 = getIntent().getExtras().getString("CID");
        st6 = getIntent().getExtras().getString("CPDF");
        st0 = getIntent().getExtras().getString("SIDPDF");
        st16 = getIntent().getExtras().getString("cact");
        st20 = getIntent().getExtras().getString("cvideo");
        st4 = getIntent().getExtras().getString("CIDNAME");

        etless = findViewById(R.id.less);
        etsim = findViewById(R.id.simlink);
        etname = findViewById(R.id.simname);
        ettest = findViewById(R.id.lname);


        etadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String aasub = asub;
                String aaact = aact;

                String gid = st1;
                String sid = st3;
                String cid = st5;
                String aid = said;
                String bid = sbid;
                String zid = szid;

                String cname = st4;


                String nna = "0";
                String sub1 = "BUDDHIST";
                String sub2 = "SCIENCE";
                String sub3 = "MATHS";
                String sub4 = "SINHALA";
                String sub5 = "HISTORY";
                String sub6 = "ENGLISH";
                String sub7 = "TAMIL";


                String sim = etsim.getText().toString();
                String name = etname.getText().toString();
                String test = ettest.getText().toString();


                String zqa = "https://nirash10qbit.github.io/newset/pages/" + etname.getText().toString() ;

                String zzz = "https://eschoolslgit1.000webhostapp.com/sets/pages/" + etname.getText().toString() + "q1.php";
                String zqb = "https://eschoolslgit1.000webhostapp.com/sets/pages/" + etname.getText().toString() + "q2.php";
                String zqc = "https://eschoolslgit1.000webhostapp.com/sets/pages/" + etname.getText().toString() + "q3.php";
                String zqd = "https://eschoolslgit1.000webhostapp.com/sets/pages/" + etname.getText().toString() + "q4.php";
                String zqe = "https://eschoolslgit1.000webhostapp.com/sets/pages/" + etname.getText().toString() + "q5.php";

                String zaa = "https://eschoolslgit1.000webhostapp.com/sets/pages/" + etname.getText().toString() + "q11.php";
                String zab = "https://eschoolslgit1.000webhostapp.com/sets/pages/" + etname.getText().toString() + "q12.php";
                String zac = "https://eschoolslgit1.000webhostapp.com/sets/pages/" + etname.getText().toString() + "q13.php";
                String zad = "https://eschoolslgit1.000webhostapp.com/sets/pages/" + etname.getText().toString() + "q14.php";
                String zae = "https://eschoolslgit1.000webhostapp.com/sets/pages/" + etname.getText().toString() + "q15.php";

                String aaa = "https://eschoolslgit1.000webhostapp.com/sets/pages/" + etname.getText().toString() + "q21.html";
                String aab = "https://eschoolslgit1.000webhostapp.com/sets/pages/" + etname.getText().toString() + "q22.html";
                String aac = "https://eschoolslgit1.000webhostapp.com/sets/pages/" + etname.getText().toString() + "q23.html";
                String aad = "https://eschoolslgit1.000webhostapp.com/sets/pages/" + etname.getText().toString() + "q24.html";
                String aae = "https://eschoolslgit1.000webhostapp.com/sets/pages/" + etname.getText().toString() + "q25.html";

                String lesss =  etless.getText().toString() + "";



                if(isValied(sim,name)){



                    addclasses(aasub,aaact,zzz,nna,gid,sid,cid,aid,bid,zid,sub1,sub2,sub3,sub4,sub5,sub6,sub7,cname,lesss,test,sim,zqa,zqb,zqc,zqd,zqe,zaa,zab,zac,zad,zae,aaa,aab,aac,aad,aae);
                }
            }

        });



    }
    private boolean isValied(String sim,String name) {


        if(sim.isEmpty()){
            showMessage("Please Enter Simulation Link");
            return false;
        }

        if(name.isEmpty()){
            showMessage("Please Enter Simulation Name");
            return false;
        }



        progressBaradd.setVisibility(View.VISIBLE);
        return true;

    }

    private void showMessage(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    private void addclasses( final String aasub, final String aaact,final String zzz,final String nna,final String gid, final String sid, final String cid, final String aid, final String bid, final String zid, final String cname,final String test, final String lesss,final String sub1, final String sub2, final String sub3, final String sub4, final String sub5, final String sub6, final String sub7,final String sim,  final String zqa,final String zqb, final String zqc, final String zqd, final String zqe, final String zaa, final String zab, final String zac,final String zad, final String zae, final String aaa, final String aab, final String aac, final String aad, final String aae) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endspoint.addnewsim_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("success")) {
                    Toast.makeText(addnewsim.this,"Successfully Access data", Toast.LENGTH_SHORT).show();
                    progressBaradd.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(addnewsim.this,plesson.class);
                    intent.putExtra("uname", stn);
                    intent.putExtra("value",st);
                    intent.putExtra("gid",st1);
                    intent.putExtra("SID",st3);
                    intent.putExtra("SIDNAME",st2);
                    intent.putExtra("SIDPDF",st0);
                    intent.putExtra("aid",said);
                    intent.putExtra("bid",sbid);
                    startActivity(intent);

                }

                else {
                    Toast.makeText(addnewsim.this,"Successfully Access data", Toast.LENGTH_SHORT).show();
                    progressBaradd.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(addnewsim.this,plesson.class);
                    intent.putExtra("uname", stn);
                    intent.putExtra("value",st);
                    intent.putExtra("gid",st1);
                    intent.putExtra("SID",st3);
                    intent.putExtra("SIDNAME",st2);
                    intent.putExtra("SIDPDF",st0);
                    intent.putExtra("aid",said);
                    intent.putExtra("bid",sbid);
                    startActivity(intent);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(addnewsim.this, "Please check your Internet Connection",Toast.LENGTH_SHORT).show();
                Log.d("VOLLEY", error.getMessage());
                progressBaradd.setVisibility(View.VISIBLE);
                Intent intent = new Intent(addnewsim.this,addnewsim.class);
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
                startActivity(intent);

            }
        }){
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("aasub",aasub);
                params.put("aaact",aaact);

                params.put("lesss",lesss);
                params.put("gid",gid);
                params.put("sid",sid);
                params.put("cid",cid);
                params.put("aid",aid);
                params.put("bid",bid);
                params.put("zid",zid);
                params.put("nna",nna);
                params.put("test",test);
                params.put("cname",cname);

                params.put("sub1",sub1);
                params.put("sub2",sub2);
                params.put("sub3",sub3);
                params.put("sub4",sub4);
                params.put("sub5",sub5);
                params.put("sub6",sub6);
                params.put("sub7",sub7);

                params.put("sim",sim);

                params.put("zqa",zqa);
                params.put("zqb",zqb);
                params.put("zqc",zqc);
                params.put("zqd",zqd);
                params.put("zqe",zqe);

                params.put("zzz",zzz);
                params.put("zaa",zaa);
                params.put("zab",zab);
                params.put("zac",zac);
                params.put("zad",zad);
                params.put("zae",zae);

                params.put("aaa",aaa);
                params.put("aab",aab);
                params.put("aac",aac);
                params.put("aad",aad);
                params.put("aae",aae);



                return  params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }


    public void backpage(View view){
        Intent intent = new Intent (addnewsim.this,plesson.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        intent.putExtra("SID",st3);
        intent.putExtra("SIDNAME",st2);
        intent.putExtra("SIDPDF",st0);
        intent.putExtra("aid",said);
        intent.putExtra("bid",sbid);
        startActivity(intent);
    }


}