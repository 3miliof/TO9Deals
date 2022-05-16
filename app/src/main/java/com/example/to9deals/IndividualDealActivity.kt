package com.example.to9deals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.random.Random

class IndividualDealActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_individual_deal)

        unloadIntent()
        configureOnClickListeners()
    }

    private fun unloadIntent() {

        val dealTitle = findViewById<TextView>(R.id.BrandName)
        val dealDesc = findViewById<TextView>(R.id.brandDesc)

        dealTitle.text = intent.getStringExtra("BrandName")
        dealDesc.text = intent.getStringExtra("BrandDesc")

    }

    private fun configureOnClickListeners() {

        val backButton = findViewById<Button>(R.id.IndividualDealBack)
        val revealCodeButton = findViewById<Button>(R.id.revealCodeButton)

        backButton.setOnClickListener {

            val returnDestination = intent.getStringExtra("cameFrom")

            if (returnDestination == "FeaturedPage") {

                val returnIntent = Intent(this, FeaturedPageActivity::class.java)
                startActivity(returnIntent)

            }

        }

        var promoCode = ""
        revealCodeButton.setOnClickListener {

            if (promoCode == "") {
                promoCode = generateCode()
            }

            findViewById<Button>(R.id.revealCodeButton).text = promoCode

        }

    }

    private fun generateCode(): String {

        val brandNameNoSpaces = findViewById<TextView>(R.id.BrandName).text.filter {!it.isWhitespace()}
        val numsNeeded = 20 - brandNameNoSpaces.length
        var promoCode = brandNameNoSpaces.toString()

        for (loopNum in 0..numsNeeded) {

            promoCode += Random.nextInt(9).toString()

        }

        return promoCode
    }


    //val backButton = findViewById<Button>(R.id.backButton)
}