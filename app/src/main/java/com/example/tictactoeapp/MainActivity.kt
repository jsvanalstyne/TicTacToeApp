package com.example.tictactoeapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buClick(view: View) {
        val buSelected = view as Button

        var cellId = 0
        when(buSelected.id){
            R.id.bu -> cellId =1
            R.id.bu2 -> cellId =2
            R.id.bu3 -> cellId =3
            R.id.bu4 -> cellId =4
            R.id.bu5 -> cellId =5
            R.id.bu6 -> cellId =6
            R.id.bu7 -> cellId =7
            R.id.bu8 -> cellId =8
            R.id.bu9 -> cellId =9

        }
        playGame(cellId,buSelected)



        Log.d("buClick", buSelected.id.toString())
        Log.d("cellId", cellId.toString())


    }
    var activePlayer = 1;

    var player1 = ArrayList<Int>()

    var player2 = ArrayList<Int>()

    fun playGame(cellId: Int, buSelected: Button){
        if(activePlayer == 1){
            buSelected.text ="X"
            buSelected.setBackgroundColor(Color.BLUE)
            player1.add(cellId)
            activePlayer = 2
            autoPlay()

        }else{
            buSelected.text="O"
            buSelected.setBackgroundColor(Color.GREEN)
            player2.add(cellId)
            activePlayer=1

        }

        buSelected.isEnabled = false

        checkWinner()

    }

    fun autoPlay(){

        var emptyCells = ArrayList<Int>()

        for( cellId in 1..9) {

            if ( !(player1.contains(cellId) || player2.contains(cellId))){
                emptyCells.add(cellId)
            }

        }
        if(emptyCells.size == 0){
            restartGame()
        }

        val r = Random()
        val randIndex = r.nextInt(emptyCells.size)
        val cellId = emptyCells [randIndex]

        var buSelected: Button?
        buSelected = when(cellId) {
            1 -> bu
            2 -> bu2
            3 -> bu3
            4 -> bu4
            5 -> bu5
            6 -> bu6
            7 -> bu7
            8 -> bu8
            9 -> bu9
            else -> {
                bu
            }
        }

        playGame(cellId, buSelected)
    }

    var player1Wins = 0
    var player2Wins = 0
    fun restartGame(){
        activePlayer = 1
        player1.clear()
        player2.clear()
        for(cellId in 1..9){
            var buSelected: Button?
            buSelected = when(cellId) {
                1 -> bu
                2 -> bu2
                3 -> bu3
                4 -> bu4
                5 -> bu5
                6 -> bu6
                7 -> bu7
                8 -> bu8
                9 -> bu9
                else -> {
                    bu
                }
                buSelected!!.text = ""
                        buSelected!!.setBackgroundColor(Color.White)
                buSelected!!.isEnabled = true
            }

        }
        Toast.makeText(this, "Player 1 wins $player1Wins, Player2 wins: $player2Wins", Toast.LENGTH_LONG).show()
    }
    fun checkWinner(){
        var winner = -1
//        row1
        if(player1.contains(1)&& player1.contains(2) && player1.contains(3)){
            winner= 1
        }
        if(player2.contains(1)&& player2.contains(2) && player2.contains(3)){
            winner= 1
        }
        if(player1.contains(4)&& player1.contains(5) && player1.contains(6)){
            winner= 1
        }
        if(player2.contains(4)&& player2.contains(5) && player2.contains(6)){
            winner= 1
        }
        if(player1.contains(7)&& player1.contains(8) && player1.contains(9)){
            winner= 1
        }
        if(player2.contains(7)&& player2.contains(8) && player2.contains(9)){
            winner= 1
        }
        if(player1.contains(4)&& player1.contains(1) && player1.contains(7)){
            winner= 1
        }
        if(player2.contains(4)&& player2.contains(1) && player2.contains(7)){
            winner= 1
        }
        if(player1.contains(2)&& player1.contains(5) && player1.contains(8)){
            winner= 1
        }
        if(player2.contains(2)&& player2.contains(5) && player2.contains(8)){
            winner= 1
        }
        if(player1.contains(3)&& player1.contains(6) && player1.contains(9)){
            winner= 1
        }
        if(player2.contains(3)&& player2.contains(6) && player2.contains(9)){
            winner= 1
        }
        if ((player1.contains(1) && player1.contains(5) && player1.contains(9))){
            winner = 1 }
        if ((player2.contains(1) && player2.contains(5) && player2.contains(9))){
            winner = 2 }


        if ((player1.contains(3) && player1.contains(5) && player1.contains(7))){
            winner = 1 }
        if ((player2.contains(3) && player2.contains(5) && player2.contains(7))){
            winner = 2 }

        if(winner == 1){
            Toast.makeText(this,"Player 1 is the winner!", LENGTH_LONG).show()
            player1Wins1++
            restartGame()
        } else if(winner ==2){
            Toast.makeText(this,"Player 2 is the winner!", LENGTH_LONG).show()
            player2Wins++
            restartGame()
        }
    }
}