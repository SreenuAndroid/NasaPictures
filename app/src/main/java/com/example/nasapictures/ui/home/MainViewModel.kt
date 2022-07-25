package com.example.nasapictures.ui

import android.content.res.AssetManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nasapictures.model.PictureFile
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    val mPictures: MutableLiveData<List<PictureFile>> = MutableLiveData()
    var mCurrentPosition: Int = 0

    fun fetchData(resources: AssetManager) {
        viewModelScope.launch(IO) {
            delay(1000)
            val raw = resources.open("data.json").bufferedReader().use { it.readText() }
            val type = TypeToken.getParameterized(List::class.java, PictureFile::class.java).type
            val data = Gson().fromJson<List<PictureFile>?>(raw, type).sortedBy { it.date }
            withContext(Main) {
                mPictures.value = data
            }
        }
    }

    fun setPosition(position: Int) {
        mCurrentPosition = position
    }
}