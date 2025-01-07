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
import com.abadock.projectecafeteriacantanhede.ViewModel.DrinksViewModel
import com.abadock.projectecafeteriacantanhede.data.FoodData
import com.abadock.projectecafeteriacantanhede.data.FoodType
import com.abadock.projectecafeteriacantanhede.databinding.FragmentDrinksBinding
import com.abadock.projectecafeteriacantanhede.adapters.FoodAdapter

class DrinksFragment : Fragment() {

    companion object {
        fun newInstance() = DrinksFragment()
    }

    private val viewModel: DrinksViewModel by viewModels()
    private val cartviewModel: CartViewModel by activityViewModels<CartViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDrinksBinding.inflate(inflater)

        binding.recyclerView.layoutManager = GridLayoutManager(context,2)
        binding.recyclerView.adapter = FoodAdapter(FoodData.loadFood().filter { it.type == FoodType.BEGUDA}, cartviewModel)

        return binding.root
    }
}