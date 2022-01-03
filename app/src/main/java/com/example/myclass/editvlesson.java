package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class editvlesson extends AppCompatActivity {

    EditText etcidname,etcpdf,etcact;
    Button etadd;
    ProgressBar progressBaradd;
    TextView tv5;
    String stn,st,st0,st1,st2,st3,st4,st5,st6,st16,said,sbid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editvlesson);

        stn = getIntent().getExtras().getString("uname");

        progressBaradd = findViewById(R.id.progressBaradd);
        progressBaradd.setVisibility(View.INVISIBLE);

        etadd = findViewById(R.id.cadd);

        st = getIntent().getExtras().getString("value");
        st1 = getIntent().getExtras().getString("gid");
        st3 = getIntent().getExtras().getString("SID");
        st2 = getIntent().getExtras().getString("SIDNAME");
        said = getIntent().getExtras().getString("aid");
        sbid = getIntent().getExtras().getString("bid");

        tv5 = findViewById(R.id.ltext10);
        st5 = getIntent().getExtras().getString("CID");
        tv5.setText(st5);

        etcidname = findViewById(R.id.cidname);
        st4 = getIntent().getExtras().getString("CIDNAME");
        etcidname.setText(st4);

        etcpdf = findViewById(R.id.cpdf);
        st6 = getIntent().getExtras().getString("CPDF");
        etcpdf.setText(st6);

        etcact = findViewById(R.id.cact);
        st16 = getIntent().getExtras().getString("cact");
        etcact.setText(st16);

        etcidname = findViewById(R.id.cidname);
        etcpdf = findViewById(R.id.cpdf);
        etcact = findViewById(R.id.cact);

        etadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                st5 = getIntent().getExtras().getString("CID");

                String cid = st5;
                String cidname = etcidname.getText().toString();
                String cpdf = etcpdf.getText().toString();
                String cact = etcact.getText().toString();



                if(isValied(cidname,cpdf)){
                    addclasses(cid,cidname,cpdf,cact);
                }
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

                    Toast.makeText(editvlesson.this,"Successfully Update data", Toast.LENGTH_SHORT).show();
                    progressBaradd.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(editvlesson.this,vlesson.class);
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
                    Toast.makeText(editvlesson.this,"Successfully Update data", Toast.LENGTH_SHORT).show();
                    progressBaradd.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(editvlesson.this,editvlesson.class);
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

                Toast.makeText(editvlesson.this, "Please check your Internet Connection",Toast.LENGTH_SHORT).show();
                Log.d("VOLLEY", error.getMessage());
                progressBaradd.setVisibility(View.VISIBLE);
                Intent intent = new Intent(editvlesson.this,editvlesson.class);
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
        Intent intent = new Intent (editvlesson.this,vlesson.class);
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


}