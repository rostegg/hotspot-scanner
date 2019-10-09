package com.rostegg.android.hotspot_scanner.services.scanners

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.os.Build
import android.util.Log

class WifiScannerManager(context: Context) {


    private var wifiScannerBase: WifiScannerBase = WifiActiveScanner(context)
        /*when (Build.VERSION.SDK_INT) {
        in Int.MIN_VALUE..26 ->
        else -> WifiRttScanner(context)
    }*/

    fun getScanResult(): List<String> {
        Log.i("WifiManager", "Lets scann")
        val result = wifiScannerBase.startScan()
        Log.i("WifiManagerResult", result.toString())
        var listItems = ArrayList<String>()
        result.forEach{item ->
            listItems.add(item.BSSID)
        }
        return listItems
    }


}