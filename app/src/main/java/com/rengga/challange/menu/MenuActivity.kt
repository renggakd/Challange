package com.rengga.challange.menu

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.rengga.challange.R
import com.rengga.challange.UserPreference
import com.rengga.challange.databinding.ActivityMenuBinding
import com.rengga.challange.main.VsComputerActivity
import com.rengga.challange.main.VsPlayerActivity

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTextMode()
        showSnackBar()
        onClick()
    }

    private fun showSnackBar() {
        val parentLayout: View = findViewById(android.R.id.content)
        Snackbar.make(
            parentLayout,
            String.format(
                getString(
                    R.string.text_welcome,
                    UserPreference(this).userName
                )
            ),
            Snackbar.LENGTH_LONG
        )
            .setActionTextColor(Color.CYAN)
            .setAction("Close") {
                Snackbar.LENGTH_INDEFINITE
            }.show()
        supportActionBar?.hide()
    }

    private fun setTextMode() {
        binding.tvPlayerVsPlayer.text = String.format(
            getString(
                R.string.text_user_vs_user,
                UserPreference(this).userName
            )
        )
        binding.tvPlayerVsComputer.text = String.format(
            getString(
                R.string.text_user_vs_cpu,
                UserPreference(this).userName
            )
        )
    }

    private fun onClick() {
        binding.ivUserVsPemain.setOnClickListener {
            val intent = Intent(this@MenuActivity, VsPlayerActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
        binding.ivUserVsCpu.setOnClickListener {
            val intent = Intent(this@MenuActivity, VsComputerActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }


}