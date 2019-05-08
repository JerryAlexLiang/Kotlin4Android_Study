package liang.com.module01_simplewidget

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

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
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_button -> startActivity(Intent(this, ButtonActivity::class.java))

            R.id.btn_checkbox -> startActivity(Intent(this, CheckboxRadioButtonActivity::class.java))

            else -> ""


        }
    }
}
