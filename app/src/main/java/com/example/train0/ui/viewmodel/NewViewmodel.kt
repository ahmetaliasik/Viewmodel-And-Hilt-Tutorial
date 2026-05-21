package com.example.train0.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

sealed class SomeOtherScreenNavigation{
    data object FirstScreen : SomeOtherScreenNavigation()
    data object SecondScreen : SomeOtherScreenNavigation()
    data class ThirdScreenWithParameters(val count : Int) : SomeOtherScreenNavigation()
}

class NewViewmodel : ViewModel(){
    private val _navigation = MutableSharedFlow<SomeOtherScreenNavigation>()
    val navigation : SharedFlow<SomeOtherScreenNavigation> = _navigation.asSharedFlow()

    fun goToFirstScreen(){
        viewModelScope.launch {
            _navigation.emit(SomeOtherScreenNavigation.FirstScreen)
        }
    }

    fun goToSecondScreen(){
        viewModelScope.launch {
            _navigation.emit(SomeOtherScreenNavigation.SecondScreen)
        }
    }

    fun goToThirdScreen(){
        viewModelScope.launch {
            _navigation.emit(SomeOtherScreenNavigation.ThirdScreenWithParameters(31))
        }
    }
}