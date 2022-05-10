package com.example.myapplication3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class JobAppForm : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_app_form)
        val save =  findViewById<Button>(R.id.saveButton)

        save.setOnClickListener{
            val name:String = intent.getStringExtra("name").toString()
            val id:String = intent.getStringExtra("id").toString()
            val password:String = intent.getStringExtra("password").toString()
            val email:String = intent.getStringExtra("email").toString()
            val phone:String = intent.getStringExtra("phone").toString()
            val address:String = intent.getStringExtra("address").toString()
            val startDate:String = intent.getStringExtra("startDate").toString()
            val experience =  findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView).text.toString()
            val position =  findViewById<CheckedTextView>(R.id.checkedTextJa1).text.toString() + findViewById<CheckedTextView>(R.id.checkedTextViewJa2).text.toString()
            val softSkills =  findViewById<MultiAutoCompleteTextView>(R.id.multiAutoCompleteTextView).text.toString()
            val salaryDollars =  findViewById<EditText>(R.id.editTextNumberDecimal).text.toString()
            val salaryColones =  findViewById<EditText>(R.id.editTextNumber).text.toString()
            val comments =  findViewById<EditText>(R.id.editTextTextMultiLine).text.toString()
            val deductions =  findViewById<EditText>(R.id.editTextNumberSigned).text.toString()
            val startTime =  findViewById<EditText>(R.id.editTextTime2).text.toString()
            val endTime =  findViewById<EditText>(R.id.editTextTime).text.toString()

            var worker  = Worker (name= name,id=id, address = address, emailAddress = email,
                phone=phone,position=position, startDate = startDate, password = password,
                pinCode = "123",startTime = startTime,endTime = endTime, experience = experience, softSkills = softSkills,
                salaryDollars = salaryDollars, salaryColones = salaryColones, comments = comments, deductions = deductions)
            val intent = Intent(this, Login::class.java)
            intent.putExtra(Login.WORKER,worker)
            startActivity(intent)

        }
        cargarCheckedTextViews()
        cargarAutoCompleteTextView()
        cargarMultiAutoCompleteTextView()


    }

    private fun cargarCheckedTextViews(){
        val checked1 = findViewById<CheckedTextView>(R.id.checkedTextJa1)
        val checked2 = findViewById<CheckedTextView>(R.id.checkedTextViewJa2)
        checked2.isChecked = !checked2.isChecked
        checked1.isChecked = !checked1.isChecked
        checked1.setCheckMarkDrawable(android.R.drawable.checkbox_off_background)
        checked2.setCheckMarkDrawable(android.R.drawable.checkbox_off_background)

        checked1.setOnClickListener {
            checked1.isChecked = !checked1.isChecked

            checked1.setCheckMarkDrawable(
                if (checked1.isChecked){
                    android.R.drawable.checkbox_off_background
                }
                else{
                    android.R.drawable.checkbox_on_background
                }
            )
        }

        checked2.setOnClickListener {
            checked2.isChecked = !checked2.isChecked

            checked2.setCheckMarkDrawable(
                if (checked2.isChecked){
                    android.R.drawable.checkbox_off_background

                }
                else{
                    android.R.drawable.checkbox_on_background
                }
            )
        }
    }

    private fun cargarAutoCompleteTextView(){
        val autoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        var suggestions = arrayOf("Ninguna","1 año","1 año +")
        var adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,suggestions)
        autoCompleteTextView.threshold = 0
        autoCompleteTextView.setAdapter(adapter)
        autoCompleteTextView.setOnFocusChangeListener({view, b-> if(b) autoCompleteTextView.showDropDown()})

    }

    private fun cargarMultiAutoCompleteTextView(){
        val multiAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.multiAutoCompleteTextView)
        var suggestions = arrayOf("Leadership","Communication","Problem Solver","Time Managment")
        var adapter = ArrayAdapter(this,androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,suggestions)
        multiAutoCompleteTextView.threshold = 1
        multiAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        multiAutoCompleteTextView.setAdapter(adapter)
    }

}


