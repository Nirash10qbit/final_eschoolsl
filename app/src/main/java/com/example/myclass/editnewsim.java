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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class editnewsim extends AppCompatActivity {

    TextView tv1;
    ProgressBar progressBaradd;

    Button etadd;
    EditText etasim,etaname,etalink;
    String st,st0,st1,st2,st3,st4,st5,st6,st16,st20,
            stn,said,sbid,szid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editnewsim);

        stn = getIntent().getExtras().getString("uname");

        progressBaradd = findViewById(R.id.progressBaradd);
        progressBaradd.setVisibility(View.INVISIBLE);

        etadd = findViewById(R.id.simadd);

        st5 = getIntent().getExtras().getString("CID");

        said = getIntent().getExtras().getString("aid");
        sbid = getIntent().getExtras().getString("bid");
        szid = getIntent().getExtras().getString("zid");


        st = getIntent().getExtras().getString("value");
        st1= getIntent().getExtras().getString("gid");

        st2 = getIntent().getExtras().getString("SIDNAME");
        st3 = getIntent().getExtras().getString("SID");
        st4 = getIntent().getExtras().getString("CIDNAME");

        st6 = getIntent().getExtras().getString("CPDF");
        st0 = getIntent().getExtras().getString("SIDPDF");
        st16 = getIntent().getExtras().getString("cact");
        st20 = getIntent().getExtras().getString("cvideo");


        etasim = findViewById(R.id.simlink);
        etaname = findViewById(R.id. simname);
        etalink = findViewById(R.id.lname);



        etadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String cid = st5;


                String sim = etasim.getText().toString();

                String zzz =  etaname.getText().toString() ;

                String zqa =  etalink.getText().toString() + "q1.php";
                String zqb =  etalink.getText().toString() + "q2.php";
                String zqc =  etalink.getText().toString() + "q3.php";
                String zqd =  etalink.getText().toString() + "q4.php";
                String zqe =  etalink.getText().toString() + "q5.php";

                String zaa =  etalink.getText().toString() + "q11.php";
                String zab =  etalink.getText().toString() + "q12.php";
                String zac =  etalink.getText().toString() + "q13.php";
                String zad =  etalink.getText().toString() + "q14.php";
                String zae =  etalink.getText().toString() + "q15.php";

                String aaa =  etalink.getText().toString() + "q21.php";
                String aab =  etalink.getText().toString() + "q22.php";
                String aac =  etalink.getText().toString() + "q23.php";
                String aad =  etalink.getText().toString() + "q24.php";
                String aae =  etalink.getText().toString() + "q25.php";




                if(isValied(sim,zzz)){



                    addclasses(zzz,cid,sim,zqa,zqb,zqc,zqd,zqe,zaa,zab,zac,zad,zae,aaa,aab,aac,aad,aae);
                }
            }

        });




    }
    private boolean isValied(String sim,String zqa) {


        if(sim.isEmpty()){
            showMessage("Please Enter Lesson Name");
            return false;
        }

        if(zqa.isEmpty()){
            showMessage("Please Enter the Simulation Name");
            return false;
        }




        progressBaradd.setVisibility(View.VISIBLE);
        return true;

    }

    private void showMessage(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    private void addclasses( final String zzz, final String cid, final String sim,  final String zqa,final String zqb, final String zqc, final String zqd, final String zqe, final String zaa, final String zab, final String zac,final String zad, final String zae, final String aaa, final String aab, final String aac, final String aad, final String aae) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endspoint.editnewsim_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("success")) {
                    Toast.makeText(editnewsim.this,"Success data", Toast.LENGTH_SHORT).show();
                    progressBaradd.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(editnewsim.this,plesson.class);
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
                    Toast.makeText(editnewsim.this,"Successfully Access data", Toast.LENGTH_SHORT).show();
                    progressBaradd.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(editnewsim.this,plesson.class);
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

                Toast.makeText(editnewsim.this, "Please check your Internet Connection",Toast.LENGTH_SHORT).show();
                Log.d("VOLLEY", error.getMessage());
                progressBaradd.setVisibility(View.VISIBLE);
                Intent intent = new Intent(editnewsim.this,editsim.class);
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


                params.put("cid",cid);
                params.put("sim",sim);
                params.put("zzz",zzz);

                params.put("zqa",zqa);
                params.put("zqb",zqb);
                params.put("zqc",zqc);
                params.put("zqd",zqd);
                params.put("zqe",zqe);


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
        Intent intent = new Intent (editnewsim.this,plesson.class);
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





    protected void onResume(){
        super.onResume();
        loadSession();

    }
    public void loadSession() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/simgr.php?cid="+st5+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            etasim.setText(response.getString("cpdf"));
                            etaname.setText(response.getString("cidname"));
                            etalink.setText(response.getString("zqa"));
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
        VolleySingleton.getInstance(editnewsim.this).addToRequestQueue(jsonObjectRequest);
    }






}