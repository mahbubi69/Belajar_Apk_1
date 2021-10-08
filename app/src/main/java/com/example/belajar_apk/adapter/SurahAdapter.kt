package com.example.belajar_apk.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.belajar_apk.databinding.ItemListSurahBinding
import com.example.belajar_apk.fragmen.ListSurahFragment
import com.example.belajar_apk.model.SurahApiModel
import com.example.belajar_apk.viewmodel.ListSurahViewModel

class SurahAdapter(
    private val listsurah: List<SurahApiModel>,
    private val onClikData: ListSurahFragment

) :
    RecyclerView.Adapter<SurahAdapter.SurahHolder>() {

    inner class SurahHolder(private val binding: ItemListSurahBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(dataResponse: SurahApiModel) {
            //menggabungkan yg mw akan di tampilkan
            binding.tvNomorListSurah.text = dataResponse.nomor.toString()
            binding.tvNamaAyatListSurah.text = dataResponse.nama
            binding.tvArabAyatListSurah.text = dataResponse.asma
            binding.tvDiturunkanSurah.text = dataResponse.type
            binding.tvInfoAyatListSurah.text = dataResponse.ayat.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurahHolder {
        val binding =
            ItemListSurahBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SurahHolder(binding)
    }

    override fun onBindViewHolder(holder: SurahHolder, position: Int) {
        holder.bind(listsurah[position])

        holder.itemView.setOnClickListener {
            onClikData.onClikData(listsurah[position])
        }
    }

    override fun getItemCount(): Int {
        return listsurah.size
    }

}