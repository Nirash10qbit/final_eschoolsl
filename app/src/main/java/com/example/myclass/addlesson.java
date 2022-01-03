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

public class addlesson extends AppCompatActivity {

    EditText etcidname,etcpdf,etcnum;
    Button etadd;
    ProgressBar progressBaradd;
    TextView tv1,tv2;

    String st,st1,st2,st3,stn,said,sbid;

    Button browse;
    String encodedPDF,mid,num,name;
    private  int REQ_PDF = 21;
    private static final String url="https://eschoolslgit1.000webhostapp.com/uploadpdf.php";
    private static final String url1="https://eschoolslgit1.000webhostapp.com/Pdf/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addlesson);

        stn = getIntent().getExtras().getString("uname");

        progressBaradd = findViewById(R.id.progressBaradd);
        progressBaradd.setVisibility(View.INVISIBLE);

        etadd = findViewById(R.id.cadd);

        st = getIntent().getExtras().getString("value");
        st2 = getIntent().getExtras().getString("sid");
        st3 = getIntent().getExtras().getString("sidname");

        tv1 = findViewById(R.id.gid4);
        st1 = getIntent().getExtras().getString("gid");
        tv1.setText(st1);
        tv2 = findViewById(R.id.sid4);
        st2 = getIntent().getExtras().getString("SID");
        tv2.setText(st2);
        said = getIntent().getExtras().getString("aid");
        sbid = getIntent().getExtras().getString("bid");



        etcnum = findViewById(R.id.cnum);
        etcidname = findViewById(R.id.cidname);
        etcpdf = findViewById(R.id.cpdf);


        etadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                num = etcnum.getText().toString();
                name = etcidname.getText().toString();

                String gid = st1;
                String sid = st2;
                String cidname = num +") "+ name;
                String cpdf = url1 + st1 + st2 + num +") "+ name + ".pdf";

                uploaddatatodb();

                if(isValied(cidname)){
                    addclasses(gid,sid,cidname,cpdf);
                }
            }

        });

        browse=(Button)findViewById(R.id.browse);

        browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
                chooseFile.setType("application/pdf");
                chooseFile = Intent.createChooser(chooseFile, "Choose a file");
                startActivityForResult(chooseFile, REQ_PDF);

            }
        });
    }
    private boolean isValied( String cidname) {

        if(cidname.isEmpty()){
            showMessage("Please Enter the lesson name");
            return false;
        }



        progressBaradd.setVisibility(View.VISIBLE);
        return true;

    }

    private void showMessage(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }



    private void addclasses( final String gid, final String sid,final String cidname, final String cpdf){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endspoint.addless_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("success")) {

                    Toast.makeText(addlesson.this,"Successfully Access data", Toast.LENGTH_SHORT).show();
                    progressBaradd.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(addlesson.this,subject.class);
                    intent.putExtra("uname", stn);
                    intent.putExtra("value",st);
                    intent.putExtra("gid",st1);
                    intent.putExtra("aid",said);
                    intent.putExtra("bid",sbid);
                    startActivity(intent);

                }
                else {
                    Toast.makeText(addlesson.this,"Successfully Access data", Toast.LENGTH_SHORT).show();
                    progressBaradd.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(addlesson.this,subject.class);
                    intent.putExtra("uname", stn);
                    intent.putExtra("value",st);
                    intent.putExtra("gid",st1);
                    intent.putExtra("aid",said);
                    intent.putExtra("bid",sbid);
                    startActivity(intent);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(addlesson.this, "Please check your Interner Connection",Toast.LENGTH_SHORT).show();
                Log.d("VOLLEY", error.getMessage());
                progressBaradd.setVisibility(View.VISIBLE);
                Intent intent = new Intent(addlesson.this,addlesson.class);
                intent.putExtra("uname", stn);
                intent.putExtra("value",st);
                intent.putExtra("gid",st1);
                intent.putExtra("SID",st2);
                intent.putExtra("sidname",st3);
                intent.putExtra("aid",said);
                intent.putExtra("bid",sbid);
                startActivity(intent);

            }
        }){
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("gid",gid);
                params.put("sid", sid);
                params.put("cidname",cidname);
                params.put("cpdf",cpdf);

                return  params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

    public void backpless(View view){
        Intent intent = new Intent (addlesson.this,subject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
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
                InputStream inputStream = addlesson.this.getContentResolver().openInputStream(path);
                byte[] pdfInBytes = new byte[inputStream.available()];
                inputStream.read(pdfInBytes);
                encodedPDF = Base64.encodeToString(pdfInBytes, Base64.DEFAULT);

                Toast.makeText(this, "Document Selected", Toast.LENGTH_SHORT).show();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void uploaddatatodb()
    {
        mid =  st1 + st2 + num +") "+ name;

        StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                Toast.makeText(getApplicationContext(),"PDF Upload",Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
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



}