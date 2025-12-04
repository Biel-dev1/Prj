package com.ffxtreme.app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ffxtreme.app.databinding.FragmentAimbotBinding

class AimbotFragment : Fragment() {

    private var _binding: FragmentAimbotBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAimbotBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        binding.tvFovValue.text = "${binding.sliderFov.value.toInt()}°"
        binding.tvSmoothnessValue.text = "${binding.sliderSmoothness.value.toInt()}"

        binding.sliderFov.addOnChangeListener { _, value, _ ->
            binding.tvFovValue.text = "${value.toInt()}°"
        }

        binding.sliderSmoothness.addOnChangeListener { _, value, _ ->
            binding.tvSmoothnessValue.text = "${value.toInt()}"
        }

        binding.switchAimbot.setOnCheckedChangeListener { _, isChecked ->
            binding.switchAutoFire.isEnabled = isChecked
            binding.switchSilentAim.isEnabled = isChecked
            binding.sliderFov.isEnabled = isChecked
            binding.sliderSmoothness.isEnabled = isChecked
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
