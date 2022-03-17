package com.binaracademy.binarandroidchapter3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import com.binaracademy.binarandroidchapter3.adapter.DrawerAdapter
import com.binaracademy.binarandroidchapter3.databinding.ActivityFifthBinding
import com.google.android.material.tabs.TabLayoutMediator

class FifthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFifthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        binding = ActivityFifthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPagerAdapter = DrawerAdapter(this)
        binding.viewPagerContent.adapter = viewPagerAdapter
        TabLayoutMediator(binding.tabLayoutHeader, binding.viewPagerContent) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Home"
                }
                1 -> {
                    tab.text = "Story"
                }
                2 -> {
                    tab.text = "Setting"
                }
            }
        }.attach()
    }
}