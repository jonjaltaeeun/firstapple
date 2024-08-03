package com.kwoneuntae.resetapple

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat

data class DataforList(
    val image:String,
    val text1:String,
    val text2:String
)
class apple(val dataList: ArrayList<DataforList>,val context:Context) :BaseAdapter() {
    override fun getCount(): Int {
        return dataList.size
    }

    override fun getItem(p0: Int): Any {
        return dataList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var convertView=p1//현재 바꿀 수 없음
        if (convertView==null){
            convertView=LayoutInflater.from(context).inflate(R.layout.nomallayout,p2,false)
        }else{
            convertView=p1//바꿀 수 있게 바꿈
        }
        var imageview11=convertView!!.findViewById<ImageView>(R.id.imageview11)
        var textview11=convertView.findViewById<TextView>(R.id.textview11)
        var textview12=convertView.findViewById<TextView>(R.id.textview12)
        val drawable: GradientDrawable=ResourcesCompat.getDrawable(context.resources,R.drawable.medal,null)as GradientDrawable
        drawable.setColor(Color.parseColor(dataList[p0].image))
        imageview11.setImageDrawable(drawable)
        textview11.text=dataList[p0].text1
        textview12.text=dataList[p0].text2
        return convertView
    }
}