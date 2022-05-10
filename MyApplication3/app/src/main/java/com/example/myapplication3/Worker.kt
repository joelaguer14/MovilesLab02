package com.example.myapplication3
import java.io.Serializable

data class Worker(
    val name: String,
    val id: String,
    val address: String,
    val emailAddress: String,
    val phone: String,
    val position: String,
    val startDate: String,
    val password: String,
    val pinCode: String,
    val startTime: String,
    val endTime: String,
    val experience: String,
    val softSkills: String,
    val salaryDollars: String,
    val salaryColones: String,
    val comments: String,
    val deductions: String
) : Serializable