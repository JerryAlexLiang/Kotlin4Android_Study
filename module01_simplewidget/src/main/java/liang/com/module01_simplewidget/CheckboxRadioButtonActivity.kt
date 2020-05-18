package liang.com.module01_simplewidget

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_checkbox_radiobutton.*
import org.jetbrains.anko.toast

/**
 * 创建日期：2019/5/7 on 20:08
 * 描述: Kotlin - 复选框Checkbox
 * 作者: liangyang
 */
class CheckboxRadioButtonActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkbox_radiobutton)

        title = "单选按钮与复选框"

//        //设置默认是未选中的状态
//        checkBox.isChecked = false

//        checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
//            toast("${if (isChecked) "勾选" else "取消勾选"}了复选框")
//
//            tv_checked.text = "${if (isChecked) "勾选" else "取消勾选"}了复选框"
//        }

        checkBox.setOnCheckedChangeListener { _, isChecked ->
            toast("${if (isChecked) "勾选" else "取消勾选"}了复选框")

            tv_checked.text = "${if (isChecked) "勾选" else "取消勾选"}了复选框"
        }

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radioButtonOne -> {
                    tvRadioSelected.text = "我最喜欢的明星是: ${radioButtonOne.text}"
                    toast("我最喜欢的明星是: ${radioButtonOne.text}")
                }
                R.id.radioButtonTwo -> {
                    tvRadioSelected.text = "我最喜欢的明星是: ${radioButtonTwo.text}"
                    toast("我最喜欢的明星是: ${radioButtonTwo.text}")
                }
                R.id.radioButtonThree -> {
                    tvRadioSelected.text = "我最喜欢的明星是: ${radioButtonThree.text}"
                    toast("我最喜欢的明星是: ${radioButtonThree.text}")
                }
                R.id.radioButtonFour -> {
                    tvRadioSelected.text = "我最喜欢的明星是: ${radioButtonFour.text}"
                    toast("我最喜欢的明星是: ${radioButtonFour.text}")
                }
                else -> {
                }
            }
        }
    }
}
