package com.kwoneuntae.resetapple

import android.content.Intent
import android.graphics.Color
import android.icu.text.Transliterator.Position
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.SeekBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var colorString:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        var li=ArrayList<DataforList>()
        li.add(DataforList("#FF0000","안녕","반가워"))
        var et1=findViewById<EditText>(R.id.nomalEditText1)
        var et2=findViewById<EditText>(R.id.nomalEditText2)
        var sb1=findViewById<SeekBar>(R.id.nomalSeekBar1)
        var sb2=findViewById<SeekBar>(R.id.nomalSeekBar2)
        var sb3=findViewById<SeekBar>(R.id.nomalSeekBar3)
        var btn=findViewById<Button>(R.id.nomalbutton)
        var v=findViewById<View>(R.id.nomalcolor)


        var seekbarlistener=object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                var red=String.format("%02X",sb1.progress)
                var green=String.format("%02X",sb2.progress)
                var blue=String.format("%02X",sb3.progress)
                colorString="#${red}${green}${blue}"
                v.setBackgroundColor(Color.parseColor(colorString))
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        }
        sb1.setOnSeekBarChangeListener(seekbarlistener)
        sb2.setOnSeekBarChangeListener(seekbarlistener)
        sb3.setOnSeekBarChangeListener(seekbarlistener)

        var listview=findViewById<ListView>(R.id.Listview1)
        listview.adapter=apple(li,this)
        listview.setOnItemClickListener{adapterView,view,position,id->
            val listdata=adapterView?.getItemAtPosition((position)) as DataforList
            Toast.makeText(this,listdata.text1,Toast.LENGTH_SHORT).show()
            AlertDialog.Builder(this).setTitle("${position+1}번째 항목을 지우시겠습니까?")
                .setMessage("${listdata.text1}를 지울까요?").setIcon(R.mipmap.ic_launcher_round)
                .setPositiveButton("네"){dialogInterface, i ->
                    li.removeAt(position)
                    (listview.adapter as apple).notifyDataSetChanged()
                }.setNegativeButton("아니요",null).show()
        }
        btn.setOnClickListener{
            li.add(DataforList(colorString,et1.text.toString(),et2.text.toString()))
            (listview.adapter as apple).notifyDataSetChanged()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var nextbtn=findViewById<Button>(R.id.nextbutton)
        nextbtn.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }



    }
}