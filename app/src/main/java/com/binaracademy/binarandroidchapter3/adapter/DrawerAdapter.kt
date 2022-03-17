package com.binaracademy.binarandroidchapter3.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.binaracademy.binarandroidchapter3.FifthActivity
import com.binaracademy.binarandroidchapter3.fragment.MainFragment
import com.binaracademy.binarandroidchapter3.fragment.SecondFragment
import com.binaracademy.binarandroidchapter3.fragment.ThirdFragment

class DrawerAdapter(fragmentActivity : FifthActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> MainFragment()
            1 -> SecondFragment()
            2 -> ThirdFragment()
            else -> MainFragment()
        }
    }
}