package com.streamafrika;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;




//Requestqueue requestque = Volley.newRequestQueue(getApplicationContext());
//RequestQueue requestque = VolleySingleton.getInstance(context).RequestQueue();

public class VolleySingleton {
    Context context;
    static VolleySingleton instance;
    RequestQueue requestqueue;

    private VolleySingleton(Context context) {
        requestqueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public static synchronized VolleySingleton getInstance(Context context){
        if (instance == null){
            instance = new VolleySingleton(context);
        }
        return instance;
    }


    public RequestQueue RequestQueue(){
        return requestqueue;
    }

}
