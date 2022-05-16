
package com.example.to9deals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.iterator

class TechnologyDealsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_technology_deals)

        val brandsTitles = findViewById<ConstraintLayout>(R.id.technologyBrandsLayout)
        val technologyBrands: Array<Array<String>> = arrayOf(arrayOf("Burger King", "Kurger Bing is one of the largest fast food chains in the world. With stores across every continent they continue to provide fast and tasty food to their customers. This code entitles you to a free large drink with any single burger."),
            arrayOf("Gordon Ramsay", "Gordon Ramsay is a famous celebrity chef, his high end michelin star restaurants being some of the most well known in the country. Use this code to enjoy a tasting experience for two. Quote your code on booking through the restaurant in order for it to be redeemed."),
            arrayOf("Pizza Express", "Bringing a dining table to life with great food, great music and great company. Lifting glasses and spirits. Getting smiles on faces and sauce on t-shirts. That's what Pizza Express is about. Use this code to get 30% off any large pizza!"),
            arrayOf("JD Wetherspoon", "The company aims to provide customers with good-quality food and drinks, served by well-trained and friendly staff, at reasonable prices. The pubs are individually designed, bringing you a fresh experience wherever you go! This code gets you 3 small plates for $10!"),
            arrayOf("Dominos", "Dominos is the largest pizza delivery service in the UK! Bringing fresh hot pizza right to your door! From pizza to sides, to desserts, Domino's have it all! This code allows you to get 30% off any non-deal orders. Get your Pizza Now!"))


        loadBrandDetails(brandsTitles, technologyBrands)
        configureOnClickListeners(brandsTitles, technologyBrands)

    }

    /**
     * Function to assign onclick listeners dynamically to the brand objects created.
     * @param brandsTitles - The constraint layout holding all of the brand ImageViews and TextViews
     * @param technologyBrands - The array of arrays holding the information for each brand, to be displayed on the individual pages.
     */
    private fun configureOnClickListeners(brandsTitles: ConstraintLayout, technologyBrands: Array<Array<String>>) {

        var counter = 0


        //Set onclick listeners for each brand object
        for (component in brandsTitles) {

            if (component is ImageView) {

                component.setOnClickListener {

                    val dealIntent = Intent(this, IndividualDealActivity::class.java)
                    dealIntent.putExtra("cameFrom", "technologyPage")
                    dealIntent.putExtra("BrandName",  technologyBrands[getBrandIndex(component)][0])
                    dealIntent.putExtra("BrandDesc", technologyBrands[getBrandIndex(component)][1])
                    startActivity(dealIntent)

                }

                counter += 1

            }

        }

        //Set an onclick listener for the back button
        val backButton = findViewById<Button>(R.id.technologyDealsBack)

        backButton.setOnClickListener {

            val backToAllDeals = Intent(this, allDealsActivity::class.java)
            startActivity(backToAllDeals)

        }

    }

    /**
     * Function used to get the index of the corresponding brand information in the array of brands
     * @param component - The component that the brand information will be displayed on
     * @return An integer value corresponding to the place of the brand information in the technologyBrands array
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
     * @param technologyBrands - The array of arrays holding the information for each brand, to be displayed on the individual pages.
     */
    private fun loadBrandDetails(brandsTitles: ConstraintLayout, technologyBrands: Array<Array<String>>) {

        var counter = 0

        for (component in brandsTitles) {

            if (component is TextView) {

                component.text = technologyBrands[counter][0] //Set the text value to what is stored in the array
                counter += 1
            }

        }

    }
}
