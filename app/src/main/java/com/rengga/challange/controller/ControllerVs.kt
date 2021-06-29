package com.rengga.challange.controller

import android.util.Log
import com.rengga.challange.R
import com.rengga.challange.callback.CallBack
import com.rengga.challange.callback.CallBackPlayer

class ControllerVs(var callBack: CallBackPlayer) {


    fun operation(player1: String, player2: String) {
        val result = when {
            player1 == "scissors" && player2 == "papper" ||
                    player1 == "stone" && player2 == "scissors" ||
                    player1 == "papper" && player2 == "stone" -> "player1 win"
            player1 == "papper" && player2 == "scissors" ||
                    player1 == "scissors" && player2 == "stone" ||
                    player1 == "stone" && player2 == "papper" -> "player2 win"


            else -> "Draw"
        }

        callBack.gameResult(result)
    }
}