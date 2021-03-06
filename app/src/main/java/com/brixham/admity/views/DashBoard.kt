package com.brixham.admity.views

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.brixham.admity.R
import com.brixham.admity.adaptars.CustomGrid
import com.google.android.material.navigation.NavigationView





class DashBoard : AppCompatActivity() {


    private lateinit var imgBellIcon: ImageView
    private lateinit var dashboardImgCircleDP: ImageView
    private lateinit var linearLayoutMessage: LinearLayout
    //private lateinit var toolbar: Toolbar
    private lateinit var dashBordDrawerLayout: DrawerLayout
    private lateinit var dashBordNavigationView: NavigationView



    var adapter: CustomGrid? = null
    var web = arrayOf(
        "Syllabu",
        "School",
        "Teacher",
        "Attendance",
        "Fees",
        "Leave",
        "Present",
        "Insight",
        "Event",
        "Holiday",
        "Notice",
        "Parents"

    )
    var imageId = intArrayOf(
        R.drawable.syllabus,
        R.drawable.school,
        R.drawable.teacher,
        R.drawable.attendance,
        R.drawable.fee,
        R.drawable.leave,
        R.drawable.present,
        R.drawable.present,
        R.drawable.event,
        R.drawable.holiday,
        R.drawable.notice,
        R.drawable.parents

    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        //toolbar = findViewById(R.id.toolbar);
        imgBellIcon = findViewById(R.id.dashboardImgBellIcon)
        linearLayoutMessage = findViewById(R.id.linearlayout_message)
        linearLayoutMessage.setOnClickListener(View.OnClickListener {
            var intent: Intent = Intent(this, Messages::class.java)
            Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        })

        dashBordDrawerLayout = findViewById(R.id.drawer_layout)
        dashboardImgCircleDP = findViewById(R.id.dashboardImgCircleDp)
        //dashBordNavigationView = findViewById(R.id.nav_view)

        dashboardImgCircleDP.setOnClickListener {
            dashBordDrawerLayout.openDrawer(Gravity.RIGHT)
        }


        /*val toggle =
            ActionBarDrawerToggle(
                this,
                dashBordDrawerLayout,

                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
            )*/
        //dashBordDrawerLayout.setDrawerListener(toggle)
        //toggle.syncState()
        /*dashboardImgCircleDP.setOnClickListener {
            if (dashBordDrawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                dashBordDrawerLayout.closeDrawer(Gravity.RIGHT)
            } else {
                dashBordDrawerLayout.openDrawer(Gravity.RIGHT)
            }
        }*/

        imgBellIcon.setOnClickListener(View.OnClickListener {
            var intent: Intent = Intent(this, Notification::class.java)
            startActivity(intent)


        })


    }
    class CustomGrid(
        private val mContext: Context,
        private val web: Array<String>,
        private val Imageid: IntArray
    ) :
        BaseAdapter() {
        override fun getCount(): Int {
            // TODO Auto-generated method stub
            return web.size
        }

        override fun getItem(position: Int): Any? {
            // TODO Auto-generated method stub
            return null
        }

        override fun getItemId(position: Int): Long {
            // TODO Auto-generated method stub
            return 0
        }

        override fun getView(
            position: Int,
            convertView: View,
            parent: ViewGroup
        ): View {
            // TODO Auto-generated method stub
            var grid: View
            val inflater = mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            if (convertView == null) {
                grid = View(mContext)
                grid = inflater.inflate(R.layout.grid_single, null)
                val textView =
                    grid.findViewById<View>(R.id.grid_text) as TextView
                val imageView =
                    grid.findViewById<View>(R.id.grid_image) as ImageView
                textView.text = web[position]
                imageView.setImageResource(Imageid[position])
            } else {
                grid = convertView
            }
            return grid
        }

    }
}




