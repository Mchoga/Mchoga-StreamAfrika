package com.streamafrika;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.itemHolder>{

    Context context;
    ArrayList<movie> mMovies;
    LayoutInflater mInflater;

    public BannerAdapter() {

    }

    public BannerAdapter(Context context, ArrayList<movie> movies) {
        this.mMovies = movies;
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
    }


    public itemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.topbanners, parent, false);
        return new itemHolder(view);


    }


    public void onBindViewHolder(@NonNull itemHolder holder, int position) {

        /*holder.title.setText("Title: "+items.get(position).title);
        holder.summary.setText("Summary: "+items.get(position).summary);
        holder.rating.setText("Rating: "+String.valueOf(items.get(position).rating));
        holder.year.setText("Year: "+String.valueOf(items.get(position).year));*/
        Glide.with(context).load(mMovies.get(position).image).centerCrop().placeholder(R.drawable.ic_downloading).into(holder.image);
        Log.d(TAG, "getItemCount here: "+mMovies.size());

    }


    public int getItemCount() {
        Log.d(TAG, "getItemCount here: "+mMovies.size());
        return mMovies.size();


    }

    public class itemHolder extends RecyclerView.ViewHolder {

        TextView title,summary,rating,year;
        ImageView image;

        public itemHolder(@NonNull View itemView) {
            super(itemView);
            /*title = itemView.findViewById(R.id.title);
            summary = itemView.findViewById(R.id.summary);
            rating = itemView.findViewById(R.id.rating);
            year = itemView.findViewById(R.id.year);*/
            image = itemView.findViewById(R.id.bannerimage);

        }
    }


}
