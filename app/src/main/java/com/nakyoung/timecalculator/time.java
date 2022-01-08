package com.nakyoung.timecalculator;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class time {

    private final String TAG = "시간 계산";

    public static int hour = 0;
    public static int min = 0;
    public static int sec = 0;


    //더하기
    //이용시 계산 순서는 초->분->시 로 한다

    //시간 더하기
    public static void addHour(int _hour){
        time.hour += _hour;
    }

    //분 더하기
    public static void addMin(int _min){
        time.min += _min;

        //결과가 60분 이상일 시
        if (time.min >= 60){
            time.hour += time.min/60;
            time.min = time.min%60;
        }
    }

    //초 더하기
    public static void addSec(int _sec){
        time.sec += _sec;

        //결과가 60초 이상일 시
        if (time.sec >= 60){
            time.min += time.sec/60;
            time.sec = time.sec%60;
        }
    }


    //빼기
    //이용시 계산 순서는 초->분->시 로 한다

    //시간 빼기
    public static int subHour(int _hour){
        //뺀 값이 음수일시 최고값인 시간이 음수일 수 없음
        if (time.hour - _hour <0){
            return -1;
        }

        time.hour -= _hour;
        return 0;
    }

    //분 빼기
    public static int subMin(int _min){

        if(min - _min < 0) {
            if (time.hour > 0) {
                --hour;
                min = min + 60 - _min;
            }else{//뺀 값이 음수일 수 없음
                return -1;
            }
        }

        return 0;
    }

    //초 빼기
    public static int subSec(int _sec){
        if(sec - _sec < 0) {
            if (time.min > 0) {
                --min;
                sec = sec + 60 - _sec;
            }else if(time.hour>0) {
                --hour;
                min += 59;
                sec = sec + 60 - _sec;
            }else{//뺀 값이 음수일 수 없음
                return -1;
            }
        }

        return 0;
    }


    public static void setHour(int hour) {
        time.hour = hour;
    }


    public static void setMin(int min) {
        time.min = min;
    }

    public static void setSec(int sec) {
        time.sec = sec;
    }

    public static int getHour(){
        return hour;
    }

    public static int getMin(){
        return min;
    }

    public static int getSec() {
        return sec;
    }

}
