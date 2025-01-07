package com.abadock.projectecafeteriacantanhede

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.abadock.projectecafeteriacantanhede.ViewModel.CartViewModel
import com.abadock.projectecafeteriacantanhede.ViewModel.DessertsViewModel
import com.abadock.projectecafeteriacantanhede.data.FoodData
import com.abadock.projectecafeteriacantanhede.data.FoodType
import com.abadock.projectecafeteriacantanhede.databinding.FragmentDessertsBinding
import com.abadock.projectecafeteriacantanhede.adapters.FoodAdapter

class DessertsFragment : Fragment() {

    companion object {
        fun newInstance() = DessertsFragment()
    }

    private val viewModel: DessertsViewModel by viewModels()
    private val cartviewModel: CartViewModel by activityViewModels<CartViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDessertsBinding.inflate(inflater)

        binding.recyclerView.layoutManager = GridLayoutManager(context,2)

        binding.recyclerView.adapter = FoodAdapter(FoodData.loadFood().filter { it.type == FoodType.POSTRE}, cartviewModel)

        return binding.root
    }
    }