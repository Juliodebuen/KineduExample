package com.example.kineduexample.ui.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val showDialog = MutableLiveData<Boolean>()
    val ageFilter = MutableLiveData<Int>()
    val resetSpinner = MutableLiveData<Boolean>()

    fun setAgeFilter(age: Int?) {
        this.ageFilter.postValue(age)
    }

    fun setShowDialog(showDialog: Boolean?) {
        this.showDialog.postValue(showDialog)
    }

    fun setResetSpinner(resetSpinner: Boolean?) {
        this.resetSpinner.postValue(resetSpinner)
    }
}
