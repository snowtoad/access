package com.mikoiot.apps.access.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import com.google.gson.Gson
import com.mikoiot.apps.access.R
import com.mikoiot.apps.access.adapter.UserAdapter
import com.mikoiot.apps.access.model.APIUserData
import com.mikoiot.apps.access.resource.APIConstants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserActivity : BaseActivity() {

    private val userDatas = ArrayList<APIUserData>()
    private lateinit var userListView: ListView
    private lateinit var userAdapter: UserAdapter
    private lateinit var callAsync: Call<ArrayList<APIUserData>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        initAll()

        //監聽點選「Github使用者」列表
        userListView.setOnItemClickListener { parent, _, position, _ ->

            val apiUserData = parent.getItemAtPosition(position) as APIUserData

            val intent = Intent(this@UserActivity, DetailActivity::class.java)
            intent.putExtra("EXTRA_LOGIN", apiUserData.login)
            startActivity(intent)

            Log.d(TAG, "已按下")
        }

        //呼叫Service
        callAsync = githubService.getUsers(20,1)

        //Retrofit 呼叫結果
        callAsync.enqueue(object : Callback<ArrayList<APIUserData>> {
            override fun onFailure(call: Call<ArrayList<APIUserData>>, t: Throwable) {
                println(t.message)
            }

            override fun onResponse(
                call: Call<ArrayList<APIUserData>>,
                response: Response<ArrayList<APIUserData>>
            ) {
                val results = response.body()

                userAdapter = UserAdapter(this@UserActivity, results!!)
                userListView.adapter = userAdapter
            }

        })

//        getUsersFromServer()

        Log.d(TAG, "onCreate")
    }

    private fun initAll() {
        //「Github使用者」清單初始化
        userListView = findViewById(R.id.lv_user)
    }

    // API 使用者資料
    private fun getUsersFromServer() {
        val params = HashMap<String,String>()

        service.post(APIConstants.userURL){ error, response ->
            if (error) {
                Toast.makeText(this@UserActivity, R.string.server_error, Toast.LENGTH_SHORT).show()
            } else {
                parseUsersResponse(response.toString())
            }
        }
    }

    //解析回應「使用者」
    private fun parseUsersResponse(response: String) {

        try {
            var userDataObjs = Gson().fromJson(response, APIUserData::class.java) as ArrayList<APIUserData>
            userDataObjs = userDatas

            Log.d(TAG, "[使用者]回傳成功：$response")
        } catch (e: Exception) {
            Log.d(TAG, "[使用者]錯誤：$e")
        }

        Log.d(TAG,"解析「使用者」")
    }

    companion object {
        private val TAG = UserActivity::class.java.simpleName
    }
}
