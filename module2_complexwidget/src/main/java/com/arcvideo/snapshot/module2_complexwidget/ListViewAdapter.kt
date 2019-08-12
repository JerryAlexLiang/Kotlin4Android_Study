package com.arcvideo.snapshot.module2_complexwidget

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

/**
 * 创建日期：2019/8/12 on 14:36
 * 描述: Kotlin-ListView-适配器
 * 作者: liangyang
 */
class ListViewAdapter(dataList: List<String>, mContext: Context) : BaseAdapter() {

    //1、Kotlin中类的构造函数可以直接写在类名的后面
    //2、Kotlin中继承extends的使用  :
    //3、初始化可以放在init中进行

    var dataList: List<String>? = null
    var mContext: Context
    var myViewHolder: MyViewHolder? = null

    init {
        this.dataList = dataList
        this.mContext = mContext
    }

    //5、方法名像JavaScript一样使用  fun 方法名() : 返回类型{}
    override fun getItem(position: Int): Any {
        return dataList!![position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dataList?.size ?: 0
    }

    /**
     * 6、使用Kotlin时，不能直接使用convertView，因为在Kotlin中val对象是只可读的
     */
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //定义一个局部对象来使用val类型的convertView
        var mConvertView = convertView
        if (convertView == null) {
            mConvertView = LayoutInflater.from(mContext).inflate(R.layout.item_lv_adapter, null);
            myViewHolder = MyViewHolder(mConvertView)
            //Java中 convertView.setTag(mViewHolder);
            mConvertView!!.tag = myViewHolder
        } else {
            //Java中 mViewHolder = (ViewHolder) convertView.getTag();
            myViewHolder = convertView.tag as MyViewHolder?
        }
        //数据映射
        myViewHolder!!.mContentTv!!.text = dataList!![position]

        return mConvertView!!
    }

    /**
     * 4、内部函数前可加inner关键字，标明内部函数
     */
    inner class MyViewHolder(view: View) {
        var mContentTv: TextView? = null

        init {
            mContentTv = view.findViewById(R.id.tv_content)
        }

    }
}