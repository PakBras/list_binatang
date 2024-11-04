package com.example.listbinatang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listbinatang.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Binatang>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvBinatang.setHasFixedSize(true)

        list.addAll(getListBinatang())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                binding.rvBinatang.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListBinatang(): ArrayList<Binatang> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listBinatang = ArrayList<Binatang>()
        for (i in dataName.indices) {
            val binatang = Binatang(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listBinatang.add(binatang)
        }
        return listBinatang
    }

    private fun showRecyclerList() {
        binding.rvBinatang.layoutManager = LinearLayoutManager(this)
        val listBinatangAdapter = ListBinatangAdapter(list)
        binding.rvBinatang.adapter = listBinatangAdapter

        listBinatangAdapter.setOnItemClickCallback(object : ListBinatangAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Binatang) {
                showSelectedBinatang(data)
            }
        })
    }

    private fun showSelectedBinatang(binatang: Binatang) {
        Toast.makeText(this, "Kamu memilih " + binatang.name, Toast.LENGTH_SHORT).show()
    }
}