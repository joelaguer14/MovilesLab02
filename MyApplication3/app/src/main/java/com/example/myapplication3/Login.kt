package com.example.myapplication3
import java.lang.CharSequence
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var workerList = arrayListOf<Worker>(
            Worker(name= "Alonso Calderon",id="116880486", address = "Santa Ana", emailAddress = "alonso@gmail.com",
            phone="60021119",position="developer", startDate = "06/06/66", password = "1234"),
            Worker(name= "Joel Aguero",id="11111111", address = "Puris", emailAddress = "joel@gmail.com",
                phone="60021119",position="developer", startDate = "06/06/66", password = "1234")
            )
        val register =  findViewById<Button>(R.id.registerButton)
        val username = findViewById<EditText>(R.id.etuser)
        val password = findViewById<EditText>(R.id.etpassword)
        val enviar = findViewById<Button>(R.id.btnEnviar)


        enviar.setOnClickListener{
            var worker = workerList.find { username.text.toString().contains(it.id) && password.text.toString().contains(it.password) }
            val intent = Intent(this, MenuJopApp::class.java)
            intent.putExtra(MenuJopApp.WORKER,worker)
            startActivity(intent)

        }
        register.setOnClickListener{
            val intent = Intent(this, JobAppForm::class.java)
            startActivity(intent)
        }
    }

}