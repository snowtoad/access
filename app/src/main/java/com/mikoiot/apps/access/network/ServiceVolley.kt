package com.mikoiot.apps.access.network

import android.content.Context
import android.util.Log
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class ServiceVolley constructor(override val context: Context): ServiceInterface {

    private var requestQueue: RequestQueue? = null

    override fun post(
        path: String,
        completionHandler: (error: Boolean, response: String?) -> Unit
    ) {
        Log.d(TAG, path)

        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context)
        }

        HttpsTrustManager.allowAllSSL()
        val stringRequest = object : StringRequest(
            Method.GET, path,
            Response.Listener<String> { response ->
                requestQueue?.cache?.clear()
                completionHandler(false, response)
            },
            Response.ErrorListener { error ->
                requestQueue?.cache?.clear()
                Log.e(TAG, "錯誤：$error")
                completionHandler(true, error.message)
            }){}

        stringRequest.setShouldCache(false)
        requestQueue?.add(stringRequest)
    }

    companion object {
        private val TAG = ServiceVolley::class.java.simpleName
    }
}