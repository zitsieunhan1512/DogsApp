package com.example.listviewadvancedapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(var context: Context, var arrayfood: ArrayList<Food>) : BaseAdapter() {
    class ViewHolder(row: View) {
        var textviewfoodname: TextView
        var imageviewfood: ImageView

        init {
            textviewfoodname = row.findViewById(R.id.textviewfoodname) as TextView
            imageviewfood = row.findViewById(R.id.imageviewfood) as ImageView
        }
    }

    override fun getCount(): Int {
        return arrayfood.size
    }

    override fun getItem(p0: Int): Any {
        return arrayfood.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view: View?
        var viewholder : ViewHolder
        if (p1==null){
            var layoutinflater : LayoutInflater = LayoutInflater.from(context)
            view = layoutinflater.inflate(R.layout.line_food, null)
            viewholder = ViewHolder(view)
            view.tag = viewholder
        }else{
            view=p1
            viewholder = p1.tag as ViewHolder
        }
        var food : Food = getItem(p0) as Food
        viewholder.textviewfoodname.text=food.name
        viewholder.imageviewfood.setImageResource(food.image)
        return view as View
    }
}