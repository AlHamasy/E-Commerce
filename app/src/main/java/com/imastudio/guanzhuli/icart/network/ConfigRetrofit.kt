package com.imastudio.guanzhuli.icart.network

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import kotlin.jvm.java

class ConfigRetrofit {

    var retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.20.191/market_server/index.php/Server/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()!!

    var service: ApiService = retrofit.create<ApiService>(ApiService::class.java!!)

}