package com.brixham.admity.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.adapters.RecyclerAdapter
import com.brixham.admity.fragments.FragmentMessage
import com.brixham.admity.fragments.HelpFragment
import com.brixham.admity.fragments.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class Notification : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    private lateinit var recycler_adaptar : RecyclerView
    private lateinit var backIcon: ImageView
    private lateinit var imgMenuIcon: ImageView
    private lateinit var imgLogoIcon: ImageView
    private lateinit var imgBellIcon: ImageView
    private lateinit var dashboardImgCircleDP: ImageView
    private lateinit var toolbarHeader: TextView
    private lateinit var linearLayoutHomePage1: LinearLayout
    private lateinit var bottomNavigationView: BottomNavigationView

    private var userName = ""

    val homeFragment: Fragment = HomeFragment()
    val fragmentMessage: Fragment = FragmentMessage()
    val helpFragment: Fragment = HelpFragment()
    val fm: FragmentManager = supportFragmentManager
    var active: Fragment = homeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        imgBellIcon = findViewById(R.id.imgHeaderBellIcon)
        imgMenuIcon = findViewById(R.id.imgMenuIcon)
        imgLogoIcon = findViewById(R.id.imgLogoIcon)
        bottomNavigationView = findViewById(R.id.bottom_navigation)
        backIcon = findViewById(R.id.imgIcLeftArrow)
        toolbarHeader = findViewById(R.id.toolbar_header)
        backIcon.setOnClickListener {
            val intent = Intent(this, DashBoard::class.java)
            startActivity(intent)
            finish()
        }



        backIcon.visibility = View.VISIBLE
        toolbarHeader.visibility = View.VISIBLE
        toolbarHeader.text = "Notification"

        recycler_adaptar = findViewById(R.id.recyclerNotification)

        layoutManager = LinearLayoutManager(this)
        recycler_adaptar.layoutManager = layoutManager

        //initInitialView()
        adapter = RecyclerAdapter()
        recycler_adaptar.adapter = adapter
        /*bottomNavigationView
            .setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        fm.beginTransaction().add(R.id.dashBoard_frameLayout, helpFragment, "3")
            .hide(helpFragment).commit()
        fm.beginTransaction().add(R.id.dashBoard_frameLayout, fragmentMessage, "2")
            .hide(fragmentMessage).commit()
        fm.beginTransaction().add(R.id.dashBoard_frameLayout, homeFragment, "1").commit()*/

    }
    /*val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item: MenuItem ->
        when (item.itemId) {
            R.id.buttonHome -> {
                fm.beginTransaction().hide(active).show(homeFragment).commit()
                active = homeFragment
            }
            R.id.buttonChat -> {
                fm.beginTransaction().hide(active).show(fragmentMessage).commit()
                active = fragmentMessage
            }
            R.id.buttonHelp -> {
                fm.beginTransaction().hide(active).show(helpFragment).commit()
                active = helpFragment
            }
        }
        true
    }*/
    /*private fun loadFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.notification_frameLayout, fragment)
        transaction.commit()
    }*/

    /*private fun initInitialView() {
        imgMenuIcon.visibility = View.VISIBLE
        imgLogoIcon.visibility = View.VISIBLE
        imgBellIcon.visibility = View.VISIBLE
        backIcon.visibility = View.GONE
        dashboardImgCircleDP.visibility = View.VISIBLE

        toolbarHeader.visibility = View.GONE

        loadFragment(HomeFragment.newInstance(name = userName))
    }
    private fun initChatFragment() {
        imgMenuIcon.visibility = View.VISIBLE
        imgLogoIcon.visibility = View.GONE
        imgBellIcon.visibility = View.GONE
        dashboardImgCircleDP.visibility = View.VISIBLE
        backIcon.visibility = View.GONE
        toolbarHeader.visibility = View.VISIBLE

        toolbarHeader.text = resources.getString(R.string.message)

        loadFragment(FragmentMessage.newInstance())
    }*/

}