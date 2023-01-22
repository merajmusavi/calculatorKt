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
        bind.result.text = ""
    }

    fun clickOnDot(view: View){
        if (firstDigit && !hasDot){
            bind.tvBoard.append(".")
            hasDot = true
        }

    }
    fun onOperatorClick(view:View){
        val btn = view as AppCompatButton
        if (firstDigit && !isOperatorActive(bind.tvBoard.text.toString())){
            bind.tvBoard.append(btn.text)
            firstDigit = false
            hasDot = false
        }



    }

    fun OnEqualCLick(view:View){
        var emp = ""

            var inputValue = bind.tvBoard.text.toString()
             if (inputValue.startsWith("-")){
                 emp = "-"
                 inputValue = inputValue.substring(1);
             }
            if (inputValue.contains("+")){
                val inputArray = inputValue.split("+")
                var num1 = inputArray[0]
                val num2 = inputArray[1]
                if (emp.isNotEmpty()){
                    num1 = emp + num1
                }
                val result = num1.toDouble()+num2.toDouble()
                bind.result.text = result.toString()
                bind.tvBoard.text = result.toString()
            }else if (inputValue.contains("*")){
                val inputArray = inputValue.split("*")
                var num1 = inputArray[0]
                val num2 = inputArray[1]

                if (emp.isNotEmpty()){
                    num1 = emp + num1
                }
                val result = num1.toDouble()*num2.toDouble()
                bind.result.text = result.toString()
                bind.tvBoard.text = result.toString()

            }else if (inputValue.contains("/")){
                val inputArray = inputValue.split("/")
                var num1 = inputArray[0]
                val num2 = inputArray[1]

                if (emp.isNotEmpty()){
                    num1 = emp + num1
                }
                val result = num1.toDouble()/num2.toDouble()
                bind.result.text = result.toString()
                bind.tvBoard.text = result.toString()
            }else if (inputValue.contains("-")){
                val inputArray = inputValue.split("-")
                var num1 = inputArray[0]
                val num2 = inputArray[1]

                if (emp.isNotEmpty()){
                   num1 = emp + num1
                }
                val result = num1.toDouble()-num2.toDouble()
                bind.result.text = result.toString()
                bind.tvBoard.text = result.toString()
            }
        }
    }

    fun isOperatorActive(text:String):Boolean{
        if (text.startsWith("-")){
            return false
        }
        if(text.contains("+") || text.contains("-") || text.contains("/") || text.contains("*")){
            return true
        }else{
            return false
        }
    }
