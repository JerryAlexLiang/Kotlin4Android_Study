package com.arcvideo.snapshot.module2_complexwidget

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import kotlinx.android.synthetic.main.activity_tab_view_pager.*

/**
 * 创建日期：2019/8/12 on 17:38
 * 描述: TabLayout + ViewPager + Fragment
 * 作者: liangyang
 */
class TabViewPagerActivity : AppCompatActivity() {
//class TabViewPagerActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {

//    override fun onPageScrollStateChanged(p0: Int) {
//
//    }
//
//    override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
//
//    }
//
//    override fun onPageSelected(p0: Int) {
//        tabLayout.getTabAt(p0)!!.select()
//    }

    private var titleList = ArrayList<String>()
    private var fragmentList = ArrayList<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_view_pager)

        title = "TabLayout + ViewPager + Fragment"

        //初始化数据源
        initData()

        //TabLayout联动ViewPager
        tabLayout.setupWithViewPager(viewPager)

//        viewPager.addOnPageChangeListener(this)
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(viewPager))
    }

    private fun initData() {
        //tabLayout
        titleList.add("One")
        titleList.add("Two")
        titleList.add("Three")
        titleList.add("Four")
        titleList.add("Five")
        titleList.add("Six")
        titleList.add("Seven")

        //ViewPager
        fragmentList.add(TabViewPagerFragment.newInstance(1, "第一页"))
        fragmentList.add(TabViewPagerFragment.newInstance(2, "第二页"))
        fragmentList.add(TabViewPagerFragment.newInstance(3, "第三页"))
        fragmentList.add(TabViewPagerFragment.newInstance(4, "第四页"))
        fragmentList.add(TabViewPagerFragment.newInstance(5, "第五页"))
        fragmentList.add(TabViewPagerFragment.newInstance(6, "第六页"))
        fragmentList.add(TabViewPagerFragment.newInstance(7, "第七页"))

        //初始化适配器
        val tabViewPagerAdapter = TabViewPagerAdapter(fragmentList, titleList, supportFragmentManager)
        //设置适配器
        viewPager.adapter = tabViewPagerAdapter

        println("ddd: $titleList  $fragmentList")
    }
}
