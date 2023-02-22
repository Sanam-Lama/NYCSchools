package com.example.nycschool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nycschool.adapters.MyAdapter
import com.example.nycschool.api.RetrofitHelper
import com.example.nycschool.api.SchoolService
import com.example.nycschool.databinding.ActivityMainBinding
import com.example.nycschool.repository.SchoolRepository
import com.example.nycschool.viewmodels.MainViewModel
import com.example.nycschool.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    lateinit var adapter: MyAdapter
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //initialize binding
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //creating an instance of repository to initialize the viewmodel
        val schoolService = RetrofitHelper.getInstance().create(SchoolService::class.java)
        val repository = SchoolRepository(schoolService)

        //creating an object of viewmodel
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository))[MainViewModel::class.java]
        callObservers()
    }

     private fun callObservers() {
         mainViewModel.schoolData.observe(this, Observer {
            Log.d("MAINACTIVITY, SCHOOL", it.toString())
             adapter = MyAdapter(this, it)
            binding.recyclerView.adapter = adapter
            binding.recyclerView.itemAnimator = DefaultItemAnimator()
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            adapter.notifyDataSetChanged()

        })
         mainViewModel.getSchools()
    }
}