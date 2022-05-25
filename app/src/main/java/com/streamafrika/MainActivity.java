package com.streamafrika;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
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
    static RecyclerView.Adapter bannerAdapter,categoryAdapter;
    Gson gson = new Gson();





    String categories[] = {"Action",
            "Animation","Comedy",
            "Fantasy",
            "Horror",
            "Mystery",
            "Drama",
            "Documentary","Sci-Fi","Thriller","War","Romance",
            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LoadMovies banner = new LoadMovies(getApplicationContext(),"https://yts.torrentbay.to/api/v2/list_movies.json?quality=2160p");



            bannerRecycler = findViewById(R.id.recyclerView);
            categoryRecycler = findViewById(R.id.recyclerView2);

            RequestQueue requestque = Volley.newRequestQueue(getApplicationContext());
            categoryAdapter = new CategoriesAdapter(getApplicationContext(),categories);
            bannerAdapter = new BannerAdapter(getApplicationContext(),banner.movieList());



            bannerRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

            categoryRecycler.setLayoutManager(new LinearLayoutManager(this));
            bannerRecycler.setAdapter(bannerAdapter);
            categoryRecycler.setAdapter(categoryAdapter);





    }



    public static void adapterNotifier(){
        bannerAdapter.notifyDataSetChanged();

    }
}


