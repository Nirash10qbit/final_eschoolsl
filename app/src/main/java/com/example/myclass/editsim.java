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

public class editsim extends AppCompatActivity {

    TextView etaaa,etaab,etaac,etaad,etaae,etana,etgana,etbna,etgbna,etcna,etgcna,etdna,etgdna,etena,etgena,etanb,etganb,etbnb,etgbnb,etcnb,etgcnb,etdnb,etgdnb,etenb,etgenb,etanc,etganc,etbnc,etgbnc,etcnc,etgcnc,etdnc,etgdnc,etenc,etgenc,etand,etgand,etbnd,etgbnd,etcnd,etgcnd,etdnd,etgdnd,etend,etgend,tv1,tv2;
    ProgressBar progressBaradd;

    Button etadd,browse,upload,browse1,upload1,browse2,upload2,browse3,upload3,browse4,upload4;
    ImageView img,img1,img2,img3,img4;
    EditText etasim,etaname,etalink;
    Bitmap bitmap;
    String etsim,etaa,etab,etac,etad,etae,st,st0,st1,st2,st3,st4,st5,st6,st16,st20,st30,st31,
            stn,said,sbid,szid,etqa,etqb,etqc,etqd,etqe,encodeImageString,encodeImageString1,
            encodeImageString2,encodeImageString3,encodeImageString4,etna,etnb,etnc,etnd,etne;
    private static final String url="https://eschoolslgit1.000webhostapp.com/fileupload.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editsim);


        stn = getIntent().getExtras().getString("uname");

        progressBaradd = findViewById(R.id.progressBaradd);
        progressBaradd.setVisibility(View.INVISIBLE);

        etadd = findViewById(R.id.etaddg);

        tv1 = findViewById(R.id.cidd);
        st5 = getIntent().getExtras().getString("CID");
        tv1.setText(st5);

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




        etqa = "https://eschoolslgit1.000webhostapp.com/Images/"+ st5+"q1.jpg";
        etqb = "https://eschoolslgit1.000webhostapp.com/Images/"+ st5+"q2.jpg";
        etqc = "https://eschoolslgit1.000webhostapp.com/Images/"+ st5+"q3.jpg";
        etqd = "https://eschoolslgit1.000webhostapp.com/Images/"+ st5+"q4.jpg";
        etqe = "https://eschoolslgit1.000webhostapp.com/Images/"+ st5+"q5.jpg";


        etasim = findViewById(R.id.esim);
        etaaa = findViewById(R.id.zaa);
        etaab = findViewById(R.id.zab);
        etaac = findViewById(R.id.zac);
        etaad = findViewById(R.id.zad);
        etaae = findViewById(R.id.zae);

        etana = findViewById(R.id.ana);
        etgana = findViewById(R.id.gana);
        etbna = findViewById(R.id.bna);
        etgbna = findViewById(R.id.gbna);
        etcna = findViewById(R.id.cna);
        etgcna = findViewById(R.id.gcna);
        etdna = findViewById(R.id.dna);
        etgdna = findViewById(R.id.gdna);
        etena = findViewById(R.id.ena);
        etgena = findViewById(R.id.gena);


        etanb = findViewById(R.id.anb);
        etganb = findViewById(R.id.ganb);
        etbnb = findViewById(R.id.bnb);
        etgbnb = findViewById(R.id.gbnb);
        etcnb = findViewById(R.id.cnb);
        etgcnb = findViewById(R.id.gcnb);
        etdnb = findViewById(R.id.dnb);
        etgdnb = findViewById(R.id.gdnb);
        etenb = findViewById(R.id.enb);
        etgenb = findViewById(R.id.genb);


        etanc = findViewById(R.id.anc);
        etganc = findViewById(R.id.ganc);
        etbnc = findViewById(R.id.bnc);
        etgbnc = findViewById(R.id.gbnc);
        etcnc = findViewById(R.id.cnc);
        etgcnc = findViewById(R.id.gcnc);
        etdnc = findViewById(R.id.dnc);
        etgdnc = findViewById(R.id.gdnc);
        etenc = findViewById(R.id.enc);
        etgenc = findViewById(R.id.genc);


