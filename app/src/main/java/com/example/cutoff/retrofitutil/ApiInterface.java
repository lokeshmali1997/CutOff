package com.example.cutoff.retrofitutil;

import com.example.cutoff.models.ApiResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("registerUser.php")
    Call<ApiResponse> performUserSignIn(@Field("username") String username,@Field("useremail") String useremail,@Field("userpassword") String userpassword,@Field("usermobile") String usermobile);

}
