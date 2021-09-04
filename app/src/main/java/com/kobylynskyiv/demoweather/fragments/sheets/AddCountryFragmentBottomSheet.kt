package com.kobylynskyiv.demoweather.fragments.sheets

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.kobylynskyiv.demoweather.databinding.BottomSheetAddCountryBinding
import com.kobylynskyiv.demoweather.fragments.sheets.interfaces.CitySelectCallBack

class AddCountryFragmentBottomSheet(val citySelectListener: CitySelectCallBack) :
    BottomSheetDialogFragment() {

    private lateinit var binding: BottomSheetAddCountryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = BottomSheetAddCountryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState) as BottomSheetDialog
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fgAddcountryIvOk.setOnClickListener {
            citySelectListener.onCallBack(binding.fgAddcountryEtCity.text.toString())
            dismiss()
        }

    }
}