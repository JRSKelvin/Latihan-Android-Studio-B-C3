package com.binaracademy.binarandroidchapter3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import com.binaracademy.binarandroidchapter3.databinding.ActivityFourthBinding
import com.binaracademy.binarandroidchapter3.fragment.ThirdFragment

class FourthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFourthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val FragmentManager = supportFragmentManager
        val FragmentTransaction = FragmentManager.beginTransaction()

        val Fragment = ThirdFragment()
        FragmentTransaction.add(R.id.third_fragment, Fragment)
        FragmentTransaction.commit()

        binding.moveActivity1.setOnClickListener {
            val intent = Intent(this@FourthActivity, FifthActivity::class.java)
            startActivity(intent)
        }

        binding.moveActivity2.setOnClickListener {
            val intent = Intent(this@FourthActivity, SixthActivity::class.java)
            startActivity(intent)
        }

        binding.moveActivity3.setOnClickListener {
            val intent = Intent(this@FourthActivity, SeventhActivity::class.java)
            startActivity(intent)
        }
    }
}