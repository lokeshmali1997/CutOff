package com.example.cutoff.retrofitutil;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CourseApiClient {

    private static final String BASE_URL = " http://192.168.29.118/CutOff_API/v1/Course/";
    private static Retrofit retrofit = null;


    public static Retrofit getCourseApiClient() {
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

    public static CourseApiInterface courseApiInterface()
    {
        return getCourseApiClient().create(CourseApiInterface.class);
    }
}
