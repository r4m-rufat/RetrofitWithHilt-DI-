package com.codingwithrufat.filmswithhilt.viewmodel

import androidx.lifecycle.*
import com.codingwithrufat.filmswithhilt.repository.FilmRepository
import com.codingwithrufat.filmswithhilt.utils.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.NullPointerException
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel
@Inject
constructor(val repository: FilmRepository) : ViewModel(), LifecycleObserver {

    var filmList: MutableLiveData<ApiState> = MutableLiveData<ApiState>()

    val list: LiveData<ApiState>
     get() {
         viewModelScope.launch {
             if (repository.getFilms() != null){
                 filmList.postValue(ApiState.SUCCESS(repository.getFilms()))
             }else{
                 filmList.postValue(ApiState.FAILURE(NullPointerException()))
             }

         }
         return filmList
    }

}