package com.example.listbinatang

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.listbinatang.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = resources.getString(R.string.about_name)
        val email = resources.getString(R.string.about_email)
        val imageResource = R.drawable.about

        binding.tvName.text = name
        binding.tvEmail.text = email
        binding.ivProfile.setImageResource(imageResource)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                startActivity(Intent(this, MainActivity::class.java))
                return true
            }
            R.id.action_about -> {
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}