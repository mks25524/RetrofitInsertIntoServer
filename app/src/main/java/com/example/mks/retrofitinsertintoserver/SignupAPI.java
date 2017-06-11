package com.example.mks.retrofitinsertintoserver;

import android.telecom.Call;

import java.util.List;

import retrofit.Callback;


import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by mks on 6/11/2017.
 */

public interface SignupAPI {
@FormUrlEncoded
    @POST("/jojo/insert.php")
    public void  insertUser(
            @Field("name") String name,
            @Field("username") String username,
            @Field("sid") String sid,
            @Field("email") String email,
            @Field("password") String password,
            @Field("batch") String batch,
            Callback<Response>callback

);


}
