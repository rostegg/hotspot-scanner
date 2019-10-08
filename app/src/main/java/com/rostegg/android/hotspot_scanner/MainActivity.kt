package com.rostegg.android.hotspot_scanner

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rostegg.android.hotspot_scanner.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewPageAdapter: ViewPagerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPageAdapter = ViewPagerAdapter(supportFragmentManager)
        this.viewPager.adapter = viewPageAdapter
        this.tabLayout.setupWithViewPager(this.viewPager)
        //this.viewPager.adapter = viewPageAdapter
        //this.tabLayout.setupVi
        //this.main_ac.setupWithViewPager(this.viewPager) //Binding ViewPager with TabLayout
    }
}
