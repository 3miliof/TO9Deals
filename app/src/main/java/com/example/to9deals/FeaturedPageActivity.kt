package com.example.to9deals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class FeaturedPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_featured_page)

        //Array [[BrandName, BrandDescription], [BrandName, BrandDescription], [BrandName, BrandDescription]]
        var featuredDeals: Array<Array<String>> = arrayOf(arrayOf("Featured Brand 1", "Featured Brand 1 is one of the leading gym in the world, giving you access to the gym for free for one month!"),
            arrayOf("Featured Brand 2", "Featured Brand 2 is the of the leading gyms in the world."))

        configureOnClickListeners(featuredDeals)

    }


    /**
     * Function to configure the onclick listeners for the Brands and Privacy Policy buttons on the
     * page.
     */
    private fun configureOnClickListeners(featuredDeals: Array<Array<String>>) {

        //Hold the privacy policy textview within a variable
        val privacyPolicy = findViewById<TextView>(R.id.privacyPolicy)

        //Set an onclick listener for the privacy policy to take the user there.
        privacyPolicy.setOnClickListener {

            val  privacyPolicyIntent = Intent(this, TandCActivity::class.java)
            //Add an extra to the intent, declaring where the user clicked the privacy policy from
            privacyPolicyIntent.putExtra("cameFrom", "Logged In")
            startActivity(privacyPolicyIntent)
        }

        val featuredOne = findViewById<ImageView>(R.id.featuredOne)
        val featuredTwo = findViewById<ImageView>(R.id.featuredTwo)
        val featuredThree = findViewById<ImageView>(R.id.featuredThree)

        val  dealIntent = Intent(this, IndividualDealActivity::class.java)
        featuredOne.setOnClickListener {

            //Add an extra to the intent, declaring where the user clicked the privacy policy from
            dealIntent.putExtra("cameFrom", "FeaturedPage")
            dealIntent.putExtra("Brand", "Featured Brand 1")
            dealIntent.putExtra("BrandDesc", featuredDeals[0][1])

            startActivity(dealIntent)
        }
    }
}