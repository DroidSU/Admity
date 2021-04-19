package com.brixham.admity.views

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.brixham.admity.R
import com.brixham.admity.adapters.FacultiesPagerAdapter
import com.brixham.admity.adapters.SyllabusPagerAdapter
import com.google.android.material.tabs.TabLayout

class FacultiesActivity : AppCompatActivity() {

    private lateinit var facultiesTabLayout: TabLayout
    private lateinit var facultiesViewPager: ViewPager
    private lateinit var backImgFaculties: ImageView
    private lateinit var imgFacultiesBellIcon: ImageView
    private lateinit var textViewHeader: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faculties)
        setupView()
    }

    private fun setupView() {
        backImgFaculties = findViewById(R.id.imgIcLeftArrow)
        imgFacultiesBellIcon = findViewById(R.id.imgHeaderBellIcon)
        textViewHeader = findViewById(R.id.toolbar_header)

        textViewHeader.text = getString(R.string.faculties)
        backImgFaculties.visibility = View.VISIBLE
        textViewHeader.visibility = View.VISIBLE
        backImgFaculties.setOnClickListener {
            onBackPressed()
        }
        facultiesTabLayout = findViewById(R.id.faculties_tabLayout)
        facultiesTabLayout.addTab(facultiesTabLayout.newTab().setText("All"))
        facultiesTabLayout.addTab(facultiesTabLayout.newTab().setText("Maths"))
        facultiesTabLayout.addTab(facultiesTabLayout.newTab().setText("English"))
        facultiesTabLayout.addTab(facultiesTabLayout.newTab().setText("Bengali"))
        facultiesTabLayout.setTabTextColors(Color.WHITE, Color.YELLOW)

        facultiesViewPager = findViewById(R.id.faculties_viewPager)
        val adapter = FacultiesPagerAdapter(this, supportFragmentManager, facultiesTabLayout.tabCount)

        facultiesViewPager.adapter = adapter
        facultiesViewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(facultiesTabLayout))
        facultiesTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                facultiesViewPager.currentItem = tab.position
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