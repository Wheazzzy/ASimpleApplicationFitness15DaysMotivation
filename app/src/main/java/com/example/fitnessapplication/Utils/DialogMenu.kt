package com.example.fitnessapplication.Utils

import android.app.AlertDialog
import android.content.Context
import com.example.fitnessapplication.R

class DialogMenu {
    fun showDialog(context: Context, massageId: Int){
        val builder = AlertDialog.Builder(context)
        builder.setTitle(R.string.attention)
        builder.setMessage(massageId)
        builder.setPositiveButton(R.string.reset) { _,_ ->

        }
    }

    interface Listener {
        fun onClick()
    }
}
