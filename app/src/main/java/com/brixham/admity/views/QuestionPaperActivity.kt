package com.brixham.admity.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.brixham.admity.R

class QuestionPaperActivity : AppCompatActivity() {

    private lateinit var backImgExam: ImageView
    private lateinit var imgExamViewBellIcon: ImageView
    private lateinit var textViewHeader: TextView

    private lateinit var buttonMath: Button
    private lateinit var buttonEng: Button
    private lateinit var buttonBeng: Button
    private lateinit var buttonComp: Button
    private lateinit var buttonPhy: Button
    private lateinit var buttonChem: Button
    private lateinit var buttonBio: Button
    private lateinit var buttonHist: Button
    private lateinit var buttonGeo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_paper)
        setupView()
    }

    private fun setupView() {
        backImgExam = findViewById(R.id.imgIcLeftArrow)
        imgExamViewBellIcon = findViewById(R.id.imgHeaderBellIcon)
        textViewHeader = findViewById(R.id.toolbar_header)

        textViewHeader.text = getString(R.string.question_paper)
        backImgExam.visibility = View.VISIBLE
        textViewHeader.visibility = View.VISIBLE

        backImgExam.setOnClickListener {
            onBackPressed()
        }
        buttonMath = findViewById(R.id.question_paper_button_math)
        buttonEng = findViewById(R.id.question_paper_button_english)
        buttonBeng = findViewById(R.id.question_paper_button_bengali)
        buttonComp = findViewById(R.id.question_paper_button_computer)
        buttonPhy = findViewById(R.id.question_paper_button_physics)
        buttonChem = findViewById(R.id.question_paper_button_chemistry)
        buttonBio = findViewById(R.id.question_paper_button_biology)
        buttonHist = findViewById(R.id.question_paper_button_history)
        buttonGeo = findViewById(R.id.question_paper_button_geography)
        buttonMath.setOnClickListener {
            val intent = Intent(this@QuestionPaperActivity, MathPaperActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }
        buttonEng.setOnClickListener {
            val intent = Intent(this@QuestionPaperActivity, EnglishPaperActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }
        buttonBeng.setOnClickListener {
            val intent = Intent(this@QuestionPaperActivity, BengaliPaperActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }
        buttonComp.setOnClickListener {
            val intent = Intent(this@QuestionPaperActivity, ComputerPaperActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }
        buttonPhy.setOnClickListener {
            val intent= Intent(this@QuestionPaperActivity, PhysicsPaperActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }
        buttonChem.setOnClickListener {
            val intent = Intent(this@QuestionPaperActivity, ChemistryPaperActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }
        buttonBio.setOnClickListener {
            val intent = Intent(this@QuestionPaperActivity, BiologyPaperActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }
        buttonHist.setOnClickListener {
            val intent = Intent(this@QuestionPaperActivity, HistoryPaperActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }
        buttonGeo.setOnClickListener {
            val intent = Intent(this@QuestionPaperActivity, GeographyPaperActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }

    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}