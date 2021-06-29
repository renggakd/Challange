package com.rengga.challange.dialogfragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.rengga.challange.R
import com.rengga.challange.databinding.FragmentCustomDialogBinding
import com.rengga.challange.menu.MenuActivity


class CustomDialogFragment(private val message: String) : DialogFragment() {
    private lateinit var binding: FragmentCustomDialogBinding

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        binding = FragmentCustomDialogBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dialog?.window?.setBackgroundDrawableResource(R.drawable.bg_dialog_rounded_white)
        super.onViewCreated(view, savedInstanceState)


        binding.tvWinner.text = message

        binding.btnReplay.setOnClickListener {
            dialog?.dismiss()

        }

        binding.btnReturn.setOnClickListener {
            val intent = Intent(view.context, MenuActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }


    }
}
