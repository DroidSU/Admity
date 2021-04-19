package com.brixham.admity.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.brixham.admity.fragments.*

class  SyllabusPagerAdapter(private val context: Context, fm: FragmentManager, internal var behavior: Int) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        when (position) {

            0 -> {
                return MathsFragment()
            }
            1 -> {
                return EnglishFragment()
            }
            2 -> {
                return BengaliFragment()
            }
            3 -> {
                return ScienceFragment()
            }
        }
        return Fragment()
    }

    override fun getCount(): Int {
        return behavior
    }


}