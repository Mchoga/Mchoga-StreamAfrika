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

import java.util.ArrayList;



public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.itemHolder> {
    Context context;
    String[] categories;
    LayoutInflater mInflater;


    public CategoriesAdapter(Context context, String[] categories) {
        this.categories = categories;
        this.context = context;
        this.mInflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public itemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.categories, parent, false);
        return new CategoriesAdapter.itemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull itemHolder holder, int position) {
        holder.categoryText.setText(categories[position]);

    }

    @Override
    public int getItemCount() {
        return categories.length;
    }

    public class itemHolder extends RecyclerView.ViewHolder {

        TextView categoryText;
        RecyclerView categoryRecycler;

        public itemHolder(@NonNull View itemView) {
            super(itemView);
            categoryText= itemView.findViewById(R.id.categorytext);

        }
    }


}
