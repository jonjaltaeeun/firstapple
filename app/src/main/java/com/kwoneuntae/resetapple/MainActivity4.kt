package com.kwoneuntae.resetapple

import android.content.Intent
import android.os.Bundle
import android.widget.CheckBox
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var etive=findViewById<CheckBox>(R.id.cccc1)
        etive.isChecked = true // 기본값을 체크된 상태로 설정
        var _is=findViewById<CheckBox>(R.id.cccc2)
        _is.isChecked = true // 기본값을 체크된 상태로 설정
        var good=findViewById<CheckBox>(R.id.cccc3)
        good.isChecked = true // 기본값을 체크된 상태로 설정
        var bad=findViewById<CheckBox>(R.id.cccc4)
        bad.isChecked = true // 기본값을 체크된 상태로 설정

        etive.setOnCheckedChangeListener { buttonView, isChecked ->
            var intent: Intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        _is.setOnCheckedChangeListener { buttonView, isChecked ->
            var intent: Intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        good.setOnCheckedChangeListener { buttonView, isChecked ->
            var intent: Intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        bad.setOnCheckedChangeListener { buttonView, isChecked ->
            var intent: Intent = Intent(this,MainActivity5::class.java)
            startActivity(intent)
        }

    }
}