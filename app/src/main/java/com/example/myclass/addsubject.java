package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class addsubject extends AppCompatActivity {

    EditText etsidname;
    Button etadd;
    ProgressBar progressBaradd;

    String st,st1,stn,said,stsn,stsi;
    private ArrayList<SubjectItem> mSubjectList;
    private SubjectAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addsubject);

        initList2();

        Spinner spinnerSubjects = findViewById(R.id.spinner_subject);
        mAdapter = new SubjectAdapter(this, mSubjectList);
        spinnerSubjects.setAdapter(mAdapter);

        spinnerSubjects.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SubjectItem clickedItem = (SubjectItem) parent.getItemAtPosition(position);
                stsi = clickedItem.getViewSubject();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        stn = getIntent().getExtras().getString("uname");

        progressBaradd = findViewById(R.id.progressBaradd);
        progressBaradd.setVisibility(View.INVISIBLE);

        etadd = findViewById(R.id.radd);

        st = getIntent().getExtras().getString("value");
        st1 = getIntent().getExtras().getString("gid");
        said = getIntent().getExtras().getString("aid");

        etsidname = findViewById(R.id.sidname);

        etadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String aid = said;
                String gid = st1;
                String bid = stsi;
                String sidname = etsidname.getText().toString();
                String sidpdf = "0";


                if(isValied(sidname)){
                    addclasses(aid,gid,bid,sidname,sidpdf);
                }
            }


        });

    }

    private void initList2() {
        mSubjectList = new ArrayList<>();

        mSubjectList.add(new SubjectItem("1", "BUDDHIST"));
        mSubjectList.add(new SubjectItem("2", "SCIENCE"));
        mSubjectList.add(new SubjectItem("3", "MATHS"));
        mSubjectList.add(new SubjectItem("4", "SINHALA"));
        mSubjectList.add(new SubjectItem("5", "HISTORY"));
        mSubjectList.add(new SubjectItem("6", "ENGLISH"));
        mSubjectList.add(new SubjectItem("7", "TAMIL"));
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



    private void addclasses( final String aid,final String gid,final String bid,final  String sidname, final String sidpdf ){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endspoint.addsub_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("success")) {

                    Toast.makeText(addsubject.this," Successfully Access data", Toast.LENGTH_SHORT).show();
                    progressBaradd.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(addsubject.this,subject.class);
                    intent.putExtra("uname", stn);
                    intent.putExtra("value",st);
                    intent.putExtra("gid",st1);
                    intent.putExtra("aid",said);
                    intent.putExtra("aid",said);
                    startActivity(intent);

                }
                else {
                    Toast.makeText(addsubject.this,"Successfully Access data", Toast.LENGTH_SHORT).show();
                    progressBaradd.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(addsubject.this,subject.class);
                    intent.putExtra("uname", stn);
                    intent.putExtra("value",st);
                    intent.putExtra("gid",st1);
                    intent.putExtra("aid",said);
                    intent.putExtra("aid",said);
                    startActivity(intent);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(addsubject.this, "Please check your Internet Connection",Toast.LENGTH_SHORT).show();
                Log.d("VOLLEY", error.getMessage());
                progressBaradd.setVisibility(View.VISIBLE);
                Intent intent = new Intent(addsubject.this,addsubject.class);
                intent.putExtra("uname", stn);
                intent.putExtra("value",st);
                intent.putExtra("gid",st1);
                intent.putExtra("aid",said);
                intent.putExtra("aid",said);
                startActivity(intent);

            }
        }){
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("aid",aid);
                params.put("gid",gid);
                params.put("bid",bid);
                params.put("sidname",sidname);
                params.put("sidpdf",sidpdf);

                return  params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

    public void backsub(View view){
        Intent intent = new Intent (addsubject.this,subject.class);
        intent.putExtra("uname", stn);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        intent.putExtra("aid",said);
        startActivity(intent);
    }

}