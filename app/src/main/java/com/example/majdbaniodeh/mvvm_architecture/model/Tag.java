package com.example.majdbaniodeh.mvvm_architecture.model;

import com.google.gson.annotations.SerializedName;

public class Tag {
    @SerializedName("webTitle")
    private String authorName;

    public String getAuthorName() {
        return authorName;
    }
}
