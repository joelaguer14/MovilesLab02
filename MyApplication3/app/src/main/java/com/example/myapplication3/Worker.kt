package com.example.myapplication3
import java.io.Serializable

data class Worker(val name: String, val id: String, val address: String,
                  val emailAddress : String, val phone : String,
                  val position : String, val startDate : String, val password:String ) : Serializable