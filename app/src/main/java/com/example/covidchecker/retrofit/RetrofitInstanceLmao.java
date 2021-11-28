package com.example.covidchecker.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstanceLmao {

    private ApiEndpointInterface LMAO_API;

    public RetrofitInstanceLmao() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd hh:mm:ss")
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiEndpointInterface.LMAO_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        LMAO_API = retrofit.create(ApiEndpointInterface.class);
    }

    public ApiEndpointInterface getLMAO_API(){
        return LMAO_API;
    }
}
