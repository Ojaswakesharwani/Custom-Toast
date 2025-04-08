@file:Suppress("DEPRECATION")

package com.example.customtoast

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


object showCustomToast {
    fun show(context: Context, message: String, isSuccess: Boolean = true) {
        val inflater = LayoutInflater.from(context)
        val layout: View = inflater.inflate(R.layout.custom_toast, null)

        val toastText = layout.findViewById<TextView>(R.id.toast_text)
        val toastIcon = layout.findViewById<ImageView>(R.id.toast_icon)

        toastText.text = message
        if (isSuccess) {
            toastIcon.setImageResource(R.drawable.baseline_3d_rotation_24)

            //Todo : Optional: enable custom background
            //layout.setBackgroundResource(R.drawable.toast_bg)

        } else {
            toastIcon.setImageResource(R.drawable.baseline_3d_rotation_24)

            //Todo : Optional: enable error background
           // layout.setBackgroundResource(R.drawable.toast_bg_error)
        }

        // ✅ Apply 360° rotation animation
        val rotateAnim = AnimationUtils.loadAnimation(context, R.anim.rotate_360)
        toastIcon.startAnimation(rotateAnim)

        val toast = Toast(context.applicationContext)
        toast.view = layout
        toast.duration = Toast.LENGTH_SHORT
        toast.show()
    }
}
