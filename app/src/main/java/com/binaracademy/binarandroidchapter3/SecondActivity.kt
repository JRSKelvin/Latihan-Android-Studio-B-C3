package com.binaracademy.binarandroidchapter3

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.net.Uri
import android.os.Bundle
import android.telephony.TelephonyManager
import android.util.Log
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.binaracademy.binarandroidchapter3.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonShowLocation.setOnClickListener {
            checkLocationPermissionStatus()
        }

        binding.buttonSpecialCall.setOnClickListener {
            checkCallPermissionStatus()
        }

        binding.buttonSpecialGetPhoneNumber.setOnClickListener {
            checkPhoneNumberStatus()
        }

        binding.buttonMoveActivity.setOnClickListener {
            val intent = Intent(this@SecondActivity, ThirdActivity::class.java)
            startActivity(intent)
        }
    }

    private fun checkLocationPermissionStatus() {
        val permissionCheck = checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Location Permission Granted", Toast.LENGTH_LONG).show()
            getCurrentLocation()
        } else {
            Toast.makeText(this, "Location Permission Denied", Toast.LENGTH_LONG).show()
            requestingAccessLocation()
        }
    }

    @SuppressLint("MissingPermission")
    fun getCurrentLocation() {
        val locationGet =
            applicationContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager

        val locationNow: Location =
            locationGet.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)!!
        Toast.makeText(
            this,
            "Latitude: ${locationNow.latitude} And Longitude ${locationNow.longitude}",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun requestingAccessLocation() {
        requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 301)
    }

//    PEMBATAS ACCESS

    private fun checkCallPermissionStatus() {
        val permissionCheck = checkSelfPermission(Manifest.permission.CALL_PHONE)

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Call Permission Granted", Toast.LENGTH_LONG).show()
            getPhoneCall()
        } else {
            Toast.makeText(this, "Call Permission Denied", Toast.LENGTH_LONG).show()
            requestingPhoneCall()
        }
    }

    @SuppressLint("MissingPermission")
    fun getPhoneCall() {
        val numberPhone = binding.editTextNumber.getText().toString()
        val callIntent = Intent(Intent.ACTION_CALL)
        Log.d("NOMORHP", "Nomor HP : $numberPhone")
        callIntent.data = Uri.parse("tel:$numberPhone")
        startActivity(callIntent)

        Toast.makeText(
            this,
            "Calling To $numberPhone",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun requestingPhoneCall() {
        requestPermissions(arrayOf(Manifest.permission.CALL_PHONE), 302)
    }

//    PEMBATAS ACCESS

    private fun checkPhoneNumberStatus() {
        val permission1Check = checkSelfPermission(Manifest.permission.READ_PHONE_STATE)
        val permission2Check = checkSelfPermission(Manifest.permission.READ_PHONE_NUMBERS)

        if (permission1Check == PackageManager.PERMISSION_GRANTED && permission2Check == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Phone State And Number Permission Granted", Toast.LENGTH_LONG).show()
            getPhoneNumber()
        } else {
            Toast.makeText(this, "Phone State And Number Permission Denied", Toast.LENGTH_LONG).show()
            requestingPhoneNumber()
        }
    }

    @SuppressLint("MissingPermission")
    fun getPhoneNumber() {
        val tMgr = this.getSystemService(TELEPHONY_SERVICE) as TelephonyManager
        val mPhoneNumber = tMgr.line1Number
        Toast.makeText(this, "Phone Number = $mPhoneNumber", Toast.LENGTH_LONG).show()

        Toast.makeText(
            this,
            "Getting Phone Number",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun requestingPhoneNumber() {
        requestPermissions(arrayOf(Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_PHONE_NUMBERS), 303)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            301 -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Location Request Granted", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Location Request Denied", Toast.LENGTH_LONG).show()
                }
            }
            302 -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Phone Call Request Granted", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Phone Call Request Denied", Toast.LENGTH_LONG).show()
                }
            }
            303 -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Phone State Request Granted", Toast.LENGTH_LONG).show()
                } else if (grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Phone Number Request Granted", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Phone State/Number Request Denied", Toast.LENGTH_LONG).show()
                }
            }
            else -> {
                Toast.makeText(this, "Unknown Request Code", Toast.LENGTH_LONG).show()
            }
        }
    }
}