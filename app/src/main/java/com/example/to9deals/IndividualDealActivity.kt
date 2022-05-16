package com.example.to9deals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
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

            } else if (returnDestination == "fitnessPage") {

                val returnIntent = Intent(this, FitnessDealsActivity::class.java)
                startActivity(returnIntent)

            } else if (returnDestination == "hospitalityPage") {

                val returnIntent = Intent(this, HospitalityDealsActivity::class.java)
                startActivity(returnIntent)
            }else if (returnDestination == "shoppingPage") {

                val returnIntent = Intent( this, ShoppingDealsActivity::class.java)
                startActivity(returnIntent)

            }

        }

        var promoCode = ""
        revealCodeButton.setOnClickListener {

            if (promoCode == "") {
                promoCode = generateCode()
            }

            revealCodeButton.text = promoCode

        }

    }

    private fun generateCode(): String {

        val brandNameNoSpaces = findViewById<TextView>(R.id.BrandName).text.filter {!it.isWhitespace()}
        val numbsNeeded = 20 - brandNameNoSpaces.length
        var promoCode = brandNameNoSpaces.toString()

        for (loopNum in 0..numbsNeeded) {

            promoCode += Random.nextInt(9).toString()

        }

        return promoCode
    }


    //val backButton = findViewById<Button>(R.id.backButton)
}