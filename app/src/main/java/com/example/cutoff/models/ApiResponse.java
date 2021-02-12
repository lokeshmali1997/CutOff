package com.example.cutoff.models;

import com.google.gson.annotations.SerializedName;

public class ApiResponse {

    @SerializedName("success")
        private String success;

        @SerializedName("message")
        private String message;

    @SerializedName("result")
    private int result;

        @SerializedName("status")
        private String  status;

    public String getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public int getResult() {
        return result;
    }
}



