package com.example.listbinatang

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.listbinatang.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private var dataBinatang: Binatang? = null

    companion object {
        const val EXTRA_BINATANG = "extra_binatang"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataBinatang = intent.getParcelableExtra(EXTRA_BINATANG)

        // Menampilkan data ke layout
        Glide.with(this).load(dataBinatang?.photo).into(binding.ivDetailPhoto)
        binding.tvDetailName.text = dataBinatang?.name
        binding.tvDetailDescription.text = dataBinatang?.description

        binding.actionShare.setOnClickListener {
            shareData()
        }
    }

    private fun shareData() {
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, "Binatang Detail")
            putExtra(
                Intent.EXTRA_TEXT,
                "Name: ${dataBinatang?.name}\nDescription: ${dataBinatang?.description}"
            )
        }

        startActivity(Intent.createChooser(shareIntent, "Share Menggunakan"))
    }
}