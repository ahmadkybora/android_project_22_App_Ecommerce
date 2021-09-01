package com.example.android_project_22_app_ecommerce.HttpConnection;

import com.example.android_project_22_app_ecommerce.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApi {

    String BASE_URL = "https://simplifiedcoding.net/demos/";
    @GET("marvel")
    Call<List<User>> getsuperHeroes();
}
