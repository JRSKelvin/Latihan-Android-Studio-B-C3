package com.binaracademy.binarandroidchapter3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import com.binaracademy.binarandroidchapter3.data.Mahasiswa
import com.binaracademy.binarandroidchapter3.databinding.ActivityEighthXBinding

class EighthActivityX : AppCompatActivity() {
    private lateinit var binding : ActivityEighthXBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        binding = ActivityEighthXBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Serializable
        Toast.makeText(this, "Ini Serializable Explicit", Toast.LENGTH_LONG).show()
        val mahasiswa = intent.getSerializableExtra("DATA") as Mahasiswa
        binding.namaView.text = "Nama Anda ${mahasiswa.nama}"
        binding.namaPanggilanView.text = "Nama Panggilan Anda ${mahasiswa.namaPanggilan}"
        binding.usiaView.text = "Usia Anda ${mahasiswa.usia}"
        binding.alamatView.text = "Alaamt Anda ${mahasiswa.alamat}"
        binding.emailView.text = "Email Anda ${mahasiswa.email}"
        binding.univView.text = "Universitas Anda ${mahasiswa.univ}"
    }
}