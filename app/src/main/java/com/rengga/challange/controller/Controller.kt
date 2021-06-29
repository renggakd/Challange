package com.rengga.challange.controller

import com.rengga.challange.callback.CallBack

class Controller (var callBack: CallBack){

    fun operation(player: String, computer: String) {

        val result = when {
            player == "scissors" && computer == "papper" ||
                    player == "stone" && computer == "scissors" ||
                    player == "papper" && computer == "stone" -> "player1 win"
            player == "papper" && computer == "scissors" ||
                    player == "scissors" && computer == "stone" ||
                    player == "stone" && computer == "papper" -> "player2 win"


            else -> "Draw"
        }

        callBack.computerChoice(computer)
        callBack.gameResult(result)
    }
}