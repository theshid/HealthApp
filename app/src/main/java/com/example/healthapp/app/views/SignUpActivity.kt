package com.example.healthapp.app.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.WindowManager
import android.widget.EditText
import com.example.healthapp.databinding.ActivitySignUpBinding

class SignUpActivity : BaseActivity() {
    private lateinit var binding: ActivitySignUpBinding

    private lateinit var firstName: EditText
    private lateinit var lastName: EditText
    private lateinit var telephone: EditText
    private lateinit var password: EditText
    private lateinit var confirmPassword: EditText
    private lateinit var email: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUI()
        this.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }

    private fun setUI() {
        firstName = binding.signUpFirstName
        lastName = binding.signUpName
        email = binding.signUpEmail
        telephone = binding.signUpPhone
        password = binding.signUpPassword
        confirmPassword = binding.signUpPasswordRepeat
    }

    private fun setClickListeners() {

    }

    private fun registerUser() {

    }

    private fun validateUser(): Boolean {
        return when {
            TextUtils.isEmpty(firstName.text.toString()) -> {
                showErrorMessage("Please Enter your Username", true)
                false
            }

            TextUtils.isEmpty(lastName.text.toString()) -> {
                showErrorMessage("Please Enter your Username", true)
                false
            }

            TextUtils.isEmpty(email.text.toString().trim { it <= ' ' })
                    || !Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()
            -> {
                showErrorMessage("Please Enter your Valid Email Address", true)
                false
            }
            TextUtils.isEmpty(password.text.toString().trim { it <= ' ' }) || password.length() <= 7
                    || !password.text.toString().matches(".*[A-Z].*".toRegex())
                    || !password.text.toString().matches(".*[0-9]*.".toRegex())
                    || !password.text.toString().matches(".*[!@#$%^&*()_+=-]*.".toRegex())
            -> {
                showErrorMessage(
                    "Password Should contain 8 Characters, One Capital Letter, One Number and Special Character ",
                    true
                )
                false
            }

            TextUtils.isEmpty(
                telephone.text.toString().trim { it <= ' ' }) || telephone.length() <= 7
            -> {
                showErrorMessage("Telephone", true)
                false
            }


            TextUtils.isEmpty(confirmPassword.text.toString().trim { it <= ' ' }) -> {
                showErrorMessage("Please Enter your Confirm Password", true)
                false
            }

            password.text.toString().trim { it <= ' ' } != confirmPassword.text.toString()
                .trim { it <= ' ' } -> {
                showErrorMessage("Password Mismatch", true)
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