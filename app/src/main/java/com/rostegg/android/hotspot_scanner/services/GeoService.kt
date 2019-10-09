package com.rostegg.android.hotspot_scanner.services

import android.content.Context
import org.osmdroid.util.GeoPoint
import kotlin.math.*

class GeoService (context: Context) {

    // get distance between two points in km
    fun distance(from : GeoPoint, to: GeoPoint) : Double {

        fun toRadians(value: Double) : Double {
            return value * (Math.PI/180)
        }

        val R = 6371e3
        val dLat = toRadians(to.latitude - from.latitude)
        val dLon = toRadians(to.longitude - from.longitude)
        val a =
            sin(dLat/2) * sin(dLat/2) +
            cos(toRadians(from.latitude)) * cos(toRadians(to.latitude)) *
            sin(dLon/2) * sin(dLon/2)

        val c = 2 * atan2(sqrt(a), sqrt(1-a))
        val d = R * c
        return  round(d) / 1000
    }
}