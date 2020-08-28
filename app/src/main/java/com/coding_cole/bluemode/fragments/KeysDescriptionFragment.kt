package com.coding_cole.bluemode.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.coding_cole.bluemode.R
import com.coding_cole.bluemode.adapters.KeyDescriptionAdapter
import kotlinx.android.synthetic.main.fragment_keys_description.*

class KeysDescriptionFragment : Fragment(R.layout.fragment_keys_description) {

    val args : KeysDescriptionFragmentArgs by navArgs()
    private lateinit var keyDescriptionAdapter: KeyDescriptionAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val shortcuts = args.shortcut

        setUpRecyclerView()

        keyDescriptionAdapter.differ.submitList(shortcuts.softwareKeyList)
    }

    private fun setUpRecyclerView() {
        keyDescriptionAdapter = KeyDescriptionAdapter()
        key_discription_rcv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = keyDescriptionAdapter
        }
    }
}