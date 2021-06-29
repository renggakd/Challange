package com.rengga.challange.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.rengga.challange.R
import com.rengga.challange.UserPreference
import com.rengga.challange.callback.CallBackPlayer
import com.rengga.challange.controller.ControllerVs
import com.rengga.challange.databinding.ActivityVsPlayerBinding
import com.rengga.challange.dialogfragment.CustomDialogFragment
import com.rengga.challange.menu.MenuActivity

class VsPlayerActivity : AppCompatActivity(), CallBackPlayer {
    private lateinit var binding: ActivityVsPlayerBinding
    private var namePlayer: String? = null
    private lateinit var player1: String
    private lateinit var player2: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVsPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        setTextMode()
        onCloseClick()


        player1 = toString()
        player2 = toString()
    }

        private fun setTextMode() {
            binding.tvPlayer1.text = String.format(
                getString(
                    R.string.text_user,
                    UserPreference(this).userName
                )
            )



        val controller = ControllerVs(this)
        binding.ivPlayerStone.setOnClickListener {
            player1 = "stone"
            binding.ivPlayerStone.setBackgroundResource(R.drawable.select)
            binding.ivPlayerStone.isEnabled = false
            binding.ivPlayerScissor.isEnabled = false
            binding.ivPlayerPapper.isEnabled = false
            binding.ivCompStone.isEnabled = true
            binding.ivCompScissor.isEnabled = true
            binding.ivCompPapper.isEnabled = true
        }

        binding.ivPlayerPapper.setOnClickListener {
            player1 = "paper"
            binding.ivPlayerPapper.setBackgroundResource(R.drawable.select)
            binding.ivPlayerStone.isEnabled = false
            binding.ivPlayerScissor.isEnabled = false
            binding.ivPlayerPapper.isEnabled = false
            binding.ivCompStone.isEnabled = true
            binding.ivCompScissor.isEnabled = true
            binding.ivCompPapper.isEnabled = true
        }
            binding.ivRefreshGame.setOnClickListener {
                binding.ivPlayerScissor.setBackgroundResource(0)
                binding.ivPlayerPapper.setBackgroundResource(0)
                binding.ivPlayerStone.setBackgroundResource(0)
                binding.ivCompScissor.setBackgroundResource(0)
                binding.ivCompPapper.setBackgroundResource(0)
                binding.ivCompStone.setBackgroundResource(0)
                binding.vs.setImageResource(R.drawable.vs)
                binding.ivPlayerScissor.isEnabled = true
                binding.ivPlayerPapper.isEnabled = true
                binding.ivPlayerStone.isEnabled = true
                binding.ivCompScissor.isEnabled = true
                binding.ivCompPapper.isEnabled = true
                binding.ivCompStone.isEnabled = true
            }


                binding.ivPlayerScissor.setOnClickListener {
            player1 = "scissors"
            binding.ivPlayerScissor.setBackgroundResource(R.drawable.select)
            binding.ivPlayerStone.isEnabled = false
            binding.ivPlayerScissor.isEnabled = false
            binding.ivPlayerPapper.isEnabled = false
            binding.ivCompStone.isEnabled = true
            binding.ivCompScissor.isEnabled = true
            binding.ivCompPapper.isEnabled = true
        }

        binding.ivCompScissor.setOnClickListener {
            player2 = "scissors"
            binding.ivCompScissor.setBackgroundResource(R.drawable.select)
            Toast.makeText(this, "Player 2 Choose Scissors", Toast.LENGTH_SHORT).show()
            controller.operation(player1, player2)
        }

        binding.ivCompStone.setOnClickListener {
            player2 = "stone"
            binding.ivCompStone.setBackgroundResource(R.drawable.select)
            Toast.makeText(this, "Player 2 Choose Stone", Toast.LENGTH_SHORT).show()
            controller.operation(player1, player2)
        }

        binding.ivCompPapper.setOnClickListener {
            player2 = "papper"
            binding.ivCompPapper.setBackgroundResource(R.drawable.select)
            Toast.makeText(this, "Player 2 Choose Papper", Toast.LENGTH_SHORT).show()
            controller.operation(player1, player2)





        }


    }
    private fun onCloseClick() {
        binding.ivCloseGame.setOnClickListener {
            val intent = Intent(this@VsPlayerActivity, MenuActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }

    override fun gameResult(result: String) {
        namePlayer = intent.getStringExtra("")
        when {
            result.contains("1") -> {
                CustomDialogFragment("$namePlayer\nWIN!").show(supportFragmentManager, null)
            }

            result.contains("2") -> {
                CustomDialogFragment("Player 2\nWINN!").show(supportFragmentManager, null)
            }

            result.contains("w") -> {
                CustomDialogFragment("DRAW!").show(supportFragmentManager, null)
            }
        }
    }

}
