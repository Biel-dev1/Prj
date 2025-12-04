package com.ffxtreme.app.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ffxtreme.app.fragments.AimbotFragment
import com.ffxtreme.app.fragments.ConfigFragment
import com.ffxtreme.app.fragments.MiscFragment
import com.ffxtreme.app.fragments.VisualFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AimbotFragment()
            1 -> VisualFragment()
            2 -> MiscFragment()
            3 -> ConfigFragment()
            else -> AimbotFragment()
        }
    }
}
