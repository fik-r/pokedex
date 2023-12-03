package com.example.myapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.Pokemon
import com.example.usecase.GetPokemonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPokemonsUseCase: GetPokemonsUseCase
) : ViewModel() {

    private val _pokemons: MutableLiveData<List<Pokemon>> = MutableLiveData(listOf())
    val pokemons: LiveData<List<Pokemon>> = _pokemons

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    fun getPokemons() {
        _isLoading.postValue(true)
        getPokemonsUseCase.execute()
            .onEach {
                _pokemons.postValue(it)
            }
            .catch { }
            .onCompletion {
                _isLoading.postValue(false)
            }
            .launchIn(viewModelScope)
    }
}