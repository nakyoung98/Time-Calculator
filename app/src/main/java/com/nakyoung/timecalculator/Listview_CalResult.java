package com.nakyoung.timecalculator;

import java.util.List;

public class Listview_CalResult {

    private static String befCalResult = "";

    private String name, calProcess;
    private String calResult;


    public Listview_CalResult(String _name){
        this.name = _name;
    }
    public Listview_CalResult(String _name, String _calResult, String _calProcess){
        this.name = _name;
        this.calResult = _calResult;
        this.calProcess = _calProcess;
    }

    public void setName(String _name){
        this.name = _name;
    }

    public void setCalResult(){
        this.calResult = time.getHour() +"시간 "+time.getMin() + "분 " + time.getSec() + "초";
        befCalResult = this.calResult.toString();
    }

    public void setCalProcess(int hour, int min, int sec, String operator){
        if(befCalResult == null){
            this.calProcess = operator +" "+ hour +"시간 "+min + "분 " + sec + "초";
        }
        this.calProcess = befCalResult +" "+ operator +" "+ hour +"시간 "+min + "분 " + sec + "초"; //03시간 23분 43초 + 00시간 32분 12초
    }

    public String getName() {
        return name;
    }

    public String getCalProcess(){
        return calProcess;
    }

    public String getCalResult(){
        return calResult;
    }
}
