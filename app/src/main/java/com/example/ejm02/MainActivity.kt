package com.example.ejm02


import android.content.DialogInterface
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AlertDialog.Builder
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var Questions: ArrayList<AnswerClass>
    var position = 0
    var score=0
    var qn=1
    var currentquestion=0
    var currentOptionA=0
    var currentOptionB=0
    var currentOptionC=0
    var currentOptionD=0



    val PROGRESS_BAR=20
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadQuestions()


        currentquestion=Questions[position].questionid
        tvQuestion.setText(currentquestion)

        currentOptionA=Questions[position].optionA
        tvQA.setText(currentOptionA)

        currentOptionB=Questions[position].optionB
        tvQB.setText(currentOptionB)

        currentOptionC=Questions[position].optionC
        tvQC.setText(currentOptionC)

        currentOptionD=Questions[position].optionD
        tvQD.setText(currentOptionD)


        tvQA.setOnClickListener{
            checkAnswer(currentOptionA,0)


        }
        tvQB.setOnClickListener{
            checkAnswer(currentOptionB,1)


        }

        tvQC.setOnClickListener{
            checkAnswer(currentOptionC,2)


        }

        tvQD.setOnClickListener{
            checkAnswer(currentOptionD,3)


        }

        btSiguiente.setOnClickListener {
            updateQuestion()
        }




        //    setupViews()
    }
    private fun checkAnswer( userSelection: Int, color:Int) {
        var musica = MediaPlayer.create(getApplicationContext(),R.raw.correctding);
        var musica2 = MediaPlayer.create(getApplicationContext(),R.raw.incorrectobocina);

        var correctans=Questions[position].getanswerid()
        tvSelected.setText(userSelection)
        tvCorrect.setText(correctans)
        var selected=tvSelected.text.trim()
        var correct=tvCorrect.text.trim()
        tvSelected.text=""
        tvCorrect.text=""

        if(selected==correct){
            Toast.makeText(this,"Rigth",Toast.LENGTH_SHORT).show()
            musica.start()
            color(color)
            score++
        }else{
            musica2.start()

            Toast.makeText(this,"Wrong",Toast.LENGTH_SHORT).show()
        }



    }

    private fun color(color: Int){
        if(color==0){
            tvQA.setBackgroundResource(R.color.rigth)
            tvQB.setBackgroundResource(R.color.wrong)
            tvQC.setBackgroundResource(R.color.wrong)
            tvQD.setBackgroundResource(R.color.wrong)
        }
        if(color==1){
            tvQB.setBackgroundResource(R.color.rigth)
            tvQA.setBackgroundResource(R.color.wrong)
            tvQC.setBackgroundResource(R.color.wrong)
            tvQD.setBackgroundResource(R.color.wrong)
        }
        if(color==2){
            tvQC.setBackgroundResource(R.color.rigth)
            tvQB.setBackgroundResource(R.color.wrong)
            tvQA.setBackgroundResource(R.color.wrong)
            tvQD.setBackgroundResource(R.color.wrong)
        }
        if(color==3){
            tvQD.setBackgroundResource(R.color.rigth)
            tvQB.setBackgroundResource(R.color.wrong)
            tvQC.setBackgroundResource(R.color.wrong)
            tvQA.setBackgroundResource(R.color.wrong)
        }

    }

    fun updateQuestion() {

        position=(position+1)%Questions.size

        if(position==0){
           val alert= Builder(this)
            alert.setTitle("Game Over");
            alert.setCancelable(false)
            alert.setMessage("Your score: " + score+" points")
            alert.setPositiveButton("Back to login", DialogInterface.OnClickListener{ dialogInterface: DialogInterface, i: Int ->
                var intent= Intent(this,LoginActivity::class.java)
                startActivity(intent)
            })
            alert.setNegativeButton("Try again",DialogInterface.OnClickListener{ dialogInterface: DialogInterface, i: Int ->
                score=0
                qn=1
                Prbar1.setProgress(0)

            })

        }

        currentquestion=Questions[position].questionid
        tvQuestion.setText(currentquestion)

        currentOptionA=Questions[position].optionA
        tvQA.setText(currentOptionA)

        currentOptionB=Questions[position].optionB
        tvQB.setText(currentOptionB)

        currentOptionC=Questions[position].optionC
        tvQC.setText(currentOptionC)

        currentOptionD=Questions[position].optionD
        tvQD.setText(currentOptionD)

        qn++
        if(qn<=Questions.size){
            tvQcount.text= qn.toString()+"/"+Questions.size.toString()+" Question"
        }
        tvScore.text="Score "+score+"/"+Questions.size
        Prbar1.incrementProgressBy(PROGRESS_BAR)

        tvQD.setBackgroundResource(R.color.common)
        tvQB.setBackgroundResource(R.color.common)
        tvQC.setBackgroundResource(R.color.common)
        tvQA.setBackgroundResource(R.color.common)

    }




    fun loadQuestions() {

        Questions= ArrayList()


        var question = AnswerClass(R.string.tvQuestion1,R.string.tvQuestion_1A,R.string.tvQuestion_1B,R.string.tvQuestion_1C,R.string.tvQuestion_1D,R.string.tvAnswer_1)
        Questions.add(question)
        question = AnswerClass(R.string.tvQuestion2,R.string.tvQuestion_2A,R.string.tvQuestion_2B,R.string.tvQuestion_2C,R.string.tvQuestion_2D,R.string.tvAnswer_2)
        Questions.add(question)
        question = AnswerClass(R.string.tvQuestion3,R.string.tvQuestion_3A,R.string.tvQuestion_3B,R.string.tvQuestion_3C,R.string.tvQuestion_3D,R.string.tvAnswer_3)
        Questions.add(question)
        question = AnswerClass(R.string.tvQuestion4,R.string.tvQuestion_4A,R.string.tvQuestion_4B,R.string.tvQuestion_4C,R.string.tvQuestion_4D,R.string.tvAnswer_4)
        Questions.add(question)
        question = AnswerClass(R.string.tvQuestion5,R.string.tvQuestion_5A,R.string.tvQuestion_5B,R.string.tvQuestion_5C,R.string.tvQuestion_5D,R.string.tvAnswer_5)
        Questions.add(question)

    }


}
