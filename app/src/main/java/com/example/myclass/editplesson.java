package com.example.myclass;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class editplesson extends AppCompatActivity {

    EditText etcidname,etcpdf,etcact;
    ProgressBar progressBaradd;
    TextView tv5;
    String stn,st,st0,st1,st2,st3,st4,st5,st6,st16,said,sbid,cname;
    Button browse,browse1,upload,upload1,etadd;
    String encodedPDF,encodedPDF1,mid,mid1;
    private  int REQ_PDF = 21;
    private static final String url="https://eschoolslgit1.000webhostapp.com/uploadpdf.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editplesson);

        browse=(Button)findViewById(R.id.browse);
        browse1=(Button)findViewById(R.id.browse1);
        upload=(Button)findViewById(R.id.upload);
        upload1=(Button)findViewById(R.id.upload1);

        stn = getIntent().getExtras().getString("uname");
        said = getIntent().getExtras().getString("aid");
        sbid = getIntent().getExtras().getString("bid");

        progressBaradd = findViewById(R.id.progressBaradd);
        progressBaradd.setVisibility(View.INVISIBLE);

        etadd = findViewById(R.id.cadd);

        st = getIntent().getExtras().getString("value");
        st1 = getIntent().getExtras().getString("gid");
        st3 = getIntent().getExtras().getString("SID");
        st2 = getIntent().getExtras().getString("SIDNAME");

        tv5 = findViewById(R.id.ltext10);
        st5 = getIntent().getExtras().getString("CID");
        tv5.setText(st5);

        etcidname = findViewById(R.id.cidname);
        st4 = getIntent().getExtras().getString("CIDNAME");
        etcidname.setText(st4);
        st6 = getIntent().getExtras().getString("CPDF");
        st16 = getIntent().getExtras().getString("cact");

        etcidname = findViewById(R.id.cidname);

        etadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                st5 = getIntent().getExtras().getString("CID");

                String cid = st5;
                String cidname = etcidname.getText().toString();
                cname = etcidname.getText().toString();
                String cpdf = "https://eschoolslgit1.000webhostapp.com/Pdf/"+st1 + st3 +  cname + ".pdf";
                String cact = "https://eschoolslgit1.000webhostapp.com/Pdf/"+st1 + st3 +  cname+ "act.pdf";



                if(isValied(cidname,cpdf)){
                    addclasses(cid,cidname,cpdf,cact);
                }
            }
        });

        browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
                chooseFile.setType("application/pdf");
                chooseFile = Intent.createChooser(chooseFile, "Choose a file");
                startActivityForResult(chooseFile, REQ_PDF);

            }
        });

        browse1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
                chooseFile.setType("application/pdf");
                chooseFile = Intent.createChooser(chooseFile, "Choose a file");
                startActivityForResult(chooseFile, REQ_PDF);

            }
        });
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploaddatatodb();
            }
        });

        upload1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploaddatatodb1();
            }
        });

    }
    private boolean isValied( String cidname, String cpdf) {

        if(cidname.isEmpty()){
            showMessage("Please Enter the lesson name");
            return false;
        }
        if(cpdf.isEmpty()){
            showMessage("Please Enter the PDF name");
            return false;
        }


        progressBaradd.setVisibility(View.VISIBLE);
        return true;

    }

    private void showMessage(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }



    private void addclasses( final String cid,final String cidname, final String cpdf,final String cact){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endspoint.editvless_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("success")) {

                    Toast.makeText(editplesson.this,"Successfully Update data", Toast.LENGTH_SHORT).show();
                    progressBaradd.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(editplesson.this,plesson.class);
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
                else {
                    Toast.makeText(editplesson.this,"Successfully Update data", Toast.LENGTH_SHORT).show();
                    progressBaradd.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(editplesson.this,editplesson.class);
                    intent.putExtra("uname", stn);
                    intent.putExtra("value",st);
                    intent.putExtra("gid",st1);
                    intent.putExtra("SIDNAME",st2);
                    intent.putExtra("SID",st3);
                    intent.putExtra("CIDNAME",st4);
                    intent.putExtra("CID",st5);
                    intent.putExtra("CPDF",st6);
                    intent.putExtra("cact",st16);
                    intent.putExtra("SIDPDF",st0);
                    intent.putExtra("aid",said);
                    intent.putExtra("bid",sbid);
                    startActivity(intent);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(editplesson.this, "Please check your Internet Connection",Toast.LENGTH_SHORT).show();
                Log.d("VOLLEY", error.getMessage());
                progressBaradd.setVisibility(View.VISIBLE);
                Intent intent = new Intent(editplesson.this,editplesson.class);
                intent.putExtra("uname", stn);
                intent.putExtra("value",st);
                intent.putExtra("gid",st1);
                intent.putExtra("SIDNAME",st2);
                intent.putExtra("SID",st3);
                intent.putExtra("CIDNAME",st4);
                intent.putExtra("CID",st5);
                intent.putExtra("CPDF",st6);
                intent.putExtra("cact",st16);
                intent.putExtra("SIDPDF",st0);
                intent.putExtra("aid",said);
                intent.putExtra("bid",sbid);
                startActivity(intent);

            }
        }){
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("cid", cid);
                params.put("cidname",cidname);
                params.put("cpdf",cpdf);
                params.put("cact",cact);

                return  params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

    public void backpless(View view){
        Intent intent = new Intent (editplesson.this,plesson.class);
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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQ_PDF && resultCode == RESULT_OK && data != null){

            Uri path = data.getData();


            try {
                InputStream inputStream = editplesson.this.getContentResolver().openInputStream(path);
                byte[] pdfInBytes = new byte[inputStream.available()];
                inputStream.read(pdfInBytes);
                encodedPDF = Base64.encodeToString(pdfInBytes, Base64.DEFAULT);
                encodedPDF1 = Base64.encodeToString(pdfInBytes, Base64.DEFAULT);

                Toast.makeText(this, "Document Selected", Toast.LENGTH_SHORT).show();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void uploaddatatodb()
    {

        cname = etcidname.getText().toString();
        mid = st1 + st3 + cname;

        StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                Toast.makeText(getApplicationContext(),"PDF Upload",Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"PDF Upload Error",Toast.LENGTH_LONG).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String,String> map=new HashMap<String, String>();
                map.put("t1",mid);
                map.put("upload",encodedPDF);
                return map;
            }
        };


        RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
        queue.add(request);
    }

    private void uploaddatatodb1()
    {

        cname = etcidname.getText().toString();
        mid1 = st1 + st3 + cname+ "act";

        StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                Toast.makeText(getApplicationContext(),"PDF Upload",Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"PDF Upload Error",Toast.LENGTH_LONG).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String,String> map=new HashMap<String, String>();
                map.put("t1",mid1);
                map.put("upload",encodedPDF1);
                return map;
            }
        };


        RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
        queue.add(request);
    }
}