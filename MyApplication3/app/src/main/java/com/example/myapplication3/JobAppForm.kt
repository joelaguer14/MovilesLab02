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
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
        cargarCheckedTextViews()
        cargarAutoCompleteTextView()
        cargarMultiAutoCompleteTextView()
    }

    fun cargarCheckedTextViews(){
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

    fun cargarAutoCompleteTextView(){
        val autoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        var suggestions = arrayOf("Ninguna","1 año","1 año +")
        var adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,suggestions)
        autoCompleteTextView.threshold = 0
        autoCompleteTextView.setAdapter(adapter)
        autoCompleteTextView.setOnFocusChangeListener({view, b-> if(b) autoCompleteTextView.showDropDown()})

    }

    fun cargarMultiAutoCompleteTextView(){
        val multiAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.multiAutoCompleteTextView)
        var suggestions = arrayOf("Ninguna","1 año","1 año +")
        var adapter = ArrayAdapter(this,androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,suggestions)
        multiAutoCompleteTextView.threshold = 1
       // multiAutoCompleteTextView.setTokenizer(multiAutoCompleteTextView.CommaTokenizer())
        multiAutoCompleteTextView.setAdapter(adapter)


    }
}


