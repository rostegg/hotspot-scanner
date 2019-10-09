package com.rostegg.android.hotspot_scanner

import android.app.Application
import com.rostegg.android.hotspot_scanner.services.GeoService
import com.rostegg.android.hotspot_scanner.services.OUIService
import com.rostegg.android.hotspot_scanner.services.SessionManager
import com.rostegg.android.hotspot_scanner.services.SessionStorage
import com.rostegg.android.hotspot_scanner.services.scanners.WifiScannerManager
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class InitApp : Application() {

    override fun onCreate() {
        super.onCreate()
        val mainModule = module {
            single { OUIService(applicationContext) }
            single { GeoService(applicationContext) }
            single { SessionManager() }
            single { SessionStorage() }
            single { WifiScannerManager(applicationContext) }
        }
        startKoin {
            androidContext(this@InitApp)
            modules(mainModule)
        }
    }
}