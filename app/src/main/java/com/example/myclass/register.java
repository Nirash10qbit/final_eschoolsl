package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static android.widget.Toast.*;
import static android.widget.Toast.makeText;

public class register extends AppCompatActivity {

    EditText etname,etemail,etpassword;
    Button etadd;
    String stnn,stnl,stnc,sta,stb,stc,std,sc,scounta;
    ProgressBar progressBaradd;
    TextView etlogin,tva1,tva2,tva3,tva4,tvc;

    private ArrayList<GradeItem> mGradeList;
    private ArrayList<LanguageItem> mLanguageList;
    private GradeAdapter mAdapter;
    private LanguageAdapter nAdapter;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        progressBaradd = findViewById(R.id.progressBarr);
        progressBaradd.setVisibility(View.INVISIBLE);

        etadd = findViewById(R.id.register);
        etlogin = findViewById(R.id.etlogin);

        etname = findViewById(R.id.rname);
        etemail = findViewById(R.id.remail);
        etpassword = findViewById(R.id.rpassword);

        tva1 = findViewById(R.id.stna);
        tva2 = findViewById(R.id.stnb);
        tva3 = findViewById(R.id.stnc);
        tva4 = findViewById(R.id.stnd);
        tvc = findViewById(R.id.count);

        initList();
        initList1();

        Spinner spinnerCountries = findViewById(R.id.spinner_grades);
        Spinner spinnerLanguages = findViewById(R.id.spinner_languages);

        mAdapter = new GradeAdapter(this, mGradeList);
        spinnerCountries.setAdapter(mAdapter);
        nAdapter = new LanguageAdapter(this, mLanguageList);
        spinnerLanguages.setAdapter(nAdapter);

        spinnerCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                GradeItem clickedItem = (GradeItem) parent.getItemAtPosition(position);
                stnn = clickedItem.getGradeName();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerLanguages.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                LanguageItem clickedItem = (LanguageItem) parent.getItemAtPosition(position);
                stnl = clickedItem.getLanguageName();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        etadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sta = tva1.getText().toString();
                stb = tva2.getText().toString();
                stc = tva3.getText().toString();
                std = tva4.getText().toString();
                sc = tvc.getText().toString();

                String name = etname.getText().toString();
                String grade = stnn;
                String language = stnl;
                String phone = etemail.getText().toString();
                String password = etpassword.getText().toString();
                String is_admin = "0";

                int gra = Integer.valueOf(stnn);

                if(gra == 8) {
                    int stncc = Integer.valueOf(sta);
                    int stca = stncc + 1;
                    stnc = String.valueOf(stca);

                    int sca = Integer.valueOf(sc);
                    int sca1 = sca + 1;
                    scounta = String.valueOf(sca1);

                    String stc = stnc;
                    String scount =scounta;

                    if(isValied(name,phone,password)){
                        addclasses(name,grade,language,phone,password,is_admin,stc,scount);
                    }
                }

                if(gra == 9) {
                    int stncc = Integer.valueOf(stb);
                    int stca = stncc + 1;
                    stnc = String.valueOf(stca);

                    int sca = Integer.valueOf(sc);
                    int sca1 = sca + 1;
                    scounta = String.valueOf(sca1);

                    String stc = stnc;
                    String scount =scounta;

                    if(isValied(name,phone,password)){
                        addclasses(name,grade,language,phone,password,is_admin,stc,scount);
                    }
                }

                if(gra == 10) {
                    int stncc = Integer.valueOf(stc);
                    int stca = stncc + 1;
                    stnc = String.valueOf(stca);

                    int sca = Integer.valueOf(sc);
                    int sca1 = sca + 1;
                    scounta = String.valueOf(sca1);

                    String stc = stnc;
                    String scount =scounta;

                    if(isValied(name,phone,password)){
                        addclasses(name,grade,language,phone,password,is_admin,stc,scount);
                    }
                }

