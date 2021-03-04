package com.brixham.admity.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.brixham.admity.R


class DashBoard : AppCompatActivity() {

    private lateinit var imgBellIcon: ImageView
    var adapter: CustomGrid? = null
    var web = arrayOf(
        "Google",
        "Github",
        "Instagram",
        "Facebook",
        "Flickr",
        "Pinterest",
        "Quora",
        "Twitter",
        "Vimeo",
        "WordPress",
        "Youtube"

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
        R.drawable.present

    )




    // lateinit var adapterView: AdapterView





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)





        imgBellIcon = findViewById(R.id.imgBell)





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




