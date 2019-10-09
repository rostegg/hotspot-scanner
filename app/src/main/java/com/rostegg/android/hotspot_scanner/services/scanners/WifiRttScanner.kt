package com.rostegg.android.hotspot_scanner.services.scanners

import android.content.Context
import android.net.wifi.ScanResult
import android.net.wifi.rtt.WifiRttManager

class WifiRttScanner (context: Context) : WifiScannerBase {
    override fun stopScan() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun startScan(): List<ScanResult> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var rttManager: WifiRttManager = context.getSystemService(Context.WIFI_RTT_RANGING_SERVICE) as WifiRttManager

}