package com.example.toyotaremote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.view.View

class text_keys_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_keys)

        val bckbtn = findViewById<Button>(R.id.bcktxt)
        bckbtn.setOnClickListener(View.OnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
    }
}
