package com.rostegg.android.hotspot_scanner.services

class SessionStorage {

    var currentStorage: MutableList<String> = mutableListOf()

    fun createStorage() {

    }

    fun addToStorage(obj : List<String> ) {
        currentStorage.addAll(obj)

    }

    fun clearStorage() {
        currentStorage = mutableListOf()
    }
}