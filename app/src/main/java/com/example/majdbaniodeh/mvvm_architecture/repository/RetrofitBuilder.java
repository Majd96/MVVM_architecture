package com.example.majdbaniodeh.mvvm_architecture.repository;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {
    private static GuardianService guardianService;

    public static GuardianService getArticles(){
        Gson gson = new GsonBuilder().create();

        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        guardianService=new Retrofit.Builder()
                .baseUrl("https://content.guardianapis.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .callFactory(httpClientBuilder.build())
                .build().create(GuardianService.class);

        return guardianService;

    }

}
