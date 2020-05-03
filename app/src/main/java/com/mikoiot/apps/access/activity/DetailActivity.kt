package com.mikoiot.apps.access.activity

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.mikoiot.apps.access.R
import com.mikoiot.apps.access.model.APIPersonData
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : BaseActivity() {

    private lateinit var callAsync: Call<APIPersonData>
    private lateinit var getLogin: String

    private lateinit var detailClose: ImageButton
    private lateinit var detailUser: ImageView
    private lateinit var detailName: TextView
    private lateinit var detailBio: TextView

    private lateinit var detailLogin: TextView
    private lateinit var detailLocation: TextView
    private lateinit var detailBlog: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initAll()

        getLogin = intent.getStringExtra("EXTRA_LOGIN")!!
        callAsync = githubService.getUser(getLogin)

        //監聽「關閉」按鈕
        detailClose.setOnClickListener {
            this.finish()
        }

        //Retrofit 呼叫結果
        callAsync.enqueue(object : Callback<APIPersonData> {
            override fun onFailure(call: Call<APIPersonData>, t: Throwable) {
                println(t.message)
            }

            override fun onResponse(call: Call<APIPersonData>, response: Response<APIPersonData>) {
                val result = response.body()

                Picasso.get().load(result!!.avatar_url).into(detailUser)
                detailName.text = result.name
                detailBio.text = result.bio

                detailLogin.text = result.login
                detailLocation.text = result.location
                detailBlog.text = result.blog

            }

        })
    }

    //初始化元件
    private fun initAll() {
        detailClose = findViewById(R.id.img_detail_close)
        detailUser = findViewById(R.id.img_detail_user)
        detailName = findViewById(R.id.tv_detail_name)
        detailBio = findViewById(R.id.tv_detail_bio)
        detailLogin = findViewById(R.id.tv_detail_login)
        detailLocation = findViewById(R.id.tv_detail_location)
        detailBlog = findViewById(R.id.tv_detail_blog)
    }

}
