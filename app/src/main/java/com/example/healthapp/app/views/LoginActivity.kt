package com.example.healthapp.app.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.healthapp.R
import com.example.healthapp.app.utils.extensions.startActivity
import com.example.healthapp.databinding.ActivitySignInBinding

class LoginActivity : BaseActivity() {
    private lateinit var binding: ActivitySignInBinding

    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var login: Button
    private lateinit var forgotPassword: TextView
    private lateinit var createAccount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUI()
        setClickListeners()
    }

    private fun setClickListeners() {
        login.setOnClickListener {
            if (validateUser()){

            }
        }

        forgotPassword.setOnClickListener {
            startActivity<ForgotPasswordActivity>()
        }

        createAccount.setOnClickListener {
            startActivity<SignUpFirstActivity>()
        }
    }

    private fun setUI() {
        email = binding.signInEmail
        password = binding.signInPassword
        login = binding.loginButton
        forgotPassword = binding.forgotPassword
        createAccount = binding.toSignUp

        hideKeyboard()
    }

    private fun validateUser(): Boolean {
        return when {
            TextUtils.isEmpty(email.text.toString().trim { it <= ' ' })
                    || !Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()
            -> {
                showErrorMessage(getString(R.string.error_email), true)
                false
            }

            TextUtils.isEmpty(password.text.toString().trim { it <= ' ' })
            -> {
                showErrorMessage(
                    getString(R.string.error_password_incomplete),
                    true
                )
                false
            }

            else -> {
                true
            }
        }
    }
}