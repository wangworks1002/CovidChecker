package com.example.covidchecker.retrofit;

import com.example.covidchecker.model.api.AllResponse;
import com.example.covidchecker.model.api.Country;
import com.example.covidchecker.model.api.LoginResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiEndpointInterface {

    String ONE_BASE_URL = "https://talentpool.oneindonesia.id";
    String LMAO_BASE_URL = "https://corona.lmao.ninja";

    @Headers({"x-api-key: 454041184B0240FBA3AACD15A1F7A8BB"})
    @FormUrlEncoded
    @POST("/api/user/login")
    Call<LoginResponse> login(@Field("username") String username, @Field("password") String password);

    @GET("/v2/all")
    Call<AllResponse> allCases();

    @GET("/v2/countries?sort=country")
    Call<ArrayList<Country>> countries();

    @GET("/v2/countries/{country}")
    Call<Country> getSpecificCountry(@Path("country") String country);
}
