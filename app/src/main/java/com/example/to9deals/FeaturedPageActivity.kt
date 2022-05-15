package com.example.to9deals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class FeaturedPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_featured_page)

        //Array [[BrandName, BrandDescription], [BrandName, BrandDescription], [BrandName, BrandDescription]]
        val featuredDeals: Array<Array<String>> = arrayOf(arrayOf("Featured Brand 1", "Featured Brand 1 is one of the leading gym in the world."),
            arrayOf("Featured Brand 2", "Featured Brand 2 is the of the leading restaurants in the world."),
            arrayOf("Featured Brand 3", "Featured Brand 3 is the of the leading hotels in the world."))

        configureOnClickListeners(featuredDeals)

    }


    /**
     * Function to configure the onclick listeners for the Brands and Privacy Policy buttons on the
     * page.
     */
    private fun configureOnClickListeners(featuredDeals: Array<Array<String>>) {

        //Declare variables to hold the widgets on the screen
        val privacyPolicy = findViewById<TextView>(R.id.privacyPolicy)
        val featuredOne = findViewById<ImageView>(R.id.featuredOne)
        val featuredTwo = findViewById<ImageView>(R.id.featuredTwo)
        val featuredThree = findViewById<ImageView>(R.id.featuredThree)
        val viewMoreButton = findViewById<Button>(R.id.viewMoreButton)

        //Set an onclick listener for the privacy policy to take the user there.
        privacyPolicy.setOnClickListener {

            val  privacyPolicyIntent = Intent(this, TandCActivity::class.java)
            //Add an extra to the intent, declaring where the user clicked the privacy policy from
            privacyPolicyIntent.putExtra("cameFrom", "Logged In")
            startActivity(privacyPolicyIntent)
        }

        val  dealIntent = Intent(this, IndividualDealActivity::class.java)
        featuredOne.setOnClickListener {

            //Add extras to the intent, where the user came from, and the brand details to display
            dealIntent.putExtra("cameFrom", "FeaturedPage")
            dealIntent.putExtra("BrandName",  featuredDeals[0][0])
            dealIntent.putExtra("BrandDesc", featuredDeals[0][1])

            startActivity(dealIntent)
        }

        featuredTwo.setOnClickListener {

            //Add extras to the intent, where the user came from, and the brand details to display
            dealIntent.putExtra("cameFrom", "FeaturedPage")
            dealIntent.putExtra("BrandName",  featuredDeals[1][0])
            dealIntent.putExtra("BrandDesc", featuredDeals[1][1])

            startActivity(dealIntent)
        }

        featuredThree.setOnClickListener {

            //Add extras to the intent, where the user came from, and the brand details to display
            dealIntent.putExtra("cameFrom", "FeaturedPage")
            dealIntent.putExtra("BrandName", featuredDeals[2][0])
            dealIntent.putExtra("BrandDesc", featuredDeals[2][1])

            startActivity(dealIntent)
        }

        viewMoreButton.setOnClickListener {

            val allDealsIntent = Intent(this, allDealsActivity::class.java)
            startActivity(allDealsIntent)

        }



    }
}