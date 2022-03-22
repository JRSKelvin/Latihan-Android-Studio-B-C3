package com.binaracademy.binarandroidchapter3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import com.binaracademy.binarandroidchapter3.data.Mahasiswa2
import com.binaracademy.binarandroidchapter3.databinding.ActivityEighthYBinding

class EighthActivityY : AppCompatActivity() {
    private lateinit var binding : ActivityEighthYBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        binding = ActivityEighthYBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Parcelable
        Toast.makeText(this, "Ini Parcelable Explicit", Toast.LENGTH_LONG).show()
        val mahasiswa = intent.getParcelableExtra<Mahasiswa2>("DATA") as Mahasiswa2
        binding.namaView.text = "Nama Anda ${mahasiswa.nama}"
        binding.namaPanggilanView.text = "Nama Panggilan Anda ${mahasiswa.namaPanggilan}"
        binding.usiaView.text = "Usia Anda ${mahasiswa.usia}"
        binding.alamatView.text = "Alaamt Anda ${mahasiswa.alamat}"
        binding.emailView.text = "Email Anda ${mahasiswa.email}"
        binding.univView.text = "Universitas Anda ${mahasiswa.univ}"
    }
}