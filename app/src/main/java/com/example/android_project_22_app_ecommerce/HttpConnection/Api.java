package com.example.android_project_22_app_ecommerce.HttpConnection;

import com.example.android_project_22_app_ecommerce.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "http://127.0.0.1:3001/api/";

    @GET("products")
    Call<List<Product>> getsuperProducts();
}
