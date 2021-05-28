package com.example.retrofitlogin

data class ListRespon<T> (
    var msg: String,
    var status : Int,
    var data : List<T>
)
data class SingleRespon<T> (
    var msg: String,
    var status : Int,
    var data : T
)