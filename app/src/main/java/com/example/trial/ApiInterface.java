package com.example.trial;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("test.php")
    Call<Notes> saveNote(


        @Field("title") String title,
        @Field("post") String post

);
}
