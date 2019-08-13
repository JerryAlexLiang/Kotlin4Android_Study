package com.arcvideo.snapshot.module2_complexwidget


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.util.Log.e as e1


/**
 * 创建日期：2019/8/12 on 19:16
 * 描述: 利用伴生对象定义获取碎片实例的静态方法
 * 作者: liangyang
 */
class TabViewPagerFragment : Fragment() {

    private var fragmentContent: String? = null
    private var fragmentFlag: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_one, container, false)
        //碎片内部通过arguments获取外部的输入参数
        if (arguments != null) {
            fragmentFlag = arguments!!.getInt("fragmentFlag", 0)
            fragmentContent = arguments!!.getString("fragmentContent")

            Log.e("tag", "fragmentFlag: $fragmentFlag  fragmentContent:  $fragmentContent")
        }
        val tvFragmentFlag = view.findViewById<TextView>(R.id.tvFragmentFlag)
        val tvFragmentContent = view.findViewById<TextView>(R.id.tvFragmentContent)
        tvFragmentFlag.text = "" + fragmentFlag
        tvFragmentContent.text = fragmentContent


        return view
    }


    //利用伴生对象定义获取碎片实例的静态方法
    companion object {
        fun newInstance(fragmentFlag: Int, fragmentContent: String): TabViewPagerFragment {
            val fragment = TabViewPagerFragment()
            val bundle = Bundle()
            bundle.putInt("fragmentFlag", fragmentFlag)
            bundle.putString("fragmentContent", fragmentContent)
            //外部通过arguments向碎片传递输入参数
            fragment.arguments = bundle
            return fragment
        }
    }

}