        etand = findViewById(R.id.and);
        etgand = findViewById(R.id.gand);
        etbnd = findViewById(R.id.bnd);
        etgbnd = findViewById(R.id.gbnd);
        etcnd = findViewById(R.id.cnd);
        etgcnd = findViewById(R.id.gcnd);
        etdnd = findViewById(R.id.dnd);
        etgdnd = findViewById(R.id.gdnd);
        etend = findViewById(R.id.end);
        etgend = findViewById(R.id.gend);

        etadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String gid = st1;
                String sid = st3;
                String cid = st5;
                String aid = said;
                String bid = sbid;
                String zid = szid;


                String qa = etqa;
                String qb = etqb;
                String qc = etqc;
                String qd = etqd;
                String qe = etqe;


                String nna = "0";
                String sub1 = "BUDDHIST";
                String sub2 = "SCIENCE";
                String sub3 = "MATHS";
                String sub4 = "SINHALA";
                String sub5 = "HISTORY";
                String sub6 = "ENGLISH";
                String sub7 = "TAMIL";
                String cidname = st4;

                String sim = etasim.getText().toString();
                String aa = sim+"1";
                String ab = sim+"2";
                String ac = sim+"3";
                String ad = sim+"4";
                String ae = sim+"5";


                String ana = etana.getText().toString();
                String gana = etgana.getText().toString();
                String bna = etbna.getText().toString();
                String gbna = etgbna.getText().toString();
                String cna = etcna.getText().toString();
                String gcna = etgcna.getText().toString();
                String dna = etdna.getText().toString();
                String gdna = etgdna.getText().toString();
                String ena = etena.getText().toString();
                String gena = etgena.getText().toString();

                String anb = etanb.getText().toString();
                String ganb = etganb.getText().toString();
                String bnb = etbnb.getText().toString();
                String gbnb = etgbnb.getText().toString();
                String cnb = etcnb.getText().toString();
                String gcnb = etgcnb.getText().toString();
                String dnb = etdnb.getText().toString();
                String gdnb = etgdnb.getText().toString();
                String enb = etenb.getText().toString();
                String genb = etgenb.getText().toString();

                String anc = etanc.getText().toString();
                String ganc = etganc.getText().toString();
                String bnc = etbnc.getText().toString();
                String gbnc = etgbnc.getText().toString();
                String cnc = etcnc.getText().toString();
                String gcnc = etgcnc.getText().toString();
                String dnc = etdnc.getText().toString();
                String gdnc = etgdnc.getText().toString();
                String enc = etenc.getText().toString();
                String genc = etgenc.getText().toString();

                String and = etand.getText().toString();
                String gand = etgand.getText().toString();
                String bnd = etbnd.getText().toString();
                String gbnd = etgbnd.getText().toString();
                String cnd = etcnd.getText().toString();
                String gcnd = etgcnd.getText().toString();
                String dnd = etdnd.getText().toString();
                String gdnd = etgdnd.getText().toString();
                String end = etend.getText().toString();
                String gend = etgend.getText().toString();


