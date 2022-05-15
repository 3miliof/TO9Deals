package com.example.to9deals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TandCActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tand_cactivity)

        configureBackButton()
    }

    private fun configureBackButton() {

        val backButton = findViewById<Button>(R.id.backButton)

        backButton.setOnClickListener {

            var lastScreen = intent.getStringExtra("cameFrom")

            if (lastScreen == "Login") {

                var returnIntent = Intent(this, MainActivity::class.java)
                startActivity(returnIntent)

            } else if (lastScreen == "Logged In") {

                var returnIntent = Intent(this, FeaturedPageActivity::class.java)
                startActivity(returnIntent)
            }

        }

    }
}