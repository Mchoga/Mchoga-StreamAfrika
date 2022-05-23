package com.streamafrika;

import android.content.Context;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.ArrayList;

public class movie {
        Gson gson = new Gson();
        String title,summary,image;
        int year;
        float rating;
        //
        int id;
        ArrayList<String> genres = new ArrayList<>();

        public movie(String title, String summary, int year, float rating, String image, int id, JSONArray genre, Context context) {
            this.title = title;
            this.summary = summary;
            this.year = year;
            this.rating = rating;
            this.image = image;
            this.id = id;
            int num = genre.length();
            for(int x=0;x<num;x++){
                try {
                    genres.add(genre.getString(x));
                }
                catch (Exception e){
                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }





            //this.genres = gson.fromJson(genres.toString());
        }

        public String getTitle() {
            return title;
        }

        public String getSummary() {
            return summary;
        }
        public String getImage() {
            return image;
        }

        public int getId() {
            return id;}
        public int getYear() {
            return year;
        }

        public float getRating() {
            return rating;
        }
        public ArrayList<String> getGenre() {
            return genres;
        }



}
