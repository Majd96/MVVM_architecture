package com.example.majdbaniodeh.mvvm_architecture.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RootObject {



    @SerializedName("response")
    public Response res;

    public Response getRes() {
        return res;
    }
}
