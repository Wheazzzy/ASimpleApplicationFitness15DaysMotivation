package com.example.fitnessapplication.Utils

import android.app.AlertDialog
import android.content.Context
import com.example.fitnessapplication.R

object DialogMenu {
    fun showDialog(context: Context, massageId: Int, listener: Listener){
        val builder = AlertDialog.Builder(context)
        var dialog: AlertDialog? = null
        builder.setTitle(R.string.attention)
        builder.setMessage(massageId)
        builder.setPositiveButton(R.string.reset) { _,_ ->
            listener.onClick()
            dialog?.dismiss()
        }
        builder.setPositiveButton(R.string.cancel) { _,_ ->
            dialog?.dismiss()
        }
        dialog = builder.create()
    }

    interface Listener {
        fun onClick()
    }
}
