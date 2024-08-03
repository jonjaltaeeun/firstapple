package com.kwoneuntae.resetapple

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var txt:TextView=findViewById(R.id.resetTextview)
        var texting:EditText=findViewById(R.id.resetEdit)
        var resetbtn=findViewById<Button>(R.id.resetButton)
        resetbtn.setOnClickListener{
            var str:String=texting.text.toString()
            if (str == "epca"){
                var intent: Intent = Intent(this,MainActivity4::class.java)
                startActivity(intent)
            }
            txt.setText(str)
        }
    }
}