package com.example.plantixtest.view.adapter

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.plantixtest.R
import com.example.plantixtest.models.DataModel

open class DataListAdapter() : RecyclerView.Adapter<DataListAdapter.ViewHolder>(){
    lateinit var mDataList :List<DataModel>

    constructor(pDataList :List<DataModel>) : this() {
        this.mDataList = pDataList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = mDataList[position]
        holder.textView.text = ItemsViewModel.getTitleCaseText()
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }

}