                if(isValied(sim,ana,gana,bna,gbna,cna,gcna,dna,gdna,ena,gena,
                        anb,ganb,bnb,gbnb,cnb,gcnb,dnb,gdnb,enb,genb,
                        anc,ganc,bnc,gbnc,cnc,gcnc,dnc,gdnc,enc,genc,
                        and,gand,bnd,gbnd,cnd,gcnd,dnd,gdnd,end,gend)){


                    String ca = "1";
                    String cb = "2";
                    String cc = "3";
                    String cd = "4";


                    addclasses(gid,sid,cid,aid,bid,zid,nna,sub1,sub2,sub3,sub4,sub5,sub6,sub7,cidname,sim,qa,qb,qc,qd,qe,aa,ab,ac,ad,ae,ca,ana,gana,bna,gbna,cna,gcna,dna,gdna,ena,gena,cb,anb,ganb,bnb,gbnb,cnb,gcnb,dnb,gdnb,enb,genb,cc,anc,ganc,bnc,gbnc,cnc,gcnc,dnc,gdnc,enc,genc,cd,and,gand,bnd,gbnd,cnd,gcnd,dnd,gdnd,end,gend);
                }
            }

        });


        img=(ImageView)findViewById(R.id.img);
        upload=(Button)findViewById(R.id.upload);
        browse=(Button)findViewById(R.id.browse);

        img1=(ImageView)findViewById(R.id.img1);
        upload1=(Button)findViewById(R.id.upload1);
        browse1=(Button)findViewById(R.id.browse1);

        img2=(ImageView)findViewById(R.id.img2);
        upload2=(Button)findViewById(R.id.upload2);
        browse2=(Button)findViewById(R.id.browse2);

        img3=(ImageView)findViewById(R.id.img3);
        upload3=(Button)findViewById(R.id.upload3);
        browse3=(Button)findViewById(R.id.browse3);

        img4=(ImageView)findViewById(R.id.img4);
        upload4=(Button)findViewById(R.id.upload4);
        browse4=(Button)findViewById(R.id.browse4);

        browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.setVisibility(View.VISIBLE);
                upload.setVisibility(View.VISIBLE);
                Dexter.withActivity(editsim.this)
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse response)
                            {
                                Intent intent=new Intent(Intent.ACTION_PICK);
                                intent.setType("image/*");
                                startActivityForResult(Intent.createChooser(intent,"Browse Image"),1);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse response) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                                token.continuePermissionRequest();
                            }
                        }).check();
            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploaddatatodb();
            }
        });

        browse1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setVisibility(View.VISIBLE);
                upload1.setVisibility(View.VISIBLE);

                Dexter.withActivity(editsim.this)
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse response)
                            {
                                Intent intent=new Intent(Intent.ACTION_PICK);
                                intent.setType("image/*");
                                startActivityForResult(Intent.createChooser(intent,"Browse Image"),1);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse response) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                                token.continuePermissionRequest();
                            }
                        }).check();
            }
        });

        upload1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploaddatatodb1();
            }
        });


        browse2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img2.setVisibility(View.VISIBLE);
                upload2.setVisibility(View.VISIBLE);

                Dexter.withActivity(editsim.this)
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse response)
                            {
                                Intent intent=new Intent(Intent.ACTION_PICK);
                                intent.setType("image/*");
                                startActivityForResult(Intent.createChooser(intent,"Browse Image"),1);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse response) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                                token.continuePermissionRequest();
                            }
                        }).check();
            }
        });

        upload2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploaddatatodb2();
            }
        });


        browse3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img3.setVisibility(View.VISIBLE);
                upload3.setVisibility(View.VISIBLE);

                Dexter.withActivity(editsim.this)
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse response)
                            {
                                Intent intent=new Intent(Intent.ACTION_PICK);
                                intent.setType("image/*");
                                startActivityForResult(Intent.createChooser(intent,"Browse Image"),1);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse response) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                                token.continuePermissionRequest();
                            }
                        }).check();
            }
        });

        upload3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploaddatatodb3();
            }
        });


        browse4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img4.setVisibility(View.VISIBLE);
                upload4.setVisibility(View.VISIBLE);

                Dexter.withActivity(editsim.this)
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse response)
                            {
                                Intent intent=new Intent(Intent.ACTION_PICK);
                                intent.setType("image/*");
                                startActivityForResult(Intent.createChooser(intent,"Browse Image"),1);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse response) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                                token.continuePermissionRequest();
                            }
                        }).check();
            }
        });

        upload4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploaddatatodb4();
            }
        });




    }
    private boolean isValied(String sim,String ana, String gana, String bna, String gbna, String cna, String gcna, String dna, String gdna, String ena, String gena,
                             String anb, String ganb, String bnb, String gbnb, String cnb, String gcnb, String dnb, String gdnb, String enb, String genb,
                             String anc, String ganc, String bnc, String gbnc, String cnc, String gcnc, String dnc,String gdnc, String enc, String genc,
                             String and, String gand, String bnd, String gbnd, String cnd, String gcnd, String dnd,String gdnd, String end, String gend) {


        if(sim.isEmpty()){
            showMessage("Please Enter Simulation Link");
            return false;
        }

        if(ana.isEmpty()){
            showMessage("Please Enter the Q1 NA");
            return false;
        }
        if(gana.isEmpty()){
            showMessage("Please Enter the Q1 Answer 01");
            return false;
        }

        if(bna.isEmpty()){
            showMessage("Please Enter the Q2 NA");
            return false;
        }
        if(gbna.isEmpty()){
            showMessage("Please Enter the Q2 Answer 01");
            return false;
        }
        if(cna.isEmpty()){
            showMessage("Please Enter the Q3 NA");
            return false;
        }
        if(gcna.isEmpty()){
            showMessage("Please Enter the Q3 Answer 01");
            return false;
        }

        if(dna.isEmpty()){
            showMessage("Please Enter the Q4 NA");
            return false;
        }
        if(gdna.isEmpty()){
            showMessage("Please Enter the Q4 Answer 01");
            return false;
        }
        if(ena.isEmpty()){
            showMessage("Please Enter the Q5 NA");
            return false;
        }
        if(gena.isEmpty()){
            showMessage("Please Enter the Q5 Answer 01");
            return false;
        }


        if(anb.isEmpty()){
            showMessage("Please Enter the Q1 NB");
            return false;
        }
        if(ganb.isEmpty()){
            showMessage("Please Enter the Q1 Answer 02");
            return false;
        }

        if(bnb.isEmpty()){
            showMessage("Please Enter the Q2 NB");
            return false;
        }
        if(gbnb.isEmpty()){
            showMessage("Please Enter the Q2 Answer 02");
            return false;
        }
        if(cnb.isEmpty()){
            showMessage("Please Enter the Q3 NB");
            return false;
        }
        if(gcnb.isEmpty()){
            showMessage("Please Enter the Q3 Answer 02");
            return false;
        }

        if(dnb.isEmpty()){
            showMessage("Please Enter the Q4 NB");
            return false;
        }
        if(gdnb.isEmpty()){
            showMessage("Please Enter the Q4 Answer 02");
            return false;
        }
        if(enb.isEmpty()){
            showMessage("Please Enter the Q5 NB");
            return false;
        }
        if(genb.isEmpty()){
            showMessage("Please Enter the Q5 Answer 02");
            return false;
        }


        if(anc.isEmpty()){
            showMessage("Please Enter the Q1 NC");
            return false;
        }
        if(ganc.isEmpty()){
            showMessage("Please Enter the Q1 Answer 03");
            return false;
        }

        if(bnc.isEmpty()){
            showMessage("Please Enter the Q2 NC");
            return false;
        }
        if(gbnc.isEmpty()){
            showMessage("Please Enter the Q2 Answer 03");
            return false;
        }
        if(cnc.isEmpty()){
            showMessage("Please Enter the Q3 NC");
            return false;
        }
        if(gcnc.isEmpty()){
            showMessage("Please Enter the Q3 Answer 03");
            return false;
        }

        if(dnc.isEmpty()){
            showMessage("Please Enter the Q4 NC");
            return false;
        }
        if(gdnc.isEmpty()){
            showMessage("Please Enter the Q4 Answer 03");
            return false;
        }
        if(enc.isEmpty()){
            showMessage("Please Enter the Q5 NC");
            return false;
        }
        if(genc.isEmpty()){
            showMessage("Please Enter the Q5 Answer 03");
            return false;
        }




        if(and.isEmpty()){
            showMessage("Please Enter the Q1 ND");
            return false;
        }
        if(gand.isEmpty()){
            showMessage("Please Enter the Q1 Answer 04");
            return false;
        }

        if(bnd.isEmpty()){
            showMessage("Please Enter the Q2 ND");
            return false;
        }
        if(gbnd.isEmpty()){
            showMessage("Please Enter the Q2 Answer 04");
            return false;
        }
        if(cnd.isEmpty()){
            showMessage("Please Enter the Q3 ND");
            return false;
        }
        if(gcnd.isEmpty()){
            showMessage("Please Enter the Q3 Answer 04");
            return false;
        }

        if(dnd.isEmpty()){
            showMessage("Please Enter the Q4 ND");
            return false;
        }
        if(gdnd.isEmpty()){
            showMessage("Please Enter the Q4 Answer 04");
            return false;
        }
        if(end.isEmpty()){
            showMessage("Please Enter the Q5 ND");
            return false;
        }
        if(gend.isEmpty()){
            showMessage("Please Enter the Q5 Answer 04");
            return false;
        }



        progressBaradd.setVisibility(View.VISIBLE);
        return true;

    }

    private void showMessage(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    private void addclasses( final String gid, final String sid, final String cid, final String aid, final String bid, final String zid, final String nna,final String sub1, final String sub2, final String sub3, final String sub4, final String sub5, final String sub6, final String sub7,final String cidname, final String sim, final String qa, final String qb, final String qc, final String qd, final String qe, final String aa, final String ab, final String ac, final String ad, final String ae,final String ca, final String ana,  final String gana, final String bna, final String gbna, final String cna, final String gcna, final String dna, final String gdna, final String ena, final String gena,final String cb, final String anb,  final String ganb, final String bnb, final String gbnb, final String cnb, final String gcnb, final String dnb, final String gdnb, final String enb, final String genb,final String cc, final String anc,  final String ganc, final String bnc, final String gbnc, final String cnc, final String gcnc, final String dnc, final String gdnc, final String enc, final String genc,final String cd, final String and,  final String gand, final String bnd, final String gbnd, final String cnd, final String gcnd, final String dnd, final String gdnd, final String end, final String gend) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endspoint.editsim_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("success")) {
                    Toast.makeText(editsim.this,"Success data", Toast.LENGTH_SHORT).show();
                    progressBaradd.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(editsim.this,plesson.class);
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
                    Toast.makeText(editsim.this,"Successfully Access data", Toast.LENGTH_SHORT).show();
                    progressBaradd.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(editsim.this,plesson.class);
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

                Toast.makeText(editsim.this, "Please check your Internet Connection",Toast.LENGTH_SHORT).show();
                Log.d("VOLLEY", error.getMessage());
                progressBaradd.setVisibility(View.VISIBLE);
                Intent intent = new Intent(editsim.this,editsim.class);
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

                params.put("sub1",sub1);
                params.put("sub2",sub2);
                params.put("sub3",sub3);
                params.put("sub4",sub4);
                params.put("sub5",sub5);
                params.put("sub6",sub6);
                params.put("sub7",sub7);

                params.put("gid",gid);
                params.put("sid",sid);
                params.put("cid",cid);
                params.put("aid",aid);
                params.put("bid",bid);
                params.put("zid",zid);
                params.put("nna",nna);
                params.put("cidname",cidname);

                params.put("ca",ca);
                params.put("cb",cb);
                params.put("cc",cc);
                params.put("cd",cd);


                params.put("cpdf",sim);
                params.put("zqa",qa);
                params.put("zqb",qb);
                params.put("zqc",qc);
                params.put("zqd",qd);
                params.put("zqe",qe);


                params.put("zaa",aa);
                params.put("zab",ab);
                params.put("zac",ac);
                params.put("zad",ad);
                params.put("zae",ae);


                params.put("ana",ana);
                params.put("gana",gana);
                params.put("bna",bna);
                params.put("gbna",gbna);
                params.put("cna",cna);
                params.put("gcna",gcna);
                params.put("dna",dna);
                params.put("gdna",gdna);
                params.put("ena",ena);
                params.put("gena",gena);

                params.put("anb",anb);
                params.put("ganb",ganb);
                params.put("bnb",bnb);
                params.put("gbnb",gbnb);
                params.put("cnb",cnb);
                params.put("gcnb",gcnb);
                params.put("dnb",dnb);
                params.put("gdnb",gdnb);
                params.put("enb",enb);
                params.put("genb",genb);


                params.put("anc",anc);
                params.put("ganc",ganc);
                params.put("bnc",bnc);
                params.put("gbnc",gbnc);
                params.put("cnc",cnc);
                params.put("gcnc",gcnc);
                params.put("dnc",dnc);
                params.put("gdnc",gdnc);
                params.put("enc",enc);
                params.put("genc",genc);

                params.put("and",and);
                params.put("gand",gand);
                params.put("bnd",bnd);
                params.put("gbnd",gbnd);
                params.put("cnd",cnd);
                params.put("gcnd",gcnd);
                params.put("dnd",dnd);
                params.put("gdnd",gdnd);
                params.put("end",end);
                params.put("gend",gend);

                return  params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }


    public void backpage(View view){
        Intent intent = new Intent (editsim.this,plesson.class);
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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        if(requestCode==1 && resultCode==RESULT_OK)
        {
            Uri filepath=data.getData();
            try
            {
                InputStream inputStream=getContentResolver().openInputStream(filepath);
                bitmap= BitmapFactory.decodeStream(inputStream);
                img.setImageBitmap(bitmap);
                encodeBitmapImage(bitmap);
                img1.setImageBitmap(bitmap);
                encodeBitmapImage1(bitmap);
                img2.setImageBitmap(bitmap);
                encodeBitmapImage2(bitmap);
                img3.setImageBitmap(bitmap);
                encodeBitmapImage3(bitmap);
                img4.setImageBitmap(bitmap);
                encodeBitmapImage4(bitmap);
            }catch (Exception ex)
            {

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void encodeBitmapImage(Bitmap bitmap)
    {
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        byte[] bytesofimage=byteArrayOutputStream.toByteArray();
        encodeImageString=android.util.Base64.encodeToString(bytesofimage, Base64.DEFAULT);
    }

    private void uploaddatatodb()
    {

        st5 = getIntent().getExtras().getString("CID");
        etna = st5+"q1";

        StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                img.setImageResource(R.drawable.ic_launcher_foreground);
                img1.setImageResource(R.drawable.ic_launcher_foreground);
                img2.setImageResource(R.drawable.ic_launcher_foreground);
                img3.setImageResource(R.drawable.ic_launcher_foreground);
                img4.setImageResource(R.drawable.ic_launcher_foreground);
                img.setVisibility(View.GONE);
                upload.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(),"Upload Image",Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String,String> map=new HashMap<String, String>();
                map.put("t1",etna);
                map.put("upload",encodeImageString);
                return map;
            }
        };


        RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
        queue.add(request);
    }


    //1111111

    private void encodeBitmapImage1(Bitmap bitmap)
    {
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        byte[] bytesofimage=byteArrayOutputStream.toByteArray();
        encodeImageString1=android.util.Base64.encodeToString(bytesofimage, Base64.DEFAULT);
    }

    private void uploaddatatodb1()
    {

        st5 = getIntent().getExtras().getString("CID");
        etnb = st5+"q2";

        StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                img.setImageResource(R.drawable.ic_launcher_foreground);
                img1.setImageResource(R.drawable.ic_launcher_foreground);
                img2.setImageResource(R.drawable.ic_launcher_foreground);
                img3.setImageResource(R.drawable.ic_launcher_foreground);
                img4.setImageResource(R.drawable.ic_launcher_foreground);
                img1.setVisibility(View.GONE);
                upload1.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(),"Upload Image",Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String,String> map=new HashMap<String, String>();
                map.put("t1",etnb);
                map.put("upload",encodeImageString1);
                return map;
            }
        };
        RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
        queue.add(request);
    }

    //2222222222

    private void encodeBitmapImage2(Bitmap bitmap)
    {
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        byte[] bytesofimage=byteArrayOutputStream.toByteArray();
        encodeImageString2=android.util.Base64.encodeToString(bytesofimage, Base64.DEFAULT);
    }

    private void uploaddatatodb2()
    {

        st5 = getIntent().getExtras().getString("CID");
        etnc = st5+"q3";

        StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                img.setImageResource(R.drawable.ic_launcher_foreground);
                img1.setImageResource(R.drawable.ic_launcher_foreground);
                img2.setImageResource(R.drawable.ic_launcher_foreground);
                img3.setImageResource(R.drawable.ic_launcher_foreground);
                img4.setImageResource(R.drawable.ic_launcher_foreground);

                img2.setVisibility(View.GONE);
                upload2.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(),"Upload Image",Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String,String> map=new HashMap<String, String>();
                map.put("t1",etnc);
                map.put("upload",encodeImageString2);
                return map;
            }
        };
        RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
        queue.add(request);
    }

    //33333333333


    private void encodeBitmapImage3(Bitmap bitmap)
    {
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        byte[] bytesofimage=byteArrayOutputStream.toByteArray();
        encodeImageString3=android.util.Base64.encodeToString(bytesofimage, Base64.DEFAULT);
    }

    private void uploaddatatodb3()
    {

        st5 = getIntent().getExtras().getString("CID");
        etnd = st5+"q4";

        StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                img.setImageResource(R.drawable.ic_launcher_foreground);
                img1.setImageResource(R.drawable.ic_launcher_foreground);
                img2.setImageResource(R.drawable.ic_launcher_foreground);
                img3.setImageResource(R.drawable.ic_launcher_foreground);
                img4.setImageResource(R.drawable.ic_launcher_foreground);

                img3.setVisibility(View.GONE);
                upload3.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(),"Upload Image",Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String,String> map=new HashMap<String, String>();
                map.put("t1",etnd);
                map.put("upload",encodeImageString3);
                return map;
            }
        };
        RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
        queue.add(request);
    }

    //44444444444

    private void encodeBitmapImage4(Bitmap bitmap)
    {
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        byte[] bytesofimage=byteArrayOutputStream.toByteArray();
        encodeImageString4=android.util.Base64.encodeToString(bytesofimage, Base64.DEFAULT);
    }

    private void uploaddatatodb4()
    {

        st5 = getIntent().getExtras().getString("CID");
        etne = st5+"q5";

        StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                img.setImageResource(R.drawable.ic_launcher_foreground);
                img1.setImageResource(R.drawable.ic_launcher_foreground);
                img2.setImageResource(R.drawable.ic_launcher_foreground);
                img3.setImageResource(R.drawable.ic_launcher_foreground);
                img4.setImageResource(R.drawable.ic_launcher_foreground);

                img4.setVisibility(View.GONE);
                upload4.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(),"Upload Image",Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String,String> map=new HashMap<String, String>();
                map.put("t1",etne);
                map.put("upload",encodeImageString4);
                return map;
            }
        };
        RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
        queue.add(request);
    }


    protected void onResume(){
        super.onResume();
        loadSession();
        loadSession1();
        loadSession2();
        loadSession3();
        loadSession4();

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
        VolleySingleton.getInstance(editsim.this).addToRequestQueue(jsonObjectRequest);
    }

    public void loadSession1() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/simga.php?cid="+st5+"&&ca=1", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            etana.setText(response.getString("na"));
                            etgana.setText(response.getString("ana"));
                            etbna.setText(response.getString("nb"));
                            etgbna.setText(response.getString("anb"));
                            etcna.setText(response.getString("nc"));
                            etgcna.setText(response.getString("anc"));
                            etdna.setText(response.getString("nd"));
                            etgdna.setText(response.getString("and"));
                            etena.setText(response.getString("ne"));
                            etgena.setText(response.getString("ane"));
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
        VolleySingleton.getInstance(editsim.this).addToRequestQueue(jsonObjectRequest);
    }


    public void loadSession2() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/simga.php?cid="+st5+"&&ca=2", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            etanb.setText(response.getString("na"));
                            etganb.setText(response.getString("ana"));
                            etbnb.setText(response.getString("nb"));
                            etgbnb.setText(response.getString("anb"));
                            etcnb.setText(response.getString("nc"));
                            etgcnb.setText(response.getString("anc"));
                            etdnb.setText(response.getString("nd"));
                            etgdnb.setText(response.getString("and"));
                            etenb.setText(response.getString("ne"));
                            etgenb.setText(response.getString("ane"));
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
        VolleySingleton.getInstance(editsim.this).addToRequestQueue(jsonObjectRequest);
    }


    public void loadSession3() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/simga.php?cid="+st5+"&&ca=3", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            etanc.setText(response.getString("na"));
                            etganc.setText(response.getString("ana"));
                            etbnc.setText(response.getString("nb"));
                            etgbnc.setText(response.getString("anb"));
                            etcnc.setText(response.getString("nc"));
                            etgcnc.setText(response.getString("anc"));
                            etdnc.setText(response.getString("nd"));
                            etgdnc.setText(response.getString("and"));
                            etenc.setText(response.getString("ne"));
                            etgenc.setText(response.getString("ane"));
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
        VolleySingleton.getInstance(editsim.this).addToRequestQueue(jsonObjectRequest);
    }

    public void loadSession4() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/simga.php?cid="+st5+"&&ca=4", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            etand.setText(response.getString("na"));
                            etgand.setText(response.getString("ana"));
                            etbnd.setText(response.getString("nb"));
                            etgbnd.setText(response.getString("anb"));
                            etcnd.setText(response.getString("nc"));
                            etgcnd.setText(response.getString("anc"));
                            etdnd.setText(response.getString("nd"));
                            etgdnd.setText(response.getString("and"));
                            etend.setText(response.getString("ne"));
                            etgend.setText(response.getString("ane"));
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
        VolleySingleton.getInstance(editsim.this).addToRequestQueue(jsonObjectRequest);
    }




}