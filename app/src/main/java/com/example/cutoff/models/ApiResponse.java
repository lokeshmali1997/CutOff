package com.example.cutoff.models;

import com.google.gson.annotations.SerializedName;

public class ApiResponse {

        @SerializedName("success")
        private String success;

        @SerializedName("message")
        private String message;

        @SerializedName("Data")
        private String  Data;

    public String getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getData() {
        return Data;
    }
}



