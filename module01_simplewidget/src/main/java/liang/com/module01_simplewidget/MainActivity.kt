package liang.com.module01_simplewidget

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toast("Kotlin 4 Android")

        btn_button.setOnClickListener { startActivity(Intent(this, ButtonActivity::class.java)) }

        btn_checkbox.setOnClickListener { startActivity(Intent(this, CheckboxActivity::class.java)) }
    }
}
