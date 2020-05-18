package com.arcvideo.snapshot.module2_complexwidget

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * 创建日期：2019/8/12 on 15:46
 * 描述: Kotlin - RecyclerView - 适配器
 * 作者: liangyang   RecyclerView.Adapter<KotlinRecycleAdapter.MyHolder>
 */
class RecyclerViewAdapter : androidx.recyclerview.widget.RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private var dataList: ArrayList<String>? = null
    private var mContext: Context? = null

    private var itemClickListener: IKotlinItemClickListener? = null

    //自定义接口
    interface IKotlinItemClickListener {
        fun onItemClickListener(position: Int)

        fun onItemLongClickListener(position: Int): Boolean
    }

    constructor(dataList: ArrayList<String>?, mContext: Context?) : super() {
        this.dataList = dataList
        this.mContext = mContext
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.item_rv_adapter, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList?.size ?: 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.mContextTv.text = dataList!![position]

        //点击事件
        holder.itemView.setOnClickListener {
            itemClickListener!!.onItemClickListener(position)
        }

        holder.itemView.setOnLongClickListener {
            itemClickListener!!.onItemLongClickListener(position)
        }

    }

    inner class MyViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        var mContextTv: TextView = itemView.findViewById(R.id.tv_content)
    }

    //对外提供set方法
    fun setOnKotlinItemClickListener(itemClickListener: IKotlinItemClickListener) {
        this.itemClickListener = itemClickListener
    }
}