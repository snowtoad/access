package com.mikoiot.apps.access.helper

import com.mikoiot.apps.access.resource.Base
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceGenerator {
    companion object {
        fun build(): Retrofit {
            val builder = Retrofit.Builder()
            builder.baseUrl(Base.GITHUB_BASE_URL)
            builder.addConverterFactory(GsonConverterFactory.create())

            return builder.build()
        }
    }
}