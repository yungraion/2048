package com.example.a2048

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
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
    }

    fun sayHello(v: View) {
        val randomNumber = Math.random() * 4
        val randomColumn = Math.random() * 4
        buttonArray[randomNumber.toInt()][randomColumn.toInt()].text = "2"
    }
}
