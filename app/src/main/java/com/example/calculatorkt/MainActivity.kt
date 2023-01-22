package com.example.calculatorkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import com.example.calculatorkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
     lateinit var bind: ActivityMainBinding
    var hasDot = false
    var firstDigit = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(bind.root)
    }

    fun clickDigit(view: View) {
        val btn_digit = view as AppCompatButton
        bind.tvBoard.append(btn_digit.text)
        firstDigit = true
    }
    fun clickClear(view: View){
        bind.tvBoard.text = ""
        firstDigit = false
        hasDot = false
    }

    fun clickOnDot(view: View){
        if (firstDigit && !hasDot){
            bind.tvBoard.append(".")
            hasDot = true
        }

    }
    fun onOperatorClick(view:View){
        val btn = view as AppCompatButton
        if (firstDigit){
            bind.tvBoard.append(btn.text)

        }


    }
}