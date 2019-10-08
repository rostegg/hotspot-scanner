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

class ImportFragment: Fragment(), FragmentMetadata {

    var tvName: TextView? = null
    var relMain: RelativeLayout? = null

    override val fragmentTitle: String
        get() = "Import"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View? = inflater!!.inflate(R.layout.fragment_import, container, false)


        relMain=view?.findViewById(R.id.relMain) as RelativeLayout

        relMain?.setBackgroundColor(Color.CYAN)
        tvName = view?.findViewById(R.id.tvName) as TextView
        tvName?.text = "just test"
        return view
    }
}