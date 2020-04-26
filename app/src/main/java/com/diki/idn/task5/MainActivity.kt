package com.diki.idn.task5

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list.*
import java.lang.reflect.Type

class MainActivity : AppCompatActivity() {
    private lateinit var foodsAdapter: FoodsAdapter
    private var models = arrayListOf<Model>()
    private lateinit var title: Array<String>
    private lateinit var description: Array<String>
    private lateinit var date: Array<String>
    private lateinit var place: Array<String>
    private lateinit var type: Array<String>
    private lateinit var image: TypedArray


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        foodsAdapter = FoodsAdapter(this)
        lv_bottomsheet.adapter = foodsAdapter
        attachData()
        loadData()

    }

    private fun loadData() {
        for (p0 in title.indices) {
            val model = Model(
                title[p0],
                description[p0],
                date[p0],
                type[p0],
                place[p0],
                image.getResourceId(p0, -1)
            )
            models.add(model)
        }
        foodsAdapter.foods = models
    }

    private fun attachData() {
        title = resources.getStringArray(R.array.title)
        description = resources.getStringArray(R.array.desc)
        date = resources.getStringArray(R.array.date)
        place = resources.getStringArray(R.array.place)
        type = resources.getStringArray(R.array.type)
        image = resources.obtainTypedArray(R.array.image)
    }
}
