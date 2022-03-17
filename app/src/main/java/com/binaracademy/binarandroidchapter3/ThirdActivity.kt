package com.binaracademy.binarandroidchapter3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import com.binaracademy.binarandroidchapter3.databinding.ActivitySecondBinding
import com.binaracademy.binarandroidchapter3.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding

//    var editText : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.moveActivityButton.setOnClickListener {
            val intent = Intent(this@ThirdActivity, FourthActivity::class.java)
            startActivity(intent)
        }

        println("Activity 3 onCreate")
        Toast.makeText(this, "Activity 3 onCreate", Toast.LENGTH_LONG).show()
    }

    override fun onStart() {
        super.onStart()
        println("Activity 3 onStart")
        Toast.makeText(this, "Activity 3 onStart", Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        println("Activity 3 onResume")
        Toast.makeText(this, "Activity 3 onResume", Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()
        println("Activity 3 onPause")
        Toast.makeText(this, "Activity 3 onPause", Toast.LENGTH_LONG).show()
    }

    override fun onStop() {
        super.onStop()
        println("Activity 3 onStop")
        Toast.makeText(this, "Activity 3 onStop", Toast.LENGTH_LONG).show()
    }

    override fun onRestart() {
        super.onRestart()
        println("Activity 3 onRestart")
        Toast.makeText(this, "Activity 3 onRestart", Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        println("Activity 3 onDestroy")
        Toast.makeText(this, "Activity 3 onDestroy", Toast.LENGTH_LONG).show()
    }
}