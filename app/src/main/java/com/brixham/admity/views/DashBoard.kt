package com.brixham.admity.views

//import com.brixham.admity.adaptars.CustomGrid
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.GridView
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import com.brixham.admity.R
import com.brixham.admity.adaptars.DashBoardGridAdapter
import com.brixham.admity.fragments.EventDetailsFragment
import com.brixham.admity.fragments.HomeFragment
import com.brixham.admity.fragments.NotificationFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView


class DashBoard : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener{


    private lateinit var imgMenuIcon: ImageView
    private lateinit var imgBellIcon: ImageView
    private lateinit var imgLogoIcon: ImageView
    private lateinit var dashboardImgCircleDP: ImageView
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var buttonChat: Menu
    private lateinit var linearLayoutChangePwd: LinearLayout
    private lateinit var dashBoardGrid: GridView
    private lateinit var gridAdapter: DashBoardGridAdapter

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
        dashBordDrawerLayout = findViewById(R.id.drawer_layout)
        dashboardImgCircleDP = findViewById(R.id.dashboardImgCircleDp)
        dashBordNavigationView = findViewById(R.id.nav_view)
        dashBordNavigationViewMenu = findViewById(R.id.nav_view_menu)
        //dashBoardGrid = findViewById(R.id.gridView_dashboard)
        //gridAdapter = DashBoardGridAdapter(applicationContext,textStudentPanel, imagesStudentPanel)
        //dashBoardGrid.adapter



        dashBordNavigationView.setNavigationItemSelectedListener(this)
        showDashBoard()




        imgBellIcon.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, EventDetails::class.java))
        })
        imgMenuIcon.setOnClickListener(View.OnClickListener {
            dashBordDrawerLayout.openDrawer(Gravity.LEFT)
            /*var intent2: Intent = Intent(this, ChangePassword::class.java)
            Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent2)*/
        })


        imgMenuIcon.visibility = View.VISIBLE
        imgLogoIcon.visibility = View.VISIBLE
        imgBellIcon.visibility = View.VISIBLE
        dashboardImgCircleDP.visibility = View.VISIBLE
        //dashBordNavigationView = findViewById(R.id.nav_view)
        dashboardImgCircleDP.setOnClickListener {
            dashBordDrawerLayout.openDrawer(Gravity.RIGHT)
            linearLayoutChangePwd = findViewById(R.id.linearLayout_changePassword)
            linearLayoutChangePwd.setOnClickListener {
                Log.d("TAG", "onNavigationItemSelected: Trigerred")


            }


        }

        /*linearLayoutChangePassword.setOnClickListener {
            var intent4: Intent = Intent(this, ChangePassword::class.java)
            Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent4)
            finish()
        }*/
    }






    private fun showDashBoard() {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
// Replace the contents of the container with the new fragment
        ft.replace(R.id.dashBoard_frameLayout, HomeFragment())
        //ft.replace(R.id.dashBoard_frameLayout, EventDetailsFragment())
// or ft.add(R.id.your_placeholder, new FooFragment());
// Complete the changes added above
        ft.commit()
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






