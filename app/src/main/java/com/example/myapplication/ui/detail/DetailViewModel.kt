package com.example.myapplication.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.Pokemon
import com.example.model.PokemonDetail
import com.example.usecase.GetCatchUseCase
import com.example.usecase.GetPokemonDetailUseCase
import com.example.usecase.GetReleaseUseCase
import com.example.usecase.GetRenameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getPokemonDetailUseCase: GetPokemonDetailUseCase,
    private val getCatchUseCase: GetCatchUseCase,
    private val getReleaseUseCase: GetReleaseUseCase,
    private val getRenameUseCase: GetRenameUseCase
) : ViewModel() {

    private val _detail: MutableLiveData<PokemonDetail> = MutableLiveData()
    val detail: LiveData<PokemonDetail> = _detail

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val loading: LiveData<Boolean> = _loading

    private val _catch: MutableLiveData<Boolean> = MutableLiveData()
    val catch: LiveData<Boolean> = _catch

    private val _rename: MutableLiveData<String> = MutableLiveData()
    val rename: LiveData<String> = _rename

    private val _release: MutableLiveData<Boolean> = MutableLiveData()
    val release: LiveData<Boolean> = _release

    fun getDetail(name: String) {
        _loading.postValue(true)
        getPokemonDetailUseCase.execute(GetPokemonDetailUseCase.Params(name))
            .onEach {
                _detail.postValue(it)
            }
            .catch { }
            .onCompletion {
                _loading.postValue(false)
            }
            .launchIn(viewModelScope)
    }

    fun catch(pokemon: Pokemon) {
        _loading.postValue(true)
        getCatchUseCase.execute(pokemon)
            .onEach {
                _catch.postValue(it.status)
            }
            .catch { }
            .onCompletion {
                _loading.postValue(false)
            }
            .launchIn(viewModelScope)
    }

    fun rename(pokemon: Pokemon) {
        _loading.postValue(true)
        getRenameUseCase.execute(pokemon)
            .onEach {
                _rename.postValue(it.newName)
            }
            .catch { }
            .onCompletion {
                _loading.postValue(false)
            }
            .launchIn(viewModelScope)
    }

    fun release(pokemon: Pokemon) {
        _loading.postValue(true)
        getReleaseUseCase.execute(pokemon)
            .onEach {
                _release.postValue(it.status)
            }
            .catch { }
            .onCompletion {
                _loading.postValue(false)
            }
            .launchIn(viewModelScope)
    }
}