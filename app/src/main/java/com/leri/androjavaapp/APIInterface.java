package com.leri.androjavaapp;
import com.leri.androjavaapp.ToDoModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

interface APIInterface {
//
//    @GET("/todos?size=50")
//    Call<ToDoModel> getList();
//
    @GET("/todos")
    Call<ToDoModel> doGetListResources();


}
