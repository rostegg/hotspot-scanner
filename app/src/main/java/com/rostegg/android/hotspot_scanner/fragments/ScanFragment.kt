package com.rostegg.android.hotspot_scanner.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.rostegg.android.hotspot_scanner.R

class ScanFragment : Fragment(), FragmentMetadata {

    var hotspotListLayout: LinearLayout? = null

    override val fragmentTitle: String
        get() = "Scan"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View? =  inflater!!.inflate(R.layout.fragment_scan, container, false)

        hotspotListLayout=view?.findViewById(R.id.hotspotListLayout) as LinearLayout
        hotspotListLayout?.setBackgroundColor(Color.BLUE)

        return view
    }
}