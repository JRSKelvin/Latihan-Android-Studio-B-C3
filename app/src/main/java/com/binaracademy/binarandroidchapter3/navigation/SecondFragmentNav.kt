package com.binaracademy.binarandroidchapter3.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.binaracademy.binarandroidchapter3.databinding.FragmentSecondNavBinding

class SecondFragmentNav : Fragment() {
    private var _binding: FragmentSecondNavBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondNavBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val aName = arguments?.getString(MainFragmentNav.EXTRA_NAME)
        binding.textViewFragmentNameView.text = "Nama Kamu : $aName"

        binding.buttonFragment.setOnClickListener {
            if (binding.textViewFragmentNameEdit.text.isNullOrEmpty()) {
                Toast.makeText(requireContext(), "Mohon Diisi Nama Pada Input", Toast.LENGTH_LONG).show()
            } else {
                val actionToThirdFragment = SecondFragmentNavDirections.actionSecondFragmentNavToThirdFragmentNav()
                actionToThirdFragment.name = binding.textViewFragmentNameEdit.text.toString()
                it.findNavController().navigate(actionToThirdFragment)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}