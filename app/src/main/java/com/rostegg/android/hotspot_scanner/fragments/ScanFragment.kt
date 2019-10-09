package com.rostegg.android.hotspot_scanner.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rostegg.android.hotspot_scanner.R
import android.widget.Button
import com.rostegg.android.hotspot_scanner.services.SessionManager
import org.koin.android.ext.android.inject


class ScanFragment : Fragment(), FragmentMetadata {

    override val fragmentTitle: String
        get() = "Scanner"

    private val sessionManager: SessionManager by inject()

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
        sessionManager.changeState()
        setButtonStyle(btn)
    }

    private fun setButtonStyle(btn: Button) {
        btn.text = if (sessionManager.state) getString(R.string.scan_button_stop) else getString(R.string.scan_button_start)
        btn.setBackgroundColor((if (sessionManager.state) Color.RED else Color.GREEN))
    }
}