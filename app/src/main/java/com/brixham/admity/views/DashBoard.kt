package com.brixham.admity.views

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
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
import com.brixham.admity.fragments.FragmentDashBoard
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance


class DashBoardActivity : AppCompatActivity() {



}


class DashBoard : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, KodeinAware, NetworkCallback{
    override val kodein by closestKodein()
    private val studentprofileViewModelFactory: StudentProfileViewModelFactory by instance()
    private lateinit var studentprofileViewModel: StudentProfileViewModel

    private lateinit var imgMenuIcon: ImageView
    private lateinit var imgBellIcon: ImageView
    private lateinit var imgLogoIcon: ImageView
    private lateinit var dashboardImgCircleDP: ImageView
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var drawerTextFullName: TextView
    private lateinit var dashBoardTextName: TextView
    private lateinit var toolbar: Toolbar
    private lateinit var dashBordDrawerLayout: DrawerLayout

    private  lateinit var navigationView: NavigationView
    private lateinit var dashBordNavigationViewMenu: NavigationView
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var alertDialog: AlertDialog.Builder
   // private lateinit var fragment: Fragment


    var drawerTextName = ""
    var dashboardTextName = ""

    private var authToken = "";
    //var fragment: Fragment? = null
    //var fragmentTransaction: FragmentTransaction? = null

    private var TAG = DashBoard::class.java.simpleName

    private fun getStudentDetails() {
        CoroutineScope(Dispatchers.IO).launch {
            studentprofileViewModel.getStudentProfile(authToken, this@DashBoard)
        }
    }
    var fragment: Fragment? = null
    var fragmentTransaction: FragmentTransaction? = null



    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        val dateFormat =
            DateFormat.getDateFormat(applicationContext)
        studentprofileViewModel = ViewModelProvider(this, studentprofileViewModelFactory).get(StudentProfileViewModel::class.java)

        imgBellIcon = findViewById(R.id.imgHeaderBellIcon)
        imgMenuIcon = findViewById(R.id.imgMenuIcon)
        imgLogoIcon = findViewById(R.id.imgLogoIcon)
        dashBordDrawerLayout = findViewById(R.id.drawer_layout)
        dashboardImgCircleDP = findViewById(R.id.dashboardImgCircleDp)
        bottomNavigationView = findViewById(R.id.bottom_navigation)
        dashBordNavigationViewMenu = findViewById(R.id.nav_view_menu)
        //drawerTextFullName = findViewById(R.id.drawer_textProfileFullName)
        //dashBoardTextName = findViewById(R.id.textView_salutation)
        dashBordNavigationViewMenu.setNavigationItemSelectedListener(this)
        navigationView = findViewById(R.id.nav_view)
        //toolbar = findViewById(R.id.toolbar)

        //toolbar.setTitle(getResources().getString(R.string.home_page));

        //initViews()
        navigationView.setNavigationItemSelectedListener(this)
        dashboardImgCircleDP.setOnClickListener {
            dashBordDrawerLayout.openDrawer(Gravity.RIGHT)
        }

        loadFragment(HomeFragment())
        imgMenuIcon.visibility = View.VISIBLE
        imgLogoIcon.visibility = View.VISIBLE
        imgBellIcon.visibility = View.VISIBLE
        dashboardImgCircleDP.visibility = View.VISIBLE
        //showDashBoard()
        bottomNavigationView.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            val id = menuItem.itemId
            if (id == R.id.buttonHome) {
                //toolbar.setTitle(resources.getString(R.string.message))
                loadFragment(HomeFragment())
                return@OnNavigationItemSelectedListener true
            } else if (id == R.id.buttonTask) {
                return@OnNavigationItemSelectedListener true
            } else if (id == R.id.buttonChat) {
                //toolbar.setTitle(resources.getString(R.string.message))
                loadFragment(FragmentMessage())

                return@OnNavigationItemSelectedListener true
            } else if (id == R.id.buttonHelp) {
                //toolbar.setTitle(resources.getString(R.string.help))
                loadFragment(fragment = HelpFragment())
                return@OnNavigationItemSelectedListener true
            }
            else if (id == R.id.buttonReport) {
                //toolbar.setTitle(resources.getString(R.string.help))
                //loadFragment(HelpFragment())
                return@OnNavigationItemSelectedListener true
            }
            return@OnNavigationItemSelectedListener false
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



    private fun loadFragment(fragment: Fragment) {
        var transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.dashBoard_frameLayout, fragment)
        transaction.commit()

    }


    /*override fun onStart() {
        super.onStart()
        val sharedPrefs = getSharedPreferences(Constants.SHARED_PREF_FILE_NAME, Context.MODE_PRIVATE)
        authToken = sharedPrefs.getString(Constants.SHARED_PREFS_AUTH_TOKEN, "")!!

        // REMOVE LATER
        authToken = Constants.DEFAULT_AUTH_TOKEN;
        Log.d(TAG, "onStart: $authToken")
        getStudentDetails()

    }*/

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_student_profile -> {
                //Toast.makeText(this, "student Profile", Toast.LENGTH_LONG).show()
                val intent =
                    Intent(this, StudentProfile::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)


            }
            R.id.menu_change_password -> {
                val intent =
                    Intent(this, ChangePassword::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
            R.id.menu_settings -> {
                val intent =
                    Intent(this, AccountsSettings::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
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
                            Intent(this, LoginScreen::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        startActivity(intent)
                         })
                alertDialog.setNegativeButton(
                    "No",
                    DialogInterface.OnClickListener { dialog, id -> dialog.cancel() })
                alertDialog.setNeutralButton(
                    "Cancel",
                    DialogInterface.OnClickListener { dialog, id -> dialog.cancel() })
                val builder:AlertDialog = alertDialog.create()
                builder.show()

            }
            R.id.menu_institute -> {
                val intent =
                    Intent(this, MyInstitute::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
            R.id.menu_transaction -> {
                /*val intent =
                    Intent(this, HelpActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)*/
            }
            R.id.menu_enquiry -> {
                /*val intent =
                    Intent(this, ::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)*/
            }
            R.id.menu_faqs -> {
               /* val intent =
                    Intent(this, ChangePassword::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)*/
            }
        }
        val dashBoardDrawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        dashBoardDrawerLayout.closeDrawer(GravityCompat.END)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.left_menu_drawer, menu)
        var menuItem: MenuItem = menu!!.findItem(R.id.menu_institute)
        menuInflater.inflate(R.menu.sub_menu, menuItem.subMenu)
        return true
    }



    /*private fun showDashBoard() {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.dashBoard_frameLayout, HomeFragment.newInstance())
        //ft.replace(R.id.dashBoard_frameLayout, EventDetailsFragment())
        // or ft.add(R.id.your_placeholder, new FooFragment());
        // Complete the changes added above
        ft.commit()
    }*/

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
            val studentProfileResponse= data as StudentProfileResponseModel
            Log.d(TAG, "callSuccess: " + studentProfileResponse.message)
            displayName(studentProfileResponse)
        }
    }

    private fun displayName(studentProfileResponse: StudentProfileResponseModel) {
        //drawerTextFullName.text = studentProfileResponse.data.s_fName
        dashBoardTextName.text = studentProfileResponse.data.s_fName

    }


}







