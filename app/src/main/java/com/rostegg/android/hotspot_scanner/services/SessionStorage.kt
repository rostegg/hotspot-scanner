package com.rostegg.android.hotspot_scanner.services

import android.content.ComponentCallbacks
import android.content.res.Configuration
import android.util.Log
import android.widget.ArrayAdapter
import org.koin.android.ext.android.inject

class SessionStorage : ComponentCallbacks {
    override fun onConfigurationChanged(newConfig: Configuration) { }

    override fun onLowMemory() {}

    var currentStorage: MutableList<String> = mutableListOf()
    private val adapter: ArrayAdapter<String> by inject()

    fun createStorage() {

    }

    fun addToStorage(obj : List<String> ) {
        currentStorage.addAll(obj)
        Log.i("DATA_STORAGE", currentStorage.toString())
        adapter!!.notifyDataSetChanged()

    }


    fun clearStorage() {
        currentStorage = mutableListOf()
    }
}