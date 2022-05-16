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
        val featuredDeals: Array<Array<String>> = arrayOf(arrayOf("FreshGym", "FreshGym is one of the leading gym groups in the world, with over 3000 locations in the UK alone. With this offer, you can get a free personal training class for each month of membership purchased! Click below to receive the code and then redeem it on their website!"),
            arrayOf("Eaters Pizza", "EatersPizza is one of the leading restaurants in Poole."),
            arrayOf("BridgeHouse Hotels", "BridgeHouseHotels is one of the leading hotel groups in Bournemouth."))

        configureOnClickListeners(featuredDeals)
        updateDealsText(featuredDeals)
    }


    /**
     * Function to configure the onclick listeners for the Brands and Privacy Policy buttons on the
     * page.
     * @param featuredDeals - The Array of arrays containing information on each of the featured deals.
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

    /**
     * Function to update the brand titles on each of the famous brands.
     * @param featuredDeals - Array of arrays holding the information on the featured deals to display
     */
    private fun updateDealsText(featuredDeals: Array<Array<String>>) {

        //Get the widget objects for each title on screen
        val featuredOneText = findViewById<TextView>(R.id.featuredOneText)
        val featuredTwoText = findViewById<TextView>(R.id.featuredTwoText)
        val featuredThreeText = findViewById<TextView>(R.id.featuredThreeText)

        //Update the title of each brand to the stored name
        featuredOneText.text = featuredDeals[0][0]
        featuredTwoText.text = featuredDeals[1][0]
        featuredThreeText.text = featuredDeals[2][0]

    }
}