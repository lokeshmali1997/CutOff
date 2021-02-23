package com.example.cutoff.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CourseApiResponse {

    @SerializedName("courseId")
    @Expose
    private Integer courseId;
    @SerializedName("courseName")
    @Expose
    private String courseName;
    @SerializedName("courseOrder")
    @Expose
    private Integer courseOrder;
    @SerializedName("courseIcon")
    @Expose
    private String courseIcon;
    @SerializedName("courseURL")
    @Expose
    private String courseURL;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCourseOrder() {
        return courseOrder;
    }

    public void setCourseOrder(Integer courseOrder) {
        this.courseOrder = courseOrder;
    }

    public String getCourseIcon() {
        return courseIcon;
    }

    public void setCourseIcon(String courseIcon) {
        this.courseIcon = courseIcon;
    }

    public String getCourseURL() {
        return courseURL;
    }

    public void setCourseURL(String courseURL) {
        this.courseURL = courseURL;
    }
}
