package com.imastudio.guanzhuli.icart

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.imastudio.guanzhuli.icart.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_signin.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.singleTop

// http://rjtmobile.com/ansari/shopingcart/androidapp/shop_login.php?mobile=123456&password=ansari

class SignInActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        to_sign_up.onClick {
            startActivity(intentFor<SignUpActivity>().singleTop())
        }
    }
}