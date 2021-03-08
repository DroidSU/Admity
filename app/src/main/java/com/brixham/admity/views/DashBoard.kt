package com.brixham.admity.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.brixham.admity.R
//import com.brixham.admity.adaptars.CustomGrid
import com.google.android.material.navigation.NavigationView


class DashBoard : AppCompatActivity() {



    private lateinit var imgBellIcon: ImageView
    private lateinit var dashboardImgCircleDP: ImageView
    private lateinit var linearLayoutMessage: LinearLayout
    private lateinit var linearLayoutHelp: LinearLayout
    //private lateinit var toolbar: Toolbar
    private lateinit var dashBordDrawerLayout: DrawerLayout
    private lateinit var dashBordNavigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        linearLayoutMessage = findViewById(R.id.linearlayout_message)
        linearLayoutHelp = findViewById(R.id.help_linearlayout)
        linearLayoutMessage.setOnClickListener(View.OnClickListener {
            var intent: Intent = Intent(this, Messages::class.java)
            Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        })
        linearLayoutHelp.setOnClickListener(View.OnClickListener {
            var intent1: Intent = Intent(this, ChatAtivity::class.java)
            Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent1)
        })

        dashBordDrawerLayout = findViewById(R.id.drawer_layout)
        dashboardImgCircleDP = findViewById(R.id.dashboardImgCircleDp)
        //dashBordNavigationView = findViewById(R.id.nav_view)

        dashboardImgCircleDP.setOnClickListener {
            dashBordDrawerLayout.openDrawer(Gravity.RIGHT)
        }
    }
}




