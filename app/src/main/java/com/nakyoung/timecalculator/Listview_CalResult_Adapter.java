package com.nakyoung.timecalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.List;

public class Listview_CalResult_Adapter extends BaseAdapter {


    private Context context;
    private List<Listview_CalResult> calResults = null;

    public Listview_CalResult_Adapter(Context contexts, List<Listview_CalResult> listview_calResults){
        this.context = contexts;
        this.calResults = listview_calResults;
    }





    @Override
    public int getCount() {
        return calResults.size();
    }

    @Override
    public Object getItem(int position) {
        return calResults.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_calresult, parent, false);
        }

        TextView name = (TextView)convertView.findViewById(R.id.name);
        TextView calProcess = (TextView)convertView.findViewById(R.id.calProcess);
        TextView calResult = (TextView)convertView.findViewById(R.id.calResult);

        Listview_CalResult item = calResults.get(position);

        name.setText(item.getName());
        calResult.setText(item.getCalResult());
        calProcess.setText(item.getCalProcess());

        return convertView;
    }

    //activity main 에서 가져올 hour, min, sec
    public void addItem(String name, int hour, int min, int sec, String operator){
        Listview_CalResult listview_calResult = new Listview_CalResult(name);
        listview_calResult.setCalProcess(hour, min, sec, operator);
        listview_calResult.setCalResult();
        calResults.add(listview_calResult);
    }
}

