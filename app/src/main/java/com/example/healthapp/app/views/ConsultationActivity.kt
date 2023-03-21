package com.example.healthapp.app.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.healthapp.R
import com.example.healthapp.app.adapters.ConsultationAdapter
import com.example.healthapp.app.utils.ExpandableLayout
import com.example.healthapp.data.Consultation
import com.example.healthapp.databinding.AAccouchementBinding
import com.example.healthapp.databinding.AExamenCliniqueBinding
import com.example.healthapp.databinding.AExamenComplBinding
import com.example.healthapp.databinding.AMereBinding
import com.example.healthapp.databinding.ActivityConsultationBinding
import com.example.healthapp.databinding.ActivityEditProfileBinding

class ConsultationActivity : AppCompatActivity() {

    private lateinit var consultationAdapter: ConsultationAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: ActivityConsultationBinding
    private lateinit var binding2: ActivityEditProfileBinding
    private lateinit var binding3: AMereBinding
    private lateinit var binding4: AAccouchementBinding
    private lateinit var binding5: AExamenCliniqueBinding
    private lateinit var binding6: AExamenComplBinding
    //private lateinit var layout:ExpandableLayout
    //private lateinit var layout2:ExpandableLayout
  /*  private lateinit var layout3:ExpandableLayout
    private lateinit var layout4:ExpandableLayout*/

    //private lateinit var voir:TextView
    //private lateinit var voir2:TextView
 /*   private lateinit var voir3:TextView
    private lateinit var voir4:TextView*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConsultationBinding.inflate(layoutInflater)
        binding2 = ActivityEditProfileBinding.inflate(layoutInflater)
        binding3 = AMereBinding.inflate(layoutInflater)
        binding4 = AAccouchementBinding.inflate(layoutInflater)
        binding5 = AExamenCliniqueBinding.inflate(layoutInflater)
        binding6 = AExamenComplBinding.inflate(layoutInflater)
        setContentView(binding6.root)

        val consultation1 = Consultation(id = 1, name = "Jennifer Bah", date = "2023-03-18")
        val consultation2 = Consultation(id = 2, name = "Jennifer Bah", date = "2023-03-20")
        val consultation3 = Consultation(id = 3, name = "Jennifer Bah", date = "2023-03-22")

        //layout = findViewById(R.id.included_layout_examen_clinique)
        //layout2 = findViewById(R.id.included_layout_acc_2)
        /*layout3 = findViewById(R.id.included_layout3)
        layout4 = findViewById(R.id.included_layout4)*/

        //voir = binding5.voir
        //voir2 = binding4.voir2
        /*voir3 = binding3.voir3
        voir4 = binding3.voir4*/

       /* voir.setOnClickListener {
            if (layout.isExpanded){
                voir.text = "Voir plus"
                layout.collapse()
            } else{
                voir.text = "Voir moins"
                layout.expand()
            }
        }*/
       /* voir2.setOnClickListener {
            if (layout2.isExpanded){
                voir2.text = "Voir plus"
                layout2.collapse()
            } else{
                voir2.text = "Voir moins"
                layout2.expand()
            }
        }*/
       /* voir3.setOnClickListener {
            if (layout3.isExpanded){
                voir3.text = "Voir plus"
                layout3.collapse()
            } else{
                voir3.text = "Voir moins"
                layout3.expand()
            }
        }
        voir4.setOnClickListener {
            if (layout4.isExpanded){
                voir4.text = "Voir plus"
                layout4.collapse()
            } else{
                voir4.text = "Voir moins"
                layout4.expand()
            }
        }*/

        val consultations = listOf(consultation1, consultation2, consultation3)

        recyclerView = binding.videoList
        consultationAdapter = ConsultationAdapter()
        recyclerView.adapter = consultationAdapter
        consultationAdapter.submitList(consultations)



    }
}