package com.rostegg.android.hotspot_scanner.services

import android.content.ComponentCallbacks
import android.content.res.Configuration
import android.util.Log
import com.rostegg.android.hotspot_scanner.services.scanners.WifiScannerManager
import org.koin.android.ext.android.inject


class SessionManager : ComponentCallbacks {
    // fix of inline type mismatch
    override fun onConfigurationChanged(newConfig: Configuration) {}

    override fun onLowMemory() {}

    var state = false

    private val wifiScannerManager: WifiScannerManager by inject()
    private val sessionStorage: SessionStorage by inject()

    fun changeState() {
        Log.i("Session", "Changing session")
        state = !state
        if (state) createSession() else saveSession()
    }


    fun saveSession() {

    }

    fun createSession() {
        Log.i("Session", "Creating session")
        val result = wifiScannerManager.getScanResult()
        sessionStorage.addToStorage(result)
        Log.i("SessionStorage", sessionStorage.currentStorage.toString())
    }
}