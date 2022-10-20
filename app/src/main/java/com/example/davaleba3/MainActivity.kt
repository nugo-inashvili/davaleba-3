package com.example.davaleba3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    private lateinit var numberView:TextView
    private lateinit var resultTextView:TextView
    private var operand:Double=0.0
    private var operation:String=""
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numberView=findViewById(R.id.numberText)
        resultTextView=findViewById(R.id.resultText)
    }
    @SuppressLint("SetTextI18n")
    fun numberClick(clickedView: View){
        if(clickedView is Button){
            var myText=numberView.text.toString()
            var buttonNumber=clickedView.text.toString()
            if(myText=="0") myText=""
            var result=myText+buttonNumber
            numberView.text=result
        }
    }
    fun operationClick(clickedView: View){
        if(clickedView is Button){
            val firstOperandText=numberView.text.toString()
            var firstOperand=0.0
            if(firstOperandText.isNotEmpty()){
                operand=firstOperandText.toDouble()
            }
            this.operation=clickedView.text.toString()
            this.numberView.text=""
            if(this.operation=="%") resultTextView.text=(firstOperandText.toDouble()/100).toString()
            if(firstOperandText!="."&&this.operation=="%") numberView.text=firstOperandText+"%"
            if(this.operation=="√") resultTextView.text= sqrt(firstOperandText.toDouble()).toString()
            if(this.operation=="+/-") numberView.text=(firstOperandText.toInt()*(-1)).toString()
        }
    }
    fun equalsClick(clickedView: View){
        val secondOperandText=numberView.text.toString()
        var secOperand=0.0
        if(secondOperandText.isNotEmpty()){
            secOperand=secondOperandText.toDouble()
        }
        when(this.operation){
            "+"->resultTextView.text=(this.operand+secOperand).toString()
            "-"->resultTextView.text=(this.operand-secOperand).toString()
            "*"->resultTextView.text=(this.operand*secOperand).toString()
            "/"->resultTextView.text=(this.operand/secOperand).toString()
        }
    }
    fun clearText(TextView:View){
        numberView.text=""
        resultTextView.text=""
    }
}