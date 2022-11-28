package com.example.healthapp.app.views

import android.app.AlertDialog
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import com.example.healthapp.R
import com.example.healthapp.app.utils.Common
import com.example.healthapp.app.utils.extensions.startActivity
import com.example.healthapp.databinding.ActivitySignUpFirstBinding
import java.text.SimpleDateFormat
import java.util.*

class SignUpFirstActivity : BaseActivity() {
    private lateinit var binding: ActivitySignUpFirstBinding

    private lateinit var profile: EditText
    private lateinit var dob: EditText
    private lateinit var btnNext: Button

    private lateinit var calendar: Calendar
    private lateinit var date: DatePickerDialog.OnDateSetListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUI()
        setClickListeners()
    }

    private fun setUI() {
        profile = binding.stickySwitch
        dob = binding.ageInput
        btnNext = binding.nextButton
        prepareDatePicker()
    }

    private fun setClickListeners() {
        profile.setOnClickListener {
            openProfileDialog()
        }

        dob.setOnClickListener {
            openDatePicker()
        }

        btnNext.setOnClickListener {
            if (validateInformation()) {
                startActivity<SignUpActivity>{
                    putExtra(Common.KEY_DOB,dob.text)
                    putExtra(Common.KEY_PROFILE, profile.text)
                }
            }
        }
    }

    private fun updateDateUI() {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.UK)
        dob.setText(sdf.format(calendar.time))
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

    private fun openProfileDialog() {
        val profileList = resources.getStringArray(R.array.profile_options)
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.profile)
            .setItems(R.array.profile_options) { _, which ->
                when (which) {
                    0 -> profile.setText(profileList[0])
                    1 -> profile.setText(profileList[1])
                    2 -> profile.setText(profileList[2])
                }
            }

        val dialog = builder.create()
        dialog.show()
    }

    private fun validateInformation(): Boolean {
        return when {
            TextUtils.isEmpty(profile.text.toString()) -> {
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
}