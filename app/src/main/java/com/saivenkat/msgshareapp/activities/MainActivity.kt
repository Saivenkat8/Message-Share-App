package com.saivenkat.msgshareapp.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.saivenkat.msgshareapp.Constants
import com.saivenkat.msgshareapp.R
import com.saivenkat.msgshareapp.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        val TAG : String = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowToast.setOnClickListener {
            //code
            Log.i(TAG,"Button was Clicked !")
            showToast(resources.getString(R.string.btn_was_clicked))
        }
        btnSendMessageToNextActivity.setOnClickListener {
            val message : String = etUserMessage.text.toString()


            val intent = Intent (this , SecondActivity:: class.java)

            intent.putExtra(Constants.USER_MSG_KEY, message)

            startActivity(intent)
        }

        btnShareToOtherApps.setOnClickListener {
            val message : String = etUserMessage.text.toString()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT , message)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent,"Please Select an app :"))
        }
        btnRecyclerViewDemo.setOnClickListener {

            val intent = Intent(this , HobbiesActivity::class.java)
            startActivity(intent)
        }

    }
}
