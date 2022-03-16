package com.binaracademy.binarandroidchapter3

import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.os.Bundle
import android.view.Window
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import com.binaracademy.binarandroidchapter3.databinding.ActivityMainBinding
import com.bumptech.glide.Glide


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        Glide.with(this)
            .load("https://i.ibb.co/zJHYGBP/binarlogo.jpg")
            .circleCrop()
            .into(binding.imageView)
        setContentView(binding.root)

        binding.moveActivity.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        }

        var changeImage = 1

        binding.buttonView.setOnClickListener {
            if (changeImage == 1){
                Glide.with(this)
                    .load("https://i.ibb.co/zJHYGBP/binarlogo.jpg")
                    .circleCrop()
                    .into(binding.imageView)
                changeImage = 2
            } else {
                Glide.with(this)
                    .load("https://global-uploads.webflow.com/6100d0111a4ed76bc1b9fd54/616fd70b2be60a72b46f2da3_logo_7b6caab85699ca72e06917e9bad7512c.png")
                    .into(binding.imageView)
                changeImage = 1
            }
        }

        binding.buttonSpecialView.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { compoundButton, checked ->
            if (checked) {
                binding.viewStatusText.text = "WiFi is ON"
                val wifi = getSystemService(Context.WIFI_SERVICE) as WifiManager
                wifi.isWifiEnabled = true
            } else {
                binding.viewStatusText.text = "WiFi is OFF"
                val wifi = getSystemService(Context.WIFI_SERVICE) as WifiManager
                wifi.isWifiEnabled = false
            }
        })

        // For initial setting
        if (binding.buttonSpecialView.isChecked) {
            binding.viewStatusText.text = "WiFi is ON"
            val wifi = getSystemService(Context.WIFI_SERVICE) as WifiManager
            wifi.isWifiEnabled = true
        } else {
            binding.viewStatusText.text = "WiFi is OFF"
            val wifi = getSystemService(Context.WIFI_SERVICE) as WifiManager
            wifi.isWifiEnabled = false
        }
    }
}