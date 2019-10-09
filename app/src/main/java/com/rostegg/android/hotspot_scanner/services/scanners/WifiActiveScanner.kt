package com.rostegg.android.hotspot_scanner.services.scanners

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.ScanResult
import android.net.wifi.WifiManager
import android.widget.Toast
import android.util.Log as Log

class WifiActiveScanner (val context: Context) : WifiScannerBase {

    private val wifiManager = context.getSystemService(Context.WIFI_SERVICE) as WifiManager

    private val wifiScanReceiver = object : BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent) {
            val success = intent.getBooleanExtra(WifiManager.EXTRA_RESULTS_UPDATED, false)
            if (success) {
                scanSuccess()
            }
        }
    }

    private fun scanSuccess() {
        Log.i("SCANNER_IN", wifiManager.scanResults.toString())
        // some callback logic
    }



    override fun stopScan() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun startScan(): List<ScanResult> {
        if (!wifiManager.isWifiEnabled) {
            Toast.makeText(context, "WiFi is disabled ... We need to enable it", Toast.LENGTH_LONG).show()
            wifiManager.setWifiEnabled(true)
        }
        Log.i("SCANNER", "Starting scan")
        Log.i("SCANNER", wifiManager.toString())
        val intentFilter = IntentFilter()
        intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)
        context.registerReceiver(wifiScanReceiver, intentFilter)
        val success = wifiManager.startScan()
        return if (success) wifiManager.scanResults else emptyList()
    }

}