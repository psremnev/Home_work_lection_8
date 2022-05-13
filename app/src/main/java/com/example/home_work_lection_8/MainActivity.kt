package com.example.home_work_lection_8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.home_work_lection_8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        val columnCount = 2
        val tileMargin = 20
        val employees = getData()
        val adapter = ListAdapter(this, employees)
        binding.EmployeesList.layoutManager = GridLayoutManager(this, columnCount)
        binding.EmployeesList.adapter = adapter
        binding.EmployeesList.addItemDecoration(ListItemDecoration(tileMargin))
    }
}