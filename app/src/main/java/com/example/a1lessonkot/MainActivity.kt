package com.example.a1lessonkot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.supportActionBar?.hide()
        btnsInint()


    }

    fun setTextBtn(text: String) {
        if (tv_output.text.isNotEmpty()) {
            tv_input.text = tv_output.text
            tv_output.text = ""
        }
            tv_input.append(text)

    }

    fun btnsInint() {
        btn_zero.setOnClickListener { setTextBtn("0") }
        btn_1.setOnClickListener { setTextBtn("1") }
        btn_2.setOnClickListener { setTextBtn("2") }
        btn_3.setOnClickListener { setTextBtn("3") }
        btn_4.setOnClickListener { setTextBtn("4") }
        btn_5.setOnClickListener { setTextBtn("5") }
        btn_6.setOnClickListener { setTextBtn("6") }
        btn_7.setOnClickListener { setTextBtn("7") }
        btn_8.setOnClickListener { setTextBtn("8") }
        btn_9.setOnClickListener { setTextBtn("9") }
        btn_plus.setOnClickListener {
            if (tv_input.text.toString().isNotEmpty()) {
                setTextBtn("+")
            }
        }
        btn_minus.setOnClickListener {
            if (tv_input.text.toString().isNotEmpty())
                setTextBtn("-")
        }
        btn_division.setOnClickListener {
            if (tv_input.text.toString().isNotEmpty())
                setTextBtn("/")
        }
        btn_multiply.setOnClickListener {
            if (tv_input.text.toString().isNotEmpty())
                setTextBtn("*")
        }
        btn_clear.setOnClickListener {
            tv_input.text = ""
            tv_output.text = ""
        }
        btn_point.setOnClickListener {
            if (tv_input.text.toString().isNotEmpty())
                setTextBtn(".")
        }
        btn_equals.setOnClickListener {
            try {
                var builderEx = ExpressionBuilder(tv_input.text.toString()).build()
                var result = builderEx.evaluate()
                var resultLong = result.toLong()
                if (result == resultLong.toDouble()) {
                    tv_output.text = resultLong.toString()
                } else {
                    tv_output.text = result.toString()
                }
            } catch (e: Exception) {
                tv_output.text = "OSHIBKA"
            }
        }
    }
}