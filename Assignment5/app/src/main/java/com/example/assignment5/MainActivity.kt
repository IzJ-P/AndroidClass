package com.example.assignment5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var tvMessage: TextView
    lateinit var btnSave: Button

    lateinit var tvName: EditText
    lateinit var tvEmail: EditText
    lateinit var tvPassword: EditText
    lateinit var tvPhone: EditText
    lateinit var tvBio: EditText
    lateinit var data: DataManager

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        data = DataManager(this)
        println("Data to start: ${data.name}, ${data.email}")
        instantiateObjects()
        data.readFromFile()
        println("Data now: ${data.name}")
        saveButtonClicked(data)
    }

    fun clearFields() {
        tvName.text.clear()
        tvEmail.text.clear()
        tvPassword.text.clear()
        tvPhone.text.clear()
        tvBio.text.clear()
    }

    fun instantiateObjects() {
        tvMessage = findViewById(R.id.tvMessage)
        btnSave = findViewById(R.id.btnSave)

        tvName = findViewById(R.id.tvName)
        tvEmail = findViewById(R.id.tvEmail)
        tvPassword = findViewById(R.id.tvPassword)
        tvPhone = findViewById(R.id.tvPhone)
        tvBio = findViewById(R.id.tvBio)
    }

    fun saveButtonClicked(data: DataManager) {
        btnSave.setOnClickListener {

            data.name = tvName.text.toString()
            data.email = tvEmail.text.toString()
            data.phone = tvPhone.text.toString()
            data.password = tvPassword.text.toString()
            data.bio = tvBio.text.toString()

            data.saveToFile()
            clearFields()
            tvMessage.text = "Thank you, ${data.name} information saved."

        }
    }


}
