package com.example.retrofitlogin

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiPoint {
    @FormUrlEncoded
    @POST("auth/sign-up")
    fun signUp
            (@Field("name")name : String,
    @Field("username")username : String,
    @Field("email")email :String,
    @Field("password")password : String) : Call<SingleRespon<DataUser>>

    @FormUrlEncoded
    @POST("auth/sign-in")
    fun SignIn(@Field("username")username : String,
               @Field("password")password : String) : Call<SingleRespon<DataUser>>
}