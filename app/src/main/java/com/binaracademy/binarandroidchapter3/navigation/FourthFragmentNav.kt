package com.binaracademy.binarandroidchapter3.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.binaracademy.binarandroidchapter3.R
import com.binaracademy.binarandroidchapter3.databinding.FragmentFourthNavBinding

class FourthFragmentNav : Fragment() {
    private var _binding: FragmentFourthNavBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFourthNavBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFragment.setOnClickListener {
//            val actionToThirdFragment = FourthFragmentDirections.actionFourthFragmentToThirdFragment()
            val mBundle = Bundle()
            mBundle.putString("NAME", arguments?.getString(MainFragmentNav.EXTRA_NAME))
            mBundle.putString("USIA", binding.textViewFragmentUsiaEdit.text.toString())
            mBundle.putString("ALAMAT", binding.textViewFragmentAlamatEdit.text.toString())
            mBundle.putString("PEKERJAAN", binding.textViewFragmentPekerjaanEdit.text.toString())
            it.findNavController().navigate(R.id.action_fourthFragmentNav_to_thirdFragmentNav, mBundle)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}