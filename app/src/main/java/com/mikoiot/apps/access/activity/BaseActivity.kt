package com.mikoiot.apps.access.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.mikoiot.apps.access.helper.GithubService
import com.mikoiot.apps.access.helper.ServiceGenerator
import com.mikoiot.apps.access.network.ServiceVolley

@SuppressLint("Registered")
open class BaseActivity: AppCompatActivity() {

    lateinit var service : ServiceVolley
    lateinit var githubService: GithubService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        service = ServiceVolley(this@BaseActivity)

        // GithubService 初始化
        githubService = ServiceGenerator.build().create(GithubService::class.java)

        Log.d(TAG, "onCreate")
    }

    companion object {
        private val TAG = BaseActivity::class.java.simpleName
    }

}