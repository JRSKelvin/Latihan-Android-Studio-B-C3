package com.binaracademy.binarandroidchapter3.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.binaracademy.binarandroidchapter3.R
import com.binaracademy.binarandroidchapter3.databinding.FragmentMainNavBinding

class MainFragmentNav : Fragment() {
    private var _binding: FragmentMainNavBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainNavBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFragment.setOnClickListener {
            val mBundle = Bundle()
            mBundle.putString(EXTRA_NAME, "Binarian Pertama")
            it.findNavController().navigate(R.id.action_mainFragmentNav_to_secondFragmentNav, mBundle)
        }
    }

    companion object {
        val EXTRA_NAME = "EXTRA_NAME"
    }
}