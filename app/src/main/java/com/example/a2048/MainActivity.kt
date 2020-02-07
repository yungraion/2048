package com.example.a2048

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    var buttonArray = emptyArray<Array<Button>>()
    var counter: Int = 0
    var score = 0
    var best = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView6.visibility = View.INVISIBLE
        buttonArray = arrayOf(
            arrayOf(button0, button1, button2, button3),
            arrayOf(button4, button5, button6, button7),
            arrayOf(button8, button9, button10, button11),
            arrayOf(button12, button13, button14, button15)
        )

        Log.println(Log.WARN, "DEBUG", "START")


    }

    fun moveTiles(startX: Int, startY: Int, targetX: Int, targetY: Int) {
        if (buttonArray[targetX][targetY].text.equals("")) {
            buttonArray[targetX][targetY].text= buttonArray[startX][startY].text.toString()
            buttonArray[startX][startY].text=("")
        } else if (buttonArray[startX][startY].text.equals(buttonArray[targetX][targetY].text)) {
            var temp: Int = buttonArray[targetX][targetY].text.toString().toInt()
            buttonArray[targetX][targetY].text=("" + temp * 2)
            buttonArray[startX][startY].text=("")
            counter--

//           update score
            score += temp * 2
            textView4.text=score.toString()
        }

    }

    fun right(view: View) {
        for (line in 0..3) {
            for (btn in 0..2) {
                moveTiles(line, btn, line, btn + 1)
            }
        }
        createNewTile()

    }

    fun left(view: View) {
        for (line in 0..3) {
            for (btn in 0..2) {
                var temp = 3 - btn
                moveTiles(line, temp, line, temp - 1)
            }
        }
        createNewTile()
    }

    fun down(view: View) {
        for (btn in 0..3) {
            for (line in 0..2) {
                moveTiles(line, btn, line + 1, btn)
            }
        }
        createNewTile()
    }

    fun up(view: View) {
        for (btn in 0..3) {
            for (line in 0..2) {
                var temp = 3 - line
                moveTiles(temp, btn, temp - 1, btn)
            }
        }
        createNewTile()
    }


    fun play(view: View) {
        if(score > best) {
            best = score
        }
        textView3.text=best.toString()

        score = 0
        textView4.text=score.toString()

        textView6.visibility = View.INVISIBLE
        button16.text = "Restart"
        counter = 2

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

        while (randomRow == randomRow2 && randomColumn == randomColumn2) {
            randomRow2 = (Math.random() * 4).toInt()
            randomColumn2 = (Math.random() * 4).toInt()
        }

        buttonArray[randomRow2][randomColumn2].text = "2"
    }

    private fun createNewTile() {
        if (counter < 16) {
            var temp = true
            counter++
                while(temp){
                    //create random position
                    val rowRandom = (Math.random() * 4).toInt()
                    val columnRandom = (Math.random() * 4).toInt()

                    //check if position is occupied
                    if(buttonArray[rowRandom][columnRandom].text.toString().equals("")){
                        //create tile
                        buttonArray[rowRandom][columnRandom].text = "2"
                        temp = false
                    }
            }
        } else {
            //lost
            textView6.visibility = View.VISIBLE




        }
    }

}
