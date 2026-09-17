package com.example.haumea_arifin.pertemuan3

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.haumea_arifin.R

class ThirdResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third_result)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }

        // Mengambil data dari ThirdActivity
        val noTujuan = intent.getStringExtra("no_tujuan")

        // Menampilkan data
        val textView2 = findViewById<TextView>(R.id.textView2)

        textView2.text = "Silahkan periksa nomor anda: $noTujuan"
    }
}