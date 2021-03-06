package com.arcvideo.snapshot.module2_complexwidget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "复杂控件"

        btnSpinner.setOnClickListener(this)
        btnListView.setOnClickListener(this)
        btnRecyclerView.setOnClickListener(this)
        btnTabViewPager.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnSpinner -> {
                startActivity<SpinnerActivity>()
            }

            R.id.btnListView -> startActivity<ListViewActivity>()

            R.id.btnRecyclerView -> startActivity<RecyclerViewActivity>()

            R.id.btnTabViewPager -> startActivity<TabViewPagerActivity>()
        }

    }
}
