package liang.com.module01_simplewidget.bean

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * 创建日期：2019/5/9 on 20:28
 * 描述: //@Parcelize注解表示自动实现Parcelize接口的相关方法
 * 作者: liangyang
 */

@Parcelize
data class StudentBean(val name: String, val score: Int) : Parcelable