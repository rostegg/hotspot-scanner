package com.rostegg.android.hotspot_scanner

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rostegg.android.hotspot_scanner.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.osmdroid.config.Configuration
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var viewPageAdapter: ViewPagerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupOsmdroid()
        setContentView(R.layout.activity_main)
        viewPageAdapter = ViewPagerAdapter(supportFragmentManager)
        this.viewPager.adapter = viewPageAdapter
        this.tabLayout.setupWithViewPager(this.viewPager)

    }

    private fun setupOsmdroid() {
        org.osmdroid.config.Configuration.getInstance().userAgentValue = packageName

        // space usage
        /*org.osmdroid.config.Configuration.getInstance().expirationOverrideDuration = 365L * 24L * 3600L * 1000L
        org.osmdroid.config.Configuration.getInstance().tileFileSystemCacheMaxBytes = 1024L * 1024L * 1024L * 10L
        org.osmdroid.config.Configuration.getInstance().tileFileSystemCacheTrimBytes = 1024L * 1024L * 1024L * 9L*/

        val osmPath = File(cacheDir.absolutePath, "osmdroid")
        org.osmdroid.config.Configuration.getInstance().osmdroidBasePath = osmPath
        val tileCache = File(Configuration.getInstance().osmdroidBasePath.absolutePath, "tile")
        org.osmdroid.config.Configuration.getInstance().osmdroidTileCache = tileCache
    }
}
