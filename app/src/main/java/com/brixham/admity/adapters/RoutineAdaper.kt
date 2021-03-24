package com.brixham.admity.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.brixham.admity.fragments.*

class  RoutineAdaper(private val context: Context, fm: FragmentManager, internal var behavior: Int) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        when (position) {

//            0 -> {
//                return MonFrag()
//            }
//            1 -> {
//                return TueFrag()
//            }
//            2 -> {
//                return Wedfrag()
//            }
//            3 -> {
//                return ThursFrag()
//            }
//            4 -> {
//                return FriFrag()
//            }
//            5 -> {
//                return SaturFrag()
//            }
//            6 -> {
//                return SunFrag()
//            }

        }
        return Fragment()
    }

    override fun getCount(): Int {
        return behavior
    }


}