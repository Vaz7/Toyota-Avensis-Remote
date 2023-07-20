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
import android.hardware.ConsumerIrManager
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var irManager: ConsumerIrManager? = null


    private fun sendIrData() {
        val frequency = 38000 // 38 kHz carrier frequency
        val irData = intArrayOf(
            // IR signal pattern (on/off durations in microseconds) for NEC protocol
            9000, // Header: 9ms ON
            4500, // Header: 4.5ms OFF
            // Data bits (bitwise representation of hexadecimal value 0x37C84480)
            560, 560, 560, 560, 560, 560, 560, 1690, // Address byte (8 bits)
            560, 560, 560, 1690, 560, 560, 560, 560, // Address byte (inverted) (8 bits)
            560, 560, 560, 1690, 560, 560, 560, 560, // Command byte (8 bits)
            560, 560, 560, 1690, 560, 1690, 560, 1690, // Command byte (inverted) (8 bits)
            // Add any required gaps or stop signals if needed
        )

        if (irManager?.hasIrEmitter() == true) {
            irManager?.transmit(frequency, irData)
            // The IR data is transmitted using the transmit method.
        } else {
            // Device does not have an IR transmitter.
            // Handle the lack of IR transmitter based on your app's requirements.
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        irManager = getSystemService(CONSUMER_IR_SERVICE) as ConsumerIrManager

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
            sendIrData()
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