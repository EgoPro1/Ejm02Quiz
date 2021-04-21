package com.example.ejm02

class AnswerClass (var questionide:Int,var optiona:Int ,var optionb:Int,var optionc:Int,var optiond:Int,var answeride:Int){
    var optionA:Int = 0
    var optionB:Int = 0
    var optionC:Int = 0
    var optionD:Int = 0
    var questionid:Int = 0
    var answerId:Int = 0

    init {
        questionid=questionide
        optionA=optiona
        optionB=optionb
        optionC=optionc
        optionD=optiond
        answerId=answeride
    }

    fun getquestionid():Int{
        return questionid
    }
    fun getoptionA():Int{
        return optionA
    }

    fun getoptionB():Int{
        return optionB
    }
    fun getoptionC():Int{
        return optionC
    }
    fun getoptionD():Int{
        return optionD
    }
    fun getanswerid():Int{
        return answerId
    }



}