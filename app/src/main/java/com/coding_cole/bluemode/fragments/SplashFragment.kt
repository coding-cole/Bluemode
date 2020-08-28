package com.coding_cole.bluemode.fragments

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.coding_cole.bluemode.R

class SplashFragment : Fragment(R.layout.fragment_splash) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler().postDelayed({
            view?.findNavController()
                ?.navigate(R.id.action_splashFragment_to_homeFragment)

        },2500)
    }
}