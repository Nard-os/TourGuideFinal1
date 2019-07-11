package com.example.tourguidefinal


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.tourguidefinal.databinding.FragmentCountry2Binding
import com.example.tourguidefinal.databinding.FragmentCountry2BindingImpl


class CountryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentCountry2Binding.inflate(inflater)

        binding.button4.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_countryFragment2_to_ethiopiaFragment)

           binding.button5.setOnClickListener{view: View ->
               view.findNavController().navigate(R.id.greeceFragment)

           }
        }
        return inflater.inflate(R.layout.fragment_country2, container, false)
    }



}
