package com.example.to9deals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class IndividualDealActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_individual_deal)

        println(intent.getStringExtra("BrandDesc"))
    }
}