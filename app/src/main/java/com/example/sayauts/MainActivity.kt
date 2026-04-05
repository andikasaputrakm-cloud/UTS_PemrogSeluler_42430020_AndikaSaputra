package com.example.sayauts
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNama = findViewById<EditText>(R.id.etNamaDosen)
        val btnMasuk = findViewById<Button>(R.id.btnMasuk)

        btnMasuk.setOnClickListener {
            val nama = etNama.text.toString()

            if (nama.isNotEmpty()) {
                val intent = Intent(this, GeneratorActivity::class.java)
                intent.putExtra("NAMA_DOSEN", nama)
                startActivity(intent)
            } else {
                Toast.makeText(this, getString(R.string.nama_kosong), Toast.LENGTH_SHORT).show()
            }
        }
    }
}
