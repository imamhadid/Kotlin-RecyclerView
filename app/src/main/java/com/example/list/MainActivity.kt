package com.example.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var items:MutableList<Item> = mutableListOf()

    private fun arrayList() {
        val name = resources.getStringArray(R.array.name_mahasiswa)
        val image = resources.obtainTypedArray(R.array.image)
        items.clear()
        for(i in name.indices) {
            items.add(
                Item(name[i],
            image.getResourceId(i,0))
            )
        }

        image.recycle()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = findViewById<RecyclerView>(R.id.list_mahasiswa)
        arrayList()

        list.layoutManager = LinearLayoutManager(this)
        list.adapter = RecyclerViewAdapter(this, items) {
            val toast = Toast.makeText(applicationContext, it.name, Toast.LENGTH_SHORT)
            toast.show()
        }

    }
}
