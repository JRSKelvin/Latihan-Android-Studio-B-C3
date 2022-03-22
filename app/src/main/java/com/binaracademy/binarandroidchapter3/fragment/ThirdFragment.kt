package com.binaracademy.binarandroidchapter3.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.binaracademy.binarandroidchapter3.R

class ThirdFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("Fragment Third onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val ctx = container?.context
        val self = LayoutInflater.from(ctx).inflate(R.layout.fragment_third, container, false)
        val bDaButton = self?.findViewById<Button>(R.id.showIntent)
        bDaButton?.setOnClickListener {
            val createIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Praktek Intent Android")
                type = "text/plain"
            }

            if (activity?.let { it1 -> createIntent.resolveActivity(it1.packageManager) } != null) {
                startActivity(createIntent)
            }
        }
        return self

        return inflater.inflate(R.layout.fragment_third, container, false)
    }
}