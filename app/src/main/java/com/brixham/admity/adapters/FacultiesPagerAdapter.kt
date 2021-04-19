package com.brixham.admity.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.brixham.admity.fragments.*

class  FacultiesPagerAdapter(private val context: Context, fm: FragmentManager, internal var behavior: Int) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        when (position) {

            0 -> {
                return AllFacultiesFragment()
            }
            1 -> {
                return MathsFacultiesFragment()
            }
            2 -> {
                return EnglishFacultiesFragment()
            }
            3 -> {
                return BengaliFacultiesFragment()
            }
        }
        return Fragment()
    }

    override fun getCount(): Int {
        return behavior
    }


}