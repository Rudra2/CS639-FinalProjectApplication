package com.example.expenseapp

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.MPPointF

class GraphActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph)
        var accommodation=intent.getStringExtra("accommodation")
        var transportation=intent.getStringExtra("transportation")
        var food=intent.getStringExtra("food")
        var textbook=intent.getStringExtra("textbook")
        var travel=intent.getStringExtra("travel")
        var phone=intent.getStringExtra("phone")
        var entertainment=intent.getStringExtra("entertainment")


        var final_accommodation= if(accommodation.equals("")) 0 else accommodation?.toFloat()
        var final_transportation=if(transportation.equals("")) 0 else transportation?.toFloat()
        var fina_food= if(food.equals("")) 0 else food?.toFloat()
        var final_textbook= if(textbook.equals("")) 0 else textbook?.toFloat()
        var final_travel= if(travel.equals("")) 0 else travel?.toFloat()
        var final_phone= if(phone.equals("")) 0 else phone?.toFloat()
        var final_entertainment= if(entertainment.equals("")) 0 else entertainment?.toFloat()

      var  pieChart = findViewById<com.github.mikephil.charting.charts.PieChart>(R.id.pieChart)
        pieChart.setUsePercentValues(true)
        pieChart.getDescription().setEnabled(false)
        pieChart.setExtraOffsets(5f, 10f, 5f, 5f)
        pieChart.setDragDecelerationFrictionCoef(0.95f)

        pieChart.setDrawHoleEnabled(true)
        pieChart.setHoleColor(Color.WHITE)
        pieChart.setTransparentCircleColor(Color.WHITE)
        pieChart.setTransparentCircleAlpha(110)
        pieChart.setHoleRadius(58f)
        pieChart.setTransparentCircleRadius(61f)
        pieChart.setDrawCenterText(true)
        pieChart.setRotationAngle(0f)
        pieChart.setRotationEnabled(true)
        pieChart.setHighlightPerTapEnabled(true)
        pieChart.animateY(1400, Easing.EaseInOutQuad)
        pieChart.legend.isEnabled = false
        pieChart.setEntryLabelColor(Color.WHITE)
        pieChart.setEntryLabelTextSize(12f)




        val expense: ArrayList<PieEntry> = ArrayList()
        expense.add(PieEntry(final_accommodation?.toFloat()!!))
        expense.add(PieEntry(final_transportation?.toFloat()!!))
        expense.add(PieEntry(fina_food?.toFloat()!!))
        expense.add(PieEntry(final_textbook?.toFloat()!!))
        expense.add(PieEntry(final_travel?.toFloat()!!))
        expense.add(PieEntry(final_phone?.toFloat()!!))
        expense.add(PieEntry(final_entertainment?.toFloat()!!))

        val dataSet = PieDataSet(expense, "Expense")
        dataSet.setDrawIcons(false)
        dataSet.sliceSpace = 3f
        dataSet.iconsOffset = MPPointF(0f, 40f)
        dataSet.selectionShift = 5f

        val colors: ArrayList<Int> = ArrayList()
        colors.add(resources.getColor(R.color.purple_200))
        colors.add(resources.getColor(R.color.teal_700))
        colors.add(resources.getColor(R.color.red))

        colors.add(resources.getColor(R.color.purple_500))
        colors.add(resources.getColor(R.color.teal_200))
        colors.add(resources.getColor(R.color.yellow))
        colors.add(resources.getColor(R.color.darkgreen))



        dataSet.colors = colors

        val data = PieData(dataSet)
        data.setValueFormatter(PercentFormatter())
        data.setValueTextSize(15f)
        data.setValueTypeface(Typeface.DEFAULT_BOLD)
        data.setValueTextColor(Color.WHITE)
        pieChart.setData(data)
        pieChart.highlightValues(null)
        pieChart.invalidate()


    }
}