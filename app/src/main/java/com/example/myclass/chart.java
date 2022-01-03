package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Collections;

import static com.github.mikephil.charting.utils.ColorTemplate.MATERIAL_COLORS;

public class chart extends AppCompatActivity {

    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;
    ArrayList barentries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        getData();

        barChart = findViewById(R.id.barChart);

        barDataSet = new BarDataSet(barentries,"Dataset");
        barData = new BarData(barDataSet);
        barChart.setData(barData);
        barDataSet.setValueTextSize(10);
        barDataSet.setValueTextColors(Collections.singletonList(Color.WHITE));
    }

    private void getData(){
        barentries = new ArrayList<>();

        barentries.add(new BarEntry(1f,2));
        barentries.add(new BarEntry(2f,0));
        barentries.add(new BarEntry(3f,7));
        barentries.add(new BarEntry(4f,2));
        barentries.add(new BarEntry(5f,3));
    }
}