package com.nakyoung.timecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.nakyoung.timecalculator.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private time times;

    private Listview_CalResult_Adapter listview_calResult_adapter;

    private static String TAG = "MainActivity";

    private ActivityMainBinding activityMainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);

        Listview_CalResult initlistview = new Listview_CalResult("시작"," ","00시 00분 00초");
        List<Listview_CalResult> listview_calResults = new ArrayList<>();
        listview_calResults.add(initlistview);

        listview_calResult_adapter = new Listview_CalResult_Adapter(MainActivity.this, listview_calResults);
        activityMainBinding.calListView.setAdapter(listview_calResult_adapter);


        activityMainBinding.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plusButton();
            }
        });

        activityMainBinding.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minusButton();
            }
        });
    }


    public void plusButton() {
        int hour = 0; int min = 0; int sec = 0;


        try {
            hour = Integer.parseInt(activityMainBinding.hour.getText().toString());
        } catch (NumberFormatException nfe) {
            Log.e(TAG, "시간 미입력");
        }

        try{
            min = Integer.parseInt(activityMainBinding.min.getText().toString());
        }catch (NumberFormatException nfe) {
            Log.e(TAG, "분 미입력");
        }

        try{
            sec = Integer.parseInt(activityMainBinding.sec.getText().toString());
        }catch (NumberFormatException nfe) {
            Log.e(TAG, " 초 미입력");
        }

       Log.i(TAG, "hour: "+hour+ " min:" +min+ " sec:"+ sec);

        if (hour == 0 && min == 0 && sec == 0) {
            Log.e(TAG, "아무 값도 입력하지 않음");
            Toast.makeText(this, "값을 입력해주세요", Toast.LENGTH_SHORT);
            return;
        }

        times.addSec(sec);
        times.addMin(min);
        times.addHour(hour);

        listview_calResult_adapter.addItem(activityMainBinding.Name.getText().toString(), hour, min, sec, "+");
        listview_calResult_adapter.notifyDataSetChanged();
    }

    public void minusButton() {
        int hour = 0; int min = 0; int sec = 0;

        try {
            hour = Integer.parseInt(activityMainBinding.hour.getText().toString());
        } catch (NumberFormatException nfe) {
            Log.e(TAG, "시간 미입력");
        }

        try{
            min = Integer.parseInt(activityMainBinding.min.getText().toString());
        }catch (NumberFormatException nfe) {
            Log.e(TAG, "분 미입력");
        }

        try{
            sec = Integer.parseInt(activityMainBinding.sec.getText().toString());
        }catch (NumberFormatException nfe) {
            Log.e(TAG, " 초 미입력");
        }

        if (hour == 0 && min == 0 && sec == 0) {
            Log.e(TAG, "아무 값도 입력하지 않음");
            Toast.makeText(this, "값을 입력해주세요", Toast.LENGTH_SHORT);
            return;
        }

        if(times.subSec(sec) == -1 || times.subMin(min) == -1 || times.subHour(hour)== -1) {
            time.setHour(hour);
            time.setMin(min);
            time.setSec(sec);
            return;
        }

        listview_calResult_adapter.addItem(activityMainBinding.Name.getText().toString(), hour, min, sec, "-");



    }
}


