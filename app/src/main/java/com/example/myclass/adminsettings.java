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

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

public class adminsettings extends AppCompatActivity {

    EditText etpassword;
    String stn,said;
    Button etreset,etback;
    ProgressBar progressBar;
    TextView uname1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminsettings);

        stn = getIntent().getExtras().getString("uname");
        said = getIntent().getExtras().getString("aid");
        uname1 = findViewById(R.id.runame);
        uname1.setText(stn);

        progressBar = findViewById(R.id.progressBarr);
        progressBar.setVisibility(View.INVISIBLE);

        etreset = findViewById(R.id.reset);
        etback = findViewById(R.id.backmains);

        etpassword = findViewById(R.id.newpassword);

        etreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uname = stn;
                String password = etpassword.getText().toString();
                if(isValied(password)){
                    addclasses(uname,password);
                }
            }


        });

        etback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(adminsettings.this,menus.class);
                intent.putExtra("uname", stn);
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

                    makeText(adminsettings.this,"Password Reset Successfully", LENGTH_SHORT).show();
                    progressBar.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(adminsettings.this,adminsettings.class);
                    intent.putExtra("uname", stn);
                    intent.putExtra("aid",said);
                    startActivity(intent);

                }
                else {
                    makeText(adminsettings.this,"Password Reset Successfully", LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(adminsettings.this,adminsettings.class);
                    intent.putExtra("uname", stn);
                    intent.putExtra("aid",said);
                    startActivity(intent);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                makeText(adminsettings.this, "Please check your Internet Connection", LENGTH_SHORT).show();
                Log.d("VOLLEY", error.getMessage());

                Intent intent = new Intent(adminsettings.this,adminsettings.class);
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