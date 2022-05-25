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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


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
        //holder.categoryListAdapter = new CategoryListAdapter(context,holder.action);

        switch (position){
            case 0:holder.categoryListAdapter = new CategoryListAdapter(context,holder.categories.get(position).movieList());

                break;
            case 1:
                holder.categoryListAdapter = new CategoryListAdapter(context,holder.categories.get(position).movieList());

                break;
            case 2:
                holder.categoryListAdapter = new CategoryListAdapter(context,holder.categories.get(position).movieList());

                break;
            case 3:
                holder.categoryListAdapter = new CategoryListAdapter(context,holder.categories.get(position).movieList());
                 break;
            case 4:
                holder.categoryListAdapter = new CategoryListAdapter(context,holder.categories.get(position).movieList());
                break;
            case 5:
                holder.categoryListAdapter = new CategoryListAdapter(context,holder.categories.get(position).movieList());
                break;
            case 6:
                holder.categoryListAdapter = new CategoryListAdapter(context,holder.categories.get(position).movieList());
                break;
            case 7:
                holder.categoryListAdapter = new CategoryListAdapter(context,holder.categories.get(position).movieList());
                break;

            case 8:
                holder.categoryListAdapter = new CategoryListAdapter(context,holder.categories.get(position).movieList());
                break;

            case 9:
                holder.categoryListAdapter = new CategoryListAdapter(context,holder.categories.get(position).movieList());
                break;

            case 10:
                holder.categoryListAdapter = new CategoryListAdapter(context,holder.categories.get(position).movieList());
                break;
            case 11:
                holder.categoryListAdapter = new CategoryListAdapter(context,holder.categories.get(position).movieList());
                break;


        }





        //holder.categoryListAdapter = new CategoryListAdapter(context,holder.categoryMovielist.movieList());
        holder.categoryListRecycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.categoryListRecycler.setAdapter(holder.categoryListAdapter);





    }

    @Override
    public int getItemCount() {


        return categories.length;
    }

    public class itemHolder extends RecyclerView.ViewHolder {


        //LoadMovies categoryMovielist;
        ArrayList<LoadMovies> categories = new ArrayList();
        TextView categoryText;
        RecyclerView categoryListRecycler;
        RecyclerView.Adapter categoryListAdapter;


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



        public itemHolder(@NonNull View itemView) {
            super(itemView);


            String categorylinks[] = {"https://yts.torrentbay.to/api/v2/list_movies.json?genre=Action",
                    "https://yts.torrentbay.to/api/v2/list_movies.json?genre=animation",
                    "https://yts.torrentbay.to/api/v2/list_movies.json?genre=comedy",
                    "https://yts.torrentbay.to/api/v2/list_movies.json?genre=fantasy",
                    "https://yts.torrentbay.to/api/v2/list_movies.json?genre=horror",
                    "https://yts.torrentbay.to/api/v2/list_movies.json?genre=mystery",
                    "https://yts.torrentbay.to/api/v2/list_movies.json?genre=drama",
                    "https://yts.torrentbay.to/api/v2/list_movies.json?genre=documentary",
                    "https://yts.torrentbay.to/api/v2/list_movies.json?genre=sci-Fi",
                    "https://yts.torrentbay.to/api/v2/list_movies.json?genre=thriller",
                    "https://yts.torrentbay.to/api/v2/list_movies.json?genre=war",
                    "https://yts.torrentbay.to/api/v2/list_movies.json?genre=romance"};


            for (int x = 0;x<categorylinks.length;x++){
                categories.add(new LoadMovies(context,categorylinks[x]));
            }
            sortedCategory();


            categoryText= itemView.findViewById(R.id.categorytext);
            categoryListRecycler = itemView.findViewById(R.id.categoryListRecycler);





        }



        public  void sortedCategory(){




            /*for (int x=0; x<categoryMovielist.movieList().size();x++){

                if (categoryMovielist.movieList().get(x).genres.contains("Action")){action.add(categoryMovielist.movieList().get(x));}
                if (categoryMovielist.movieList().get(x).genres.contains("Animation")){animation.add(categoryMovielist.movieList().get(x));}
                if (categoryMovielist.movieList().get(x).genres.contains("Comedy")){comedy.add(categoryMovielist.movieList().get(x));}
                if (categoryMovielist.movieList().get(x).genres.contains("Fantasy")){fantasy.add(categoryMovielist.movieList().get(x));}
                if (categoryMovielist.movieList().get(x).genres.contains("Horror")){horror.add(categoryMovielist.movieList().get(x));}
                if (categoryMovielist.movieList().get(x).genres.contains("Mystery")){mystery.add(categoryMovielist.movieList().get(x));}
                if (categoryMovielist.movieList().get(x).genres.contains("Drama")){drama.add(categoryMovielist.movieList().get(x));}
                if (categoryMovielist.movieList().get(x).genres.contains("Documentary")){documentary.add(categoryMovielist.movieList().get(x));}
                if (categoryMovielist.movieList().get(x).genres.contains("Sci-Fi")){sciFi.add(categoryMovielist.movieList().get(x));}
                if (categoryMovielist.movieList().get(x).genres.contains("Thriller")){thriller.add(categoryMovielist.movieList().get(x));}
                if (categoryMovielist.movieList().get(x).genres.contains("War")){war.add(categoryMovielist.movieList().get(x));}
                if (categoryMovielist.movieList().get(x).genres.contains("Romance")){romance.add(categoryMovielist.movieList().get(x));}

            }*/


            /*categories.add(action);
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
*/


        }
    }


}
