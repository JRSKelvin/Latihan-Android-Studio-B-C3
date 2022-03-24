package com.binaracademy.binarandroidchapter3.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.binaracademy.binarandroidchapter3.R
import com.binaracademy.binarandroidchapter3.databinding.FragmentThirdNavBinding

class ThirdFragmentNav : Fragment() {
    private var _binding: FragmentThirdNavBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThirdNavBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val aName = ThirdFragmentNavArgs.fromBundle(arguments as Bundle).name
        val aUsia = arguments?.getString("USIA")
        val aAlamat = arguments?.getString("ALAMAT")
        val aPekerjaan = arguments?.getString("PEKERJAAN")
        val aNewName = arguments?.getString("NAME")
        binding.textViewFragmentNameView.text = "Nama Kamu : $aName"
        if (!aUsia.isNullOrEmpty() or !aAlamat.isNullOrEmpty() or !aPekerjaan.isNullOrEmpty() or !aNewName.isNullOrEmpty()) {
            var deviderByInt : String = ""
            if (aUsia!!.toInt() %2 == 0) {
                deviderByInt = "Genap"
            } else {
                deviderByInt = "Ganjil"
            }
            binding.textViewFragmentNameView.text = "Nama Kamu : $aNewName"
            binding.textViewFragmentUsiaView.text = "Usia Kamu : $aUsia Angka $deviderByInt"
            binding.textViewFragmentAlamatView.text = "Alamat Kamu : $aAlamat"
            binding.textViewFragmentPekerjaanView.text = "Pekerjaan Kamu : $aPekerjaan"
        } else {
            binding.textViewFragmentUsiaView.visibility = View.GONE
            binding.textViewFragmentAlamatView.visibility = View.GONE
            binding.textViewFragmentPekerjaanView.visibility = View.GONE
        }

        binding.buttonFragment.setOnClickListener {
            val mBundle = Bundle()
            mBundle.putString(MainFragmentNav.EXTRA_NAME, aName)
            it.findNavController().navigate(R.id.action_thirdFragmentNav_to_fourthFragmentNav, mBundle)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}