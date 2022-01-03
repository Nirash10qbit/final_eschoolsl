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

public class editsubject extends AppCompatActivity {

    String st,st1,st2,st3,stn,said;
    EditText etsidname;
    Button etadd;
    ProgressBar progressBaradd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editsubject);

        etsidname = findViewById(R.id.sidname);
        st2 = getIntent().getExtras().getString("SIDNAME");
        etsidname.setText(st2);
        st3 = getIntent().getExtras().getString("SID");

        stn = getIntent().getExtras().getString("uname");
        said = getIntent().getExtras().getString("aid");

        progressBaradd = findViewById(R.id.progressBaradd);
        progressBaradd.setVisibility(View.INVISIBLE);

        etadd = findViewById(R.id.radd);
        st = getIntent().getExtras().getString("value");
        st1 = getIntent().getExtras().getString("gid");

        etsidname = findViewById(R.id.sidname);

        etadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sid = st3;
                String sidname = etsidname.getText().toString();
                String sidpdf = "";


                if(isValied(sidname)){
                    addclasses(sid,sidname,sidpdf);
                }
            }


        });

    }
    private boolean isValied( String sidname) {

        if(sidname.isEmpty()){
            showMessage("Please Enter the Subject Name ");
            return false;
        }



        progressBaradd.setVisibility(View.VISIBLE);
        return true;

    }

    private void showMessage(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }



    private void addclasses( final String sid, final  String sidname, final String sidpdf ){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endspoint.editsub_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("success")) {

                    Toast.makeText(editsubject.this," Successfully Update data", Toast.LENGTH_SHORT).show();
                    progressBaradd.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(editsubject.this,subject.class);
                    intent.putExtra("uname", stn);
                    intent.putExtra("value",st);
                    intent.putExtra("gid",st1);
                    intent.putExtra("aid",said);
                    startActivity(intent);

                }
                else {
                    Toast.makeText(editsubject.this,"Successfully Update data", Toast.LENGTH_SHORT).show();
                    progressBaradd.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(editsubject.this,subject.class);
                    intent.putExtra("uname", stn);
                    intent.putExtra("value",st);
                    intent.putExtra("gid",st1);
                    intent.putExtra("aid",said);
                    startActivity(intent);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(editsubject.this, "Please check your Internet Connection",Toast.LENGTH_SHORT).show();
                Log.d("VOLLEY", error.getMessage());
                progressBaradd.setVisibility(View.VISIBLE);
                Intent intent = new Intent(editsubject.this,editsubject.class);
                intent.putExtra("uname", stn);
                intent.putExtra("value",st);
                intent.putExtra("gid",st1);
                intent.putExtra("aid",said);
                startActivity(intent);

            }
        }){
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("sid",sid);
                params.put("sidname",sidname);
                params.put("sidpdf",sidpdf);

                return  params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

    public void backsub(View view){
        Intent intent = new Intent (editsubject.this,subject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        intent.putExtra("aid",said);
        startActivity(intent);
    }

}