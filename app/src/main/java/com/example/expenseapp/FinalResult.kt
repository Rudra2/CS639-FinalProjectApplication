package com.example.expenseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class FinalResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_result)

        //Fetch and Store expense data to variable
        var mListView = findViewById<ListView>(R.id.msglist)
        var accommodation=intent.getStringExtra("accommodation")
        var transportation=intent.getStringExtra("transportation")
        var food=intent.getStringExtra("food")
        var textbook=intent.getStringExtra("textbook")
        var travel=intent.getStringExtra("travel")
        var phone=intent.getStringExtra("phone")
        var entertainment=intent.getStringExtra("entertainment")

        // convert expense data to float

        var final_accommodation= if(accommodation.equals("")) 0 else accommodation?.toFloat()
        var final_transportation=if(transportation.equals("")) 0 else transportation?.toFloat()
        var fina_food= if(food.equals("")) 0 else food?.toFloat()
        var final_textbook= if(textbook.equals("")) 0 else textbook?.toFloat()
        var final_travel= if(travel.equals("")) 0 else travel?.toFloat()
        var final_phone= if(phone.equals("")) 0 else phone?.toFloat()
        var final_entertainment= if(entertainment.equals("")) 0 else entertainment?.toFloat()

        //total budget is 2000 and depending on find the percetage of expense.

         var total_budget=2000;
         var accommodation_percentage=(100*final_accommodation?.toFloat()!!)/2000;
        var transportation_percentage=(100*final_transportation?.toFloat()!!)/2000;
        var food_percentage=(100*fina_food?.toFloat()!!)/2000;
        var textbook_percentage=(100*final_textbook?.toFloat()!!)/2000;
        var travel_percentage=(100*final_travel?.toFloat()!!)/2000;
        var phone_percentage=(100*final_phone?.toFloat()!!)/2000;
        var entertainment_percentage=(100*final_entertainment?.toFloat()!!)/2000;

        val list: MutableList<String> = ArrayList()

        if(accommodation_percentage>40)
        {
            list.add("\nAccommodation : "+final_accommodation.toString()+"\n\nTo save money, student should opt for sharing basis accomodation. He can also look for places which have low rents than there University area.");
        }

        if(transportation_percentage>10)
        {
            list.add("\nTransportation : "+final_transportation.toString()+"\n\nPublic transportation is usually the most affordable option. Students can consider investing in a monthly pass to save money in the long run.");
        }

        if(food_percentage>20)
        {
            list.add("\nFood And Groceries : "+fina_food.toString()+"\n\nTo save money, students can cook meals at home instead of eating out. They can also consider buying groceries in bulk and shopping at budget-friendly stores.");
        }

        if(textbook_percentage>5)
        {
            list.add("\nTextbooks And Course : "+final_textbook.toString()+"\n\nTextbooks and course materials: To save money, students can consider buying used textbooks or renting them. They can also look for free online resources or borrow materials from the library.");
        }

        if(travel_percentage>10)
        {
            list.add("\nTravel : "+final_travel.toString()+"\n\nTo save money, students can plan their trips in advance, take advantage of student discounts, and consider cheaper modes of transportation.");
        }

        if(phone_percentage>5)
        {
            list.add("\nPhone And Internet Bills : "+final_phone.toString()+"\n\nTo save money, students can consider opting for a cheaper phone plan or internet package.");
        }

        if(entertainment_percentage>10)
        {
            list.add("\nEntertainment : "+final_entertainment.toString()+"\n\nTo save money, students can llok for free activities, such as visiting museums or parks, joining clubs, or attending events on campus.");
        }


        val arrayAdapter: ArrayAdapter<*>
        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, list)
        mListView.adapter = arrayAdapter



    }
}