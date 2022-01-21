package com.raywenderlich.datepickerdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.raywenderlich.datepickerdialog.databinding.FragmentDataBinding


class DataFragment : Fragment() {

    private var _binding : FragmentDataBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_data, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            buttonId.setOnClickListener {
                val dataPickerDialogFragment = DataPickerDialogFragment()
                val supportFragmentManager = requireActivity().supportFragmentManager

                supportFragmentManager.setFragmentResultListener("BUNDLE_KEY", viewLifecycleOwner){
                    resultKey, bundle -> if (resultKey == "BUNDLE_KEY"){
                        val date = bundle.getString("SELECTED_DATE_KEY")
                    textViewId.text = date
                    }
                }

                dataPickerDialogFragment.show(supportFragmentManager, "DataPickerFragment")
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        fun getInstance(): DataFragment {
            return DataFragment()
        }
    }




}