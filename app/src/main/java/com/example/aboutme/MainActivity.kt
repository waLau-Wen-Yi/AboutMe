package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnDone : Button = findViewById(R.id.btn_done)
        var tfNickname : TextView = findViewById(R.id.tf_nickname)
        var tvNickname : TextView = findViewById(R.id.tv_nickname)
        var title : TextView = findViewById(R.id.aboutme_title)

        btnDone.setOnClickListener {
            var nickname : String = tfNickname.text.toString()
            tvNickname.text = "Hello, $nickname"

            btnDone.visibility = View.GONE
            tfNickname.visibility = View.GONE
            title.visibility = View.GONE
            tvNickname.visibility = View.VISIBLE

            // Hide the keyboard.
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
        }

        tvNickname.setOnClickListener {
            btnDone.visibility = View.VISIBLE
            tfNickname.visibility = View.VISIBLE
            title.visibility = View.VISIBLE
            tvNickname.visibility = View.GONE

            // Set the focus to the edit text.
            tfNickname.requestFocus()
            // Show the keyboard.
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(tfNickname, 0)
        }
    }
}