package com.example.to9deals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FeaturedPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_featured_page)
        //Array [[BrandName, BrandDescription], [BrandName, BrandDescription], [BrandName, BrandDescription]]
        configureOnClickListeners()
    }
    private fun configureOnClickListeners() {

        val privacyPolicy = findViewById<TextView>(R.id.privacyPolicy)

        privacyPolicy.setOnClickListener {

            val  privacyPolicyIntent = Intent(this, TandCActivity::class.java)

            privacyPolicyIntent.putExtra("cameFrom", "Logged In")

            startActivity(privacyPolicyIntent)
        }

    }
}