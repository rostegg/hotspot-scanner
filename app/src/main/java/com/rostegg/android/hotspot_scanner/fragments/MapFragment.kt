package com.rostegg.android.hotspot_scanner.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rostegg.android.hotspot_scanner.R
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay


class MapFragment: Fragment(), FragmentMetadata {

    override val fragmentTitle: String
        get() = "Map"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view: View? =  inflater!!.inflate(R.layout.fragment_map, container, false)
        val mapView = view!!.findViewById(R.id.mapView) as MapView

        val somewhere = GeoPoint(50.45466, 30.5238)

        mapView.isClickable = true
        mapView.setBuiltInZoomControls(true)
        mapView.setMultiTouchControls(true)

        //Set below to False to check if it works offline
        mapView.setUseDataConnection(true)

        mapView.setTileSource(TileSourceFactory.MAPNIK)

        val mapViewController = mapView.controller
        mapViewController.setZoom(16)
        mapViewController.setCenter(somewhere)

        return view
    }


}