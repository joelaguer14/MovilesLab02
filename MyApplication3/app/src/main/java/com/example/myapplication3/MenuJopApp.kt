package com.example.myapplication3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MenuJopApp : AppCompatActivity() {
    companion object{
        val WORKER = "worker_past";
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_jop_app)
        val tvusername =  findViewById<TextView>(R.id.workertxt)
        val tvaddress =  findViewById<TextView>(R.id.addressTextView)
        val tvemail =  findViewById<TextView>(R.id.emailTextView)
        val tvphone =  findViewById<TextView>(R.id.phoneTextView)
        val tvposition =  findViewById<TextView>(R.id.positionTextView)
        val tvdate =  findViewById<TextView>(R.id.dateTextView)

        val back =  findViewById<Button>(R.id.btnBack)

        val worker = intent.getSerializableExtra(WORKER) as Worker


        tvusername.text = worker.name
        tvaddress.text = worker.address
        tvemail.text = worker.emailAddress
        tvphone.text = worker.phone
        tvposition.text = worker.position
        tvdate.text = worker.startDate

        back.setOnClickListener{
            val intent = Intent(this, InterviewForm::class.java)

            startActivity(intent)
        }


    }
}