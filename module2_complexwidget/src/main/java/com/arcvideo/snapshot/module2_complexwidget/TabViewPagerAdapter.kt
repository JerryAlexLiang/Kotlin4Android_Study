package com.arcvideo.snapshot.module2_complexwidget

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * 创建日期：2019/8/12 on 19:17
 * 描述: TabLayout + ViewPager + Fragment 适配器
 * 作者: liangyang
 */
class TabViewPagerAdapter(var fragmentList: ArrayList<Fragment>?, var titleList: ArrayList<String>?,
                          fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    /**
     * 获取每个页面的碎片对象
     */
    override fun getItem(position: Int): Fragment? {
        return fragmentList?.get(position)
    }

    /**
     * 获取页面的数量
     */
    override fun getCount(): Int {
        return fragmentList?.size ?: 0
    }

    /**
     *  获取页面的标题
     */
    override fun getPageTitle(position: Int): CharSequence? {
        return titleList?.get(position)
    }
}