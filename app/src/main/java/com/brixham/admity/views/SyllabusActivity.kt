package com.brixham.admity.views

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import com.brixham.admity.R
import com.brixham.admity.adapters.SyllabusPagerAdapter
import com.brixham.admity.fragments.MathsFragment
import com.google.android.material.tabs.TabLayout


class SyllabusActivity : AppCompatActivity() {

    private lateinit var syllabusTabLayout: TabLayout
    private lateinit var syllabusViewPager: ViewPager
    private lateinit var backImgSyllabus: ImageView
    private lateinit var imgSyllabusBellIcon: ImageView
    private lateinit var textViewHeader: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_syllabus)
        setupView()
       setFragment()
    }

    private fun setFragment() {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.syllabus_viewPager, MathsFragment())
        ft.commit()
    }

    private fun setupView() {
        backImgSyllabus = findViewById(R.id.imgIcLeftArrow)
        imgSyllabusBellIcon = findViewById(R.id.imgHeaderBellIcon)
        textViewHeader = findViewById(R.id.toolbar_header)

        textViewHeader.text = getString(R.string.syllabus)
        backImgSyllabus.visibility = View.VISIBLE
        textViewHeader.visibility = View.VISIBLE
        backImgSyllabus.setOnClickListener {
            onBackPressed()
        }
        syllabusTabLayout = findViewById(R.id.syllabus_tabLayout)
        syllabusTabLayout.addTab(syllabusTabLayout.newTab().setText("Maths"))
        syllabusTabLayout.addTab(syllabusTabLayout.newTab().setText("English"))
        syllabusTabLayout.addTab(syllabusTabLayout.newTab().setText("Bengali"))
        syllabusTabLayout.addTab(syllabusTabLayout.newTab().setText("Science"))
        syllabusTabLayout.setTabTextColors(Color.WHITE, Color.YELLOW)


        syllabusViewPager = findViewById(R.id.syllabus_viewPager)
        val adapter = SyllabusPagerAdapter(this, supportFragmentManager, syllabusTabLayout.tabCount)

        syllabusViewPager.adapter = adapter
        syllabusViewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(syllabusTabLayout))
        syllabusTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                syllabusViewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}