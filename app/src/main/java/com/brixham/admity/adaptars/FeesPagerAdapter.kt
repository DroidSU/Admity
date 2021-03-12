package com.brixham.admity.adaptars

import android.R
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.brixham.admity.fragments.FeesAllFragment
import com.brixham.admity.fragments.PaidFeesFragment
import com.brixham.admity.fragments.PendingFeesFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener


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



