package com.abadock.projectecafeteriacantanhede.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abadock.projectecafeteriacantanhede.data.FoodData
import com.abadock.projectecafeteriacantanhede.data.FoodModel
import java.math.RoundingMode
import java.text.DecimalFormat

class CartViewModel: ViewModel() {

    private var _menu: MutableLiveData<List<FoodModel>> = MutableLiveData<List<FoodModel>>()
    val menu: LiveData<List<FoodModel>> = _menu


    fun addFood(plato: FoodModel) {
        val list = mutableListOf<FoodModel>()
        _menu.value?.let { list.addAll(it) }
        FoodData.loadFood().find { it == plato }?.let { list.add(it) }
        _menu.value = list
    }

    fun deleteFood(posicion: Int) {
        val list = mutableListOf<FoodModel>()
        _menu.value?.let { list.addAll(it) }
        list.removeAt(posicion)
        _menu.value = list
    }

    fun getPrice(): Float {
        val total = _menu.value?.map{ it.price}?.sum()
        val numformat = DecimalFormat("#.##")
        numformat.roundingMode = RoundingMode.CEILING
        return numformat.format(total).toFloat()
    }

    fun getQuantity(): Int {
        val quantity = _menu.value?.size
        if (quantity != null) {
            return quantity.toInt()
        }
        return 0
    }

    fun getMenu() {
        _menu.value = menu.value
    }

    fun clearAll() {
        val list = mutableListOf<FoodModel>()
        _menu.value = list
    }
}