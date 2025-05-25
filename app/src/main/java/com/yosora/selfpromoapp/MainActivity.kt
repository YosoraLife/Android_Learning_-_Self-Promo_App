package com.yosora.selfpromoapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.yosora.selfpromoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(this.binding.root)

        val previewButton: Button = binding.buttonPreview
        previewButton.setOnClickListener {
            onPreviewClicked()
        }

        val spinnerValues: Array<String> = arrayOf("Android Developer", "Android Engineer")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerValues)
        binding.spinnerJobTitle.adapter = spinnerAdapter
    }

    private fun onPreviewClicked() {

        val message = Message(
            binding.editTextContactName.text.toString(),
            binding.editTextContactNumber.text.toString(),
            binding.editTextMyDisplayName.text.toString(),
            binding.checkBoxJunior.isChecked,
            binding.spinnerJobTitle.selectedItem?.toString(),
            binding.checkBoxImmediateStart.isChecked,
            binding.editTextStartDate.text.toString()
        )

        val previewActivityIntent = Intent(this, PreviewActivity::class.java)
        previewActivityIntent.putExtra("Message", message)
        startActivity(previewActivityIntent)
    }
}