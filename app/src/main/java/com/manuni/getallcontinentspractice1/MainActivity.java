package com.manuni.getallcontinentspractice1;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = ApiClient.getRetrofit();
        ApiData data = retrofit.create(ApiData.class);
        Call<MainObjectData> mainObjectDataCall = data.getAllData(Utils.API_TOKEN);
        mainObjectDataCall.enqueue(new Callback<MainObjectData>() {
            @Override
            public void onResponse(Call<MainObjectData> call, Response<MainObjectData> response) {
                if (response.isSuccessful()) {
                    List<ObjectData> data1 = response.body().getData();
                    for (ObjectData objectData : data1) {
                        Log.d(TAG, "onResponse: resource "+objectData.getResource());
                        Log.d(TAG, "onResponse: id "+objectData.getId());
                        Log.d(TAG, "onResponse: name "+objectData.getName());
                        Log.d(TAG, "onResponse: updated_at "+objectData.getUpdated_at());

                    }
                }
            }

            @Override
            public void onFailure(Call<MainObjectData> call, Throwable t) {
                Log.d(TAG, "onFailure: error"+t.getMessage());
            }
        });
    }
}