package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class zlabgamed extends AppCompatActivity {

    String st,st0,st1,st2,st3,st4,st5,st6,st8,st9,st10,ca,cb,cc,cd,stn,stl,stg,sta,stb,stz,stqa,stqb,stqc,stqd,stqe,staa,stab,stac,stad,stae,totalc,totald,ra,rb,rc,rd;
    TextView tv1,tv2,tv3,tv4,tv8,tv9,tv10,tv11;
    ImageView imageView1;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zlabgamed);

        stqd = getIntent().getExtras().getString("zqd");
        imageView1 = findViewById(R.id.image1);
        String url1 = stqd;
        Picasso.with(this).load(url1).into(imageView1);


        stn = getIntent().getExtras().getString("uname");
        stl = getIntent().getExtras().getString("language");
        stg = getIntent().getExtras().getString("grade");

        st = getIntent().getExtras().getString("value");
        st1= getIntent().getExtras().getString("gid");
        st2 = getIntent().getExtras().getString("SIDNAME");
        st3 = getIntent().getExtras().getString("SID");
        st4 = getIntent().getExtras().getString("CIDNAME");
        st5 = getIntent().getExtras().getString("CID");

        st6 = getIntent().getExtras().getString("CPDF");
        st0 = getIntent().getExtras().getString("SIDPDF");
        sta = getIntent().getExtras().getString("aid");
        stb = getIntent().getExtras().getString("bid");
        stz = getIntent().getExtras().getString("zid");
        stqa = getIntent().getExtras().getString("zqa");
        stqb = getIntent().getExtras().getString("zqb");
        stqc = getIntent().getExtras().getString("zqc");
        stqd = getIntent().getExtras().getString("zqd");
        stqe = getIntent().getExtras().getString("zqe");
        staa = getIntent().getExtras().getString("zaa");
        stab = getIntent().getExtras().getString("zab");
        stac = getIntent().getExtras().getString("zac");
        stad = getIntent().getExtras().getString("zad");
        stae = getIntent().getExtras().getString("zae");


        tv1 = findViewById(R.id.gidnew5);
        ra = getIntent().getExtras().getString("ra");
        tv1.setText(ra);
        tv3 = findViewById(R.id.gidnew8);
        rb = getIntent().getExtras().getString("rb");
        tv3.setText(rb);
        tv4 = findViewById(R.id.gidnew9);
        rc = getIntent().getExtras().getString("rc");
        tv4.setText(rc);

        ca = getIntent().getExtras().getString("ca");
        cb = getIntent().getExtras().getString("cb");
        cc = getIntent().getExtras().getString("cc");

        tv2 = findViewById(R.id.gidnew6);
        totalc = getIntent().getExtras().getString("totalc");
        tv2.setText(totalc);

        lv = findViewById(R.id.zgamelist);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {


                tv8 = view.findViewById(R.id.tvn);
                st8 = tv8.getText().toString();

                tv9 = view.findViewById(R.id.tvan);
                st9 = tv9.getText().toString();

                tv10 = view.findViewById(R.id.tvnn);
                st10 = tv10.getText().toString();

                tv11 = view.findViewById(R.id.tvca);
                cd = tv11.getText().toString();

                int leone = st8.length ();
                int letwo = st10.length ();

                if(leone == letwo){
                    rd ="0";

                    int tmaks = Integer.valueOf(totalc);
                    final int tbmarks = tmaks + 0;

                    totald = String.valueOf(tbmarks);

                    MediaPlayer mysong = MediaPlayer.create (zlabgamed.this,R.raw.omai);
                    mysong.start ();

                    LayoutInflater inflater = getLayoutInflater ();
                    View layout = inflater.inflate (R.layout.wrong,(ViewGroup)findViewById (R.id.wrong_laypout));

                    final Toast toast = new Toast (getApplicationContext ());
                    toast.setGravity (Gravity.CENTER_HORIZONTAL,0,0);
                    toast.setDuration (Toast.LENGTH_SHORT);
                    toast.setView (layout);
                    toast.show ();
                    Handler handler = new Handler();
                    handler.postDelayed (new Runnable ( ) {
                        @Override
                        public void run() {
                            Intent intent = new Intent(zlabgamed.this,zlabgamee.class);
                            intent.putExtra("uname", stn);
                            intent.putExtra("language", stl);
                            intent.putExtra("grade", stg);
                            intent.putExtra("value",st);
                            intent.putExtra("gid",st1);
                            intent.putExtra("SIDNAME",st2);
                            intent.putExtra("SID",st3);
                            intent.putExtra("SIDPDF",st0);
                            intent.putExtra("CID",st5);
                            intent.putExtra("CIDNAME",st4);
                            intent.putExtra("CPDF",st6);
                            intent.putExtra("aid",sta);
                            intent.putExtra("bid",stb);
                            intent.putExtra("zid",stz);
                            intent.putExtra("zqa",stqa);
                            intent.putExtra("zqb",stqb);
                            intent.putExtra("zqc",stqc);
                            intent.putExtra("zqd",stqd);
                            intent.putExtra("zqe",stqe);
                            intent.putExtra("zaa",staa);
                            intent.putExtra("zab",stab);
                            intent.putExtra("zac",stac);
                            intent.putExtra("zad",stad);
                            intent.putExtra("zae",stae);
                            intent.putExtra("totald", totald);
                            intent.putExtra("ra", ra);
                            intent.putExtra("rb", rb);
                            intent.putExtra("rc", rc);
                            intent.putExtra("rd", rd);
                            intent.putExtra("ca", ca);
                            intent.putExtra("cb", cb);
                            intent.putExtra("cc", cc);
                            intent.putExtra("cd", cd);

                            startActivity (intent);

                        }
                    },1500);

                }

                else {
                    rd ="20";

                    int tmaks = Integer.valueOf(totalc);
                    final int tbmarks = tmaks + 20;

                    totald = String.valueOf(tbmarks);

                    MediaPlayer mysong = MediaPlayer.create (zlabgamed.this,R.raw.mix);
                    mysong.start ();

                    LayoutInflater inflater = getLayoutInflater ();
                    View layout = inflater.inflate (R.layout.right,(ViewGroup)findViewById (R.id.right_layout));

                    final Toast toast = new Toast (getApplicationContext ());
                    toast.setGravity (Gravity.CENTER_HORIZONTAL,0,0);
                    toast.setDuration (Toast.LENGTH_SHORT);
                    toast.setView (layout);
                    toast.show ();

                    Handler handler = new Handler();
                    handler.postDelayed (new Runnable ( ) {
                        @Override
                        public void run() {
                            Intent intent = new Intent(zlabgamed.this,zlabgamee.class);
                            intent.putExtra("uname", stn);
                            intent.putExtra("language", stl);
                            intent.putExtra("grade", stg);
                            intent.putExtra("value",st);
                            intent.putExtra("gid",st1);
                            intent.putExtra("SIDNAME",st2);
                            intent.putExtra("SID",st3);
                            intent.putExtra("SIDPDF",st0);
                            intent.putExtra("CID",st5);
                            intent.putExtra("CIDNAME",st4);
                            intent.putExtra("CPDF",st6);
                            intent.putExtra("aid",sta);
                            intent.putExtra("bid",stb);
                            intent.putExtra("zid",stz);
                            intent.putExtra("zqa",stqa);
                            intent.putExtra("zqb",stqb);
                            intent.putExtra("zqc",stqc);
                            intent.putExtra("zqd",stqd);
                            intent.putExtra("zqe",stqe);
                            intent.putExtra("zaa",staa);
                            intent.putExtra("zab",stab);
                            intent.putExtra("zac",stac);
                            intent.putExtra("zad",stad);
                            intent.putExtra("zae",stae);
                            intent.putExtra("zma", st8);
                            intent.putExtra("totald", totald);
                            intent.putExtra("ra", ra);
                            intent.putExtra("rb", rb);
                            intent.putExtra("rc", rc);
                            intent.putExtra("rd", rd);
                            intent.putExtra("ca", ca);
                            intent.putExtra("cb", cb);
                            intent.putExtra("cc", cc);
                            intent.putExtra("cd", cd);

                            startActivity (intent);

                        }
                    },1500);
                }
            }
        });

    }


    protected void onResume(){
        super.onResume();
        loadSession();
    }

    public void loadSession(){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://eschoolslgit1.000webhostapp.com/simgame.php?gid="+st1+"&&cid="+st5+"";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        setSessions(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(zlabgamed.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
                        Log.d("VOLLEY", error.getMessage());
                    }
                });

        queue.add(request);
    }
    public void setSessions(JSONArray response){
        List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try{
            for(int i=0;i <response.length()  ;i++){
                JSONObject obj = response.getJSONObject(i);
                HashMap<String, String> map = new HashMap<>();

                map.put("nna",obj.getString("nna"));
                map.put("cd",obj.getString("cd"));
                map.put("nd",obj.getString("nd"));
                map.put("and",obj.getString("and"));

                list.add(map);
            }
            //1.layout file
            int layout= R.layout.gam;
            //2.views
            int[] views = {R.id.tvnn,R.id.tvca,R.id.tvn,R.id.tvan};
            //3.Columms
            String[]  columns = {"nna","cd","nd","and"};

            SimpleAdapter adapter = new SimpleAdapter(this, list, layout, columns, views);
            lv.setAdapter(adapter);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
