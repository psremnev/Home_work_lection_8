package com.example.home_work_lection_8

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

interface IChangeName {
    var newName: String
    var position: Int
}

class EditFragmentModel: ViewModel() {
    private val name: MutableLiveData<IChangeName> = MutableLiveData<IChangeName>()

    fun setName(value: IChangeName) {
        name.value = value
    }

    fun getName(): MutableLiveData<IChangeName> {
        return name
    }
}