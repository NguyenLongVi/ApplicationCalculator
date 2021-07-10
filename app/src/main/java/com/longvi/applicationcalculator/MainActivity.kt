package com.longvi.applicationcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var isNewOp = true
    var oldNumber = ""
    var op = "+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun numberEvent(view: View) {
        if (isNewOp)
            editText.setText("")
        isNewOp = false
        var buclick=editText.text.toString()
        var buselect=view as Button
        when(buselect.id){
            btn0.id -> {buclick += "0" }
            btn1.id -> {buclick += "1" }
            btn2.id -> {buclick += "2" }
            btn3.id -> {buclick += "3" }
            btn4.id -> {buclick += "4" }
            btn5.id -> {buclick += "5" }
            btn6.id -> {buclick += "6" }
            btn7.id -> {buclick += "7" }
            btn8.id -> {buclick += "8" }
            btn9.id -> {buclick += "9" }
            btnCham.id -> {buclick += "." }
            btnCongTru.id -> {buclick = "-$buclick"}


        }
        editText.setText(buclick)
    }

    fun operatorEvent(view: View) {
        isNewOp = true
        oldNumber = editText.text.toString()
        var buselect = view as Button
        when (buselect.id){
            btnCong.id -> { op = "+" }
            btnTru.id -> { op = "-" }
            btnNhan.id -> { op = "*" }
            btnChia.id -> { op = "/" }

        }


    }

    fun equalEvelt(view: View) {
        var newNumber= editText.text.toString()
        var result=0.0
        when (op)
        {
            "+" -> {result=oldNumber.toDouble()+ newNumber.toDouble()}
            "-" -> {result=oldNumber.toDouble()- newNumber.toDouble()}
            "*" -> {result=oldNumber.toDouble()* newNumber.toDouble()}
            "/" -> {result=oldNumber.toDouble()/ newNumber.toDouble()}

        }
        editText.setText(result.toString())

    }

    fun CEEvent(view: View) {
        editText.setText("0")
        isNewOp=true
    }
}