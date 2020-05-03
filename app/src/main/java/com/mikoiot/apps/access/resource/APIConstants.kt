package com.mikoiot.apps.access.resource

object APIConstants {

    var userURL = ""
        get() {
            field = "https://api.github.com/users"
            return field
        }

    object HTTPHeaderField {
        const val authorization = "Authorization"
        const val contentType = "Content-Type"
        const val acceptType = "Accept"
        const val acceptEncoding = "Accept-Encoding"
    }

    object ContentType {
        const val json = "application/json"
        const val x_www_form_urlencoded = "application/x-www-form-urlencoded"
    }
}