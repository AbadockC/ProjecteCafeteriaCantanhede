package com.abadock.projectecafeteriacantanhede

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.abadock.projectecafeteriacantanhede.ViewModel.CartViewModel
import com.abadock.projectecafeteriacantanhede.ViewModel.PaymentViewModel
import com.abadock.projectecafeteriacantanhede.adapters.PaymentAdapter
import com.abadock.projectecafeteriacantanhede.databinding.FragmentPaymentBinding

class PaymentFragment : Fragment() {

    companion object {
        fun newInstance() = PaymentFragment()
    }

    private val viewModel: PaymentViewModel by viewModels()
    private val cartviewModel: CartViewModel by activityViewModels<CartViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPaymentBinding.inflate(inflater)

        binding.recyclerView2.layoutManager = LinearLayoutManager(context)

        cartviewModel.getMenu()

        cartviewModel.menu.observe(viewLifecycleOwner) {
            binding.recyclerView2.adapter = PaymentAdapter(cartviewModel.menu.value!!, cartviewModel)
            binding.PreuTotalPagament.text = "${cartviewModel.getPrice()} €"
        }

        binding.button.setOnClickListener() {
            cartviewModel.clearAll()
        }

        return binding.root
    }
}