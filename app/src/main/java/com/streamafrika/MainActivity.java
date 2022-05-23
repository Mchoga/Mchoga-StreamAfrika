package com.streamafrika;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView bannerRecycler,categoryRecycler;
    RecyclerView.Adapter bannerAdapter,categoryAdapter;
    Gson gson = new Gson();



    String categories[] = {"Action",
            "Comedy",
            "Drama",
            "Fantasy",
            "Horror",
            "Mystery",
            "Romance",
            "Thriller"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// the below two lines want to give me a headache :(
        LoadMovies banner = new LoadMovies(getApplicationContext(),"https://yts.torrentbay.to/api/v2/list_movies.json?limit=40",bannerAdapter); //if this is on top, im unable to pass (bannerAdapter) in the constructor since it has not been instantiated.
        bannerAdapter = new BannerAdapter(getApplicationContext(),banner.movieList()); //if i put this on top i am unable to pass (movielist) in the adapter

        bannerRecycler = findViewById(R.id.recyclerView);
            categoryRecycler = findViewById(R.id.recyclerView2);
            RequestQueue requestque = Volley.newRequestQueue(getApplicationContext());
            categoryAdapter = new CategoriesAdapter(this,categories);

            LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            bannerRecycler.setLayoutManager(layoutManager);
            categoryRecycler.setLayoutManager(new LinearLayoutManager(this));
            bannerRecycler.setAdapter(bannerAdapter);
            categoryRecycler.setAdapter(categoryAdapter);



    }


}


