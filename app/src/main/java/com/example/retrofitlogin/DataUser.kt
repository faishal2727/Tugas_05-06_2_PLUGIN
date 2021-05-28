package com.example.retrofitlogin


data class DataUser (
    var id : Int,
    var name : String,
    var username : String,
    var email : String,
    var password : String,
    var token : String
)