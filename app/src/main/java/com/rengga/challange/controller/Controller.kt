package com.rengga.challange.controller

import android.util.Log
import com.rengga.challange.R
import com.rengga.challange.callback.CallBack
import com.rengga.challange.databinding.ActivityMainBinding

class Controller (var callBack: CallBack){
    var result = 0

    fun operation(player: String, computer: String) {

        if (player == "scissors" && computer == "papper" || player == "stone" && computer == "scissors" || player == "papper" && computer == "stone") {
            result = R.drawable.iv_player_win
                Log.d("result", "Player Win")
        } else if (player == "papper" && computer == "scissors" || player == "scissors" && computer == "stone" || player == "stone" && computer == "papper") {
            result = R.drawable.iv_computer_win
            Log.d("result", "Computer Win")
        } else if (player == "papper" && computer == "papper" || player == "scissors" && computer == "scissors" || player == "stone" && computer == "stone") {
            result = R.drawable.draw
            Log.d("result", "Game Draw")
        }

        callBack.computerChoice(computer)

        callBack.gameResult(result)
    }
}