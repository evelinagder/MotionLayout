package com.example.evelinaderventska.motionlayout

import android.os.Bundle
import android.support.constraint.motion.MotionLayout
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.ceil


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        motionLayoutView.setTransitionListener(
                object : MotionLayout.TransitionListener {
                    override fun onTransitionChange(motionLayout: MotionLayout?, startId: Int,
                                                    endId: Int,
                                                    progress: Float) {
                        seekbarMotion.progress = ceil(progress * 100).toInt()
                    }

                    override fun onTransitionCompleted(motionLayout: MotionLayout?,
                                                       currentId: Int) {
                        if (currentId == R.id.ending_set) {
                            // Return to original constraint set
                            motionLayoutView.transitionToStart()
                        }
                    }
                }
        )
    }

    fun start(v: View) {
        motionLayoutView.transitionToEnd()
    }


}
