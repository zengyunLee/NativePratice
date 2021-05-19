package com.aaron.hulanative.ui.home

import PopularsAdapter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aaron.hulanative.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val rv: RecyclerView = root.findViewById(R.id.home_recyclerview)
        val adapter = PopularsAdapter {
            Log.d("recyclerview item",it)
        }
//        rv.layoutManager = LinearLayoutManager(this.context)
        rv.adapter = adapter
        homeViewModel.fruitList.observe(viewLifecycleOwner, {
            it?.let {
                adapter.submitList(it as MutableList<Int>)
            }
        })
        return root
    }
}