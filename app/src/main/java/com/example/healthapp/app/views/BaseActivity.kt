package com.example.healthapp.app.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.example.healthapp.app.utils.extensions.showSnackbar

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun showErrorMessage(
        message: String,
        isError: Boolean,
        view: View = findViewById(android.R.id.content)
    ) {
        showSnackbar(view, message, isError)
    }

    protected fun hideKeyboard() {
        this.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }
}