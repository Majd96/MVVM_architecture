package com.example.majdbaniodeh.mvvm_architecture.repository;

import com.example.majdbaniodeh.mvvm_architecture.model.Article;
import com.example.majdbaniodeh.mvvm_architecture.model.RootObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GuardianService {
    @GET("search")
    Call<RootObject> getArticles(@Query("q") String topic, @Query("api-key") String id, @Query("show-tags") String contributor);

}
