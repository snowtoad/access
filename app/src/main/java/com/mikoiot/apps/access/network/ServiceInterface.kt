package com.mikoiot.apps.access.network

import android.content.Context

interface ServiceInterface {
    val context: Context

    fun post(path: String, completionHandler: (error: Boolean, response: String?) -> Unit)
}