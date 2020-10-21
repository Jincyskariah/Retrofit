package com.example.retrofit.Retrofit;

import com.example.retrofit.Model.Categorymodel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apis {

    @GET("api/json/v1/1/categories.php")
    Call<Categorymodel> categ_call();
}
