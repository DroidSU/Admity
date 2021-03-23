package com.brixham.admity.views

import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ExpandableListView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.brixham.admity.R
import com.brixham.admity.fragments.FragmentMessage
import com.brixham.admity.fragments.HelpFragment
import com.brixham.admity.fragments.HomeFragment
import com.brixham.admity.models.StudentProfileResponseModel
import com.brixham.admity.network.NetworkCallback
import com.brixham.admity.utilities.Constants
import com.brixham.admity.viewmodels.StudentProfileViewModel
import com.brixham.admity.viewmodels.StudentProfileViewModelFactory
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.techatmosphere.expandablenavigation.model.ChildModel
import com.techatmosphere.expandablenavigation.model.HeaderModel
import com.techatmosphere.expandablenavigation.view.ExpandableNavigationListView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance


class DashBoard : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, KodeinAware,
    NetworkCallback {
    override val kodein by closestKodein()

    // for student data
    private val studentprofileViewModelFactory: StudentProfileViewModelFactory by instance()
    private lateinit var studentprofileViewModel: StudentProfileViewModel

    private lateinit var imgMenuIcon: ImageView
    private lateinit var imgBellIcon: ImageView
    private lateinit var imgLogoIcon: ImageView
    private lateinit var dashboardImgCircleDP: ImageView
    private lateinit var backIcon : ImageView
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var drawerTextFullName: TextView
    private lateinit var toolbarHeader: TextView
    private lateinit var toolbar: Toolbar
    private lateinit var dashBordDrawerLayout: DrawerLayout
    private lateinit var expandableNavigationListView: ExpandableNavigationListView

    private lateinit var navigationView: NavigationView
    private lateinit var dashBordNavigationViewMenu: NavigationView
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var alertDialog: AlertDialog.Builder

    private var authToken = ""
    private var userName = ""

    private var TAG = DashBoard::class.java.simpleName

    private fun getStudentDetails() {
        CoroutineScope(Dispatchers.IO).launch {
            studentprofileViewModel.getStudentProfile(authToken, this@DashBoard)
        }
    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        // Initialising student profile data
        studentprofileViewModel = ViewModelProvider(
            this,
            studentprofileViewModelFactory
        ).get(StudentProfileViewModel::class.java)

        sharedPreferences = getSharedPreferences(Constants.SHARED_PREF_FILE_NAME, MODE_PRIVATE)
        authToken = sharedPreferences.getString(Constants.SHARED_PREFS_AUTH_TOKEN, "")!!
        userName = sharedPreferences.getString(Constants.SHARED_PREFS_USER_NAME, "")!!

        imgBellIcon = findViewById(R.id.imgHeaderBellIcon)
        imgMenuIcon = findViewById(R.id.imgMenuIcon)
        imgLogoIcon = findViewById(R.id.imgLogoIcon)
        toolbarHeader = findViewById(R.id.toolbar_header)
        dashBordDrawerLayout = findViewById(R.id.drawer_layout)
        dashboardImgCircleDP = findViewById(R.id.dashboardImgCircleDp)
        bottomNavigationView = findViewById(R.id.dashboard_bottom_navigation)
        dashBordNavigationViewMenu = findViewById(R.id.nav_view_menu)
        backIcon = findViewById(R.id.imgIcLeftArrow)

        //drawerTextFullName = findViewById(R.id.drawer_textProfileFullName)
        dashBordNavigationViewMenu.setNavigationItemSelectedListener(this)
        navigationView = findViewById(R.id.nav_view)
        expandableNavigationListView = findViewById(R.id.expandable_navigation)
        expandableNavigationListView.init(this).addHeaderModel(
            HeaderModel(
                "My Institute",
                R.drawable.institute,
                true
            ).addChildModel(ChildModel("Institute Prospectus"))
                .addChildModel(ChildModel("Institute Profile"))
                .addChildModel(ChildModel("Institute Download"))
                .addChildModel(ChildModel("Institute Timetable"))
                .addChildModel(ChildModel("Institute Guardian Call"))
                .addChildModel(ChildModel("Institute Guardian Meeting"))
        )
            .addHeaderModel(HeaderModel("My Transaction", R.drawable.transaction))
            .addHeaderModel(HeaderModel("Enquiry", R.drawable.enquiry))
            .addHeaderModel(HeaderModel("FAQs", R.drawable.faqs)).build()
            .addOnGroupClickListener(ExpandableListView.OnGroupClickListener { parent, v, groupPosition, id ->
                expandableNavigationListView.setSelected(groupPosition)
                //drawer.closeDrawer(GravityCompat.START);
                when (id) {
                    0L -> {
                        //Home Menu

                        //dashBordDrawerLayout.closeDrawer(GravityCompat.START)
                    }
                    1L -> {
                        //Cart Menu
                        /*val intent =
                                    Intent(this, MyInstitute::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                                startActivity(intent)
                                dashBordDrawerLayout.closeDrawer(GravityCompat.START)*/
                        /*Common.showToast(context, "Cart Select")
                                drawer.closeDrawer(GravityCompat.START)*/
                    }
                    2L -> {
                        //Categories Menu

                    }
                    3L -> {
                        //Orders Menu
                        /* Common.showToast(context, "Orders")
                                 drawer.closeDrawer(GravityCompat.START)*/
                    }
                    4L -> {
                        //Wishlist Menu
                        /*Common.showToast(context, "Wishlist Selected")
                                drawer.closeDrawer(GravityCompat.START)*/
                    }
                    5L -> {
                        //Notifications Menu
                        /*Common.showToast(context, "Notifications")
                                drawer.closeDrawer(GravityCompat.START)*/
                    }
                }
                false
            })
            .addOnChildClickListener(ExpandableListView.OnChildClickListener { parent, v, groupPosition, childPosition, id ->
                expandableNavigationListView.setSelected(groupPosition, childPosition)
                if (id == 0L) {
                    val intent =
                        Intent(
                            this,
                            MyProspectus::class.java
                        ).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    startActivity(intent)
                    dashBordDrawerLayout.closeDrawer(GravityCompat.START)
                } else if (id == 1L) {
                    dashBordDrawerLayout.closeDrawer(GravityCompat.START)
                } else if (id == 2L) {

                } else if (id == 3L) {

                }
                dashBordDrawerLayout.closeDrawer(GravityCompat.START)
                false
            })


        //toolbar = findViewById(R.id.toolbar)

        //toolbar.setTitle(getResources().getString(R.string.home_page));

        //initViews()
        navigationView.setNavigationItemSelectedListener(this)
        dashboardImgCircleDP.setOnClickListener {
            dashBordDrawerLayout.openDrawer(Gravity.RIGHT)
        }

       initInitialView()

        bottomNavigationView.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.buttonHome -> {
                    initInitialView()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.buttonTask -> {
                    return@OnNavigationItemSelectedListener true
                }
                R.id.buttonChat -> {
                    initChatFragment()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.buttonHelp -> {
                    imgMenuIcon.visibility = VISIBLE
                    imgLogoIcon.visibility = GONE
                    imgBellIcon.visibility = GONE
                    dashboardImgCircleDP.visibility = VISIBLE
                    backIcon.visibility = GONE
                    toolbarHeader.visibility = VISIBLE

                    toolbarHeader.text = resources.getString(R.string.help)
                    //toolbar.setTitle(resources.getString(R.string.help))
                    loadFragment(fragment = HelpFragment.newInstance())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.buttonReport -> {
                    //toolbar.setTitle(resources.getString(R.string.help))
                    //loadFragment(HelpFragment())
                    return@OnNavigationItemSelectedListener true
                }
                else -> return@OnNavigationItemSelectedListener false
            }
        })





        imgMenuIcon.setOnClickListener(View.OnClickListener {
            dashBordDrawerLayout.openDrawer(Gravity.LEFT)
        })
        /*dashboardImgCircleDP.setOnClickListener {
            dashBordDrawerLayout.openDrawer(Gravity.RIGHT)

        }*/
        imgBellIcon.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, Notification::class.java))
        })


        //var view : View = dashBordNavigationView.getHeaderView(0)
    }

    private fun initChatFragment() {
        imgMenuIcon.visibility = VISIBLE
        imgLogoIcon.visibility = GONE
        imgBellIcon.visibility = GONE
        dashboardImgCircleDP.visibility = VISIBLE
        backIcon.visibility = GONE
        toolbarHeader.visibility = VISIBLE

        toolbarHeader.text = resources.getString(R.string.message)

        loadFragment(FragmentMessage.newInstance())
    }

    private fun initInitialView() {
        imgMenuIcon.visibility = VISIBLE
        imgLogoIcon.visibility = VISIBLE
        imgBellIcon.visibility = VISIBLE
        backIcon.visibility = GONE
        dashboardImgCircleDP.visibility = VISIBLE

        toolbarHeader.visibility = GONE

        loadFragment(HomeFragment.newInstance(name = userName))
    }


    private fun loadFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.dashBoard_frameLayout, fragment)
        transaction.commit()
    }


    override fun onStart() {
        super.onStart()

        getStudentDetails()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_student_profile -> {
                //Toast.makeText(this, "student Profile", Toast.LENGTH_LONG).show()
                val intent =
                    Intent(
                        this,
                        StudentProfile::class.java
                    ).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
            R.id.menu_change_password -> {
                val intent =
                    Intent(
                        this,
                        ChangePassword::class.java
                    ).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
            R.id.menu_settings -> {
                val intent =
                    Intent(
                        this,
                        AccountsSettings::class.java
                    ).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
            R.id.menu_logout -> {
                alertDialog = AlertDialog.Builder(this)
                alertDialog.setTitle("Confirm Exit...!!!")
                alertDialog.setIcon(R.drawable.ic_warning)
                alertDialog.setMessage("Are you sure, You want to Logout")
                alertDialog.setCancelable(false)
                alertDialog.setPositiveButton(
                    "Yes",
                    DialogInterface.OnClickListener { dialog, id ->
                        val intent =
                            Intent(
                                this,
                                LoginScreen::class.java
                            ).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        startActivity(intent)
                    })
                alertDialog.setNegativeButton(
                    "No",
                    DialogInterface.OnClickListener { dialog, id -> dialog.cancel() })
                alertDialog.setNeutralButton(
                    "Cancel",
                    DialogInterface.OnClickListener { dialog, id -> dialog.cancel() })
                val builder: AlertDialog = alertDialog.create()
                builder.show()

            }


            /* R.id.menu_transaction -> {
                 *//*val intent =
                    Intent(this, HelpActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)*//*
            }
            R.id.menu_enquiry -> {
                *//*val intent =
                    Intent(this, ::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)*//*
            }
            R.id.menu_faqs -> {
                *//* val intent =
                     Intent(this, ChangePassword::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                 startActivity(intent)*//*
            }*/
        }

        val dashBoardDrawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        dashBoardDrawerLayout.closeDrawer(GravityCompat.END)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.left_menu_drawer, menu)
        return true
    }

    override fun callStarted() {
        CoroutineScope(Dispatchers.Main).launch {
        }
    }

    override fun callFailed(errorMessage: String) {
        CoroutineScope(Dispatchers.Main).launch {
            Log.d(TAG, "callFailed: $errorMessage")
        }
    }

    override fun callSuccess(data: Any) {
        CoroutineScope(Dispatchers.Main).launch {
            val studentProfileResponse = data as StudentProfileResponseModel

            if (studentProfileResponse.data.s_fName != userName) {
                val editor = sharedPreferences.edit()
                editor.putString(Constants.SHARED_PREFS_USER_NAME, studentProfileResponse.data.s_fName)
                loadFragment(HomeFragment.newInstance(studentProfileResponse.data.s_fName))
                editor.apply()
            }
        }
    }
}







