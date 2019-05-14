package liang.com.module01_simplewidget

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import kotlinx.android.synthetic.main.activity_intent.*
import liang.com.module01_simplewidget.bean.StudentBean
import org.jetbrains.anko.toast

class IntentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        //接收配对字段数据
        val bundle = intent.extras
        val name = bundle.getString("request_name")
        val score = bundle.getInt("request_score")

        if (name != null) {
            title = "Intent传递配对字段数据"
            tv_name.text = name
            tv_score.text = score.toString()
        } else {
            tv_name.visibility = View.GONE
            tv_score.visibility = View.GONE
        }


        //接收序列化数据
        val bundle1 = intent.extras
        val studentBean = bundle1.getParcelable<StudentBean>("studentBean")
        if (studentBean != null) {
            title = "Intent传递序列化数据"
            val name1 = studentBean.name
            val score1 = studentBean.score
            if (name1.isNotEmpty() && score1.toString().isNotEmpty()) {
                tv_name_two.text = name1
                tv_score_two.text = score1.toString()
            }
        }

        //处理返回数据
        val bundle2 = intent.extras
        val messageInfo = bundle2.getString("message")
        if (messageInfo != null) {
            title = "Intent传递并处理返回数据"
            tv_receive_message_two.text = "对方说: $messageInfo"
        }

        editContentResult.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                val responseMessage = s.toString()
                tv_send_message_two.text = "我说: $responseMessage"
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        })

        btnSetResult.setOnClickListener {
            var responseMessage = editContentResult.text.toString().trim()
            if (responseMessage.isNotEmpty()) {
                val intent2 = Intent()
                intent2.putExtra("responseMessage", responseMessage)
                //调用setResult方法表示携带应答参数返回到上一个页面
                setResult(Activity.RESULT_OK, intent2)
                //返回上一页
                finish()
            } else {
                toast("请输入内容!")
            }
        }


    }
}
