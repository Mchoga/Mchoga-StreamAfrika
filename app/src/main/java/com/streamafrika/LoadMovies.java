package com.streamafrika;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.util.Log;
import android.widget.Adapter;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LoadMovies {
     ArrayList<movie> movies = new ArrayList<>();
     Context context;


     public  LoadMovies(Context context, String url){

         RequestQueue requestqueue = VolleySingleton.getInstance(context).RequestQueue();//Volley.newRequestQueue(context);
            this.context = context;
            JsonObjectRequest object = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {

                    try {

                        JSONObject object = response.getJSONObject("data");
                        JSONArray array = object.getJSONArray("movies");

                        for (int x = 0; x < array.length(); x++) {
                            JSONObject movie = array.getJSONObject(x);
                            boolean available = false;
                            for (int y=0; y< movies.size();y++){
                                if(movies.get(y).id == movie.getInt("id")){
                                    available =true;
                                }

                            }
                            if (available == false) {
                                movies.add(new movie(movie.getString("title").toString(), movie.getString("summary").toString(),
                                        Integer.parseInt(movie.getString("year")),
                                        Float.valueOf(movie.getString("rating")), movie.getString("large_cover_image"), movie.getInt("id"), movie.getJSONArray("genres"), context));
                            }

                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    MainActivity.adapterNotifier();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(context, "Error Connecting", Toast.LENGTH_SHORT).show();
                }


            });
            requestqueue.add(object);
        }


        public ArrayList<movie> movieList(){
        return movies;
    }

}

