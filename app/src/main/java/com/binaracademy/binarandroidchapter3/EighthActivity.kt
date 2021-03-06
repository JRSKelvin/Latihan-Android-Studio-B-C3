package com.binaracademy.binarandroidchapter3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import com.binaracademy.binarandroidchapter3.databinding.ActivityEighthBinding

class EighthActivity : AppCompatActivity() {
    private lateinit var binding : ActivityEighthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        binding = ActivityEighthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Normal Explicit
        Toast.makeText(this, "Ini Normal Explicit", Toast.LENGTH_LONG).show()
        val namaIntent = intent.getStringExtra("NAMA")
        val namaPanggilanIntent = intent.getStringExtra("NAMA_PANGGILAN")
        val usiaIntent = intent.getStringExtra("USIA")
        val alamatIntent = intent.getStringExtra("ALAMAT")
        val emailIntent = intent.getStringExtra("EMAIL")
        val univIntent = intent.getStringExtra("UNIV")
        binding.namaView.text = "Nama Anda $namaIntent"
        binding.namaPanggilanView.text = "Nama Panggilan Anda $namaPanggilanIntent"
        binding.usiaView.text = "Usia Anda $usiaIntent"
        binding.alamatView.text = "Alamat Anda $alamatIntent"
        binding.emailView.text = "Email Anda $emailIntent"
        binding.univView.text = "Universitas Anda $univIntent"
    }
}