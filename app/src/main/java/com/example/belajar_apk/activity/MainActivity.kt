package com.example.belajar_apk.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.belajar_apk.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val listsurahfragment = ListSurahFragment()
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragmentContainerView, listsurahfragment).commit()

    }


//    override fun passData(DataList: SurahApiModel) {
//        val bundle = Bundle()
//    }
}