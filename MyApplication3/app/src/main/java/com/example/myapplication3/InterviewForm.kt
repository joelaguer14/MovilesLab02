package com.example.myapplication3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class InterviewForm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interview_form)
        val next =  findViewById<Button>(R.id.nextButton)
        next.setOnClickListener{
            colectAndSendInfo()
        }
    }

    fun colectAndSendInfo(){
        val name =  findViewById<EditText>(R.id.nameTxt)
        val id =  findViewById<EditText>(R.id.idTxt)
        val password =  findViewById<EditText>(R.id.passwordTxt)
        val email =  findViewById<EditText>(R.id.emailTxt)
        val phone =  findViewById<EditText>(R.id.phoneTxt)
        val address =  findViewById<EditText>(R.id.addressTxt)
        val startDate =  findViewById<EditText>(R.id.startDateTxt)
        val intent = Intent(this, JobAppForm::class.java)
        intent.putExtra("name",name.text.toString())
        intent.putExtra("id",id.text.toString())
        intent.putExtra("password",password.text.toString())
        intent.putExtra("email",email.text.toString())
        intent.putExtra("phone",phone.text.toString())
        intent.putExtra("address",address.text.toString())
        intent.putExtra("startDate",startDate.text.toString())
        startActivity(intent)
    }
}