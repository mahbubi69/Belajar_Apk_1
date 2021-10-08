package com.example.belajar_apk.fragmen


import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.belajar_apk.R
import com.example.belajar_apk.adapter.SurahAdapter
import com.example.belajar_apk.databinding.FragmentListSurahBinding
import com.example.belajar_apk.handler.CommunicatorFagment
import com.example.belajar_apk.model.SurahApiModel
import com.example.belajar_apk.viewmodel.ListSurahViewModel
import java.util.*
import kotlin.collections.ArrayList


class ListSurahFragment : Fragment(), CommunicatorFagment {

    private var _binding: FragmentListSurahBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: SurahAdapter
    private lateinit var viewModel: ListSurahViewModel

    var hariIni: String? = null
    var tanggal: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListSurahBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvTanggalListSurah.setOnClickListener {
            findNavController().navigate(R.id.action_listSurahFragment_to_jadwalWaktuFragment)
        }
        dataApiMvvm()
        tanggalWaktu()
    }

    fun tanggalWaktu() {
        val date = Calendar.getInstance().time
        hariIni = DateFormat.format("EEEE", date) as String
        tanggal = DateFormat.format("d MMMM yyyy", date) as String

        binding.tvHariListSurah.text = "$hariIni,"
        binding.tvTanggalListSurah.text = tanggal

    }

    fun dataApiMvvm() {
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ListSurahViewModel::class.java)
        viewModel.setDataApi()
        viewModel.getDataList().observe(viewLifecycleOwner, Observer { data ->
            menampilkanDataApi(data)
        })
    }

    fun menampilkanDataApi(dataApi: ArrayList<SurahApiModel>) {
        adapter = SurahAdapter(dataApi, this)
        binding.rvListDataSurah.adapter = adapter
        binding.rvListDataSurah.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
    }

    //apk onstop
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClikData(clikDataList: SurahApiModel) {
        val nama = clikDataList.nama
        val audio = clikDataList.audio
//        onclik mindah antar fragment
        val nextDetail =
            ListSurahFragmentDirections.actionListSurahFragmentToDetailListSurahFragment(
                nama, audio
            )
        view?.findNavController()?.navigate(nextDetail)
    }
}


