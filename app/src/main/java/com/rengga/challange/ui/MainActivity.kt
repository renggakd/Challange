package com.rengga.challange.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.rengga.challange.R
import com.rengga.challange.callback.CallBack
import com.rengga.challange.controller.Controller
import com.rengga.challange.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CallBack {
    override fun gameResult(result: Int) {
        binding.vs.setImageResource(result)
    }

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

    private val TAG = MainActivity::class.java.simpleName
    private lateinit var binding: ActivityMainBinding
    private var computer = mutableListOf<String>("scissors", "papper", "stone")
    private var clicked: Boolean = true
    private var controller = Controller(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()
        setClickListeners()

    }

    private fun bindViews() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


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

