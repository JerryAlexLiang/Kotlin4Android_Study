package liang.com.module01_simplewidget

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_checkbox.*
import org.jetbrains.anko.toast

/**
 * 创建日期：2019/5/7 on 20:08
 * 描述: Kotlin - 复选框Checkbox
 * 作者: liangyang
 */
class CheckboxActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkbox)

        //设置默认是未选中的状态
        checkBox.isChecked = false

        checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            toast("${if (isChecked) "勾选" else "取消勾选"}了复选框")

            tv_checked.text = "${if (isChecked) "勾选" else "取消勾选"}了复选框"
        }

        checkBox.setOnCheckedChangeListener { _, isChecked ->
            toast("${if (isChecked) "勾选" else "取消勾选"}了复选框")

            tv_checked.text = "${if (isChecked) "勾选" else "取消勾选"}了复选框"
        }
    }
}
