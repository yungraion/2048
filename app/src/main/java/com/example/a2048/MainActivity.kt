package com.example.a2048

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var buttonArray = emptyArray<Array<Button>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonArray = arrayOf(
            arrayOf(button0,button1,button2,button3),
            arrayOf(button4,button5,button6,button7),
            arrayOf(button8,button9,button10,button11),
            arrayOf(button12,button13,button14,button15))
        Log.println(Log.WARN, "DEBUG", "START")

        GridLayout1.setOnTouchListener(object : OnSwipeTouchListener(this) {
            override fun onSwipeLeft() {
                Log.println(Log.WARN,"DEBUG", "left")
                swipeRight()
            }

            override fun onSwipeRight() {
                Log.println(Log.WARN,"DEBUG", "right")
                swipeLeft()
            }
        })
    }

    fun swipeLeft() {
        Toast.makeText(this, "Left", Toast.LENGTH_LONG).show()

    }

    fun swipeRight() {
        Toast.makeText(this, "Right", Toast.LENGTH_LONG).show()
    }

    fun play(v: View) {
        button16.text = "Restart"

        for (row in 0..3) {
            for (column in 0..3) {
                buttonArray[row][column].text = ""
            }
        }

        val randomRow = (Math.random() * 4).toInt()
        val randomColumn = (Math.random() * 4).toInt()

        buttonArray[randomRow][randomColumn].text = "2"

        var randomRow2 = (Math.random() * 4).toInt()
        var randomColumn2 = (Math.random() * 4).toInt()

        while(randomRow == randomRow2 && randomColumn == randomColumn2) {
            randomRow2 = (Math.random() * 4).toInt()
            randomColumn2 = (Math.random() * 4).toInt()
        }

        buttonArray[randomRow2][randomColumn2].text = "2"





    }
}
