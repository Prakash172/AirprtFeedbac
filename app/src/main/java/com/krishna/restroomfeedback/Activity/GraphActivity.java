package com.krishna.restroomfeedback.Activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.krishna.restroomfeedback.Activity.DataModel.MyAxisFormatter;
import com.krishna.restroomfeedback.Activity.DataModel.MyFormatter;
import com.krishna.restroomfeedback.Database.MyDatabase;
import com.krishna.restroomfeedback.R;

import java.util.ArrayList;
import java.util.List;

public class GraphActivity extends Activity {
    private static final String TAG = "GraphActivity";
    ArrayList<Entry> entries ;
//    MEntry entry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        entries = new ArrayList<>();
        LineChart chart = findViewById(R.id.charts);

        chart.getDescription().setEnabled(false);
//        chart.setBackgroundColor(Color.parseColor(""));
//        chart.setMaxVisibleValueCount(10);
        // database code
        MyDatabase database = new MyDatabase(this);
        Cursor c = database.selectRecords();
        int value = c.getColumnIndex("value");

        int count = c.getCount();
        float sum = 0;
        int index = 1;
        List<Entry> dataObject = new ArrayList<Entry>();
       while(count!=0){
           count--;
           Log.i(TAG, "onCreate: count "+count +" value : "+c.getInt(value));
           dataObject.add(new Entry(index,6-c.getInt(value)));
           sum+=(6-c.getInt(value));
           c.moveToNext();
           index++;

       }

        LineDataSet lineDataSet = new LineDataSet(dataObject,"Feedback chart");
        lineDataSet.setCircleColor(Color.RED);
        lineDataSet.setCircleColorHole(Color.parseColor("#9C27B0"));
        lineDataSet.setValueTextColor(Color.RED);
        lineDataSet.setColor(Color.parseColor("#9C27B0"));
        lineDataSet.setValueFormatter(new MyFormatter());
        lineDataSet.setValueTextSize(10);
        lineDataSet.setDrawValues(false);


        YAxis yAxis = chart.getAxisLeft();
        yAxis.setAxisMinimum(1f);
        yAxis.setAxisMaximum(5f);
        yAxis.setTextColor(Color.RED);
        yAxis.setGranularity(1f);
        yAxis.setValueFormatter(new MyAxisFormatter());


//        yAxis.setSpaceMax(1f);
//        yAxis.setSpaceMin(1f);

        YAxis yr = chart.getAxisRight();
        yr.setEnabled(false);
        XAxis xt = chart.getXAxis();
        xt.setGranularity(5f);
        xt.setEnabled(false);
//        xt.setGranularity(5f);

        float avg = sum / c.getCount();
        LimitLine ly = new LimitLine(avg,"Feedback noted("+c.getCount()+")\n Average : "+avg);
        ly.setLineColor(Color.RED);
        ly.setLineWidth(1f);
        ly.setTextColor(Color.DKGRAY);
        ly.setTextSize(10f);
        ly.enableDashedLine(10f,5f,0);
        yAxis.addLimitLine(ly);

        XAxis xAxis = chart.getXAxis();
        xAxis.setAxisMinimum(1f);
        xAxis.setAxisMaximum(c.getCount());


        Legend legend = chart.getLegend();
        legend.setForm(Legend.LegendForm.SQUARE);
        legend.setYEntrySpace(20);
        legend.setEnabled(true);


        LineData data = new LineData(lineDataSet);
        chart.setData(data);
        chart.invalidate();

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Intent intent = new Intent(this,HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        return super.onKeyDown(keyCode, event);

    }

    private void calculateAvg(){

    }
}
