package com.mikoiot.apps.access.model

import com.google.gson.annotations.SerializedName

class APIPersonData {
    @SerializedName("login")
    var login: String? = null

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("node_id")
    var node_id: String? = null

    @SerializedName("avatar_url")
    var avatar_url: String? = null

    @SerializedName("gravatar_id")
    var gravatar_id: String? = null

    @SerializedName("url")
    var url: String? = null

    @SerializedName("html_url")
    var html_url: String? = null

    @SerializedName("followers_url")
    var followers_url: String? = null

    @SerializedName("following_url")
    var following_url: String? = null

    @SerializedName("gists_url")
    var gists_url: String? = null

    @SerializedName("starred_url")
    var starred_url: String? = null

    @SerializedName("subscriptions_url")
    var subscriptions_url: String? = null

    @SerializedName("organizations_url")
    var organizations_url: String? = null

    @SerializedName("repos_url")
    var repos_url: String? = null

    @SerializedName("events_url")
    var events_url: String? = null

    @SerializedName("received_events_url")
    var received_events_url: String? = null

    @SerializedName("type")
    var type: String? = null

    @SerializedName("site_admin")
    var site_admin: Boolean = false

    @SerializedName("name")
    var name: String? = null

    @SerializedName("company")
    var company: String? = null

    @SerializedName("blog")
    var blog: String? = null

    @SerializedName("location")
    var location: String? = null

    @SerializedName("email")
    var email: String? = null

    @SerializedName("hireable")
    var hireable: String? = null

    @SerializedName("bio")
    var bio: String? = null

    @SerializedName("public_repos")
    var public_repos: String? = null

    @SerializedName("public_gists")
    var public_gists: String? = null

    @SerializedName("followers")
    var followers: String? = null

    @SerializedName("following")
    var following: String? = null

    @SerializedName("created_at")
    var created_at: String? = null

    @SerializedName("updated_at")
    var updated_at: String? = null
}