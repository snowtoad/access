package com.mikoiot.apps.access.helper

import com.mikoiot.apps.access.model.APIPersonData
import com.mikoiot.apps.access.model.APIUserData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {
    @GET("/users")
    fun getUsers(@Query("per_page") perPage: Int, @Query("page") page: Int): Call<ArrayList<APIUserData>>

    @GET("/users/{username}")
    fun getUser(@Path("username") username: String): Call<APIPersonData>
}