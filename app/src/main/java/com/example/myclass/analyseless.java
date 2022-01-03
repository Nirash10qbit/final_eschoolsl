package com.example.myclass;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
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
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class analyseless extends AppCompatActivity {

    String stz,st2,stn, sta,staname, stb,stbname,total,sl1,sl2,sl3,sl4,sl5,stnc;
    TextView tvsu,tvto,tvl1,tvl2,tvl3,tvl4,tvl5,tvl6,tv20;

    BarChart barChart;
    ArrayList<BarEntry> barEntryArrayList;
    ArrayList<String> labelsNames;
    ArrayList<chartMarks> chartMarksArrayList = new ArrayList<>();
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyseless);

        tvl1 = findViewById(R.id.l1);
        tvl2 = findViewById(R.id.l2);
        tvl3 = findViewById(R.id.l3);
        tvl4 = findViewById(R.id.l4);
        tvl5 = findViewById(R.id.l5);
        tvl6 = findViewById(R.id.l6);
        tv20 = findViewById(R.id.l7);

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
                barDataSet.setValueTextColors(Collections.singletonList(Color.WHITE));

                xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
                xAxis.setDrawGridLines(false);
                xAxis.setDrawAxisLine(false);
                xAxis.setGranularity(1f);
                xAxis.setLabelCount(labelsNames.size());
                xAxis.setLabelRotationAngle(270);
                barChart.animateY(100);
                barChart.invalidate();

                barChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                    @Override
                    public void onValueSelected(Entry e, Highlight h) {

                        int x = barChart.getBarData().getDataSetForEntry(e).getEntryIndex((BarEntry)e);

                        String subject = chartMarksArrayList.get(x).getSubject();
                        String mark = NumberFormat.getNumberInstance().format(chartMarksArrayList.get(x).getMarks()) ;
                        AlertDialog.Builder builder = new AlertDialog.Builder(analyseless.this);
                        builder.setCancelable(true);
                        View nview = LayoutInflater.from(analyseless  .this).inflate(R.layout.chart_stn,null);
                        TextView marks = nview.findViewById(R.id.stm);
                        TextView nostn = nview.findViewById(R.id.stn);

                        marks.setText(subject);
                        nostn.setText(mark);
                        builder.setView(nview);
                        alertDialog = builder.create();
                        alertDialog.show();
                    }

                    @Override
                    public void onNothingSelected() {

                    }
                });

            }
        },3000);

        stn = getIntent().getExtras().getString("uname");
        stnc = getIntent().getExtras().getString("stnc");
        sta = getIntent().getExtras().getString("aid");
        staname = getIntent().getExtras().getString("aname");
        stb = getIntent().getExtras().getString("bid");

        stz= getIntent().getExtras().getString("zid");
        stbname = getIntent().getExtras().getString("bname");
        tvsu = findViewById(R.id.tvsu);
        stbname = getIntent().getExtras().getString("zname");
        tvsu.setText(stbname);

        tvto = findViewById(R.id.subm);
        total = getIntent().getExtras().getString("ztotal");
        tvto.setText( total);




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

    public void backanalyseact(View view) {
        Intent intent = new Intent(this, analyseact.class);
        intent.putExtra("uname", stn);
        intent.putExtra("aid",sta);
        intent.putExtra("aname",staname);
        intent.putExtra("bid",stb);
        intent.putExtra("bname",stbname);
        intent.putExtra("stnc",stnc);
        startActivity(intent);
        finish();
    }
    protected void onResume() {
        super.onResume();
        loadSession();
    }

    public void loadSession() {

        JsonObjectRequest jsonObjectRequest4 = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/getgrade.php?aid="+sta+"", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tv20.setText(response.getString("stnc"));
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


        VolleySingleton.getInstance(analyseless.this).addToRequestQueue(jsonObjectRequest4)   ;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "https://eschoolslgit1.000webhostapp.com/zgetlabact.php?aid="+sta+"&&bid="+stb+"&&zid="+stz+"", null,

                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            tvl1.setText(response.getString("aa"));
                            tvl2.setText(response.getString("ab"));
                            tvl3.setText(response.getString("ac"));
                            tvl4.setText(response.getString("ad"));
                            tvl5.setText(response.getString("ae"));
                            tvl6.setText(response.getString("zstn"));

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

        VolleySingleton.getInstance(analyseless.this).addToRequestQueue(jsonObjectRequest)   ;
    }
}
