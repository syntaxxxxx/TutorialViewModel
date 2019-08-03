package com.syntax.tutorialviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.syntax.tutorialviewmodel.model.Result
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    // deklarasi ViewModel
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * communication your activity/fragment with MainViewModel
         * */
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        /**
         * get value from your live data into MainViewModel
         * */
        viewModel.getHitung().observe(this, getHitung) // => asynchronous

        btn_hitung.setOnClickListener {
            hitung(edt_panjang.text.toString().trim(), edt_panjang.text.toString().trim())
        }
    }

    fun hitung(panjang: String, lebar: String) {
        if (panjang.isEmpty() || lebar.isEmpty()) {
            toast("kosong cuy")
        } else {
            viewModel.setHitung(edt_panjang.text.toString().trim(), edt_lebar.text.toString().trim())
        }
    }

    /**
     * SUBSCRIBE
     * call this if you want get your data when function gethitung() to do observe
     * */
    val getHitung = Observer<Result> {
        it.let {
            tv_result.text = it?.result
        }
    }
}
