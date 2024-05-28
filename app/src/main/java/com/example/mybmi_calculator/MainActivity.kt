package com.example.mybmi_calculator

import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var heightEditText =  findViewById<EditText>(R.id.et_height)
        var weightEditText =  findViewById<EditText>(R.id.et_weight)
        var submitButton = findViewById<Button>(R.id.btn_check)
        var heightTitle = findViewById<TextView>(R.id.heightTitle)
        var weightTitle = findViewById<TextView>(R.id.weightTitle)
        var heightUnit = findViewById<TextView>(R.id.heightUnit)
        var weightUnit = findViewById<TextView>(R.id.weightUnit)

        val nightModeFlags =
            getResources().configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK

        when (nightModeFlags) {
            Configuration.UI_MODE_NIGHT_YES -> {
                heightEditText.setTextColor(Color.WHITE)
                heightEditText.setBackgroundColor(Color.DKGRAY)
                heightTitle.setTextColor(Color.WHITE)
                heightUnit.setTextColor(Color.WHITE)

                weightEditText.setTextColor(Color.WHITE)
                weightEditText.setBackgroundColor(Color.DKGRAY)
                weightTitle.setTextColor(Color.WHITE)
                weightUnit.setTextColor(Color.WHITE)

                submitButton.setTextColor(Color.BLACK)
            } // 다크 모드
            Configuration.UI_MODE_NIGHT_NO -> {
                heightEditText.setTextColor(Color.BLACK)
                weightEditText.setTextColor(Color.BLACK)
                submitButton.setTextColor(Color.WHITE)
            } // 라이트 모드
        }

        submitButton.setOnClickListener {
            if (heightEditText.text.isEmpty()){
                Toast.makeText(this, "신장을 입력해 주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if (heightEditText.text.toString().toInt() !in 80 .. 300){
                heightEditText.text.clear()
                Toast.makeText(this, "80~300cm 사이로 입력해 주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (weightEditText.text.isEmpty()){
                Toast.makeText(this, "체중을 입력해 주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if (weightEditText.text.toString().toInt() !in 40 .. 250){
                weightEditText.text.clear()
                Toast.makeText(this, "40~250kg 사이로 입력해 주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val height : Int = heightEditText.text.toString().toInt()
            val weight : Int = weightEditText.text.toString().toInt()

            val intent = Intent(this,ResultActivity::class.java)
            intent.putExtra("height", height)
            intent.putExtra("weight", weight)
            startActivity(intent)
        }
    }
}