package com.rostegg.android.hotspot_scanner.services

import android.content.Context
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import com.rostegg.android.hotspot_scanner.R

class OUIService (context: Context) {

    inner class OUIModel(val registry: String,
                           val assignment: String,
                           val organization: String,
                           val address: String) {

        fun compare(other: OUIModel): Boolean {
            return assignment == other.assignment
        }

        fun compare(other: String): Boolean {
            return assignment == other
        }
    }

    private val emptyOuiObject = OUIModel("","", "","")

    var ouiListCached = ArrayList<OUIModel>()


    fun updateOui() {
        // TODO
    }

    private fun simplifiedMac(mac: String): String{
        return mac.replace(":","").substring(0,6).toUpperCase()
    }

    fun find(mac: String) : OUIModel {
        val shortMac = simplifiedMac(mac)
        val result = ouiListCached.find { item -> item.assignment == shortMac }
        return result ?: emptyOuiObject
    }


    init {
        val ouiStream = context.resources.openRawResource(R.raw.oui)
        csvReader().open(ouiStream) {
            readAllAsSequence().forEach { row ->
                ouiListCached.add(OUIModel(row[0], row[1], row[2], row[3]))
            }
        }
    }
}