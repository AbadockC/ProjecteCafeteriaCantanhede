package com.abadock.projectecafeteriacantanhede

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.abadock.projectecafeteriacantanhede.ViewModel.AperitiusViewModel
import com.abadock.projectecafeteriacantanhede.ViewModel.CartViewModel
import com.abadock.projectecafeteriacantanhede.adapters.FoodAdapter
import com.abadock.projectecafeteriacantanhede.data.FoodData
import com.abadock.projectecafeteriacantanhede.data.FoodType
import com.abadock.projectecafeteriacantanhede.databinding.FragmentAperitiusBinding
import com.abadock.projectecafeteriacantanhede.databinding.FragmentDessertsBinding

class AperitiusFragment : Fragment() {

    companion object {
        fun newInstance() = AperitiusFragment()
    }

    private val viewModel: AperitiusViewModel by viewModels()
    private val cartviewModel: CartViewModel by activityViewModels<CartViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentAperitiusBinding.inflate(inflater)

        binding.recyclerView.layoutManager = GridLayoutManager(context,2)

        binding.recyclerView.adapter = FoodAdapter(FoodData.loadFood().filter { it.type == FoodType.APERITIUS}, cartviewModel)

        return binding.root
    }
}