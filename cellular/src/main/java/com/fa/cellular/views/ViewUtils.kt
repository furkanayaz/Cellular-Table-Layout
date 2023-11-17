package com.fa.cellular.views

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.view.MotionEvent
import android.view.View
import android.annotation.SuppressLint

@SuppressLint("ClickableViewAccessibility")
fun View.withAnimation(isAlpha: Boolean = false, isScale: Boolean = false) {
    if (!isAlpha && !isScale) {
        return
    }

    fun startAlphaAnim(vararg values: Float) {
        val alpha: ValueAnimator? = if (isAlpha) ValueAnimator() else null

        alpha?.setFloatValues(values[0], values[1])
        alpha?.addUpdateListener {
            this.alpha = it.animatedValue as Float
        }

        AnimatorSet().apply {
            this.duration = 125L
            this.play(alpha)
            this.start()
        }
    }

    fun startScaleAnim(vararg values: Float) {
        val scaleX: ObjectAnimator =
            ObjectAnimator.ofFloat(this, "scaleX", values[0], values[1])
        val scaleY: ObjectAnimator =
            ObjectAnimator.ofFloat(this, "scaleY", values[0], values[1])

        AnimatorSet().apply {
            this.duration = 125L
            this.playTogether(scaleX, scaleY)
            this.start()
        }
    }

    this.setOnTouchListener { _, motionEvent: MotionEvent ->

        when (motionEvent.action) {
            MotionEvent.ACTION_DOWN -> if (isAlpha && isScale) {
                startAlphaAnim(values = floatArrayOf(1.0F, 0.5F))
                startScaleAnim(values = floatArrayOf(1.0F, 0.98F))
            } else if (isAlpha)
                startAlphaAnim(
                    values = floatArrayOf(
                        1.0F,
                        0.5F
                    )
                )
            else
                startScaleAnim(values = floatArrayOf(1.0F, 0.98F))

            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> if (isAlpha && isScale) {
                startAlphaAnim(values = floatArrayOf(0.5F, 1.0F))
                startScaleAnim(values = floatArrayOf(0.98F, 1.0F))
            } else if (isAlpha)
                startAlphaAnim(
                    values = floatArrayOf(
                        0.5F,
                        1.0F
                    )
                )
            else
                startScaleAnim(values = floatArrayOf(0.98F, 1.0F))
        }

        return@setOnTouchListener false
    }
}