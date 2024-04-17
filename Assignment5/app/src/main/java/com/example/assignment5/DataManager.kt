package com.example.assignment5

import android.content.Context
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader
import java.lang.Exception

class DataManager(private var activity: MainActivity) {
    var name: String? = null
    var email: String? = null
    var phone: String? = null
    var password: String? = null
    var bio: String? = null

    fun readFromFile(){
        val filename: String = "userInfo.txt"
        var fileInputStream: FileInputStream? = null

        try {
            fileInputStream = activity.openFileInput(filename)
            val inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
            val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
            val stringBuilder: StringBuilder = StringBuilder()
            var text: String? = null

            while ({ text = bufferedReader.readLine(); text }() != null) {
                stringBuilder.append(text)
                println(text)
            }
        } catch (e: Exception) {
            println("Error $e")
        }
    }
    fun saveToFile() {
        val data = """{
            "name": "$name",
            "email": "$email",
            "phone": "$phone",
            "password": "$password",
            "bio": "$bio"
        }"""
        val filename = "userInfo.txt"
        try {
            val fileOutputStream = activity.openFileOutput(filename, Context.MODE_PRIVATE)
            fileOutputStream.write(data.toByteArray())
            fileOutputStream.close()
        } catch (e: Exception) {
            e.printStackTrace()

        }
    }
}