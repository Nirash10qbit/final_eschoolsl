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
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class analysesub extends AppCompatActivity {

    String st1,st2,st3,st4,stn, sta,staname,sl1,sl2,sl3,sl4,sl5,stnc;
    TextView tv1,tv2,tv3,tv4,tvgr,tvl1,tvl2,tvl3,tvl4,tvl5,tvl6,tv3a,tvf;
    ListView lv;

    BarChart barChart;
    ArrayList<BarEntry> barEntryArrayList;
    ArrayList<String> labelsNames;
    ArrayList<chartMarks> chartMarksArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysesub);

        tv3a = findViewById(R.id.tv3a);
        stnc = getIntent().getExtras().getString("stnc");
        tv3a.setText(stnc);

        tvl1 = findViewById(R.id.l1);
        tvl2 = findViewById(R.id.l2);
        tvl3 = findViewById(R.id.l3);
        tvl4 = findViewById(R.id.l4);
        tvl5 = findViewById(R.id.l5);
        tvl6 = findViewById(R.id.subm);

        tvf = findViewById(R.id.tvf);

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
                barChart.animateY(100);
                barChart.invalidate();
            }
        },3000);

        stn = getIntent().getExtras().getString("uname");
        sta = getIntent().getExtras().getString("aid");
        tvgr = findViewById(R.id.tvgr);
        staname = getIntent().getExtras().getString("aname");
        tvgr.setText(staname);

        lv = findViewById(R.id.sublist);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                stnc = getIntent().getExtras().getString("stnc");

                tv1 = view.findViewById(R.id.tvbid);
                st1 = tv1.getText().toString();

                tv2 = view.findViewById(R.id.tvbname);
                st2 = tv2.getText().toString();

                tv3 = view.findViewById(R.id.tvbtotal);
                st3 = tv3.getText().toString();

                tv4 = view.findViewById(R.id.tvbstn);
                st4 = tv4.getText().toString();



                Intent intent = new Intent(analysesub.this,analyseact.class);
                intent.putExtra("uname", stn);
                intent.putExtra("aid",sta);
                intent.putExtra("aname",staname);
                intent.putExtra("bid",st1);
                intent.putExtra("bname",st2);
                intent.putExtra("btotal",st3);
                intent.putExtra("stnc",stnc);
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


        chartMarksArrayList.add(new chartMarks ("1-20",l1));
        chartMarksArrayList.add(new chartMarks ("21-40",l2));
        chartMarksArrayList.add(new chartMarks ("41-60",l3));
        chartMarksArrayList.add(new chartMarks ("61-80",l4));
        chartMarksArrayList.add(new chartMarks ("81-100",l5));
    }

    public void backanalysesub(View view) {
        Intent intent = new Intent(this, analyse.class);
        intent.putExtra("uname", stn);
        startActivity(intent);
        finish();
    }

    protected void onResume() {
        super.onResume();
        loadSession();
    }

    public void loadSession() {

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://eschoolslgit1.000webhostapp.com/sub.php?aid=" + sta + " ";

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
                        Toast.makeText(analysesub.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
                        Log.d("VOLLEY", error.getMessage());


                    }
                });

        queue.add(request);

        JsonObjectRequest jsonObjectRequest2 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zgetlabsub.php?aid="+sta+"&&bid=3", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tvl1.setText(response.getString("sa"));
                            tvl2.setText(response.getString("sb"));
                            tvl3.setText(response.getString("sc"));
                            tvl4.setText(response.getString("sd"));
                            tvl5.setText(response.getString("se"));
                            tvl6.setText(response.getString("btotal"));
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

        VolleySingleton.getInstance(analysesub.this).addToRequestQueue(jsonObjectRequest2)   ;

        JsonObjectRequest jsonObjectRequest6 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zgsub.php?aid="+sta+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tvf.setText(response.getString("ng"));
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
        VolleySingleton.getInstance(analysesub.this).addToRequestQueue(jsonObjectRequest6);

    }

    public void setSessions(JSONArray response) {
        List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try {
            for (int i = 0; i < response.length(); i++) {
                JSONObject obj = response.getJSONObject(i);
                HashMap<String, String> map = new HashMap<>();

                map.put("bid", obj.getString("bid"));
                map.put("sf", obj.getString("sf"));
                map.put("bname", obj.getString("bname"));
                map.put("btotal", obj.getString("btotal"));

                list.add(map);
            }
            //1.layout file
            int layout = R.layout.zanalysesub;
            //2.views
            int[] views = {R.id.tvbid, R.id.tvbstn,R.id.tvbname , R.id.tvbtotal};
            //3.Columms
            String[] columns = {"bid", "sf","bname", "btotal"};

            SimpleAdapter adapter = new SimpleAdapter(this, list, layout, columns, views);
            lv.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

