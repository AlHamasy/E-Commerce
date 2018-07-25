package com.imastudio.guanzhuli.icart.network

import android.telecom.Call
import com.imastudio.guanzhuli.icart.signup.model.SignUP_Respon
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST ("register")
    fun requestSign (@Field("name")name:String,
                     @Field("password")password:String,
                     @Field("alamat")alamat:String,
                     @Field("email")email:String,
                     @Field("nohp")nohp:String
                     ):retrofit2.Call<SignUP_Respon>


}