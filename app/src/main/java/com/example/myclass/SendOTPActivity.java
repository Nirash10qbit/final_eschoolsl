package com.example.myclass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.TimeUnit;

public class SendOTPActivity extends AppCompatActivity {

    String stn;
    TextView inputMobile,tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_o_t_p);

        tv = findViewById(R.id.tv);
        stn = getIntent().getExtras().getString("uname");
        tv.setText(stn);



        inputMobile = findViewById(R.id.inputMobile);
        final Button buttonGetOTP = findViewById(R.id.buttonGetOTP);

        final ProgressBar progressBar = findViewById(R.id.progressBar);

        buttonGetOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                buttonGetOTP.setVisibility(View.INVISIBLE);


                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+94"+ inputMobile.getText().toString(),
                        60,
                        TimeUnit.SECONDS,
                        SendOTPActivity.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                progressBar.setVisibility(View.GONE);
                                buttonGetOTP.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                progressBar.setVisibility(View.GONE);
                                buttonGetOTP.setVisibility(View.VISIBLE);
                                Toast.makeText(SendOTPActivity.this,"Error",Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                progressBar.setVisibility(View.GONE);
                                buttonGetOTP.setVisibility(View.VISIBLE);
                                Intent intent = new Intent(getApplicationContext(),VerifyOTPActivity.class);
                                intent.putExtra("mobile",inputMobile.getText().toString());
                                intent.putExtra("verificationId",verificationId);
                                intent.putExtra("uname",stn);
                                startActivity(intent);
                            }
                        }
                );
            }
        });
    }

    protected void onResume(){
        super.onResume();
        loadSession();
    }
    public void loadSession() {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/phone.php?name="+ stn+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            inputMobile.setText(response.getString("phone"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                            ;
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SendOTPActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        });

        VolleySingleton.getInstance(SendOTPActivity.this).addToRequestQueue(jsonObjectRequest);
    }
}