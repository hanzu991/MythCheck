package com.example.mythcheck

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent

class QuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        class `QuestionActivity` : AppCompatActivity() {
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                enableEdgeToEdge()
                setContentView(R.layout.activity_question)
                ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                    val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                    v.setPadding(
                        systemBars.left,
                        systemBars.top,
                        systemBars.right,
                        systemBars.bottom
                    )
                    insets
                }
                class QuestionActivity : AppCompatActivity() {

                    private val questions = arrayOf(
                        "Drinking 8 glasses of water daily is necessary for everyone",
                        "Placing your phone in rice fixes water damage",
                        "Cold showers improve circulation",
                        "Cracking knuckles causes arthritis",
                        "Eating carrots improves night vision"
                    )

                    private val answers = arrayOf(
                        false,
                        false,
                        true,
                        false,
                        true
                    )

                    private var currentIndex = 0
                    private var score = 0
                    private var answered = false

                    override fun onCreate(savedInstanceState: Bundle?) {
                        super.onCreate(savedInstanceState)
                        setContentView(R.layout.activity_question)

                        val tvQuestionNumber = findViewById<TextView>(R.id.tvQuestionNumber)
                        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
                        val tvQuestion = findViewById<TextView>(R.id.tvQuestion)
                        val btnHack = findViewById<Button>(R.id.btnHack)
                        val btnMyth = findViewById<Button>(R.id.btnMyth)
                        val tvFeedback = findViewById<TextView>(R.id.tvFeedback)
                        val btnNext = findViewById<Button>(R.id.btnNext)

                        progressBar.max = questions.size

                        fun loadQuestion() {
                            tvQuestion.text = questions[currentIndex]
                            tvQuestionNumber.text =
                                "Question ${currentIndex + 1} of ${questions.size}"
                            progressBar.progress = currentIndex + 1
                            tvFeedback.text = ""
                            answered = false
                        }

                        loadQuestion()

                        btnHack.setOnClickListener {
                            if (!answered) {
                                if (answers[currentIndex]) {
                                    tvFeedback.text = "Correct!"
                                    score++
                                } else {
                                    tvFeedback.text = "Wrong!"
                                }
                                answered = true
                            }
                        }

                        btnMyth.setOnClickListener {
                            if (!answered) {
                                if (!answers[currentIndex]) {
                                    tvFeedback.text = "Correct!"
                                    score++
                                } else {
                                    tvFeedback.text = "Wrong!"
                                }
                                answered = true
                            }
                        }

                        btnNext.setOnClickListener {
                            if (!answered) {
                                Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT)
                                    .show()
                                return@setOnClickListener
                            }

                            currentIndex++

                            if (currentIndex < questions.size) {
                                loadQuestion()
                            } else {
                                val intent = Intent(this, ScoreActivity::class.java)
                                intent.putExtra("score", score)
                                intent.putExtra("total", questions.size)
                                startActivity(intent)
                                finish()
                            }
                        }
                    }
                }
            }

        }
    }
}