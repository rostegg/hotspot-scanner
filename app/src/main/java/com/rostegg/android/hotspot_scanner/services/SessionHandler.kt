package com.rostegg.android.hotspot_scanner.services

class SessionHandler {

    var state = false

    fun changeState() {
        state = !state
        if (!state)
            saveSession()
    }

    private fun saveSession() {

    }
}