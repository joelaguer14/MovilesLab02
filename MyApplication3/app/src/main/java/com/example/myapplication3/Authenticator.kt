package com.example.myapplication3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Authenticator : AppCompatActivity() {
    companion object {
        val WORKER = "worker_past";
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authenticator)
        val next = findViewById<Button>(R.id.nextButton)
        val pin = findViewById<EditText>(R.id.editTextNumberPassword)
        val worker = intent.getSerializableExtra(Login.WORKER) as Worker

        next.setOnClickListener {
            val intent = Intent(this, MenuJopApp::class.java)
            if (pin.text.toString().contains(worker.pinCode)) {
                intent.putExtra(Authenticator.WORKER, worker)
                startActivity(intent)
            }
        }
    }

}