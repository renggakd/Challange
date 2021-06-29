package com.rengga.challange.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.rengga.challange.R
import com.rengga.challange.UserPreference
import com.rengga.challange.callback.CallBack
import com.rengga.challange.controller.Controller
import com.rengga.challange.databinding.ActivityVsComputerBinding
import com.rengga.challange.dialogfragment.CustomDialogFragment
import com.rengga.challange.menu.MenuActivity

class VsComputerActivity : AppCompatActivity(), CallBack {


    override fun computerChoice(computer: String) {
        when (computer) {
            "scissors" -> {
                binding.ivCompScissor.setBackgroundResource(R.drawable.select)
            }
            "stone" -> {
                binding.ivCompStone.setBackgroundResource(R.drawable.select)
            }
            else -> {
                binding.ivCompPapper.setBackgroundResource(R.drawable.select)
            }
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

    private val TAG = VsComputerActivity::class.java.simpleName
    private lateinit var binding: ActivityVsComputerBinding
    private var computer = mutableListOf<String>("scissors", "papper", "stone")
    private var clicked: Boolean = true
    private var namePlayer: String? = null
    private var controller = Controller(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_vs_computer)
        bindViews()
        setClickListeners()
        setTextMode()
        onCloseClick()


    }

    private fun setTextMode() {
        binding.tvPlayer.text = String.format(
            getString(
                R.string.text_user,
                UserPreference(this).userName
            )
        )
    }

    private fun bindViews() {
        binding = ActivityVsComputerBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    private fun onCloseClick() {
        binding.ivCloseGame.setOnClickListener {
            val intent = Intent(this@VsComputerActivity, MenuActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }


    private fun setClickListeners() {
        binding.ivPlayerStone.setOnClickListener {
            if (clicked) {
                val computerChoice = computer.random()
                controller.operation("stone", computerChoice)
                binding.ivPlayerStone.setBackgroundResource(R.drawable.select)
                clicked = false
                Log.d(TAG, "Stone Button Clicked")


            } else {
                Toast.makeText(this, getString(R.string.toast_text_reset), Toast.LENGTH_LONG).show()
            }
        }

        binding.ivPlayerPapper.setOnClickListener {
            if (clicked) {
                val computerChoice = computer.random()
                controller.operation("papper", computerChoice)
                binding.ivPlayerPapper.setBackgroundResource(R.drawable.select)
                clicked = false
                Log.d(TAG, "Papper Button Clicked")


            } else {
                Toast.makeText(this, getString(R.string.toast_text_reset), Toast.LENGTH_LONG).show()
            }
        }
        binding.ivPlayerScissor.setOnClickListener {
            if (clicked) {
                val computerChoice = computer.random()
                controller.operation("scissors", computerChoice)
                binding.ivPlayerScissor.setBackgroundResource(R.drawable.select)
                clicked = false
                Log.d(TAG, "Scissor Button Clicked")


            } else {
                Toast.makeText(this, getString(R.string.toast_text_reset), Toast.LENGTH_LONG).show()
            }
        }

        binding.ivRefreshGame.setOnClickListener {
            binding.ivPlayerScissor.setBackgroundResource(0)
            binding.ivPlayerPapper.setBackgroundResource(0)
            binding.ivPlayerStone.setBackgroundResource(0)
            binding.ivCompScissor.setBackgroundResource(0)
            binding.ivCompPapper.setBackgroundResource(0)
            binding.ivCompStone.setBackgroundResource(0)
            binding.vs.setImageResource(R.drawable.vs)
            clicked = true
            Log.d(TAG, "Resset Button Clicked")
        }
    }
}

