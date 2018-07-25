package com.imastudio.guanzhuli.icart.signup

//TODO 9 bikin interface untuk angkut informasi di presenter ke activity
interface SignUpView {

    //jika berhasil di server
    fun onSuccess(msg : String, status : Boolean)

    //jika error di server
    fun onError(msg : String)

}