package com.example.kartheek.retrofitexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Kartheek on 11/4/2017.
 */

public interface ApiDoc {
    String BASE_URL="https://simplifiedcoding.net/demos/";
    @GET("marvel")
    Call<List<HeroModel>> getHeroes();
}
