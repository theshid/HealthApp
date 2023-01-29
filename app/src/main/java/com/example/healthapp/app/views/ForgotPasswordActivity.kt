package com.example.healthapp.app.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import com.example.healthapp.R
import com.example.healthapp.app.utils.extensions.startActivity
import com.example.healthapp.databinding.ActivityForgotPasswordBinding

class ForgotPasswordActivity : BaseActivity() {
    private lateinit var binding: ActivityForgotPasswordBinding

    private lateinit var email: EditText
    private lateinit var btnRequest: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUI()
        setClickListeners()
    }

    private fun setUI() {
        email = binding.forgotPassEmail
        btnRequest = binding.ForgotPassButton
    }

    private fun setClickListeners() {
        btnRequest.setOnClickListener {
            if (validateData()) {
                startActivity<LoginActivity>()
            }

        }
    }

    private fun validateData(): Boolean {
        return when {
            TextUtils.isEmpty(email.text.toString().trim { it <= ' ' })
                    || !Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()
            -> {
                showErrorMessage(getString(R.string.error_email), true)
                false
            }

            else -> {
                true
            }
        }
    }
}