package com.mikoiot.apps.access.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.mikoiot.apps.access.R
import com.mikoiot.apps.access.model.APIUserData
import com.squareup.picasso.Picasso

class UserAdapter(private val mContext: Context, private val userDatas: ArrayList<APIUserData>): BaseAdapter() {

//    private var userDatas = ArrayList<UserData>()
//
//    fun add(userDatas: ArrayList<UserData>) {
//
//        this.userDatas = userDatas
//
//        notifyDataSetChanged()
//    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        val holder: ViewHolder
        val userData = userDatas[position]

//        val view = LayoutInflater.from(mContext).inflate(R.layout.row_user, parent, false)
//
//        val userImg = view.findViewById(R.id.img_user) as ImageView
//        val userName = view.findViewById(R.id.tv_user_name) as TextView
//
//        Picasso.get().load(userData.html_url).into(userImg)
//        userName.text = userData.login

        if (null == convertView) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.row_user, parent,false)
            holder = ViewHolder(convertView)
            convertView?.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }

        Picasso.get().load(userData.avatar_url).into(holder.userImg)
        holder.userLogin.text = userData.login

        return convertView!!
    }

    override fun getItem(position: Int): Any {
        return userDatas[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return userDatas.size
    }

    private class ViewHolder(row: View?){
        val userImg: ImageView = row?.findViewById(R.id.img_user)!!
        val userLogin: TextView = row?.findViewById(R.id.tv_user_login)!!
    }

}