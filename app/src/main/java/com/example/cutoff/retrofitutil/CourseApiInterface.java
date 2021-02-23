package com.example.cutoff.retrofitutil;

import com.example.cutoff.models.CourseApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CourseApiInterface {

    @GET("fetch_course.php")
    Call<List<CourseApiResponse>> getCourseApiResponse();


}
