package com.example.socialcompose.ui.utils

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent

object ContactUtils {// contains fun sendMail


    fun Context.sendMail(to: String, subject: String) { //extension function of context class
        try {
            val intent = Intent(Intent.ACTION_SEND) //creating a email intent
            intent.type = "vnd.android.cursor.item/email"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(to))
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            startActivity(intent)  //we are starting the email activity
        } catch (e: ActivityNotFoundException) {
        } catch (t: Throwable) {
        }
    }
}