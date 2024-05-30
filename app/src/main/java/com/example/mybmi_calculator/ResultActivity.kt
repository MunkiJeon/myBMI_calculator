package com.example.mybmi_calculator

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow
import kotlin.math.round

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height",0)
        val weight = intent.getIntExtra("weight",0)

        //BMI계산
        var value = weight / (height/ 100.0).pow(2.0)
        value = round(value*10)/10

        var resText = ""
        var resImge = 0
        var resColor = 0

        if (value < 18.5){
            resText ="저체중"
            resImge = R.drawable.img_lv1
            resColor = Color.YELLOW
        } else if (value in 18.5 ..23.0){
            resText ="정상"
            resImge = R.drawable.img_lv2
            resColor = Color.GREEN
        } else if (value in 23.0 ..25.0){
            resText ="과체중"
            resImge = R.drawable.img_lv3
            resColor = Color.DKGRAY
        } else if (value in 25.0 ..30.0){
            resText ="경도 비만"
            resImge = R.drawable.img_lv4
            resColor = Color.CYAN
        } else if (value in 30.5 ..35.0){
            resText ="중도 비만"
            resImge = R.drawable.img_lv5
            resColor = Color.MAGENTA
        } else {
            resText ="고도 비만"
            resImge = R.drawable.img_lv6
            resColor = Color.RED
        }

        var tv_resValue = findViewById<TextView>(R.id.tv_resValue)
        var tv_resText = findViewById<TextView>(R.id.tv_resText)
        var iv_image = findViewById<ImageView>(R.id.iv_image)
        var btn_back = findViewById<Button>(R.id.btn_back)

        tv_resValue.text = value.toString()
        tv_resText.text = resText
        iv_image.setImageResource(resImge)
        tv_resText.setTextColor(resColor)

        btn_back.setOnClickListener{
            finish()
        }
    }
}