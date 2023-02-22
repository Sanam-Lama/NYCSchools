package com.example.nycschool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.nycschool.api.RetrofitHelper
import com.example.nycschool.api.SatResultService
import com.example.nycschool.databinding.ActivityResultBinding
import com.example.nycschool.repository.SatResultRepository
import com.example.nycschool.viewmodels.ResultViewModel
import com.example.nycschool.viewmodels.ResultViewModelFactory

class ResultActivity : AppCompatActivity() {

    private var _binding: ActivityResultBinding? = null
    private val binding get() = _binding!!
    lateinit var viewModel: ResultViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val resultService = RetrofitHelper.getInstance().create(SatResultService::class.java)
        val repository = SatResultRepository(resultService)

        viewModel = ViewModelProvider(this, ResultViewModelFactory(repository))[ResultViewModel::class.java]
    }

}