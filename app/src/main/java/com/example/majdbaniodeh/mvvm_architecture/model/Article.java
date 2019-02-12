package com.example.majdbaniodeh.mvvm_architecture.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Article {

    @SerializedName("sectionName")
    public String section;
    @SerializedName("webTitle")
    public String title;
    @SerializedName("webPublicationDate")
    public String date;
    @SerializedName("webUrl")
    public String url;


    public String getSection() {
        return section;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getUrl() {
        return url;
    }


}
