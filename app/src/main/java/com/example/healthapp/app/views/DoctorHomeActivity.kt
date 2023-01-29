package com.example.healthapp.app.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.healthapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DoctorHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_patient)
    }
}