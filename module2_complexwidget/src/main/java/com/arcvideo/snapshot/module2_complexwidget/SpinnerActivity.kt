package com.arcvideo.snapshot.module2_complexwidget

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_spinner.*
import org.jetbrains.anko.selector
import org.jetbrains.anko.toast

/**
 * 创建日期：2019/5/30 on 16:34
 * 描述: Spinner控件
 * 作者: liangyang
 */
class SpinnerActivity : AppCompatActivity() {

    //    private val spinnerArray = arrayOf("丁程鑫", "马嘉祺", "刘耀文", "李天泽", "敖子逸", "贺峻霖", "宋亚轩", "姚景元", "马天宇", "李钟硕", "杨洋", "羽生结玄", "李玹雨")
    private val spinnerArray = listOf("丁程鑫", "马嘉祺", "刘耀文", "李天泽", "敖子逸", "贺峻霖", "宋亚轩", "姚景元", "马天宇", "李钟硕", "杨洋", "羽生结玄", "李玹雨")
    //    private val dataList: ArrayList<String> = ArrayList<String>()
    private lateinit var dialogDataList: ArrayList<String>
    private lateinit var dropdownDataList: ArrayList<String>
    private lateinit var ankoAlertDataList: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)

        title = "Spinner 控件"

        dialogDataList = ArrayList<String>()
        dropdownDataList = ArrayList<String>()
        ankoAlertDataList = ArrayList<String>()

        //Kotlin原生Spinner-Dialog控件写法
        initKotlinSpinnerDialog()

        //Kotlin原生Spinner-Dropdown控件写法
        initKotlinSpinnerDropdown()

        //Anko库 实现Spinner Dialog效果的方法Alert
        initAnkoSpinner()

        btn_submit_one.setOnClickListener {
            if (dialogDataList.isNotEmpty()) {
                toast("你最喜欢的明星是: ${dialogDataList[0]}")
            } else {
                toast("请选择后再提交!")
            }
        }

        btn_submit_two.setOnClickListener {
            if (dropdownDataList.isNotEmpty()) {
                toast("你最喜欢的明星是: ${dropdownDataList[0]}")
            } else {
                toast("请选择后再提交!")
            }
        }

        btn_submit_three.setOnClickListener {
            if (ankoAlertDataList.isNotEmpty()) {
                toast("你最喜欢的明星是: ${ankoAlertDataList[0]}")
            } else {
                toast("请选择后再提交!")
            }
        }
    }


    private fun initAnkoSpinner() {
        tv_spinner_anko.text = "点击选择"
        tv_spinner_anko.setOnClickListener {
            selector("你喜欢的明星是?", spinnerArray) { position ->
                tv_spinner_anko.text = spinnerArray[position]
                toast("你选择的明星是: ${spinnerArray[position]}")
                ankoAlertDataList.clear()
                ankoAlertDataList.add(spinnerArray[position])

                if (ankoAlertDataList.isNotEmpty()) {
                    Log.e("TAG", "AnkoSpinner  选中的明星:  " + ankoAlertDataList[0])
                }
            }
        }

    }

    private fun initKotlinSpinnerDropdown() {
        //数组适配器
        val spinnerAdapter = ArrayAdapter(this, R.layout.item_select, spinnerArray)
        spinnerAdapter.setDropDownViewResource(R.layout.item_dropdown)
        //Android8.0之后findViewById方法要求后面要加上<View>才能进行类型转换操作
//        val spinnerKotlin = findViewById<View>(R.id.sp_kotlin)
        //prompt属性只有在dialog状态才有用
        sp_dropdown_kotlin.prompt = "你喜欢的明星是?"
        sp_dropdown_kotlin.setSelection(0)
        sp_dropdown_kotlin.adapter = spinnerAdapter
        sp_dropdown_kotlin.onItemSelectedListener = SpinnerDropdownKotlinSelectedListener()

    }

    private fun initKotlinSpinnerDialog() {
        //数组适配器
        val spinnerAdapter = ArrayAdapter(this, R.layout.item_select, spinnerArray)
        spinnerAdapter.setDropDownViewResource(R.layout.item_dropdown)
        //Android8.0之后findViewById方法要求后面要加上<View>才能进行类型转换操作
//        val spinnerKotlin = findViewById<View>(R.id.sp_kotlin)
        //prompt属性只有在dialog状态才有用
        sp_dialog_kotlin.prompt = "你喜欢的明星是?"
        sp_dialog_kotlin.setSelection(0)
        sp_dialog_kotlin.adapter = spinnerAdapter
        sp_dialog_kotlin.onItemSelectedListener = SpinnerDialogKotlinSelectedListener()


    }

    internal inner class SpinnerDialogKotlinSelectedListener : AdapterView.OnItemSelectedListener {

        override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            toast("你选择的明星是: ${spinnerArray[position]}")
            dialogDataList.clear()
            dialogDataList.add(spinnerArray[position])

            if (dialogDataList.isNotEmpty()) {
                Log.e("TAG", "KotlinDialogSpinner  选中的明星:  " + dialogDataList[0])
            }
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
        }

    }

    internal inner class SpinnerDropdownKotlinSelectedListener : AdapterView.OnItemSelectedListener {

        override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            toast("你选择的明星是: ${spinnerArray[position]}")
            dropdownDataList.clear()
            dropdownDataList.add(spinnerArray[position])

            if (dropdownDataList.isNotEmpty()) {
                Log.e("TAG", "KotlinDropdownSpinner  选中的明星:  " + dropdownDataList[0])
            }
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
        }

    }
}
