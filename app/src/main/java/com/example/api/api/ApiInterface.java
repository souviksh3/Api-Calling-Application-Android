package com.example.api.api;

import com.example.api.model.Note;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("read.php")
    Call<List<Note>> readNote();
    @FormUrlEncoded
    @POST("save.php")
    Call<Note> saveNote(@Field("name") String name,@Field("address") String address, @Field("contact") String contact, @Field("ragistration") String ragistration);

    @FormUrlEncoded
    @POST("delete.php")
    Call<Note> deleteNote(@Field("id") String id);

    @FormUrlEncoded
    @POST("update.php")
    Call<Note> updateNote(@Field("id")String id,@Field("message") String message,@Field("title") String title);


}
