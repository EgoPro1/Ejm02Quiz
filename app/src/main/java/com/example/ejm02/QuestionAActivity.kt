package com.example.ejm02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class QuestionAActivity : AppCompatActivity() {

    lateinit var questions2: ArrayList<Question2>
    var position = 0
    lateinit var aux :ArrayList<String>

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_a)


            loadQuestions()
            setupViews()
        }

        fun loadQuestions() {
            aux=ArrayList()

            questions2 = ArrayList()


            aux.add("Lima")
            aux.add("Caracas")
            aux.add("La Paz")
            aux.add("Montevideo")

            var question2 = Question2("Capital de Perú",aux,0)
            questions2.add(question2)

            aux.add("Lima")
            aux.add("Madrid")
            aux.add("La Paz")
            aux.add("Moscu")
            question2 = Question2("Capital de Bolivia",aux, 2)
            questions2.add(question2)

            aux.add("Lima")
            aux.add("Madrid")
            aux.add("La Paz")
            aux.add("Paris")
            question2 = Question2("Es Paris capital de Francia", aux,3)
            questions2.add(question2)


        }

        fun setupViews() {

        }

        fun showSentence() {
        //    tvSentence.text = questions[position].sentence
        }
}
