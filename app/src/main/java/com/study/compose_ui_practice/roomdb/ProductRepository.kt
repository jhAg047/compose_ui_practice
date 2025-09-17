package com.study.compose_ui_practice.roomdb

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

// 저장소 추가하기
class ProductRepository(private val productDao: ProductDao) {
    // 초기화 단계에서 productDao의 getAllProducts() 메서드를 호출하고 그 결과를 LiveData 객체 안에 저장
    val allProducts: LiveData<List<Product>> = productDao.getAllProducts()
    // 비동기 검색 태스크가 완료될 때마다 검색 조작 결과를 저장한다.
    val searchResults = MutableLiveData<List<Product>>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun insertProduct(newproduct: Product){
        coroutineScope.launch(Dispatchers.IO) {
            productDao.insertProduct(newproduct)
        }
    }

    fun deleteProduct(name:String){
        coroutineScope.launch(Dispatchers.IO) {
            productDao.deleteProduct(name)
        }
    }

    fun findProduct(name:String){
        coroutineScope.launch(Dispatchers.Main) {
            productDao.finProduct(name)
        }
    }

    // 검색 조작 시 지연된 값을 이용해 검색 결과를 findProduct() 메서드로 반환
    private fun asyncFind(name: String): Deferred<List<Product>?> =
        coroutineScope.async(Dispatchers.IO) {
            return@async productDao.finProduct(name)
        }

}