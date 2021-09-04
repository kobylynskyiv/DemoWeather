package com.kobylynskyiv.demoweather.fragments.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.kobylynskyiv.demoweather.data.enums.EApiStatus
import com.kobylynskyiv.demoweather.databinding.FragmentMainBinding
import com.kobylynskyiv.demoweather.fragments.main.models.WeatherViewModel
import com.kobylynskyiv.demoweather.fragments.sheets.AddCountryFragmentBottomSheet
import com.kobylynskyiv.demoweather.fragments.sheets.interfaces.CitySelectCallBack
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.KoinComponent

class MainFragment : Fragment(), KoinComponent, CitySelectCallBack {

    private val viewModel: WeatherViewModel by viewModel()
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.textChange("Киев")

        viewModel.weatherData.observe(viewLifecycleOwner) {

            if (it.status == EApiStatus.SUCCESS) {
                binding.progressBar.visibility = View.GONE
                binding.fgMainTvTemp.text = "${it.weather?.current?.temp_c}°C"
                binding.fgMainTvCity.text =
                    "${it.weather?.location?.country}, ${it.weather?.location?.name}"
                binding.fgMainTvShDescription.text = "${it.weather?.location?.name}"
                binding.fgMainTvShDescription.text = it.weather?.current?.condition?.text
                binding.fgMainTvRegion.text = it.weather?.location?.region

                Glide
                    .with(requireContext())
                    .load("https:${it.weather?.current?.condition?.icon}")
                    .into(binding.fgMainIvIcon)
            } else {
                binding.progressBar.visibility = View.VISIBLE
                Snackbar.make(binding.root,
                    "Произошла ошибка во время получения данных",
                    Snackbar.LENGTH_LONG).show()
            }
        }

        binding.fgMainIvAdd.setOnClickListener {
            val searchItem = AddCountryFragmentBottomSheet(this)
            searchItem.show(requireFragmentManager(), "")
        }
    }

    override fun onCallBack(value: String) {
        viewModel.textChange(value)
    }
}