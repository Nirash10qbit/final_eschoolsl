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

public class testsubaddf extends AppCompatActivity {

    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9;
    Button etadd;
    String url1 = "https://eschoolslgit1.000webhostapp.com/getdata.php";
    String url2 = "https://eschoolslgit1.000webhostapp.com/getlabsub.php?aid=11&&bid=3";
    String url3 = "https://eschoolslgit1.000webhostapp.com/getlabact.php?aid=11&&bid=3&&zid=1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testsubaddf);

        etadd = findViewById(R.id.bn);
        tv1 =findViewById(R.id.aastn);
        tv2 =findViewById(R.id.aamarks);
        tv3 =findViewById(R.id.aatotal);
        tv4 =findViewById(R.id.abstn);
        tv5 =findViewById(R.id.abmarks);
        tv6 =findViewById(R.id.abtotal);
        tv7 =findViewById(R.id.azstn);
        tv8 =findViewById(R.id.azmarks);
        tv9 =findViewById(R.id.aztotal);


        etadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url1, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    tv1.setText(response.getString("tstn"));
                                    tv2.setText(response.getString("tmarks"));
                                    tv3.setText(response.getString("ttotal"));
                                } catch (JSONException e){
                                    e.printStackTrace();;
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(testsubaddf.this,"wrong",Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                });

                VolleySingleton.getInstance(testsubaddf.this).addToRequestQueue(jsonObjectRequest)   ;

                JsonObjectRequest jsonObjectRequest2 = new JsonObjectRequest(Request.Method.POST, url2, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    tv4.setText(response.getString("bstn"));
                                    tv5.setText(response.getString("bmarks"));
                                    tv6.setText(response.getString("btotal"));
                                } catch (JSONException e){
                                    e.printStackTrace();;
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(testsubaddf.this,"wrong",Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                });


                VolleySingleton.getInstance(testsubaddf.this).addToRequestQueue(jsonObjectRequest2)   ;

                JsonObjectRequest jsonObjectRequest3 = new JsonObjectRequest(Request.Method.POST, url3, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    tv7.setText(response.getString("zstn"));
                                    tv8.setText(response.getString("zmarks"));
                                    tv9.setText(response.getString("ztotal"));
                                } catch (JSONException e){
                                    e.printStackTrace();;
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(testsubaddf.this,"wrong",Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                });


                VolleySingleton.getInstance(testsubaddf.this).addToRequestQueue(jsonObjectRequest3)   ;

            }
        });
    }
}