package com.example.cutoff.retrofitutil;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiLoginClient {

    private static final String BASE_URL = " http://192.168.1.25/CutOff_API/v1/Login/";
    private static Retrofit retrofit = null;


    public static Retrofit getApiLoginClient() {
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
