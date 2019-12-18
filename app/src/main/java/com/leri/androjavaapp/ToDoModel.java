package com.leri.androjavaapp;
import com.google.gson.annotations.SerializedName;


public class ToDoModel {

    @SerializedName("userId")
    public Integer userId;
    @SerializedName("id")
    public Integer id;
    @SerializedName("title")
    public String title;
    @SerializedName("completed")
    public String completed;

}
