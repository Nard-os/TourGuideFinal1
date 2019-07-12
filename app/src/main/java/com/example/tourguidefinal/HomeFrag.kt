package com.example.tourguidefinal


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.tourguidefinal.Network.TourApiService
import com.example.tourguidefinal.databinding.FragmentHome2Binding
import kotlinx.android.synthetic.main.fragment_home2.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeFrag : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentHome2Binding.inflate(inflater)
        binding.countryButton.setOnClickListener { view: View ->

            view.findNavController().navigate(R.id.countryFragment2)

            binding.loginButton.setOnClickListener{view :View ->
                view.findNavController().navigate(R.id.loginFragment2)
            }

        }
        country_button.setOnClickListener{
            val country = readFields()
            GlobalScope.launch ( Dispatcher.IO) {
                if(connected()){
                    val response: Response<Void>=
                    arrayOf(TourApiService.getInstance().insertCountryAsync(country).await
                        ()
                Log.d("HomeFrag". response.message())}
            }
            clearFields()
        }
        login_button.setOnClickListener{
            val country = readFields()
            GlobalScope.launch ( Dispatcher.IO) {
                if(connected()){
                    val response: Response<Void>=
                    arrayOf(TourApiService.getInstance().insertCountryAsync(country).await
                        ()
                            Log.d("HomeFrag". response.message())}
            }
            clearFields()
        }

            return inflater.inflate(R.layout.fragment_home2, container, false)
        }
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
