package com.vitaliyhtc.rxjava2investigation.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public abstract class Utils {

    public Utils() {
        throw new AssertionError();
    }


    public static String rawTimeTo24String(int raw){
        int hour = raw / 60;
        int mins = raw % 60;
        return hour + ":" + mins;
    }
    public static int[] rawTimeTo24Int(int raw){
        int hour = raw / 60;
        int mins = raw % 60;
        return new int[]{hour, mins};
    }
    public static String rawTimeTo12String(int raw){
        int[] timein24Int = rawTimeTo24Int(raw);
        int h24 = timein24Int[0];
        int h12;
        if(0 == h24){
            h12 = 12;
        }else{
            if(h24 > 12){
                h12 = h24-12;
            }else{
                h12 = h24;
            }
        }
        String ampm;
        if(h24>=12){
            ampm = "PM";
        }else{
            ampm = "AM";
        }
        return ""+h12+":"+timein24Int[1]+" "+ampm;
    }



    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

}
