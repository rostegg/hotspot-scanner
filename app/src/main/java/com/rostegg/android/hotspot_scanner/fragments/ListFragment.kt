package com.rostegg.android.hotspot_scanner.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.rostegg.android.hotspot_scanner.R
import com.rostegg.android.hotspot_scanner.services.OUIService
import com.rostegg.android.hotspot_scanner.services.SessionStorage
import org.koin.android.ext.android.inject
import kotlin.reflect.KProperty

class ListFragment: Fragment(), FragmentMetadata {

    override val fragmentTitle: String
        get() = "List"

    //var listItems = ArrayList<String>()
    //var adapter: ArrayAdapter<String>? = null
    private val adapter: ArrayAdapter<String> by inject()
    //private val ouiService: OUIService by inject()
    private val sessionStorage: SessionStorage by inject()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View? = inflater!!.inflate(R.layout.fragment_list, container, false)

        var listView= view?.findViewById(R.id.sessionListView) as ListView



        listView.adapter = adapter
        /*ouiService.ouiListCached.forEach{ item ->
            listItems.add(item.assignment)
            adapter!!.notifyDataSetChanged()
        }*/
        return view
    }
}
