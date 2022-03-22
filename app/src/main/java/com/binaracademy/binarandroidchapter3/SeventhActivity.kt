package com.binaracademy.binarandroidchapter3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import com.binaracademy.binarandroidchapter3.data.Mahasiswa
import com.binaracademy.binarandroidchapter3.data.Mahasiswa2
import com.binaracademy.binarandroidchapter3.databinding.ActivitySeventhBinding

class SeventhActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySeventhBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        binding = ActivitySeventhBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.moveActivity.setOnClickListener {
            // Normal Explicit
            val moveIntent = Intent(this@SeventhActivity, EighthActivity::class.java)
            moveIntent.putExtra("NAMA", binding.namaInput.text.toString())
            moveIntent.putExtra("NAMA_PANGGILAN", binding.namaPanggilanInput.text.toString())
            moveIntent.putExtra("USIA", binding.usiaInput.text.toString())
            moveIntent.putExtra("ALAMAT", binding.alamatInput.text.toString())
            moveIntent.putExtra("EMAIL", binding.emailInput.text.toString())
            moveIntent.putExtra("UNIV", binding.univInput.text.toString())
            startActivity(moveIntent)
        }

        binding.moveActivityBundle.setOnClickListener {
            // Bundle
            val moveIntent = Intent(this@SeventhActivity, EighthActivityW::class.java)
            val bundlePack = Bundle()
            bundlePack.putString("NAMA", binding.namaInput.text.toString())
            bundlePack.putString("NAMA_PANGGILAN", binding.namaPanggilanInput.text.toString())
            bundlePack.putString("USIA", binding.usiaInput.text.toString())
            bundlePack.putString("ALAMAT", binding.alamatInput.text.toString())
            bundlePack.putString("EMAIL", binding.emailInput.text.toString())
            bundlePack.putString("UNIV", binding.univInput.text.toString())
            moveIntent.putExtras(bundlePack)
            startActivity(moveIntent)
        }

        binding.moveActivitySerializable.setOnClickListener {
            // Serializable
            val moveIntent = Intent(this@SeventhActivity, EighthActivityX::class.java)
            val mahasiswa = Mahasiswa(binding.namaInput.text.toString(), binding.namaPanggilanInput.text.toString(), binding.usiaInput.text.toString(), binding.alamatInput.text.toString(), binding.emailInput.text.toString(), binding.univInput.text.toString())
            moveIntent.putExtra("DATA", mahasiswa)
            startActivity(moveIntent)
        }

        binding.moveActivityParcelable.setOnClickListener {
            // Parcelable
            val moveIntent = Intent(this@SeventhActivity, EighthActivityY::class.java)
            val mahasiswa2 = Mahasiswa2(binding.namaInput.text.toString(), binding.namaPanggilanInput.text.toString(), binding.usiaInput.text.toString(), binding.alamatInput.text.toString(), binding.emailInput.text.toString(), binding.univInput.text.toString())
            moveIntent.putExtra("DATA", mahasiswa2)
            startActivity(moveIntent)
        }

        binding.intentPractice.setOnClickListener {
            val createIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Praktek Intent Android")
                type = "text/plain"
            }

            if (createIntent.resolveActivity(packageManager) != null) {
                startActivity(createIntent)
            }
        }

        binding.intentPractice2.setOnClickListener {
            val createIntent = Intent().apply {
                action = Intent.ACTION_CALL
                setData(Uri.parse("tel: 123"))
            }

            if (createIntent.resolveActivity(packageManager) != null) {
                startActivity(createIntent)
            }
        }
    }
}