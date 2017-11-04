package com.example.kartheek.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit= new Retrofit.Builder().baseUrl(ApiDoc.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        ApiDoc apiDoc=retrofit.create(ApiDoc.class);
        Call<List<HeroModel>> call=apiDoc.getHeroes();
        call.enqueue(new Callback<List<HeroModel>>() {
            @Override
            public void onResponse(Call<List<HeroModel>> call, Response<List<HeroModel>> response) {
                Toast.makeText(MainActivity.this, " "+response.body(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<HeroModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
