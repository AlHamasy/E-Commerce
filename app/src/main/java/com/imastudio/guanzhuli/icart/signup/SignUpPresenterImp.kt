package com.imastudio.guanzhuli.icart.signup

import android.util.Log
import com.imastudio.guanzhuli.icart.network.ConfigRetrofit
import com.imastudio.guanzhuli.icart.signup.model.SignUP_Respon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//TODO 10 constructor interfae
class SignUpPresenterImp(var signUpView: SignUpView) {

    //TODO 1 bikin presenter fuunction
    //kita butuh analisa kira" activity kirim apa dan berapa data
    fun signUp(name: String, email: String, alamat: String, password: String, confrim: String, hp: String) {

        //TODO 2 check kondisi
        if (name != "" && email != "" && alamat != "" && password != "" && confrim != "" && hp != "") {

            //TODO 4 chack pw dan confirm pw
            if (password == confrim) {

                //TODO 3 insert to server
                val config = ConfigRetrofit().service

                //TODO 5 ambil response dari insert apa nggak
                config.requestSign(name, password, alamat, email, hp).enqueue(object : Callback<SignUP_Respon> {
                    override fun onFailure(call: Call<SignUP_Respon>?, t: Throwable?) {

                        //TODO 6 cetak di log untuk pesan error
                        Log.d("error register", t?.message)

                        //TODO 11 set view error
                        signUpView.onError("server Error")
                    }

                    override fun onResponse(call: Call<SignUP_Respon>?, response: Response<SignUP_Respon>?) {
                        if (response!!.isSuccessful){

                            //TODO 7 mbil response jsonnya
                            val alljson = response?.body()

                            //pesan dan status
                            val msg = alljson?.pesan
                            val status = alljson?.status

                            //TODO 8 chack status

                            //TODO 12 set onSuccess
                            signUpView.onSuccess(msg!!, status!!)

                            Log.d("success", response.body().toString())
                        }
                        else{
                            Log.d("error", response.isSuccessful.toString())
                        }
                    }
                })
            }
            else {

                //TODO 13 set not valid pass
                signUpView.onError("NOT MATCH PASSWORD")

            }
        }
        else {

            //TODO 14 set error kalau ada yang kosong
            signUpView.onError("tidak boleh ada yang kosong, please!")

        }
    }


}