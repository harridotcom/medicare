package com.medicare.logging

import android.util.Log

object Mcrlogger
{
    fun logWithTag(tag: String, message: String)
    {
        if(isLoggingAllowed)
        {
            Log.i(tag, message)
        }
    }

    fun logMsg(message: String)
    {
        if(isLoggingAllowed)
        {
            Log.i(TAG, message)
        }
    }

    private var isLoggingAllowed = true
    private const val TAG = "Shreekant :"
}