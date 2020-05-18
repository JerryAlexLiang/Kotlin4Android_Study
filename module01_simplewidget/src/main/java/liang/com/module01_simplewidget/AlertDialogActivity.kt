package liang.com.module01_simplewidget

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_alert_dialog.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.toast

class AlertDialogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)

        title = "AlertDialog提醒对话框"

        //使用Kotlin原生的构造者模式
        val builder = AlertDialog.Builder(this)
        builder.setCancelable(false)
        builder.setTitle("提示")
        builder.setMessage("是否退出当前页?")
        builder.setPositiveButton("返回") { dialog, which ->
            toast("返回上一页")
            finish()
        }
        builder.setNegativeButton("取消") { dialog, which ->
            toast("取消")
        }
        val dialog = builder.create()

        btn_one.setOnClickListener { dialog.show() }


        val builder1 = AlertDialog.Builder(this)
        builder1.setCancelable(false)
        val alertDialogView = layoutInflater.inflate(R.layout.custom_alert_dialog_layout, null) as View
        builder1.setView(alertDialogView)
        val dialog1 = builder1.create()

        val btnCancel = alertDialogView.findViewById<View>(R.id.btn_cancel) as TextView
        val btnOk = alertDialogView.findViewById<View>(R.id.btn_ok) as TextView
        val tvTitle = alertDialogView.findViewById<View>(R.id.tv_title) as TextView
        val tvContent = alertDialogView.findViewById<View>(R.id.tv_content) as TextView
        tvTitle.text = "提醒"
        tvContent.text = "是否返回上一页"

        btnCancel.setOnClickListener {
            toast("取消")
            dialog1.dismiss()
        }
        btnOk.setOnClickListener {
            toast("返回上一页 ")
            finish()
        }

        btn_two.setOnClickListener { dialog1.show() }


        //使用Anko库
        btn_three.setOnClickListener {
            alert("是否退出当前页?", "提示") {
                positiveButton("返回") {
                    toast("返回上一页")
                    finish()
                }
                negativeButton("取消") {
                    toast("取消")
                }
            }.show()
        }

        btn_four.setOnClickListener {
            //            alert("是否退出当前页?", "提示"){
//                yesButton { toast("yes") }
//                noButton { toast("no") }
//            }.show()

            alert {
                val alertDialogView = layoutInflater.inflate(R.layout.custom_alert_dialog_layout, null) as View
                customView(alertDialogView)
                val btnCancel = alertDialogView.findViewById<View>(R.id.btn_cancel) as TextView
                val btnOk = alertDialogView.findViewById<View>(R.id.btn_ok) as TextView
                val tvTitle = alertDialogView.findViewById<View>(R.id.tv_title) as TextView
                val tvContent = alertDialogView.findViewById<View>(R.id.tv_content) as TextView

                tvTitle.text = "提醒"
                tvContent.text = "是否返回上一页"

                btnCancel.setOnClickListener {
                    toast("取消")
                    dismiss()
                }
                btnOk.setOnClickListener {
                    toast("返回上一页 ")
                    finish()
                }

                cancellable(false)

            }.show()
        }
    }
}
