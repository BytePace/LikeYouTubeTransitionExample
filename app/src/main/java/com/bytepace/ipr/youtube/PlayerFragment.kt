package com.bytepace.ipr.youtube

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_player.*
import kotlinx.android.synthetic.main.fragment_player.recyclerView
import kotlin.math.abs

private const val URL = "url"

class PlayerFragment: Fragment() {

    companion object {
        fun newInstance(url: String): PlayerFragment = PlayerFragment().also { f ->
            f.arguments = Bundle().also { b ->
                b.putString(URL, url)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_player, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments?.containsKey(URL) == true) {
            Picasso.get()
                .load(arguments?.getString(URL))
                .into(videoView)
        }

        recyclerView.apply {
            adapter = SimpleAdapter(layoutResId = R.layout.view_item_player)
            layoutManager = LinearLayoutManager(activity)
        }
        videoMotionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionChange(motionLayout: MotionLayout?, startId: Int, endId: Int, progress: Float) {
                (activity as MainActivity).also {
                    it.mainMotionLayout.progress = abs(progress)
                }
            }

            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
            }

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
            }

            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
            }
        })
        videoMotionLayout.transitionToEnd()
    }
}