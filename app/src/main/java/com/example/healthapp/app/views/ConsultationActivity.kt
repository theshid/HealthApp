package com.example.healthapp.app.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.healthapp.R
import com.example.healthapp.app.adapters.ConsultationAdapter
import com.example.healthapp.data.Consultation
import com.example.healthapp.databinding.ActivityConsultationBinding
import com.example.healthapp.databinding.ActivityEditProfileBinding

class ConsultationActivity : AppCompatActivity() {

    private lateinit var consultationAdapter: ConsultationAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: ActivityConsultationBinding
    private lateinit var binding2: ActivityEditProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConsultationBinding.inflate(layoutInflater)
        binding2 = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding2.root)

        val consultation1 = Consultation(id = 1, name = "Jennifer Bah", date = "2023-03-18")
        val consultation2 = Consultation(id = 2, name = "Jennifer Bah", date = "2023-03-20")
        val consultation3 = Consultation(id = 3, name = "Jennifer Bah", date = "2023-03-22")

        val consultations = listOf(consultation1, consultation2, consultation3)

        recyclerView = binding.videoList
        consultationAdapter = ConsultationAdapter()
        recyclerView.adapter = consultationAdapter
        consultationAdapter.submitList(consultations)



    }
}