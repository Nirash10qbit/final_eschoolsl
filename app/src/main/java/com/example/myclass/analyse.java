package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class analyse extends AppCompatActivity {

    String stn,st1,st2,sl1,sl2,sl3,sl4,sl5,st3;
    TextView tv1,tv2,tva1,tva2,tva3,tvl1,tvl2,tvl3,tvl4,tvl5,tvc,tvf,tv3;
    ListView lv;

    BarChart barChart;
    ArrayList<BarEntry> barEntryArrayList;
    ArrayList<String> labelsNames;
    ArrayList<chartMarks> chartMarksArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyse);


        tvl1 =findViewById(R.id.l1);
        tvl2 =findViewById(R.id.l2);
        tvl3 =findViewById(R.id.l3);
        tvl4 =findViewById(R.id.l4);
        tvl5 =findViewById(R.id.l5);

        tvf =findViewById(R.id.tvf);

        tvc =findViewById(R.id.count);

        barChart = findViewById(R.id.barChart);

        barEntryArrayList = new ArrayList<>();
        labelsNames =  new ArrayList<>();


        Handler handler = new Handler ();
        handler.postDelayed (new Runnable ( ) {
            @Override
            public void run() {
                fillmarks();

                for(int i=0; i< chartMarksArrayList.size(); i++){
                    String subject = chartMarksArrayList.get(i).getSubject();
                    int marks = chartMarksArrayList.get(i).getMarks();
                    barEntryArrayList.add(new BarEntry(i,marks));
                    labelsNames.add(subject);


                }
                BarDataSet barDataSet = new BarDataSet(barEntryArrayList, "");
               // barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                Description description = new Description();
                description.setText("Marks");
                barChart.setDescription(description);
                BarData barData = new BarData(barDataSet);
                barChart.setData(barData);

                XAxis xAxis = barChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(labelsNames));

                xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
                xAxis.setDrawGridLines(false);
                xAxis.setDrawAxisLine(false);
                xAxis.setGranularity(1f);
                xAxis.setLabelCount(labelsNames.size());
                xAxis.setLabelRotationAngle(270);
                barChart.animateY(10000);
                barChart.invalidate();
            }
        },3000);


        tva1 =findViewById(R.id.tva1);
        tva2 =findViewById(R.id.tva2);
        tva3 =findViewById(R.id.tva3);


        lv = findViewById(R.id.gradelist);

        stn = getIntent().getExtras().getString("uname");

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                tv1 = view.findViewById(R.id.tvaid);
                st1 = tv1.getText().toString();

                tv2 = view.findViewById(R.id.tvaidname);
                st2 = tv2.getText().toString();

                tv3 = view.findViewById(R.id.tvstnc);
                st3 = tv3.getText().toString();



                Intent intent = new Intent(analyse.this,analysesub.class);
                    intent.putExtra("uname", stn);
                    intent.putExtra("aid",st1);
                    intent.putExtra("aname",st2);
                    intent.putExtra("stnc",st3);
                    startActivity(intent);
            }
        });
    }

    private void fillmarks () {
        chartMarksArrayList.clear();

        sl1 = tvl1.getText().toString();
        sl2 = tvl2.getText().toString();
        sl3 = tvl3.getText().toString();
        sl4 = tvl4.getText().toString();
        sl5 = tvl5.getText().toString();

        int l1 = Integer.valueOf(sl1);
        int l2 = Integer.valueOf(sl2);
        int l3 = Integer.valueOf(sl3);
        int l4 = Integer.valueOf(sl4);
        int l5 = Integer.valueOf(sl5);


        chartMarksArrayList.add(new chartMarks ("0-20",l1));
        chartMarksArrayList.add(new chartMarks ("21-40",l2));
        chartMarksArrayList.add(new chartMarks ("41-60",l3));
        chartMarksArrayList.add(new chartMarks ("61-80",l4));
        chartMarksArrayList.add(new chartMarks ("81-100",l5));
    }

    public void backanalyse(View view){
        Intent intent = new Intent(this,menus.class);
        intent.putExtra("uname", stn);
        startActivity(intent);
        finish();
    }
    protected void onResume(){
        super.onResume();
        loadSession1();
        loadSession();
    }
    public void loadSession1() {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/getdata.php", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tva1.setText(response.getString("tstn"));
                            tva2.setText(response.getString("tmarks"));
                            tva3.setText(response.getString("ttotal"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                            ;
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        VolleySingleton.getInstance(analyse.this).addToRequestQueue(jsonObjectRequest);


        JsonObjectRequest jsonObjectRequest2 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zgetlab.php", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tvl1.setText(response.getString("la"));
                            tvl2.setText(response.getString("lb"));
                            tvl3.setText(response.getString("lc"));
                            tvl4.setText(response.getString("ld"));
                            tvl5.setText(response.getString("le"));
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

        VolleySingleton.getInstance(analyse.this).addToRequestQueue(jsonObjectRequest2)   ;

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

        VolleySingleton.getInstance(analyse.this).addToRequestQueue(jsonObjectRequest5)   ;

        JsonObjectRequest jsonObjectRequest6 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zfsub.php?bid=3", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tvf.setText(response.getString("nf"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                error.printStackTrace();
            }
        });
        VolleySingleton.getInstance(analyse.this).addToRequestQueue(jsonObjectRequest6);


    }


    public void loadSession(){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://eschoolslgit1.000webhostapp.com/grade.php?";

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
                        Toast.makeText(analyse.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
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

                map.put("aid",obj.getString("aid"));
                map.put("aname",obj.getString("aname"));
                map.put("stnc",obj.getString("stnc"));

                list.add(map);
            }
            //1.layout file
            int layout= R.layout.zgrade;
            //2.views
            int[] views = {R.id.tvaid,R.id.tvaidname,R.id.tvstnc};
            //3.Columms
            String[]  columns = {"aid","aname","stnc"};

            SimpleAdapter adapter = new SimpleAdapter(this, list, layout, columns, views);
            lv.setAdapter(adapter);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}