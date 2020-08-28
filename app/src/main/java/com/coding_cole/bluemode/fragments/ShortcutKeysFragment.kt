package com.coding_cole.bluemode.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.coding_cole.bluemode.R
import com.coding_cole.bluemode.adapters.ShortcutsListAdapter
import com.coding_cole.bluemode.models.Shortcuts
import kotlinx.android.synthetic.main.fragment_shortcut_keys.*

class ShortcutKeysFragment : Fragment(R.layout.fragment_shortcut_keys) {

    private lateinit var shortcutsListAdapter: ShortcutsListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()

        getSoftwareList()
        setUpAdapterListener()
    }

    private fun setUpAdapterListener() {
        shortcutsListAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("shortcut", it)
            }
            findNavController().navigate(
                R.id.action_shortcutKeysFragment_to_keysDescriptionFragment,
                bundle
            )
        }
    }

    private fun getSoftwareList() {
        // get list of shortcuts from json
        val shortcutsList = arrayListOf<Shortcuts>()
        shortcutsListAdapter.differ.submitList(shortcutsList)
    }

    private fun setUpRecyclerView() {
        shortcutsListAdapter = ShortcutsListAdapter()
        shortcut_keys_rcv.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = shortcutsListAdapter
        }
    }
}