package com.example.mealapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.time.Duration.Companion.hours

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "WrongViewCast", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Initializing UI elements
        val timeEdt = findViewById<EditText>(R.id.Time)// Input field for time
        val meals = findViewById<Button>(R.id.Meals)//Button to check meal options
        val reset = findViewById<Button>(R.id.Clear)// Button to reset fields
        val answer = findViewById<TextView>(R.id.Final)// TextView to display meal options

        // Setting click listeners for buttons
        meals.setOnClickListener {
            // Retrieving user input from the EditText and converting to an integer
            var time = timeEdt.text.toString().toInt()
            // Displaying the entered time as a Toast message
            Toast.makeText(this, "Time is $time", Toast.LENGTH_LONG).show()
            // Checking the time range and updating the answer TextView accordingly
            if(time >= 5 && time <= 7){
                answer.text =
                    " MORNING MEALS \n Bacon and Eggs \n Waffles \n Sweet Potato Breakfast Burrito \n Smoothie of your choice"

            } else if (time >= 8 && time <=11 ) {
                answer.text = "MIT-MORNING MEALS \n Eggs.\n"+ "Greek yogurt.\n"+ "Coffee.\n"+ "Oatmeal.\n"+ "Chia seeds.\n"+ "Berries.\n"+ "Cottage cheese.\n"+ "Whole grain toast. "

            }else if (time >= 12 && time <= 13){
                answer.text ="AFTERNOON MEALS \n Buffalo Chicken Grilled Cheese \n Taco Salad \n Thai-Inspired Basil Beef Bowls \n Chicken/Beef/Rib Burger \n Salmon Quinoa Bowls"

            }else if (time > 13 && time <= 17){
                answer.text ="MIT-AFRERNOON MEALS \n Smoothie of your choice \n Sandwiches \n Sesame Soba Noodles \n Fresh Spring Rolls \n Tofu Nuggets "

            }else if (time >= 18&& time <= 20){
                answer.text ="DINNER MEALS \n Steak and Potatoes \n Pork Ribs \n Roasted Vegetables \n Chicken Pot Pie \n Butter Chicken \n Carbonara of your Choice  "

            }else
                answer.text = "NO MEALS"// If the time is outside meal hours

            // Click listener for the Reset button to clear the input and output
            reset.setOnClickListener {
                answer.text = ""// Clear the answer text
                timeEdt.text.clear()// Clear the input field
            }

        }


    }
}
