package com.example.tourguidefinal


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions

class HomeFrag : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val options = navOptions {
            anim {
                enter = R.anim.slide_in_right
                exit = R.anim.slide_out_left
                popEnter = R.anim.slide_in_left
                popExit = R.anim.slide_out_right
            }
        }
        view.findViewById<Button>(R.id.country_button)?.setOnClickListener {
            findNavController().navigate(R.id.action_homeFrag_to_countryFragment2, null, options)
        }
        val button = view.findViewById<Button>(R.id.country_button)
        button?.setOnClickListener {
            findNavController().navigate(R.id.action_homeFrag_to_countryFragment2)
        }

        val buttonL = view.findViewById<Button>(R.id.login_button)
        buttonL?.setOnClickListener {
            findNavController().navigate(R.id.action_homeFrag_to_loginFragment2)
        }


    }
}
