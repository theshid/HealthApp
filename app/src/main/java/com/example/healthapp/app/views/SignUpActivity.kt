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
import com.example.healthapp.app.utils.Common
import com.example.healthapp.databinding.ActivitySignUpBinding

class SignUpActivity : BaseActivity() {
    private lateinit var binding: ActivitySignUpBinding

    private lateinit var firstName: EditText
    private lateinit var lastName: EditText
    private lateinit var telephone: EditText
    private lateinit var password: EditText
    private lateinit var confirmPassword: EditText
    private lateinit var email: EditText
    private lateinit var btnCreateAccount: Button
    private lateinit var textViewSignIn: TextView

    private var dob:String? = null
    private var profile:String ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUI()
        setClickListeners()

    }

    private fun setUI() {
        firstName = binding.signUpFirstName
        lastName = binding.signUpName
        email = binding.signUpEmail
        telephone = binding.signUpPhone
        password = binding.signUpPassword
        confirmPassword = binding.signUpPasswordRepeat
        btnCreateAccount = binding.createAccount
        textViewSignIn = binding.toSignIn

        getDataFromIntent()
        hideKeyboard()

    }

    private fun getDataFromIntent(){
        dob = intent.getStringExtra(Common.KEY_DOB)
        profile = intent.getStringExtra(Common.KEY_PROFILE)
    }

    private fun hideKeyboard(){
        this.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }

    private fun setClickListeners() {
        btnCreateAccount.setOnClickListener {

        }

        textViewSignIn.setOnClickListener {

        }
    }

    private fun registerUser() {

    }

    private fun validateUser(): Boolean {
        return when {
            TextUtils.isEmpty(firstName.text.toString()) -> {
                showErrorMessage(getString(R.string.error_first_name), true)
                false
            }

            TextUtils.isEmpty(lastName.text.toString()) -> {
                showErrorMessage(getString(R.string.error_last_name), true)
                false
            }

            TextUtils.isEmpty(email.text.toString().trim { it <= ' ' })
                    || !Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()
            -> {
                showErrorMessage(getString(R.string.error_email), true)
                false
            }
            TextUtils.isEmpty(password.text.toString().trim { it <= ' ' }) || password.length() <= 7
                    || !password.text.toString().matches(".*[A-Z].*".toRegex())
                    || !password.text.toString().matches(".*[0-9]*.".toRegex())
                    || !password.text.toString().matches(".*[!@#$%^&*()_+=-]*.".toRegex())
            -> {
                showErrorMessage(
                    getString(R.string.error_password_incomplete),
                    true
                )
                false
            }

            TextUtils.isEmpty(
                telephone.text.toString().trim { it <= ' ' }) || telephone.length() <= 7
            -> {
                showErrorMessage(getString(R.string.error_phone_number), true)
                false
            }


            TextUtils.isEmpty(confirmPassword.text.toString().trim { it <= ' ' }) -> {
                showErrorMessage(getString(R.string.repeat_password), true)
                false
            }

            password.text.toString().trim { it <= ' ' } != confirmPassword.text.toString()
                .trim { it <= ' ' } -> {
                showErrorMessage(getString(R.string.password_mismatch), true)
                false
            }

            /*!binding.checkTermsRegister.isChecked ->{
                showErrorMessage("Please Agree The Terms & Conditions and Privacy Policy",true)
                false
            }*/

            else -> {
//                showErrorMessage("Your Details are Saved", false)
                true
            }
        }
    }
}