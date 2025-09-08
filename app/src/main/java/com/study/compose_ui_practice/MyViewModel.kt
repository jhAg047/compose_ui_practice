package com.study.compose_ui_practice

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    //  생성자?

) : ViewModel() {

    /*
    * 하나의 ViewModel은 별도의 클래스로 구현되며, 모델 데이터와 그 데이터를 관리하기 위해 호출될 수 있는 함수들을 포함한 상태값을 포함
    * ViewModel은 액티비티의 사용자 인터페이스에서 관찰할 수 있는 데이터를 저장하는 것을 주요 목표로 한다.
    * 이를 통해서 UI는 ViewModel의 데이터가 변경되었을 때 반응할 수 있음
    * ViewModel의 상태는 함수들의 mutableStateOf 그룹을 이용해 선언
    * */

    var customerCount by mutableStateOf(0)

    fun increaseCount(){
        customerCount++
    }

}