package com.rengga.challange.landingpage

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.rengga.challange.UserPreference
import com.rengga.challange.databinding.FragmentLandingPage3Binding
import com.rengga.challange.menu.MenuActivity

class LandingPage3 : Fragment() {
    private lateinit var binding: FragmentLandingPage3Binding
    private lateinit var userPreference: UserPreference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLandingPage3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prefilledCurrentName()
    }

    private fun prefilledCurrentName() {
        context?.let {
            userPreference = UserPreference(it)
            binding.etName.setText(userPreference.userName.orEmpty())
        }
    }

    private fun isFormFilled(): Boolean {
        val name = binding.etName.text.toString()
        var isFormValid = true

        if (name.isEmpty()) {
            isFormValid = false
            Toast.makeText(context, "Write Your Name Please!", Toast.LENGTH_SHORT).show()

        }
        return isFormValid
    }

    fun navigateToMenuGame() {
        if (isFormFilled()) {
            userPreference.userName = binding.etName.text.toString()
            context?.startActivity(Intent(context,MenuActivity::class.java))
        }
    }
}