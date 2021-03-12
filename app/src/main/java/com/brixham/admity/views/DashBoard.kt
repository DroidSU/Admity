package com.brixham.admity.views

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.GridView
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import com.brixham.admity.R
import com.brixham.admity.fragments.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView


class DashBoard : AppCompatActivity(){


    private lateinit var imgMenuIcon: ImageView
    private lateinit var imgBellIcon: ImageView
    private lateinit var imgLogoIcon: ImageView
    private lateinit var dashboardImgCircleDP: ImageView
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var linearLayoutChangePwd: LinearLayout
    private lateinit var dashBoardGrid: GridView

    //private lateinit var toolbar: Toolbar
    private lateinit var dashBordDrawerLayout: DrawerLayout

    private lateinit var dashBordNavigationView: NavigationView
    private lateinit var dashBordNavigationViewMenu: NavigationView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        initViews()

        showDashBoard()

        imgBellIcon.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, ChangePassword::class.java))
        })

        imgMenuIcon.setOnClickListener(View.OnClickListener {
            dashBordDrawerLayout.openDrawer(Gravity.LEFT)
        })

        dashboardImgCircleDP.setOnClickListener {
            dashBordDrawerLayout.openDrawer(Gravity.RIGHT)
            linearLayoutChangePwd = findViewById(R.id.linearLayout_changePassword)
        }
    }

    private fun initViews() {
        imgBellIcon = findViewById(R.id.imgHeaderBellIcon)
        imgMenuIcon = findViewById(R.id.imgMenuIcon)
        imgLogoIcon = findViewById(R.id.imgLogoIcon)
        dashBordDrawerLayout = findViewById(R.id.drawer_layout)
        dashboardImgCircleDP = findViewById(R.id.dashboardImgCircleDp)
        dashBordNavigationView = findViewById(R.id.nav_view)
        dashBordNavigationViewMenu = findViewById(R.id.nav_view_menu)

        imgMenuIcon.visibility = View.VISIBLE
        imgLogoIcon.visibility = View.VISIBLE
        imgBellIcon.visibility = View.VISIBLE
        dashboardImgCircleDP.visibility = View.VISIBLE
    }


    private fun showDashBoard() {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.dashBoard_frameLayout, HomeFragment.newInstance())
        //ft.replace(R.id.dashBoard_frameLayout, EventDetailsFragment())
        // or ft.add(R.id.your_placeholder, new FooFragment());
        // Complete the changes added above
        ft.commit()
    }
}






