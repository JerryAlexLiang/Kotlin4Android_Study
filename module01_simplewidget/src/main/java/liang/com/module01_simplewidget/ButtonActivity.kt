package liang.com.module01_simplewidget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_button.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast

/**
 * 创建日期：2019/5/7 on 9:33
 * 描述: 使用Kotlin玩转Button控件
 * 作者: liangyang
 */
class ButtonActivity : AppCompatActivity(), View.OnClickListener, View.OnLongClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)

        title = "按钮Button"

        /**
         * 1、Button的匿名函数方式响应事件
         * 下面两个带入参的函数处理代码构成了按钮事件的第一种写法---匿名函数方式(编码最简洁的一种方式)
         * 点击事件的函数代码被 -> 分割成了两部分，v表示发生点击动作的视图入参，后面是处理事件的具体函数代码
         * 注意点：
         * a) 视图View是基本的视图类型，并不存在文本属性，所以需要把这个视图对象的变量类型转换为按钮
         * Button,然后才能得到按钮Button对象的文本，  Kotlin中类型转换通常是用关键字as实现
         * b) 由于待显示的字符串需要拼接按钮文本，因此需要字符串模板表达式 “ ${***} ” 将按钮文本置入该字符串。
         */
        btn_anonymos.setOnClickListener { v ->
            //Kotlin对变量进行类型转换的关键字是as
            toast("点击了控件: ${(v as Button).text}")
        }

        btn_anonymos_long.setOnLongClickListener { v ->
            longToast("长按了控件: ${(v as Button).text}")
            //长按末尾多了返回true
            true
        }

        /**
         * 2、Button的内部类方式响应事件
         * 定义了处理的内部类后，按钮控件在调用setOnClickListener / setOnLongClickListener方法时，即可直接传入对应的内部类的对象实例。
         */
        btn_inner.setOnClickListener(MyInnerClickListener())

        btn_inner_long.setOnLongClickListener(MyInnerLongClickListener())

        /**
         * 3、Button的第三种点击响应方式：Activity接口实现
         */
        btn_interface.setOnClickListener(this)

        btn_interface_long.setOnLongClickListener(this)

    }

    /**
     * 2、Button的内部类方式响应事件
     */
    private inner class MyInnerClickListener : View.OnClickListener {
        override fun onClick(v: View?) {
            toast("点击了控件: ${(v as Button).text}")
        }
    }

    private inner class MyInnerLongClickListener : View.OnLongClickListener {
        override fun onLongClick(v: View?): Boolean {
            longToast("长按了控件: ${(v as Button).text}")
            return true
        }
    }

    /**
     * 3、Button的第三种点击响应方式：Activity接口实现
     */
    override fun onClick(v: View) {
        if (v.id == R.id.btn_interface) {
            toast("点击了控件: ${(v as Button).text}")
        }
    }

    override fun onLongClick(v: View): Boolean {
        if (v.id == R.id.btn_interface_long) {
            longToast("长按了控件: ${(v as Button).text}")
        }
        return true
    }
}
