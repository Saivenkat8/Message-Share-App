package com.saivenkat.msgshareapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.saivenkat.msgshareapp.Constants
import com.saivenkat.msgshareapp.R
import com.saivenkat.msgshareapp.showToast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle : Bundle? = intent.extras
        bundle?.let{
            val msg = bundle.getString(Constants.USER_MSG_KEY)
            showToast("Hi $msg")
            txvUserMessage.text = msg
        }
    }
}