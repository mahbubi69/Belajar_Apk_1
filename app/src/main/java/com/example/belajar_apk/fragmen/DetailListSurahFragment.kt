package com.example.belajar_apk.fragmen

import android.annotation.SuppressLint
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import androidx.navigation.fragment.findNavController
import com.example.belajar_apk.R
import com.example.belajar_apk.databinding.FragmentDetailListSurahBinding
import java.io.IOException
import java.util.concurrent.TimeUnit


@Suppress("DEPRECATION")
class DetailListSurahFragment : Fragment() {

    private var _binding: FragmentDetailListSurahBinding? = null
    private val binding get() = _binding!!

    var rotate: RotateAnimation? = null
    var runNable: Runnable? = null
    var handler: Handler? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailListSurahBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbarDetailBack.setOnClickListener {
            findNavController().navigate(R.id.action_detailListSurahFragment_to_listSurahFragment)
        }
        getListData()
        playAudio()
    }

    //mengambil daata yg di bawa oleh ListSurahFragment
    fun getListData() {
        val args = arguments?.let { DetailListSurahFragmentArgs.fromBundle(it) }
        val nama = args?.nama
        binding.tvTitleMusic.text = nama.toString()

    }


    fun playAudio() {
        val args = arguments?.let { DetailListSurahFragmentArgs.fromBundle(it) }
        val audio = args?.audio.toString()
        val mediaPlayer = MediaPlayer().apply {

            binding.fabPlay.setOnClickListener {
                rotate = RotateAnimation(
                    0F, 360F, Animation.RELATIVE_TO_SELF, 0.5F,
                    Animation.RELATIVE_TO_SELF, 05F
                )
                rotate!!.duration = 1500
                rotate!!.interpolator = LinearInterpolator()
                rotate!!.repeatCount = Animation.INFINITE

                binding.imgCover.startAnimation(rotate)

                try {
                    this.setAudioStreamType(AudioManager.STREAM_MUSIC)
                    this.setDataSource(audio)
                    this.prepare()
                    this.start()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
                binding.fabPlay.visibility = View.GONE
                binding.fabStop.visibility = View.VISIBLE
                binding.seekBar.maxProgress = this.duration / 1000

                runNable = Runnable {
                    val currentPosition = this.currentPosition / 1000
                    val duration = this.duration

                    @SuppressLint("Default") val time = String.format(
                        "%02d min,%02d sec",
                        TimeUnit.MILLISECONDS.toMinutes(duration.toLong()),
                        TimeUnit.MILLISECONDS.toSeconds(duration.toLong()),
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration.toLong()))
                    )
                    binding.seekBar.progress = currentPosition
                    handler!!.postDelayed(runNable!!, 1000)
                    binding.tvTime.text = time
                }
                handler!!.postDelayed(runNable!!, 1000)
            }
        }

        //pause
        binding.fabStop.setOnClickListener {
            mediaPlayer.stop()
            mediaPlayer.reset()
            binding.fabPlay.visibility = View.VISIBLE
            binding.fabStop.visibility = View.GONE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}