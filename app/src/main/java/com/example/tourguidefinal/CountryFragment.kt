package com.example.tourguidefinal


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.tourguidefinal.Network.TourApiService
import com.example.tourguidefinal.databinding.FragmentCountry2Binding
import com.example.tourguidefinal.databinding.FragmentCountry2BindingImpl
import kotlinx.android.synthetic.main.fragment_country2.*
import kotlinx.android.synthetic.main.fragment_home2.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


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
        button4.setOnClickListener{
            val country = readFields()
            GlobalScope.launch ( Dispatcher.IO) {
                if(connected()){
                    val response: Response<Void>=
                    arrayOf(
                        TourApiService.getInstance().insertCountryAsync(country).await
                            ()
                                Log.d("EthiopiaFragment". response.message())}
            }
            clearFields()

            button5.setOnClickListener{
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
        }
        return inflater.inflate(R.layout.fragment_country2, container, false)
    }



}
