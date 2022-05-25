package com.nasywa.kisahnabiapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nasywa.kisahnabiapp.model.ResponseMain
import com.nasywa.kisahnabiapp.repo.RepositoryMain

class ViewModelMain: ViewModel() {

    val repository = RepositoryMain()

    var responGetData = MutableLiveData<List<ResponseMain>>()
    var isError = MutableLiveData<Throwable>()
    val isLoading = MutableLiveData<Boolean>()

    fun getDataView(){
        isLoading.value = true

        repository.getData({
            isLoading.value = false
            responGetData.value = it
        },{
            isLoading.value = false
            isError.value = it
        })
    }
}