                if(gra == 11) {
                    int stncc = Integer.valueOf(std);
                    int stca = stncc + 1;
                    stnc = String.valueOf(stca);

                    int sca = Integer.valueOf(sc);
                    int sca1 = sca + 1;
                    scounta = String.valueOf(sca1);

                    String stc = stnc;
                    String scount = scounta;

                    if(isValied(name,phone,password)){
                        addclasses(name,grade,language,phone,password,is_admin,stc,scount);
                    }
                }


            }


        });

        etlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(register.this,login.class);
                startActivity(intent);
            }


        });

    }
    private void initList() {
        mGradeList = new ArrayList<>();

        mGradeList.add(new GradeItem("Grade 06", "6"));
        mGradeList.add(new GradeItem("Grade 07", "7"));
        mGradeList.add(new GradeItem("Grade 08", "8"));
        mGradeList.add(new GradeItem("Grade 09", "9"));
        mGradeList.add(new GradeItem("Grade 10", "10"));
        mGradeList.add(new GradeItem("Grade 11", "11"));
    }

    private void initList1() {
        mLanguageList = new ArrayList<>();

        mLanguageList.add(new LanguageItem("ENGLISH", "en"));
        mLanguageList.add(new LanguageItem("සිංහල", "sin"));
        mLanguageList.add(new LanguageItem("தமிழ்", "t"));
    }

    private boolean isValied(String name, String phone, String password) {

        if(name.isEmpty()){
            showMessage("Please Enter User Name ");
            return false;
        }
        if(name.length() > 20){
            showMessage("User Name Is Too Long ");
            return false;
        }

        if(phone.isEmpty()){
            showMessage("Please Enter the Mobile Number");
            return false;
        }
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

        return true;
    }

    private void showMessage(String msg) {
        makeText(this,msg, LENGTH_SHORT).show();
    }

    private void addclasses( final String name,final String grade,final String language, final String phone, final  String password, final String is_admin, final String stc, final String scount ){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endspoint.register_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("success")) {

                    makeText(register.this," Registration Successfully", LENGTH_SHORT).show();
                    progressBaradd.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(register.this,login.class);
                    startActivity(intent);

                }
                else {
                    makeText(register.this,"User Name Already Exists", LENGTH_SHORT).show();
                    progressBaradd.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(register.this,register.class);
                    startActivity(intent);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                makeText(register.this, "Please check your Internet Connection", LENGTH_SHORT).show();
                Log.d("VOLLEY", error.getMessage());

                Intent intent = new Intent(register.this,register.class);
                startActivity(intent);

            }
        }){
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name",name);
                params.put("grade", grade);
                params.put("language", language);
                params.put("phone", phone);
                params.put("password",password);
                params.put("is_admin",is_admin);
                params.put("stc",stc);
                params.put("scount",scount);
                return  params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

    protected void onResume(){
        super.onResume();
        loadSession1();
    }
    public void loadSession1(){

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zgetstca.php", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tva1.setText(response.getString("stnc"));
                        } catch (JSONException e){
                            e.printStackTrace();;
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        VolleySingleton.getInstance(register.this).addToRequestQueue(jsonObjectRequest)   ;

        JsonObjectRequest jsonObjectRequest1 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zgetstcb.php", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tva2.setText(response.getString("stnc"));
                        } catch (JSONException e){
                            e.printStackTrace();;
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        VolleySingleton.getInstance(register.this).addToRequestQueue(jsonObjectRequest1)   ;

        JsonObjectRequest jsonObjectRequest2 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zgetstcc.php", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tva3.setText(response.getString("stnc"));
                        } catch (JSONException e){
                            e.printStackTrace();;
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        VolleySingleton.getInstance(register.this).addToRequestQueue(jsonObjectRequest2)   ;

        JsonObjectRequest jsonObjectRequest3 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zgetstcd.php", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tva4.setText(response.getString("stnc"));
                        } catch (JSONException e){
                            e.printStackTrace();;
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        VolleySingleton.getInstance(register.this).addToRequestQueue(jsonObjectRequest3)   ;


        JsonObjectRequest jsonObjectRequest5 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zgettotalst.php", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tvc.setText(response.getString("count"));
                        } catch (JSONException e){
                            e.printStackTrace();;
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        VolleySingleton.getInstance(register.this).addToRequestQueue(jsonObjectRequest5)   ;



    }




}