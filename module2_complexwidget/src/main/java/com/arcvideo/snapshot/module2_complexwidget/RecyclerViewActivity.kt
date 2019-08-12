package com.arcvideo.snapshot.module2_complexwidget

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view.*
import org.jetbrains.anko.toast

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var adapter: RecyclerViewAdapter
    private var dataList: ArrayList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        title = "RecyclerView控件"

        initData()

        initView()

        initListener()
    }

    private fun initListener() {
        adapter.setOnKotlinItemClickListener(object : RecyclerViewAdapter.IKotlinItemClickListener {
            override fun onItemClickListener(position: Int) {
                val desc = "点击了第${position + 1}个Item,内容为${dataList?.get(position)}"
                toast(desc)
            }

            override fun onItemLongClickListener(position: Int): Boolean {
                val desc2 = "长按了第${position + 1}个Item,内容为${dataList?.get(position)}"
                toast(desc2)
                return true
            }
        })

    }

    private fun initView() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        // layoutManager
        recyclerView.layoutManager = layoutManager
        // itemDecoration
        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(itemDecoration)
        // animation
        recyclerView.itemAnimator = DefaultItemAnimator()
        //初始化适配器
        adapter = RecyclerViewAdapter(dataList, this)
        //设置适配器
        recyclerView.adapter = adapter

    }

    private fun initData() {
        dataList = ArrayList()
        for (i in 0..20) {
            dataList!!.add("Hello " + (i + 1))
        }

    }
}
