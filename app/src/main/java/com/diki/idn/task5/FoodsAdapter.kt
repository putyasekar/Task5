package com.diki.idn.task5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class FoodsAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var foods = arrayListOf<Model>()
    override fun getView(p0: Int, p1: View?, p2: ViewGroup): View {
        var view = p1
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list, p2, false)
        }
        val viewHolder = ViewHolder(view as View)
        val food = getItem(p0) as Model
        viewHolder.bind(food)

        return view
    }

    override fun getItem(p0: Int): Any {
        return foods[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int = foods.size

    private inner class ViewHolder internal constructor(view: View) {
        private val tvTitle: TextView = view.findViewById(R.id.tv_title)
        private val tvDesc: TextView = view.findViewById(R.id.tv_desc)
        private val tvDate: TextView = view.findViewById(R.id.tv_date)
        private val tvType: TextView = view.findViewById(R.id.tv_type)
        private val tvPlace: TextView = view.findViewById(R.id.tv_place)
        private val imageView: ImageView = view.findViewById(R.id.image_food)

        internal fun bind(food: Model) {
            tvTitle.setText(food.title)
            tvDesc.text = food.desc
            tvDate.setText(food.date)
            tvType.text = food.type
            tvPlace.text = food.place

            Glide.with(context).load(food.image).circleCrop().override(120).into(imageView)
        }
    }
}
