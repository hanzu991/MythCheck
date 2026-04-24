package com.example.mythcheck

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        class `ScoreActivity` : AppCompatActivity() {
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                enableEdgeToEdge()
                setContentView(R.layout.activity_score)
                ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                    val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                    insets
                }
                class ScoreActivity : AppCompatActivity() {

                    override fun onCreate(savedInstanceState: Bundle?) {
                        super.onCreate(savedInstanceState)
                        setContentView(R.layout.activity_score)

                        val tvScore = findViewById<TextView>(R.id.tvScore)
                        val tvResultMessage = findViewById<TextView>(R.id.tvResultMessage)
                        val btnReview = findViewById<Button>(R.id.btnReview)
                        val btnHome = findViewById<Button>(R.id.btnHome)

                        val score = intent.getIntExtra("score", 0)
                        val total = intent.getIntExtra("total", 0)

                        tvScore.text = "$score / $total"

                        if (score >= total / 2) {
                            tvResultMessage.text = "Great job!"
                        } else {
                            tvResultMessage.text = "Keep practicing!"
                        }

                        btnReview.setOnClickListener {
                            val intent = Intent(this, QuestionActivity::class.java)
                            startActivity(intent)
                            finish()
                        }

                        btnHome.setOnClickListener {
                            val intent = Intent(this, WelcomeActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
            }
        }
    }
}