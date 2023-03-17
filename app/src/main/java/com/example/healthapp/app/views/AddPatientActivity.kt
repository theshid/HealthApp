package com.example.healthapp.app.views

import android.app.DatePickerDialog
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.os.Bundle
import android.text.TextUtils
import android.widget.DatePicker
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.healthapp.R
import com.example.healthapp.databinding.ActivityAddPatientBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale

@AndroidEntryPoint
class AddPatientActivity : BaseActivity() {
    private lateinit var binding :ActivityAddPatientBinding

    private lateinit var firstName : EditText
    private lateinit var lastName : EditText
    private lateinit var sexe : EditText
    private lateinit var dob : EditText
    private lateinit var ethny : EditText
    private lateinit var idNumber : EditText
    private lateinit var gsRh : EditText
    private lateinit var education : EditText
    private lateinit var maritalStatus : EditText
    private lateinit var profession : EditText
    private lateinit var telephoneNumber : EditText
    private lateinit var village : EditText
    private lateinit var distance : EditText

    private lateinit var calendar: Calendar
    private lateinit var date: DatePickerDialog.OnDateSetListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPatientBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setUi()
        setClickListeners()
    }

    private fun setClickListeners() {
        maritalStatus.setOnClickListener{
            openSingleStatusDialog()
        }
        sexe.setOnClickListener {
            openGenderDialog()
        }
        ethny.setOnClickListener {
            openEthnyDialog()
        }

        distance.setOnClickListener {
            openDistanceDialog()
        }

        education.setOnClickListener {
            openEducationDialog()
        }

        dob.setOnClickListener {
            openDatePicker()
        }
    }

    private fun setUi() {
        firstName = binding.signUpFirstName
        lastName = binding.signUpName
        sexe =  binding.sexe
        dob = binding.patientDob
        ethny = binding.ethny
        idNumber = binding.carteId
        gsRh = binding.gs
        education = binding.patientNiveauInstruction
        maritalStatus = binding.patientSituationMatri
        profession = binding.patientProfession
        telephoneNumber = binding.patientPhone
        village = binding.patientQuartier
        distance = binding.patientDistance
    }

    private fun validationInformation():Boolean{
        return when{
            TextUtils.isEmpty(village.text.toString()) -> {
                showErrorMessage(getString(R.string.error_profile), true)
                false
            }

            TextUtils.isEmpty(dob.text.toString()) -> {
                showErrorMessage(getString(R.string.error_dob), true)
                false
            }

            else -> {
                true
            }
        }
    }

    private fun prepareDatePicker() {
        calendar = Calendar.getInstance()
        date =
            DatePickerDialog.OnDateSetListener { _: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                calendar[Calendar.YEAR] = year
                calendar[Calendar.MONTH] = monthOfYear
                calendar[Calendar.DAY_OF_MONTH] = dayOfMonth
                updateDateUI()
            }

    }

    private fun openDatePicker() {
        DatePickerDialog(
            this, date, calendar[Calendar.YEAR],
            calendar[Calendar.MONTH],
            calendar[Calendar.DAY_OF_MONTH]
        ).show()
    }

    private fun updateDateUI() {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.UK)
        dob.setText(sdf.format(calendar.time))
    }

    private fun openSingleStatusDialog() {
        val singleStatusArray = resources.getStringArray(R.array.patient_matrimoniale)
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.patient_single_status)
            .setItems(R.array.patient_matrimoniale) { _, which ->
                when (which) {
                    0 -> maritalStatus.setText(singleStatusArray[0])
                    1 -> maritalStatus.setText(singleStatusArray[1])
                    2 -> maritalStatus.setText(singleStatusArray[2])
                }
            }

        val dialog = builder.create()
        dialog.show()
    }

    private fun openEducationDialog() {
        val educationArray = resources.getStringArray(R.array.patient_education)
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.patient_niveau_instruction)
            .setItems(R.array.patient_education) { _, which ->
                when (which) {
                    0 -> education.setText(educationArray[0])
                    1 -> education.setText(educationArray[1])
                    2 -> education.setText(educationArray[2])
                }
            }

        val dialog = builder.create()
        dialog.show()
    }

    private fun openEthnyDialog() {
        val ethnyArray = resources.getStringArray(R.array.patient_ehtny)
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.patient_ethnie)
            .setItems(R.array.patient_ehtny) { _, which ->
                when (which) {
                    0 -> ethny.setText(ethnyArray[0])
                    1 -> ethny.setText(ethnyArray[1])
                }
            }

        val dialog = builder.create()
        dialog.show()
    }

    private fun openGenderDialog() {
        val genderArray = resources.getStringArray(R.array.patient_sex)
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.patient_sexe)
            .setItems(R.array.patient_sex) { _, which ->
                when (which) {
                    0 -> sexe.setText(genderArray[0])
                    1 -> sexe.setText(genderArray[1])
                }
            }

        val dialog = builder.create()
        dialog.show()
    }


    private fun openDistanceDialog() {
        val distanceArray = resources.getStringArray(R.array.patient_distance)

        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.patient_distance)
            .setItems(R.array.patient_distance) { _, which ->
                when (which) {
                    0 -> distance.setText(distanceArray[5])
                    1 -> distance.setText(distanceArray[6])
                    2 -> distance.setText(distanceArray[7])
                    3 -> distance.setText(distanceArray[8])
                }
            }

        val dialog = builder.create()
        dialog.show()
    }
}