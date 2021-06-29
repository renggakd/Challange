package com.rengga.challange.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.rengga.challange.adapter.ViewPagerAdapter
import com.rengga.challange.databinding.ActivityFragmentBinding
import com.rengga.challange.databinding.FragmentLandingPage3Binding
import com.rengga.challange.landingpage.LandingPage1
import com.rengga.challange.landingpage.LandingPage2
import com.rengga.challange.landingpage.LandingPage3

class FragmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        initViewPage()
        onPageChange()
        onClick()
    }

    private fun initViewPage() {
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPagerAdapter.addFragment(
            LandingPage1()
        )
        viewPagerAdapter.addFragment(
            LandingPage2()
        )
        viewPagerAdapter.addFragment(
            LandingPage3()
        )
        binding.viewPager.apply {
            adapter = viewPagerAdapter
        }
        binding.indicator.setViewPager(binding.viewPager)
    }


    private fun onPageChange() {
        val viewPager = binding.viewPager
        val ivNextNavigate = binding.ivNextNavigation

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 2) {
                    ivNextNavigate.visibility = View.VISIBLE
                    onClick()
                } else {
                    ivNextNavigate.visibility = View.INVISIBLE
                }
            }
        })
    }

    private fun onClick() {
        binding.ivNextNavigation.setOnClickListener {
            val myFragment = supportFragmentManager.findFragmentByTag("f2")
            (myFragment as LandingPage3).navigateToMenuGame()

        }
    }
}
