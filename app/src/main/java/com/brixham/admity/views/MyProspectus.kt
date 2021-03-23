package com.brixham.admity.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ExpandableListView

import android.widget.Toast
import com.brixham.admity.R
import com.brixham.admity.adapters.ExpandableListAdapter

class MyProspectus : AppCompatActivity() {

    private var expandableListView: ExpandableListView? = null
    private var adapter: ExpandableListAdapter? = null
    private var titleList: List<String> ? = null


    val data: HashMap<String, List<String>>
        get() {
            val listData = HashMap<String, List<String>>()

            val prospectusQ = ArrayList<String>()
            prospectusQ.add("Like many other students whose families have suffered in the")
            prospectusQ.add("Q")
            prospectusQ.add("Q")


            /*val prospectusQues = ArrayList<String>()
            prospectusQues.add("What is Lorem Ipsum?")
            prospectusQues.add("What is Lorem Ipsum?")
            prospectusQues.add("What is Lorem Ipsum?")*/


            /*val prospectusA = ArrayList<String>()
            prospectusA.add("A")
            prospectusA.add("A")
            prospectusA.add("A")*/


            /*val prospectusAns = ArrayList<String>()
            prospectusAns.add("Samsung Galaxy S9+")
            prospectusAns.add("Samsung Galaxy Note 7")
            prospectusAns.add("Samsung Galaxy Note 5 Dual")*/


            listData["Like many other students whose families have suffered in the"] = prospectusQ
           /* listData["Ques"] = prospectusQues
            listData["A"] = prospectusA
            listData["Ans"] = prospectusAns*/

            return listData
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_prospectus)
        expandableListView = findViewById(R.id.myprospectus_expandablelistView)
        if (expandableListView != null) {
            val listData = data
            titleList = ArrayList(listData.keys)
            adapter = ExpandableListAdapter(this, titleList as ArrayList<String>, listData)
            //adapter = ExpandableListAdapter(this, titleList, listData)
            
            expandableListView!!.setAdapter(adapter)

            expandableListView!!.setOnGroupExpandListener { groupPosition -> Toast.makeText(applicationContext, (titleList as ArrayList<String>)[groupPosition] + " List Expanded.", Toast.LENGTH_SHORT).show() }

            expandableListView!!.setOnGroupCollapseListener { groupPosition -> Toast.makeText(applicationContext, (titleList as ArrayList<String>)[groupPosition] + " List Collapsed.", Toast.LENGTH_SHORT).show() }

            expandableListView!!.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
                Toast.makeText(applicationContext, "Clicked: " + (titleList as ArrayList<String>)[groupPosition] + " -> " + listData[(titleList as ArrayList<String>)[groupPosition]]!!.get(childPosition), Toast.LENGTH_SHORT).show()
                false
            }
        }
    }

}
