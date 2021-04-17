package com.example.ejm02


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var questions: ArrayList<Question>
    lateinit var questions2: ArrayList<Question2>
    var position = 0
    lateinit var aux :ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadQuestions()
        setupViews()
    }

    fun loadQuestions() {
        aux=ArrayList()
        questions = ArrayList()
        questions2 = ArrayList()

        var question = Question("Es Lima capital de Ecuador", false)
        questions.add(question)

        aux.add("Lima")
        aux.add("Caracas")
        aux.add("La Paz")
        aux.add("Montevideo")

        var question2 = Question2("Capital de Perú",aux,0)
        questions2.add(question2)


        question = Question("Es La Paz capital de Bolivia", true)
        questions.add(question)

        aux.add("Lima")
        aux.add("Madrid")
        aux.add("La Paz")
        aux.add("Moscu")
        question2 = Question2("Capital de Bolivia",aux, 2)
        questions2.add(question2)


        question = Question("Es Brasil capital de Ecuador", false)
        questions.add(question)

        aux.add("Lima")
        aux.add("Madrid")
        aux.add("La Paz")
        aux.add("Paris")
        question2 = Question2("Es Paris capital de Francia", aux,3)
        questions2.add(question2)


    }

    fun setupViews() {
        //val btYes = findViewById<Button>(R.id.btYes)

        showSentence()

        btYes.setOnClickListener {
            if (questions[position].answer){
                Toast.makeText(this, "Correcto",Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this, "Incorrecto",Toast.LENGTH_LONG).show()
            }

            position++
            showSentence()
        }

        btNo.setOnClickListener {
            if (!questions[position].answer){
                Toast.makeText(this, "Correcto",Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this, "Incorrecto",Toast.LENGTH_LONG).show()
            }
            position++
            showSentence()
        }


    }

    fun showSentence() {
        tvSentence.text = questions[position].sentence
    }
}
