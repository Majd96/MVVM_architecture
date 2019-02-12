package com.example.majdbaniodeh.mvvm_architecture.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Response {
    @SerializedName("results")
    public ArrayList<Article> articles;

    @SerializedName("userTier")
    public String yahoo;

    public ArrayList<Article> getArticles() {
        return articles;
    }
}
