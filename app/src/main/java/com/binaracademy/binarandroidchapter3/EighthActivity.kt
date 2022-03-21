package com.binaracademy.binarandroidchapter3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import com.binaracademy.binarandroidchapter3.data.Mahasiswa
import com.binaracademy.binarandroidchapter3.data.Mahasiswa2
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
//        val namaIntent = intent.getStringExtra("NAMA")
//        val emailIntent = intent.getStringExtra("EMAIL")
//        val univIntent = intent.getStringExtra("UNIV")
//        binding.namaView.text = "Nama Anda $namaIntent"
//        binding.emailView.text = "Email Anda $emailIntent"
//        binding.univView.text = "Universitas Anda $univIntent"

        // Bundle
//        val getBundle = intent.extras
//        val namaIntent = getBundle?.getString("NAMA")
//        val emailIntent = getBundle?.getString("EMAIL")
//        val univIntent = getBundle?.getString("UNIV")
//        binding.namaView.text = "Nama Anda $namaIntent"
//        binding.emailView.text = "Email Anda $emailIntent"
//        binding.univView.text = "Universitas Anda $univIntent"

        // Serializable
//        val mahasiswa = intent.getSerializableExtra("DATA") as Mahasiswa
//        binding.namaView.text = "Nama Anda ${mahasiswa.nama}"
//        binding.emailView.text = "Email Anda ${mahasiswa.email}"
//        binding.univView.text = "Universitas Anda ${mahasiswa.univ}"

        // Parcelable
        val mahasiswa = intent.getParcelableExtra<Mahasiswa2>("DATA") as Mahasiswa2
        binding.namaView.text = "Nama Anda ${mahasiswa.nama}"
        binding.emailView.text = "Email Anda ${mahasiswa.email}"
        binding.univView.text = "Universitas Anda ${mahasiswa.univ}"
    }
}