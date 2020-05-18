package liang.com.module01_simplewidget

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.format.DateUtils
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import liang.com.module01_simplewidget.bean.StudentBean
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.startActivityForResult
import org.jetbrains.anko.toast
import java.sql.Date
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toast("Kotlin 4 Android")

//        btn_button.setOnClickListener { startActivity(Intent(this, ButtonActivity::class.java)) }
//
//        btn_checkbox.setOnClickListener { startActivity(Intent(this, CheckboxRadioButtonActivity::class.java)) }

        btn_button.setOnClickListener(this)
        btn_checkbox.setOnClickListener(this)
        btnIntentActivity.setOnClickListener(this)
        btnParcelableActivity.setOnClickListener(this)
        btnStartActivityForResult.setOnClickListener(this)
        btnAlertDialog.setOnClickListener(this)

        editContent.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                val edContent = s.toString()
                tv_send_message.text = "我说: $edContent"
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        })
    }

    override fun onClick(v: View) {
        when (v.id) {
//            R.id.btn_button -> startActivity(Intent(this, ButtonActivity::class.java))
            R.id.btn_button -> startActivity<ButtonActivity>()

//            R.id.btn_checkbox -> startActivity(Intent(this, CheckboxRadioButtonActivity::class.java))
            R.id.btn_checkbox -> startActivity<CheckboxRadioButtonActivity>()

            //传送配对字段数据-跳转Activity
            R.id.btnIntentActivity -> startActivity<IntentActivity>(Pair("request_name", "丁程鑫"), Pair("request_score", 100))

            //传送序列化数据
            R.id.btnParcelableActivity -> {
                val studentBean = StudentBean("刘耀文", 90)
//                startActivity<IntentActivity>(Pair("studentBean", studentBean))

                val intent = intentFor<IntentActivity>(Pair("studentBean", studentBean))
                startActivity(intent)
            }

            //数据跳转回传
            R.id.btnStartActivityForResult -> {
                var editMessage = editContent.text.toString().trim()
                if (editMessage.isNotEmpty()) {
                    startActivityForResult<IntentActivity>(0, Pair("message", editMessage))
                } else {
                    toast("请输入对话信息!")
                }
            }

            R.id.btnAlertDialog -> startActivity<AlertDialogActivity>()

            else -> ""

        }
    }

    /**
     * 从下一页面返回到本页面时回调onActivityResult方法，处理返回数据
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 0) {
                if (data != null) {
                    //获取到下一个页面的返回参数(应答参数)
                    val responseMessage = data.extras.getString("responseMessage")
                    tv_receive_message.text = "对方说: $responseMessage"
                }
            }
        }
    }
}
