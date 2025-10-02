package com.atta.notesapp.utils

import android.content.Context
import android.widget.Toast

object Utils {
    const val NOTE="Note"

    fun showToast(context:Context,message:String){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}