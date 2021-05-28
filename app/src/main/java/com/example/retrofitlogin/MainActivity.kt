package com.example.retrofitlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofitlogin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Keluar()
    }
    private fun Keluar(){
        binding.btnkeluar.setOnClickListener {
            Constant.DeletToken(this)
            startActivity(Intent(this,login::class.java))
            finish()
        }
    }
}