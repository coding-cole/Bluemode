package com.coding_cole.bluemode.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.coding_cole.bluemode.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home), View.OnClickListener{

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        shortcut_keys.setOnClickListener(this)
        fav.setOnClickListener(this)
        rate_us.setOnClickListener(this)
        more_apps.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            shortcut_keys -> {
                v?.findNavController()
                    ?.navigate(R.id.action_homeFragment_to_shortcutKeysFragment)
            }
            fav -> {
//                v?.findNavController()
//                    ?.navigate(R.id.action_homeFragment_to_shortcutKeysFragment)
            }
            rate_us -> {
//                v?.findNavController()
//                    ?.navigate(R.id.action_homeFragment_to_shortcutKeysFragment)
            }
            more_apps -> {
//                v?.findNavController()
//                    ?.navigate(R.id.action_homeFragment_to_shortcutKeysFragment)
            }
        }
    }

}