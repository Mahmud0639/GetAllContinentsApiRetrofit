package com.manuni.getallcontinentspractice1;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiData {

    @GET("continents")
    Call<MainObjectData> getAllData(@Query("api_token")String token);
}
