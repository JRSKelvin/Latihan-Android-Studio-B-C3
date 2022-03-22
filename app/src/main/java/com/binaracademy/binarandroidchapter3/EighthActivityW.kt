package com.binaracademy.binarandroidchapter3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import com.binaracademy.binarandroidchapter3.databinding.ActivityEighthWBinding

class EighthActivityW : AppCompatActivity() {
    private lateinit var binding : ActivityEighthWBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        binding = ActivityEighthWBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Bundle
        Toast.makeText(this, "Ini Bundle Explicit", Toast.LENGTH_LONG).show()
        val getBundle = intent.extras
        val namaIntent = getBundle?.getString("NAMA")
        val namaPanggilanIntent = getBundle?.getString("NAMA_PANGGILAN")
        val usiaIntent = getBundle?.getString("USIA")
        val alamatIntent = getBundle?.getString("ALAMAT")
        val emailIntent = getBundle?.getString("EMAIL")
        val univIntent = getBundle?.getString("UNIV")
        binding.namaView.text = "Nama Anda $namaIntent"
        binding.namaPanggilanView.text = "Nama Panggilan Anda $namaPanggilanIntent"
        binding.usiaView.text = "Usia Anda $usiaIntent"
        binding.alamatView.text = "Alamat Anda $alamatIntent"
        binding.emailView.text = "Email Anda $emailIntent"
        binding.univView.text = "Universitas Anda $univIntent"
    }
}