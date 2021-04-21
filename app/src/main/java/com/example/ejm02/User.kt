package com.example.ejm02

class User{

    var id : Int = 0
    var name : String = ""
    var password : String = ""
    var score : Int =0

    constructor(name: String, password: String){
        this.name = name
        this.password = password
    }
    constructor(id:Int ,name: String, password: String,score:Int){
        this.name = name
        this.password = password
        this.id = id
        this.score=score
    }
    constructor(){
    }

}