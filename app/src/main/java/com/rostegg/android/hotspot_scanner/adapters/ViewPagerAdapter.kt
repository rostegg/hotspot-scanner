package com.rostegg.android.hotspot_scanner.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.rostegg.android.hotspot_scanner.fragments.ImportFragment
import com.rostegg.android.hotspot_scanner.fragments.ScanFragment
import com.rostegg.android.hotspot_scanner.fragments.FragmentMetadata
import com.rostegg.android.hotspot_scanner.fragments.MapFragment

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val fragmentsList = listOf<Fragment>(ScanFragment(), ImportFragment(), MapFragment())

    override fun getItem(position: Int): Fragment? {
        return fragmentsList[position]
    }

    override fun getCount(): Int {
        return fragmentsList.count()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return  (fragmentsList[position] as FragmentMetadata).fragmentTitle
    }
}