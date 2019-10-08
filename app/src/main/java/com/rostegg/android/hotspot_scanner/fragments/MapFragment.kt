package com.rostegg.android.hotspot_scanner.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.rostegg.android.hotspot_scanner.R

class MapFragment: Fragment(), FragmentMetadata {

    override val fragmentTitle: String
        get() = "Map"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View? = inflater!!.inflate(R.layout.fragment_import, container, false)

        return view
    }
}