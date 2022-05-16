package com.example.to9deals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.iterator

class FitnessDealsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fitness_deals)

        val brandsTitles = findViewById<ConstraintLayout>(R.id.shoppingBrandsLayout)
        val fitnessBrands: Array<Array<String>> = arrayOf(arrayOf("FreshGym", "FreshGym is one of the leading gym groups in the world, with over 3000 locations in the UK alone. With this offer, you can get a free personal training class for each month of membership purchased! Click below to receive the code and then redeem it on their website!"),
            arrayOf("PureGym", "FreshGym is one of the leading gym groups in the world, with over 3000 locations in the UK alone. With this offer, you can get a free personal training class for each month of membership purchased! Click below to receive the code and then redeem it on their website!"),
            arrayOf("GymLife", "FreshGym is one of the leading gym groups in the world, with over 3000 locations in the UK alone. With this offer, you can get a free personal training class for each month of membership purchased! Click below to receive the code and then redeem it on their website!"),
            arrayOf("FitnessDudes", "FreshGym is one of the leading gym groups in the world, with over 3000 locations in the UK alone. With this offer, you can get a free personal training class for each month of membership purchased! Click below to receive the code and then redeem it on their website!"),
            arrayOf("ExerciseU", "FreshGym is one of the leading gym groups in the world, with over 3000 locations in the UK alone. With this offer, you can get a free personal training class for each month of membership purchased! Click below to receive the code and then redeem it on their website!"))


        loadBrandDetails(brandsTitles, fitnessBrands)
        configureOnClickListeners(brandsTitles, fitnessBrands)

    }

    /**
     * Function to assign onclick listeners dynamically to the brand objects created.
     * @param brandsTitles - The constraint layout holding all of the brand ImageViews and TextViews
     * @param fitnessBrands - The array of arrays holding the information for each brand, to be displayed on the individual pages.
     */
    private fun configureOnClickListeners(brandsTitles: ConstraintLayout, fitnessBrands: Array<Array<String>>) {

        var counter = 0


        //Set onclick listeners for each brand object
        for (component in brandsTitles) {

            if (component is ImageView) {

                component.setOnClickListener {

                    val dealIntent = Intent(this, IndividualDealActivity::class.java)
                    dealIntent.putExtra("cameFrom", "fitnessPage")
                    dealIntent.putExtra("BrandName",  fitnessBrands[getBrandIndex(component)][0])
                    dealIntent.putExtra("BrandDesc", fitnessBrands[getBrandIndex(component)][1])
                    startActivity(dealIntent)

                }

                counter += 1

            }

        }

        //Set an onclick listener for the back button
        val backButton = findViewById<Button>(R.id.shoppingDealsBack)

        backButton.setOnClickListener {

            val backToAllDeals = Intent(this, allDealsActivity::class.java)
            startActivity(backToAllDeals)

        }

    }

    /**
     * Function used to get the index of the corresponding brand information in the array of brands
     * @param component - The component that the brand information will be displayed on
     * @return An integer value corresponding to the place of the brand information in the fitnessBrands array
     */
    private fun getBrandIndex(component : ImageView): Int {

        //Filter the content description to find which number brand it is
        val digit = component.contentDescription.filter {it.isDigit()}

        //Return the integer value, altered to correspond to the array of brand information
        return Integer.parseInt(digit.toString())-1
    }


    /**
     * Function used to get the brand titles for each brand stores and display them on the screen
     * @param brandsTitles - The constraint layout holding all of the brand ImageViews and TextViews
     * @param fitnessBrands - The array of arrays holding the information for each brand, to be displayed on the individual pages.
     */
    private fun loadBrandDetails(brandsTitles: ConstraintLayout, fitnessBrands: Array<Array<String>>) {

        var counter = 0

        for (component in brandsTitles) {

            if (component is TextView) {

                component.text = fitnessBrands[counter][0] //Set the text value to what is stored in the array
                counter += 1
            }

        }

    }
}