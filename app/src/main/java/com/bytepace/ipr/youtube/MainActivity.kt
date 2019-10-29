package com.bytepace.ipr.youtube

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, PlayerFragment())
            .commitAllowingStateLoss()
        recyclerView.apply {
            adapter = SimpleAdapter(layoutResId = R.layout.view_item_main)
            layoutManager = LinearLayoutManager(context)
        }
    }
}
