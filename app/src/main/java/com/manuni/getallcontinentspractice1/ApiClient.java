package com.manuni.getallcontinentspractice1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static Retrofit retrofit = null;
    public static Retrofit getRetrofit(){
        if (retrofit==null){
            OkHttpClient client = new OkHttpClient.Builder().build();
            Gson gson = new GsonBuilder().create();
            retrofit = new Retrofit.Builder().baseUrl(Utils.BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
