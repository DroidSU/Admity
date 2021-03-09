package com.brixham.admity.views

//import com.brixham.admity.adaptars.CustomGrid
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.brixham.admity.R
import com.google.android.material.navigation.NavigationView


class DashBoard : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener{


    private lateinit var imgMenuIcon: ImageView
    private lateinit var imgBellIcon: ImageView
    private lateinit var imgLogoIcon: ImageView
    private lateinit var dashboardImgCircleDP: ImageView
    private lateinit var linearLayoutMessage: LinearLayout
    private lateinit var linearLayoutHelp: LinearLayout
    private lateinit var linearLayoutReport: LinearLayout
    private lateinit var linearLayoutChangePassword: LinearLayout

    //private lateinit var toolbar: Toolbar
    private lateinit var dashBordDrawerLayout: DrawerLayout

    private lateinit var dashBordNavigationView: NavigationView
    private lateinit var dashBordNavigationViewMenu: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        imgBellIcon = findViewById(R.id.imgHeaderBellIcon)
        imgMenuIcon = findViewById(R.id.imgMenuIcon)
        imgLogoIcon = findViewById(R.id.imgLogoIcon)
        linearLayoutMessage = findViewById(R.id.linearLayout_messagePage1)
        linearLayoutHelp = findViewById(R.id.linearLayout_helpPage1)
        //linearLayoutChangePassword = findViewById(R.id.linearLayout_changePassword)
        linearLayoutReport = findViewById(R.id.linearLayout_reportPage1)
        dashBordDrawerLayout = findViewById(R.id.drawer_layout)
        dashboardImgCircleDP = findViewById(R.id.dashboardImgCircleDp)
        dashBordNavigationView = findViewById(R.id.nav_view)
        dashBordNavigationViewMenu = findViewById(R.id.nav_view_menu)
        dashBordNavigationView.setNavigationItemSelectedListener(this)
        linearLayoutReport.setOnClickListener(View.OnClickListener {
            var intent1: Intent = Intent(this, ChatAtivity::class.java)
            Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent1)
        })
        imgBellIcon.setOnClickListener(View.OnClickListener {
            var intent2: Intent = Intent(this, Notification::class.java)
            Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent2)
        })
        imgMenuIcon.setOnClickListener(View.OnClickListener {
            dashBordDrawerLayout.openDrawer(Gravity.LEFT)
            /*var intent2: Intent = Intent(this, ChangePassword::class.java)
            Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent2)*/
        })
        linearLayoutMessage.setOnClickListener(View.OnClickListener {
            var intent3: Intent = Intent(this, Messages::class.java)
            Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent3)
        })
        linearLayoutHelp.setOnClickListener {
            var intent4: Intent = Intent(this, HelpActivity::class.java)
            Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent4)
        }

        imgMenuIcon.visibility = View.VISIBLE
        imgLogoIcon.visibility = View.VISIBLE
        imgBellIcon.visibility = View.VISIBLE
        dashboardImgCircleDP.visibility = View.VISIBLE




        //dashBordNavigationView = findViewById(R.id.nav_view)


        dashboardImgCircleDP.setOnClickListener {
            dashBordDrawerLayout.openDrawer(Gravity.RIGHT)


        }

        /*linearLayoutChangePassword.setOnClickListener {
            var intent4: Intent = Intent(this, ChangePassword::class.java)
            Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent4)
            finish()
        }*/
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (item.isChecked){
            dashBordDrawerLayout.closeDrawer(GravityCompat.START)
            return false
        }

        if (id == R.id.linearLayout_changePassword) {
            Log.d("TAG", "onNavigationItemSelected: Trigerred")
            startActivity(Intent(this, ChangePassword::class.java))
        }

        dashBordDrawerLayout = findViewById(R.id.drawer_layout)
        dashBordDrawerLayout.openDrawer(Gravity.RIGHT)
        dashBordDrawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}






