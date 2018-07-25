package com.imastudio.guanzhuli.icart.signup

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.imastudio.guanzhuli.icart.R
import com.imastudio.guanzhuli.icart.SignInActivity
import com.paypal.android.sdk.payments.LoginActivity
import kotlinx.android.synthetic.main.activity_signup.*
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

// url
// http://rjtmobile.com/ansari/shopingcart/androidapp/shop_reg.php?%20name=aamir&email=aa@gmail.com&mobile=555454545465&password=7011

//TODO 15 set view di activity
class SignUpActivity : AppCompatActivity(),SignUpView {

    //TODO 16 deklarasi presenter SignUp
    var presenter : SignUpPresenterImp? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        //TODO 17 inisialisasi presenter
        presenter = SignUpPresenterImp(this)

        //TODO 18 listener
        button_sign_up.onClick {

            //TODO 19 get logic presenter
            presenter?.signUp(sign_up_username.text.toString(),
                sign_up_email.text.toString(),
                signu_alamat.text.toString(),
                sign_up_password.text.toString(),
                sign_up_password2.text.toString(),
                sign_up_mobile.text.toString())

        }
    }

    override fun onSuccess(msg: String, status: Boolean) {

        //TODO 20 eksekusi response dari presenter
        if (status == true) startActivity(intentFor<SignInActivity>().singleTop())
        else tampilAlert(msg)

    }

    override fun onError(msg: String) {
        tampilAlert(msg)
    }

    //TODO 22 create alert
    private fun tampilAlert(msg: String){
        alert {
            title = "Information"
            message = msg
            noButton {  }
            yesButton {  }
        }.show()
    }

}
