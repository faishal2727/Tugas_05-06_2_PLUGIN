package com.example.retrofitlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.retrofitlogin.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ButtonLogin()
        SignUp()
    }
    override fun onResume() {
        super.onResume()
        IsLogin()

    }
    private fun SignUp(){
        binding.buttonSignUp.setOnClickListener {
            startActivity(Intent(this,signup::class.java))
            finish()
        }
    }
    private fun ReqLogin(){
        val username = binding.etNama.text.toString()
        val password = binding.etPassword.text.toString()
        APIService.ApiPoint().SignIn(username, password).enqueue(object :
            Callback<SingleRespon<DataUser>> {
            override fun onResponse(call: Call<SingleRespon<DataUser>>, response: Response<SingleRespon<DataUser>>) {
                if(response.isSuccessful){
                    val body = response.body()
                    if(body != null){
                        Constant.SetToken(this@login,body.data.token)
                        Toast.makeText(applicationContext," Hii ${body.data.name}", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@login,MainActivity::class.java))
                        finish()
                    }
                }else{
                    Toast.makeText(applicationContext,"Login Failed",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<SingleRespon<DataUser>>, t: Throwable) {
                println(t.message)
                Toast.makeText(applicationContext, t.message.toString(), Toast.LENGTH_SHORT).show()
            }

        })
    }
    private fun IsLogin(){
        val token = Constant.GetToken(this)
        if(!token.equals("Undefined")){
            startActivity(Intent(this,MainActivity::class.java).also {
                finish()
            })

        }
    }
    private fun ButtonLogin(){
        binding.buttonLogin.setOnClickListener {
            ReqLogin()

        }
    }

}