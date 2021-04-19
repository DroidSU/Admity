package com.brixham.admity.views

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.brixham.admity.R

class PaymentActivity : AppCompatActivity() {

    private lateinit var backImgPaymentMethod: ImageView
    private lateinit var imgPaymentMethodBellIcon: ImageView
    private lateinit var textViewHeader: TextView
    private lateinit var paymentmethodmonthSpinner: Spinner
    private lateinit var paymentmethodyearSpinner: Spinner
    private lateinit var debitCardRadioButton: RadioButton
    private lateinit var debitCardRadioGroup: RadioGroup
    private lateinit var debitCardLinearLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        setUpViews()
    }

    private fun setUpViews() {
        backImgPaymentMethod = findViewById(R.id.imgIcLeftArrow)
        textViewHeader = findViewById(R.id.toolbar_header)

        textViewHeader.text = getString(R.string.payment_method)
        backImgPaymentMethod.visibility = View.VISIBLE
        textViewHeader.visibility = View.VISIBLE
        backImgPaymentMethod.setOnClickListener {
            onBackPressed()
        }
        paymentmethodmonthSpinner = findViewById(R.id.payment_method_month_spinner)
        val monthList = resources.getStringArray(R.array.MonthList)

        var adapter1 = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item, monthList
        )
        paymentmethodmonthSpinner.adapter = adapter1
        paymentmethodmonthSpinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            @SuppressLint("ResourceAsColor")
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {

                /*Toast.makeText(
                    this@EnquiryActivity,
                    getString(R.string.enquiry_type) + " " +
                            "" + languages[position], Toast.LENGTH_SHORT
                ).show()*/
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }  }

        paymentmethodyearSpinner = findViewById(R.id.payment_method_year_spinner)
        val yearList = resources.getStringArray(R.array.YearList)
        var adapter2 = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item, yearList
        )
        paymentmethodyearSpinner.adapter = adapter2
        paymentmethodyearSpinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            @SuppressLint("ResourceAsColor")
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {

            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }  }
        debitCardRadioButton = findViewById(R.id.radioButton_debit_card)
        debitCardRadioGroup = findViewById(R.id.radioGroup_debit_card)
        debitCardLinearLayout = findViewById(R.id.ll_payment_method_debit_card)


    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.radioButton_debit_card ->
                    if (checked) {
                        debitCardLinearLayout.visibility = View.VISIBLE
                    }else if(checked){
                        finish()
                    }

            }
        }
    }

    fun onRadioButtonClickedUpi(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.radioButton_upi ->
                    if (checked) {
                        debitCardLinearLayout.visibility = View.GONE
                    }else if(checked){
                        finish()
                    }

            }
        }
    }
}