package com.example.recyclerviewpractice

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<RecyclerItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        // 아이템 추가.
        addItem(getDrawable(R.drawable.ic_account_box_black_36dp)!!,
            "Box", "Account Box Black 36dp")
        // 두 번째 아이템 추가.
        addItem(getDrawable(R.drawable.ic_account_circle_black_36dp)!!,
            "Circle", "Account Circle Black 36dp")
        // 세 번째 아이템 추가.
        addItem(getDrawable(R.drawable.ic_assignment_ind_black_36dp)!!,
            "Ind", "Assignment Ind Black 36dp")

        val recyclerView = findViewById<RecyclerView>(R.id.recycler1)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = RecyclerImageTextAdapter(list)

    }

    private fun addItem(icon: Drawable, title: String, desc: String){
        val item = RecyclerItem().apply{
            iconDrawable = icon
            titleStr = title
            descStr = desc
        }
        list.add(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
