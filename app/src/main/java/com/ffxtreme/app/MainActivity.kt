package com.ffxtreme.app

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.ffxtreme.app.adapters.ViewPagerAdapter
import com.ffxtreme.app.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val handler = Handler(Looper.getMainLooper())
    private lateinit var updateRunnable: Runnable

    private val tabTitles = listOf("AIMBOT", "VISUAL", "MISC", "CONFIG")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewPager()
        startStatusUpdates()
    }

    private fun setupViewPager() {
        val adapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }

    private fun startStatusUpdates() {
        updateRunnable = object : Runnable {
            override fun run() {
                val fps = Random.nextInt(55, 65)
                val ping = Random.nextInt(20, 60)

                binding.tvFps.text = getString(R.string.fps_label, fps)
                binding.tvPing.text = getString(R.string.ping_label, ping)

                handler.postDelayed(this, 1000)
            }
        }
        handler.post(updateRunnable)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(updateRunnable)
    }
}
