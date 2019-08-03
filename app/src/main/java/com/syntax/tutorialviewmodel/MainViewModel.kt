package com.syntax.tutorialviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.syntax.tutorialviewmodel.model.Result

class MainViewModel : ViewModel() {

    val liveData = MutableLiveData<Result>() // => can change value

    fun setHitung(panjang: String, lebar: String): LiveData<Result> { // => LiveData is Read Only
        val p = panjang.toDouble()
        val l = lebar.toDouble()
        val tampung = p * l
        val result = Result(tampung.toString())
        liveData.postValue(result)
        return liveData
    }

    /**
     * return value from liveData if you have done calculate
     * */
    fun getHitung(): LiveData<Result> {
        return liveData
    }

    /**
     *
     * NOTED
     * do not pass context into this class ViewModel
     * if you want need context from this class => avoiding memory leaks
     * you can implement like this :
     *
     * class MainViewModel(application: Application) : AndroidViewModel(application) {
     * }
     * */
}