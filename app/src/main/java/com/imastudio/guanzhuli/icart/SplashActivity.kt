package com.imastudio.guanzhuli.icart

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //TODO 23
        Handler().postDelayed(Runnable {
            startActivity<SignInActivity>()
            finish()
        }, 5000)

    }

}
