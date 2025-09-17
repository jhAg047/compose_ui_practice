package com.study.compose_ui_practice.roomdb

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProductViewModel(application: Application) : ViewModel() {

    val allProducts: LiveData<List<Product>>
    private val repository:ProductRepository
    val searchResults: MutableLiveData<List<Product>>

    init {

        val productDb = ProductRoomDatabase.getInstance(application)
        val productDao = productDb.productDao()
        repository = ProductRepository(productDao)

        allProducts = repository.allProducts
        searchResults = repository.searchResults

    }

    // 버튼 클릭시 호출될 메소드
    fun insertProduct(product: Product) {
        repository.insertProduct(product)
    }

    fun findProduct(name: String){
        repository.findProduct(name)
    }

    fun deleteProduct(name:String){
        repository.deleteProduct(name)
    }

}