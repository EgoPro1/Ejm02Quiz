package com.example.ejm02

class User{

    var id : Int = 0
    var name : String = ""
    var password : String = ""

    constructor(name: String, password: String){
        this.name = name
        this.password = password
    }
    constructor(id:Int ,name: String, password: String){
        this.name = name
        this.password = password
        this.id = id
    }
    constructor(){
    }

}