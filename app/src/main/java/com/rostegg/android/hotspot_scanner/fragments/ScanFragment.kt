package com.rostegg.android.hotspot_scanner.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rostegg.android.hotspot_scanner.R
import android.widget.Button
import androidx.core.graphics.green
import androidx.core.graphics.red
import com.rostegg.android.hotspot_scanner.services.SessionHandler
import org.koin.android.ext.android.inject


class ScanFragment : Fragment(), FragmentMetadata {

    override val fragmentTitle: String
        get() = "Scanner"

    private val sessionHandler: SessionHandler by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View? =  inflater!!.inflate(R.layout.fragment_scan, container, false)
        var scanBtn = view!!.findViewById(R.id.scanBtn) as Button
        setButtonStyle(scanBtn)
        scanBtn.setOnClickListener {
            buttonOnClickHandler(scanBtn)

        }
        return view
    }

    private fun buttonOnClickHandler(btn: Button) {
        sessionHandler.changeState()
        setButtonStyle(btn)
    }

    private fun setButtonStyle(btn: Button) {
        btn.text = if (sessionHandler.state) getString(R.string.scan_button_stop) else getString(R.string.scan_button_start)
        btn.setBackgroundColor(if (sessionHandler.state) R.color.colorPrimary.red else R.color.colorPrimary.green)
    }
}