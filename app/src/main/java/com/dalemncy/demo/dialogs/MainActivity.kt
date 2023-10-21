package com.dalemncy.demo.dialogs

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.dalemncy.demo.dialogs.databinding.ActivityMainBinding
import com.dalemncy.demo.dialogs.dialogs.CustomDialog
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.simpleContentDialog.setOnClickListener { simpleContentDialog() }
        binding.yesOrNoDialog.setOnClickListener { yesOrNoDialog() }
        binding.datePickerDialog.setOnClickListener { datePickerDialog() }
        binding.timePickerDialog.setOnClickListener { timePickerDialog() }
        binding.customDialog.setOnClickListener { customDialog() }
    }

    private fun simpleContentDialog() {
        val dialogBuilder = AlertDialog.Builder(this)

        dialogBuilder.setMessage("This is a sample dialog.")
            .setCancelable(false) // Set this to true if you dialog can be closed via tapping outside.
            .setPositiveButton("Okay") { dialog, _ -> dialog.dismiss() }

        val alert = dialogBuilder.create()
        alert.setTitle("Sample Dialog")
        alert.show()
    }

    private fun yesOrNoDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Confirmation")
        builder.setMessage("Are you sure you want to proceed?")
        builder.setPositiveButton("Yes") { dialogInterface, _ ->
            // Handle the "Yes" response here
            Toast.makeText(this, "You said Yes", Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss()
        }
        builder.setNegativeButton("No") { dialogInterface, _ ->
            // Handle the "No" response here
            Toast.makeText(this, "You said No", Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss()
        }
        builder.setNeutralButton("Maybe") { dialogInterface, _ ->
            // Handle the "Maybe" response here
            Toast.makeText(this, "You said Maybe", Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss()
        }
        builder.show()
    }

    private fun datePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this,
            { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
                val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                Toast.makeText(this, selectedDate, Toast.LENGTH_SHORT).show()
            }, year, month, day)

        datePickerDialog.show()
    }

    private fun timePickerDialog() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(this,
            { _: TimePicker, selectedHour: Int, selectedMinute: Int ->
                val selectedTime = String.format("%02d:%02d", selectedHour, selectedMinute)
                Toast.makeText(this, selectedTime, Toast.LENGTH_SHORT).show()
            }, hour, minute, true)

        timePickerDialog.show()
    }

    private fun customDialog() {
        val customDialog = CustomDialog(this)
        customDialog.show()
    }
}