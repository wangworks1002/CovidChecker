package com.example.covidchecker.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstanceOne {

    private ApiEndpointInterface ONE_API;

    public RetrofitInstanceOne() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd hh:mm:ss")
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiEndpointInterface.ONE_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        ONE_API = retrofit.create(ApiEndpointInterface.class);
    }

    public ApiEndpointInterface getONE_API(){
        return ONE_API;
    }
}
