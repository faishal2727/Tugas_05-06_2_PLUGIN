package com.example.retrofitlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.retrofitlogin.databinding.ActivitySignupBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class signup : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ButtonSignUp()
        ButtonBack()
    }
    private fun Register(){
        val name = binding.etNama1.text.toString()
        val username = binding.etUsername1.text.toString()
        val email = binding.etEmail1.text.toString()
        val password = binding.etPassword1.text.toString()
        APIService.ApiPoint().signUp(name,username,email,password)
            .enqueue(object : Callback<SingleRespon<DataUser>> {
                override fun onResponse(call: Call<SingleRespon<DataUser>>, response: Response<SingleRespon<DataUser>>) {
                    if(response.isSuccessful){
                        val body = response.body()
                        if(body != null){
                            Toast.makeText(applicationContext,body.msg,Toast.LENGTH_SHORT).show()
                        }
                    }else{
                        val errorBody = response.errorBody().toString()
                        val code = response.code()
                        Log.e("xxxxx", errorBody )
                        Toast.makeText(applicationContext,code.toString(),Toast.LENGTH_SHORT).show()
                    }
                }
                override fun onFailure(call: Call<SingleRespon<DataUser>>, t: Throwable) {
                    println(t.message)
                    Toast.makeText(applicationContext,t.message,Toast.LENGTH_SHORT).show()
                }
            })
    }
    private fun ButtonSignUp(){
        binding.buttonSignUp1.setOnClickListener {
            Register()
            startActivity(Intent(this,login::class.java))
            finish()
        }
    }
    private fun ButtonBack(){
        binding.btnBack.setOnClickListener {
            startActivity(Intent(this,login::class.java ))
            finish()
        }
    }
}