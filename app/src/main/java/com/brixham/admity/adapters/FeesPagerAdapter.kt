package com.brixham.admity.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.brixham.admity.fragments.FeesAllFragment
import com.brixham.admity.fragments.PaidFeesFragment
import com.brixham.admity.fragments.PendingFeesFragment


class  FeesPagerAdapter(private val context: Context, fm: FragmentManager,internal var behavior: Int) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        when (position) {

            0 -> {
                return FeesAllFragment()
            }
            1 -> {
                return PendingFeesFragment()
            }
            2 -> {
                return PaidFeesFragment()
            }

        }
        return Fragment()
    }

    override fun getCount(): Int {
        return behavior
    }


}



