package com.brixham.admity.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.view.*
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.views.ChangePassword
import com.brixham.admity.views.ForgotPassword
import com.brixham.admity.views.HomeWorkDetailsActivity

class HomeWorkAdapter(private  var context: Context) : RecyclerView.Adapter<HomeWorkAdapter.ViewHolder>() {


    private val textV1 = arrayOf("Biology", "Physics", "Geography", "Science", "English")
    private val textV2 =
        arrayOf("Human Anatomy", "Earth Quantum", "Mason Rains", "Earth Quantum", "Earth Quantum")
    private val textV3 = arrayOf("Priya Sarkar", "Amit Gupta", "Amit Gupta", "Rita Dey", "Rita Dey")
    private val images1 = intArrayOf(
        R.drawable.ic_threedot,
        R.drawable.ic_threedot,
        R.drawable.ic_threedot,
        R.drawable.ic_threedot,
        R.drawable.ic_threedot)
    private val button1 = arrayOf("View", "View", "View", "View", "View")


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var textViewSubName: TextView = view.findViewById(R.id.homework_sub)
        var textViewSubTopic: TextView = view.findViewById(R.id.homework_topic)
        var textViewSubTeacher: TextView = view.findViewById(R.id.homework_teacher)
        var imageViewMenu :ImageView = view.findViewById(R.id.homework_img_menu)
        var imageViewDot :View = view.findViewById(R.id.dot_indicator_homework)
        var buttonView :Button = view.findViewById(R.id.homework_button_view)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeWorkAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.homework_layout_list, parent, false)
        return ViewHolder(v)
    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onBindViewHolder(holder: HomeWorkAdapter.ViewHolder, position: Int) {
        holder.textViewSubName.text = textV1[position]
        holder.textViewSubTopic.text = textV2[position]
        holder.textViewSubTeacher.text = textV3[position]
        holder.imageViewMenu.setImageResource(images1[position])
        holder.buttonView.text = button1[position]
        holder.imageViewMenu.setOnClickListener {
            val popupMenu = PopupMenu(context, holder.imageViewMenu, Gravity.START)
            popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { item: MenuItem ->
                when (item.itemId) {
                    R.id.popup_one -> {

                        true
                    }
                    R.id.popup_two -> {

                        true
                    }

                    else -> {
                        false
                    }
                }
            }
            popupMenu.show()
        }
        if (position==1){
            holder.imageViewDot.setBackgroundResource(R.drawable.dot_enabled)
            holder.buttonView.visibility = View.VISIBLE
            holder.imageViewMenu.visibility = View.VISIBLE
            holder.buttonView.setOnClickListener {
                val intent = Intent(context, HomeWorkDetailsActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                context.startActivity(intent)


            }
        }
    }

    override fun getItemCount(): Int {
        return textV1.size
    }


}