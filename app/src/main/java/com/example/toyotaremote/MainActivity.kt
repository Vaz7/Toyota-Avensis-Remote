package com.example.toyotaremote

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import com.example.toyotaremote.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val txtbtn = findViewById<Button>(R.id.txt)
        txtbtn.setOnClickListener(View.OnClickListener {

            val intent = Intent(this,text_keys_activity::class.java)
            startActivity(intent)
        })


        binding.map.setOnClickListener(){
          binding.textView.text = "map selected"
        }

        binding.menu.setOnClickListener(){
            binding.textView.text = "menu selected"
        }

        binding.dest.setOnClickListener(){
            binding.textView.text = "dest selected"
        }

        binding.ent.setOnClickListener(){
            binding.textView.text = "ent selected"
        }

        binding.back.setOnClickListener(){
            binding.textView.text = "back selected"
        }

        binding.off.setOnClickListener(){
            binding.textView.text = "off selected"
        }

        binding.info.setOnClickListener(){
            binding.textView.text = "info selected"
        }

        binding.disp.setOnClickListener(){
            binding.textView.text = "disp selected"
        }

    }
}