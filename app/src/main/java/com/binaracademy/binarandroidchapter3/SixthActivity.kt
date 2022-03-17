package com.binaracademy.binarandroidchapter3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.fragment.app.Fragment
import com.binaracademy.binarandroidchapter3.databinding.ActivitySixthBinding
import com.binaracademy.binarandroidchapter3.fragment.MainFragment
import com.binaracademy.binarandroidchapter3.fragment.SecondFragment
import com.binaracademy.binarandroidchapter3.fragment.ThirdFragment

class SixthActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySixthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        binding = ActivitySixthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstFragment = MainFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()

        setCurrentFragment(firstFragment)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home->setCurrentFragment(firstFragment)
                R.id.ic_account_balance_wallet->setCurrentFragment(secondFragment)
                R.id.ic_list_alt->setCurrentFragment(thirdFragment)

            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }
}