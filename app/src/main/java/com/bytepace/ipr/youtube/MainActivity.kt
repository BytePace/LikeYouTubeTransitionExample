package com.bytepace.ipr.youtube

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.recyclerView
import kotlinx.android.synthetic.main.fragment_player.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.apply {
            adapter = SimpleAdapter(layoutResId = R.layout.view_item_main,
                callback = { replaceVideoFragment(it) })
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onBackPressed() {
        (supportFragmentManager.findFragmentById(R.id.fragmentContainer)).also {
            if (it == null) {
                super.onBackPressed()
                return
            }
            it as PlayerFragment
            if (it.videoMotionLayout.currentState == R.id.expanded)
                it.videoMotionLayout.transitionToStart()
            else
                super.onBackPressed()
        }
    }

    private fun replaceVideoFragment(url: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, PlayerFragment.newInstance(url))
            .commit()
    }
}
