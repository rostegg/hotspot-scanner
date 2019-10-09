package com.rostegg.android.hotspot_scanner.services.scanners

import android.net.wifi.ScanResult

interface WifiScannerBase {
    fun startScan() : List<ScanResult>
    fun stopScan()
}