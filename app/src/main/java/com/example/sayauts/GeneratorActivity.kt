package com.example.sayauts
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class GeneratorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generator)

        val tvSapaan = findViewById<TextView>(R.id.tvSapaan)
        val etJumlah = findViewById<EditText>(R.id.etJumlah)
        val etNilai = findViewById<EditText>(R.id.etNilai)
        val btnProses = findViewById<Button>(R.id.btnProses)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)
        val tvAbsen = findViewById<TextView>(R.id.tvAbsen)

        val nama = intent.getStringExtra("NAMA_DOSEN") ?: ""
        tvSapaan.text = getString(R.string.sapaan_dosen, nama)

        btnProses.setOnClickListener {

            val jumlahStr = etJumlah.text.toString()
            val nilaiStr = etNilai.text.toString()

            if (jumlahStr.isNotEmpty() && nilaiStr.isNotEmpty()) {

                val jumlah = jumlahStr.toInt()
                val nilai = nilaiStr.toDouble()

                val status = when {
                    nilai >= 80 -> "Sangat Baik"
                    nilai >= 60 -> "Cukup"
                    else -> "Kurang"
                }

                tvStatus.text = getString(R.string.status_kelas, status)

                val absen = StringBuilder()
                for (i in 1..jumlah) {
                    absen.append(getString(R.string.mahasiswa_absen, i))
                }

                tvAbsen.text = absen.toString()

            } else {
                Toast.makeText(this, getString(R.string.isi_semua_data), Toast.LENGTH_SHORT).show()
            }
        }
    }
}
