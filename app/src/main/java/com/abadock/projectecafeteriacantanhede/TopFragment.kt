package com.abadock.projectecafeteriacantanhede

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.abadock.projectecafeteriacantanhede.ViewModel.CartViewModel
import com.abadock.projectecafeteriacantanhede.ViewModel.TopViewModel
import com.abadock.projectecafeteriacantanhede.databinding.FragmentTopBinding

class TopFragment : Fragment() {

    companion object {
        fun newInstance() = TopFragment()
    }

    private val viewModel: TopViewModel by viewModels()
    private val cartviewModel: CartViewModel by activityViewModels<CartViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTopBinding.inflate(inflater)

        cartviewModel.menu.observe(viewLifecycleOwner) {
            binding.totalPreuTop.text = "${cartviewModel.getPrice()} €"
        }



        return binding.root
    }
}