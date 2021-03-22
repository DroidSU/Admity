package com.brixham.admity.views

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.brixham.admity.R
import com.brixham.admity.adapters.RoutineAdaper
import com.google.android.material.tabs.TabLayout
import xdroid.widget.HorizontalSpinner

class RoutineActivity : AppCompatActivity() {

    //private lateinit var horizontalSpinner: HorizontalSpinner;
    private lateinit var routineTabLayout: TabLayout
    private lateinit var routineViewPager: ViewPager
    private lateinit var backImgRoutine: ImageView
    private lateinit var imgRoutineBellIcon: ImageView
    private lateinit var textViewRoutine: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_routine)
        backImgRoutine = findViewById(R.id.imgIcLeftArrow)
        imgRoutineBellIcon = findViewById(R.id.imgHeaderBellIcon)
        textViewRoutine = findViewById(R.id.textHeaderRoutine)
        backImgRoutine.visibility = View.VISIBLE
        imgRoutineBellIcon.visibility = View.VISIBLE
        textViewRoutine.visibility = View.VISIBLE

       backImgRoutine.setOnClickListener {
           var intent: Intent = Intent(this, DashBoard::class.java)
           startActivity(intent)
           finish()
       }
        imgRoutineBellIcon.setOnClickListener {
            var intent: Intent = Intent(this, Notification::class.java)
            startActivity(intent)
            finish()
        }

        routineTabLayout = findViewById(R.id.routine_tabLayout)
        routineTabLayout.addTab(routineTabLayout.newTab().setText("Mon"))
        routineTabLayout.addTab(routineTabLayout.newTab().setText("Tue"))
        routineTabLayout.addTab(routineTabLayout.newTab().setText("Wed"))
        routineTabLayout.addTab(routineTabLayout.newTab().setText("Thu"))
        routineTabLayout.addTab(routineTabLayout.newTab().setText("Fri"))
        routineTabLayout.addTab(routineTabLayout.newTab().setText("Sat"))
        routineTabLayout.addTab(routineTabLayout.newTab().setText("Sun"))
        routineTabLayout.setTabTextColors(Color.BLACK, Color.BLUE)

        //horizontalSpinner = findViewById(R.id.horizontal_spinner)



        routineTabLayout.tabGravity = TabLayout.GRAVITY_FILL
        routineViewPager = findViewById(R.id.routine_viewPager)
        val adaper = RoutineAdaper(this, supportFragmentManager, routineTabLayout.tabCount)
        routineViewPager.adapter = adaper
        routineTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                routineViewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

    }
}