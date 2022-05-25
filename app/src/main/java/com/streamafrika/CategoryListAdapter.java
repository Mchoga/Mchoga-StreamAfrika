package com.streamafrika;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LongDef;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.CategoryListHolder> {

    Context context;
    ArrayList<movie> categoryMovies;




    public CategoryListAdapter(Context context,ArrayList<movie> categoryMovies) {
        this.context=context;
        this.categoryMovies = categoryMovies;




    }

    @NonNull
    @Override
    public CategoryListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movieicon,parent,false);


        return new CategoryListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryListHolder holder, int position) {
        Glide.with(context).load(categoryMovies.get(position).image).centerCrop().placeholder(R.drawable.ic_downloading).into(holder.image);


        //holder.categories.get(holder.getAdapterPosition()).get(position).image
        

    }

    @Override
    public int getItemCount() {

        return categoryMovies.size();
    }

    public class CategoryListHolder extends RecyclerView.ViewHolder{
        TextView title,summary,rating,year;
        ImageView image;
        /*ArrayList<ArrayList<movie>> categories = new ArrayList();*/

        public CategoryListHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.categoryimage);
            
        }

        /*public  void sortedCategory(){
            ArrayList<movie> action = new ArrayList<>();
            ArrayList<movie> animation= new ArrayList<>();
            ArrayList<movie> comedy= new ArrayList<>();
            ArrayList<movie> fantasy= new ArrayList<>();
            ArrayList<movie> horror= new ArrayList<>();
            ArrayList<movie> mystery= new ArrayList<>();
            ArrayList<movie> drama= new ArrayList<>();
            ArrayList<movie> documentary= new ArrayList<>();
            ArrayList<movie> sciFi= new ArrayList<>();
            ArrayList<movie> thriller= new ArrayList<>();
            ArrayList<movie> war= new ArrayList<>();
            ArrayList<movie> romance= new ArrayList<>();


            for (int x=0; x<categoryMovies.size();x++){

                if (categoryMovies.get(x).genres.contains("Action")){action.add(categoryMovies.get(x));}
                if (categoryMovies.get(x).genres.contains("Animation")){animation.add(categoryMovies.get(x));}
                if (categoryMovies.get(x).genres.contains("Comedy")){comedy.add(categoryMovies.get(x));}
                if (categoryMovies.get(x).genres.contains("Fantasy")){fantasy.add(categoryMovies.get(x));}
                if (categoryMovies.get(x).genres.contains("Horror")){horror.add(categoryMovies.get(x));}
                if (categoryMovies.get(x).genres.contains("Mystery")){mystery.add(categoryMovies.get(x));}
                if (categoryMovies.get(x).genres.contains("Drama")){drama.add(categoryMovies.get(x));}
                if (categoryMovies.get(x).genres.contains("Documentary")){documentary.add(categoryMovies.get(x));}
                if (categoryMovies.get(x).genres.contains("Sci-Fi")){sciFi.add(categoryMovies.get(x));}
                if (categoryMovies.get(x).genres.contains("Thriller")){thriller.add(categoryMovies.get(x));}
                if (categoryMovies.get(x).genres.contains("War")){war.add(categoryMovies.get(x));}
                if (categoryMovies.get(x).genres.contains("Romance")){romance.add(categoryMovies.get(x));}

            }


            categories.add(action);
            categories.add(animation);
            categories.add(comedy);
            categories.add(fantasy);
            categories.add(horror);
            categories.add(mystery);
            categories.add(drama);
            categories.add(documentary);
            categories.add(sciFi);
            categories.add(thriller);
            categories.add(war);
            categories.add(romance);



        }*/





    }

    }

