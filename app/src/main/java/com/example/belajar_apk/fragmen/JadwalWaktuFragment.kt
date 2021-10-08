package com.example.belajar_apk.fragmen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.belajar_apk.databinding.FragmentJadwalWaktuBinding
import com.example.belajar_apk.model.DaftarKotaObj
import com.example.belajar_apk.viewmodel.DataKotaViewModel

class JadwalWaktuFragment : Fragment() {

    private var _binding: FragmentJadwalWaktuBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModelListKota: DataKotaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentJadwalWaktuBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    fun dataKotaApiMvvm() {
        viewModelListKota = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(DataKotaViewModel::class.java)
        viewModelListKota.setDataKota()
        viewModelListKota.getDatalistKota().observe(viewLifecycleOwner, Observer { data ->
            showSpiner(data)
        })
    }

    fun showSpiner(data: ArrayList<DaftarKotaObj>) {
        var arrarlist = ArrayList<DaftarKotaObj>()
        for (i in arrarlist){
        }
        val spiner: Spinner = binding.spinerKota
        val arrayAdapter = ArrayAdapter<String>(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item
        )
        arrayAdapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
        spiner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}