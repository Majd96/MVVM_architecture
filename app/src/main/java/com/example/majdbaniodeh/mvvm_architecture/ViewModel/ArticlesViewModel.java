package com.example.majdbaniodeh.mvvm_architecture.ViewModel;


import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;
import android.widget.Toast;

import com.example.majdbaniodeh.mvvm_architecture.model.Article;
import com.example.majdbaniodeh.mvvm_architecture.model.RootObject;
import com.example.majdbaniodeh.mvvm_architecture.repository.GuardianService;
import com.example.majdbaniodeh.mvvm_architecture.repository.RetrofitBuilder;

import java.net.URL;
import java.util.ArrayList;

import okhttp3.HttpUrl;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticlesViewModel extends ViewModel {
    private static final String TAG=AndroidViewModel.class.getName();
    private String topic;
    private String apiKey;
    private String contributor;

    private MutableLiveData<ArrayList<Article>> articlesObservable;

    public ArticlesViewModel(String topic) {
        this.topic=topic;

    }



    public MutableLiveData<ArrayList<Article>> getArticlesList() {
        if (articlesObservable == null) { // if the list is null we will fetch the data from server
            articlesObservable = new MutableLiveData<>();
            loadTheDataFromServer();
        }
        return articlesObservable;
    }

    private void loadTheDataFromServer() {


        GuardianService guardianService= RetrofitBuilder.getArticles();
        final Call<RootObject> call = guardianService.getArticles(topic,"test","contributor");
        HttpUrl url=call.request().url();


        call.enqueue(new Callback<RootObject>() {
            @Override
            public void onResponse(Call<RootObject> call, Response<RootObject> response) {
                if (response.isSuccessful()) {
                    RootObject object=response.body();
                    Log.d("","");

                   articlesObservable.setValue(object.res.articles);
                }

            }

            @Override
            public void onFailure(Call<RootObject> call, Throwable t) {
                Log.e(TAG,t.getMessage());

            }
        });

    }





    }

