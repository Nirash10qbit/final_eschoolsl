package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

public class usersettings extends AppCompatActivity {

    EditText etpassword;
    String stn,stl,stg;
    Button etreset,etback;
    ProgressBar progressBar;
    TextView uname1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usersettings);

        uname1 = findViewById(R.id.runame);
        stn = getIntent().getExtras().getString("uname");
        uname1.setText(stn);

        stl = getIntent().getExtras().getString("language");
        stg = getIntent().getExtras().getString("grade");

        progressBar = findViewById(R.id.progressBarr);
        progressBar.setVisibility(View.INVISIBLE);

        etreset = findViewById(R.id.reset);
        etback = findViewById(R.id.backmains);

        etpassword = findViewById(R.id.newpassword);

        etreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uname = uname1.getText().toString();
                String password = etpassword.getText().toString();
                if(isValied(password)){
                    addclasses(uname,password);
                }
            }


        });

        etback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(usersettings.this,zmenus.class);
                intent.putExtra("uname", stn);
                intent.putExtra("language", stl);
                intent.putExtra("grade", stg);
                startActivity(intent);
            }


        });

    }



    private boolean isValied(String password) {

        if(password.isEmpty()){
            showMessage("Please Enter the Password ");
            return false;
        }
        if(password.length() < 6){
            showMessage("Password be between 6 and 8 characters");
            return false;
        }
        if(password.length() > 8){
            showMessage("Password be between 6 and 8 characters");
            return false;
        }
        progressBar.setVisibility(View.VISIBLE);
        return true;
    }

    private void showMessage(String msg) {
        makeText(this,msg, LENGTH_SHORT).show();
    }

    private void addclasses(  final  String uname,final  String password ){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endspoint.resetpassword_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("success")) {

                    makeText(usersettings.this,"Password Reset Successfully", LENGTH_SHORT).show();
                    progressBar.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(usersettings.this,usersettings.class);
                    intent.putExtra("uname", stn);
                    intent.putExtra("language", stl);
                    intent.putExtra("grade", stg);
                    startActivity(intent);

                }
                else {
                    makeText(usersettings.this,"Password Reset Successfully", LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(usersettings.this,usersettings.class);
                    intent.putExtra("uname", stn);
                    intent.putExtra("language", stl);
                    intent.putExtra("grade", stg);
                    startActivity(intent);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                makeText(usersettings.this, "Please check your Internet Connection", LENGTH_SHORT).show();
                Log.d("VOLLEY", error.getMessage());

                Intent intent = new Intent(usersettings.this,usersettings.class);
                intent.putExtra("uname", stn);
                intent.putExtra("language", stl);
                intent.putExtra("grade", stg);
                startActivity(intent);

            }
        }){
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("uname",uname);
                params.put("password",password);
                return  params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

}