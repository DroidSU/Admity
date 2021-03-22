package com.brixham.admity.views

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.brixham.admity.R
import com.brixham.admity.adapters.FeesPagerAdapter
import com.google.android.material.tabs.TabLayout

class FeesActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var feesTabLayout: TabLayout
    private lateinit var feesViewPager: ViewPager
    private lateinit var backImgMsg: ImageView
    private lateinit var imgMsgBellIcon: ImageView
    private lateinit var textViewMsg: TextView
    //private lateinit var feesAdapter: FeesPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fees)

        backImgMsg = findViewById(R.id.imgIcLeftArrow)
        imgMsgBellIcon = findViewById(R.id.imgHeaderBellIcon)
        textViewMsg = findViewById(R.id.textHeaderFees)
        backImgMsg.visibility = View.VISIBLE
        imgMsgBellIcon.visibility = View.VISIBLE
        textViewMsg.visibility = View.VISIBLE
        backImgMsg.setOnClickListener {
            var intent: Intent = Intent(this, DashBoard::class.java)
            startActivity(intent)
            finish()
        }
        imgMsgBellIcon.setOnClickListener {
            var intent: Intent = Intent(this, Notification::class.java)
            startActivity(intent)
            finish()
        }
        //toolbar = findViewById(R.id.Feeslayout_toolbaar)
        //setSupportActionBar(toolbar)
        feesTabLayout = findViewById(R.id.fees_tabLayout)
        feesTabLayout.addTab(feesTabLayout.newTab().setText("All"))
        feesTabLayout.addTab(feesTabLayout.newTab().setText("Pending"))
        feesTabLayout.addTab(feesTabLayout.newTab().setText("Paid"))
        feesTabLayout.setTabTextColors(Color.BLACK, Color.YELLOW)

        feesTabLayout.tabGravity = TabLayout.GRAVITY_FILL
        feesViewPager = findViewById(R.id.fees_viewPager)
        val adapter = FeesPagerAdapter(this,supportFragmentManager, feesTabLayout.tabCount)

        feesViewPager.adapter = adapter
        feesViewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(feesTabLayout))
        feesTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                feesViewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }




}