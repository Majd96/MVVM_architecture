package com.example.majdbaniodeh.mvvm_architecture;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.majdbaniodeh.mvvm_architecture.ViewModel.ArticlesViewModel;
import com.example.majdbaniodeh.mvvm_architecture.adapters.ArticleAdapter;
import com.example.majdbaniodeh.mvvm_architecture.model.Article;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Article> articlesList;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rv);
        initView();
    }

    private void initView() {
       ArticlesViewModel model = new ArticlesViewModel("palestine");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setObservers(model);
    }

    private void setObservers(ArticlesViewModel model) {
        model.getArticlesList().observe(this, new Observer<ArrayList<Article>>() {

            @Override
            public void onChanged(@Nullable ArrayList<Article> articles) {
                if(articles==null){
                    articlesList=new ArrayList<>();
                }
                articlesList=articles;
                if (articlesList != null && articlesList.size() > 0) {
                    ArticleAdapter articleAdapter = new ArticleAdapter(articlesList, getApplicationContext());
                    recyclerView.setAdapter(articleAdapter);
                }
            }
        });
    }


}
