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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class forgetpassword extends AppCompatActivity {

    String stn;
    EditText etname;
    ProgressBar progressBar;
    TextView etreg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);

        etname = findViewById(R.id.fpname);
        progressBar = findViewById(R.id.progressBarfp);

        etreg = findViewById(R.id.etfgp);
        progressBar.setVisibility(View.INVISIBLE);

        etreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(forgetpassword.this,login.class);
                startActivity(intent);
            }
        });
    }

    public void fpbutton(View view) {

        String uname = etname.getText().toString();

        if (isValied(uname)){
            loginl(uname);
        }

    }

    private boolean isValied(String uname) {

        if (uname.isEmpty()){
            showMessage("UserName is empty");
            etname.setText(null);
            return false;
        }

        progressBar.setVisibility(View.VISIBLE);
        return true;

    }

    private void loginl(final String uname) {


        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endspoint.forgetpassword_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                stn = etname.getText().toString();

                if (response.equals("success")) {
                    progressBar.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(forgetpassword.this,SendOTPActivity.class);
                    intent.putExtra("uname", stn);
                    startActivity(intent);
                    etname.setText(null);

                }
                if (response.equals("INVALIED")) {
                    Toast.makeText(forgetpassword.this,"Invalid User Name", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);
                    etname.setText(null);
                    Intent intent = new Intent(forgetpassword.this,forgetpassword.class);
                    startActivity(intent);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(forgetpassword.this, "Please check your Internet Connection",Toast.LENGTH_SHORT).show();
                Log.d("VOLLEY", error.getMessage());
                progressBar.setVisibility(View.VISIBLE);
                Intent intent = new Intent(forgetpassword.this,forgetpassword.class);
                startActivity(intent);

            }
        }){
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("uname", uname);
                return  params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

    private void showMessage(String msg) { Toast.makeText(this,msg , Toast.LENGTH_SHORT).show(); }

}