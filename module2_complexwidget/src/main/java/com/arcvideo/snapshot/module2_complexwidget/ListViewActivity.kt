package com.arcvideo.snapshot.module2_complexwidget

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_list_view.*
import org.jetbrains.anko.toast
import java.util.*

/**
 * 创建日期：2019/8/12 on 15:11
 * 描述: Kotlin中使用ListView
 * 作者: liangyang
 */
class ListViewActivity : AppCompatActivity() {

    var dataList = ArrayList<String>()
    var adapter: ListViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        title = "ListView"
        //初始化数据源
        initViewData()
        //ListView的点击事件
        listView.setOnItemClickListener { parent, view, position, id ->
            val desc = "点击了第${position + 1}个Item,内容为${dataList[position]}"
            toast(desc)
        }

        //ListView的长按事件
        listView.setOnItemLongClickListener { parent, view, position, id ->
            val desc2 = "长按了第${position + 1}个Item,内容为${dataList[position]}"
            toast(desc2)
            true
        }

    }

    private fun initViewData() {
        for (i in 0..20) {
            dataList.add("Hello " + (i + 1))
        }
        //初始化适配器
        adapter = ListViewAdapter(dataList, this.baseContext)
        listView.adapter = adapter
    }

}
