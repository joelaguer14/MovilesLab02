package com.example.myapplication3
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {
    companion object{
        val WORKER = "worker_past";
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val register =  findViewById<Button>(R.id.registerButton)
        val username = findViewById<EditText>(R.id.etuser)
        val password = findViewById<EditText>(R.id.etpassword)
        val enviar = findViewById<Button>(R.id.btnEnviar)
        val worker = intent.getSerializableExtra(WORKER) as Worker




        enviar.setOnClickListener{
            val intent = Intent(this, Authenticator::class.java)
            if (username.text.toString().contains(worker.id) && password.text.toString().contains(worker.password)) {
                intent.putExtra(Authenticator.WORKER, worker)
                startActivity(intent)
            }
        }

        register.setOnClickListener{
            val intent = Intent(this, InterviewForm::class.java)
            startActivity(intent)
        }
    }

}